package com.esphere.k8s_maven_plugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class K8SUtil {

	public static Map<String, String> toMap(Properties properties) {
		Map<String, String> map = new HashMap<String, String>();
		for (final String name : properties.stringPropertyNames())
			map.put(name, properties.getProperty(name));
		return map;
	}

}
