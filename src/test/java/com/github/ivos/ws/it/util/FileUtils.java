package com.github.ivos.ws.it.util;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class FileUtils {

	public static String load(Object testInstance, String fileName) {
		try {
			String path = testInstance.getClass().getPackage().getName().replace('.', '/') + '/' + fileName;
			InputStream is = new ClassPathResource(path).getInputStream();
			return IOUtils.toString(is);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
