package com.esphere.k8s_maven_plugin;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import okhttp3.Response;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import com.fico.k8s.core.Mutator;
import com.fico.k8s.facade.K8sConfigMapFacade;

@Mojo(name = "config")
public class K8sConfigMapMojo extends AbstractMojo {
	

	@Parameter(property = "configMap", readonly = true, defaultValue = "${configMap}")
	private ConfigMap configMap;

	public ConfigMap getConfigMap() {
		return configMap;
	}

	public void setConfigMap(ConfigMap configMap) {
		this.configMap = configMap;
	}

	@Parameter(property = "msg", defaultValue = "from maven")
	private String msg;

	public void execute() throws MojoExecutionException {
		Map<String, String> data = K8SUtil.toMap(configMap.getData());
		if(configMap.getFromFile().length>0){
			Arrays.asList(configMap.getFromFile()).stream().forEach(path->{
				FileReader.read(path, data);
			});
		}
		
		Mutator mutator = new Mutator.Builder().baseUrl(configMap.getK8sUrl().toString()).build();
		K8sConfigMapFacade configMapFacade = mutator.mutate(K8sConfigMapFacade.class);
		Response response = null;
		System.out.println(data);
		try {
			com.fico.k8s.model.ConfigMap configMaps = new com.fico.k8s.model.ConfigMap(configMap.getName(),data);
			response = configMapFacade.create(configMap.getNamespace(), configMaps).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(response.body().toString());
		
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}