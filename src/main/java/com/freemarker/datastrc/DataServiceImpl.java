package com.freemarker.datastrc;

import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.Data;

import com.freemarker.utils.PropUtils;
import org.apache.log4j.Logger;

import com.freemarker.utils.DataBaseService;
import com.freemarker.utils.DataBaseServiceImpl;

public class DataServiceImpl implements DataService {
	
	private static Logger log = Logger.getLogger(DataBaseServiceImpl.class);

	@Override
	public Map<String, Object> getTemplateData(String tableName, char fieldSeparator, String packageName, String className) {
		DataBaseService dbs = new DataBaseServiceImpl();
		Map<String, Object> templateData = new HashMap<String, Object>();
		templateData.put("version",PropUtils.getPorp("version"));
		templateData.put("project",PropUtils.getPorp("project"));
		templateData.put("tableName", tableName);
		templateData.put("packageName", packageName);
		templateData.put("className", className);
		templateData.put("voClassName",dbs.getVOName(className));
		templateData.put("vo_packageName", PropUtils.getPorp("voPackageName"));
		templateData.put("pojo_packageName", PropUtils.getPorp("pojoPackageName"));
		templateData.put("dao_packageName", PropUtils.getPorp("daoPackageName"));
		templateData.put("mapper_packageName", PropUtils.getPorp("mapperPackageName"));
		templateData.put("service_packageName", PropUtils.getPorp("servicePackageName"));
		templateData.put("serviceImpl_packageName", PropUtils.getPorp("serviceImplPackageName"));
		templateData.put("controller_packageName", PropUtils.getPorp("controllerPackageName"));
		templateData.put("properties", dbs.getTableInfo(fieldSeparator, tableName));
		templateData.put("requestMappingAddr",dbs.getAllRequestMappingAddr(fieldSeparator,tableName));
		log.info("当前模版所用的表名为："+tableName+"，当前模版所用的包名为："+packageName+"，当前模版所用的类名为："+className);
		return templateData;
	}

	@Override
	public Map<String, Object> getTemplateTestData(String tableName, char fieldSeparator, String packageName, String className) {
		DataBaseService dbs = new DataBaseServiceImpl();
		Map<String, Object> templateData = new HashMap<String, Object>();
		//测试包的存放路径
		templateData.put("daoTestPackageName", PropUtils.getPorp("daoTestPackageName"));
		templateData.put("serviceTestPackageName", PropUtils.getPorp("serviceTestPackageName"));
		templateData.put("controllerTestPackageName", PropUtils.getPorp("controllerTestPackageName"));
		//获取所有的set方法的集合
		templateData.put("setMethodList",dbs.getAllSetMethod(fieldSeparator,tableName));
		//获取配置文件中的要引入的配置文件名
		templateData.put("contextConfiguration",dbs.getPropList("contextConfiguration",","));
		//通用信息
		templateData.put("version",PropUtils.getPorp("version"));
		templateData.put("project",PropUtils.getPorp("project"));
		templateData.put("tableName", tableName);
		templateData.put("packageName", packageName);
		templateData.put("className", className);
		templateData.put("voClassName",dbs.getVOName(className));
		templateData.put("vo_packageName", PropUtils.getPorp("voPackageName"));
		templateData.put("pojo_packageName", PropUtils.getPorp("pojoPackageName"));
		templateData.put("dao_packageName", PropUtils.getPorp("daoPackageName"));
		templateData.put("mapper_packageName", PropUtils.getPorp("mapperPackageName"));
		templateData.put("service_packageName", PropUtils.getPorp("servicePackageName"));
		templateData.put("controller_packageName", PropUtils.getPorp("controllerPackageName"));
		templateData.put("properties", dbs.getTableInfo(fieldSeparator, tableName));
		log.info("当前模版所用的表名为："+tableName+"，当前模版所用的包名为："+packageName+"，当前模版所用的类名为："+className);
		return templateData;
	}

}
