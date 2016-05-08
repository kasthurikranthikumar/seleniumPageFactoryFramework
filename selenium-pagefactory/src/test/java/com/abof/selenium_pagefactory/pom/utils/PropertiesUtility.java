package com.abof.selenium_pagefactory.pom.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	public final static String PROPERTY_FILENAME = "D:\\Selenium\\JavaWorld\\WorkSpace\\WD\\MyFramework\\Config\\MyProperties";

	private static Properties properties = new Properties();
	
	public PropertiesUtility() {
		//Constructor
		try {
			properties.load(new FileInputStream(PROPERTY_FILENAME));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		assert !properties.isEmpty();
	}
 
	public static String getProperty(final String key) {
		String property = properties.getProperty(key);
		return property != null ? property.trim() : property;
	} 
}
