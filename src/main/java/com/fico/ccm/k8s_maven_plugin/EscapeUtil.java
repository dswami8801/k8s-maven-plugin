package com.fico.ccm.k8s_maven_plugin;

import org.apache.commons.lang.StringEscapeUtils;

public class EscapeUtil {
	
	public static String escapeJava(String data){
		return StringEscapeUtils.escapeJava(data);
	}

}
