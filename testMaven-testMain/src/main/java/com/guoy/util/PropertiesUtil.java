package com.guoy.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	
	private static Properties prop = new PropertiesOrder();     
	
	
	public static String checkGetPro(String key) throws Exception{
		InputStream path =Thread.currentThread().getContextClassLoader().getResourceAsStream("check.properties");
		prop.load(path);
		String value= prop.getProperty(key);
		path.close();
		return value;
	}
	public static String getPro(String key) throws Exception{
		InputStream path =Thread.currentThread().getContextClassLoader().getResourceAsStream("url.properties");
		prop.load(path);
		String value= prop.getProperty(key);
		path.close();
		return value;
	}
}
