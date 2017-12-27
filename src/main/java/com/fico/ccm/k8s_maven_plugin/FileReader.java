package com.fico.ccm.k8s_maven_plugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class FileReader {

	public static Map<String, String> read(String filePath,
			Map<String, String> map) {
		if (map == null) {
			map = new HashMap<String, String>();
		}
		Path path = Paths.get(filePath);
		String content = null;
		try {
			content = FileUtils.readFileToString(new File(filePath));

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		map.put(path.getFileName().toString(), content);
		return map;

	}

}
