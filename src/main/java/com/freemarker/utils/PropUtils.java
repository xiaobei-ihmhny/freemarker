package com.freemarker.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropUtils {
	private static Properties prop = null;
	private PropUtils() {
	}
	
	static{
		try {
			prop = new Properties();
			InputStream config = PropUtils.class.getClassLoader().getResourceAsStream("config.properties");
//			prop.load(new FileInputStream(PropUtils.class.getClassLoader().getResource("config.properties").getPath()));
			prop.load(config);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static Properties getProp(){
		return prop;
	}
	
	public static String getPorp(String key){
		return prop.getProperty(key);
	}
	

}
