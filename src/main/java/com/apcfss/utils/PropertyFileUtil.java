package com.apcfss.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.apcfss.constants.FrameworkConstants;
import com.apcfss.enums.ConfigProperties;
import com.apcfss.frameworkexceptions.InvalidPathOfPropertyFileException;
import com.apcfss.frameworkexceptions.PropertyFileUsageException;

/**
 * Read the property file and store it in a HashMap for faster processing.
 * 
 * @author Pavan Kumar T
 * @version 1.0
 * @since 1.0
 */
public final class PropertyFileUtil {
	/**
	 * Private constructor to avoid external instantiation
	 */
	private PropertyFileUtil() {
	}

	private static Properties properties = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();
	static {
		try (FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
			properties.load(fileInputStream);
			for (Map.Entry<Object, Object> entry : properties.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	/**
	 * Receives the {@link com.apcfss.enums.ConfigProperties},converts to lower case , return the corresponding value
	 * for the key from the HashMap
	 * @author Pavan Kumar T
	 * 22-05-2023
	 * @param key To be fetched from property file
	 * @return corresponding value for the requested key if found else {@link PropertyFileUsageException}
	 */
	public static String readDataFromPropertyFile(ConfigProperties key) {
		if (Objects.isNull(CONFIGMAP.get(key.name().toLowerCase())) || Objects.isNull(key)) {
			throw new PropertyFileUsageException(
					"Property Name :" + key + " is not Found. Please check config.properties ");
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
}
