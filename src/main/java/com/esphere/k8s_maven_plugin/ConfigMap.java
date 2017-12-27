package com.esphere.k8s_maven_plugin;

import java.net.URL;
import java.util.Properties;

import org.apache.maven.plugins.annotations.Parameter;

public class ConfigMap {

	@Parameter(property = "k8sUrl")
	URL k8sUrl;
	@Parameter(property = "name")
	String name;
	@Parameter(property = "namespace")
	String namespace;
	@Parameter(property = "data")
	Properties data;

	@Parameter(property = "fromFile")
	private String[] fromFile;

	public URL getK8sUrl() {
		return k8sUrl;
	}

	public void setK8sUrl(URL k8sUrl) {
		this.k8sUrl = k8sUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public Properties getData() {
		return data;
	}

	public void setData(Properties data) {
		this.data = data;
	}

	public String[] getFromFile() {
		return fromFile;
	}

	public void setFromFile(String[] fromFile) {
		this.fromFile = fromFile;
	}

	@Override
	public String toString() {
		return "ConfigMap [k8sUrl=" + k8sUrl + ", name=" + name
				+ ", namespace=" + namespace + ", data=" + data + "]";
	}

}
