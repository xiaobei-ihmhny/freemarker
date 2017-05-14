package com.freemarker.datastrc;

import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.Data;

import org.apache.log4j.Logger;

import com.freemarker.utils.DataBaseService;
import com.freemarker.utils.DataBaseServiceImpl;

public class DataServiceImpl implements DataService {
	
	private static Logger log = Logger.getLogger(DataBaseServiceImpl.class);

	@Override
	public Map<String, Object> getTemplateData(String tableName, char fieldSeparator, String packageName, String className) {
		DataBaseService dbs = new DataBaseServiceImpl();
		Map<String, Object> templateData = new HashMap<String, Object>();
		templateData.put("tableName", tableName);
		templateData.put("packageName", packageName);
		templateData.put("className", className);
		templateData.put("properties", dbs.getTableInfo(fieldSeparator, tableName));
		log.info("当前模版所用的表名为："+tableName+"，当前模版所用的包名为："+packageName+"，当前模版所用的类名为："+className);
		return templateData;
	}

}
