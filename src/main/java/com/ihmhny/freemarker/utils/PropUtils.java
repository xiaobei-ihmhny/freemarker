package com.ihmhny.freemarker.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author xiaobei-ihmhny
 * @version 1.2
 * @project yzys
 * @class_name PropUtils
 * @date 2017-10-26 10:18
 * @description 通过Properties类加载配置文件，后期可改为spring加载
 */
public class PropUtils {
	private static Properties prop = null;
	private static Map<String,String> propMap = new HashMap<>();
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

	/**
	 * 获取配置文件中的所有信息
	 * @return
     */
	public static Map<String,String> getAllProps(){
		Set<Object> keys = prop.keySet();
		for(Object key : keys){
			propMap.put(key.toString(),getPorp(key.toString()));
		}
		return propMap;
	}

}
