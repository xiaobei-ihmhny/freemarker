package com.ihmhny.freemarker.datastrc;

import com.ihmhny.freemarker.model.JavaBeanMap;
import com.ihmhny.freemarker.model.PackageNames;
import com.ihmhny.freemarker.model.TableNeededMap;
import com.ihmhny.freemarker.utils.DataBaseService;
import com.ihmhny.freemarker.utils.DataBaseServiceImpl;
import com.ihmhny.freemarker.utils.PropUtils;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DataServiceImpl implements DataService {
	
	private static Logger log = Logger.getLogger(DataBaseServiceImpl.class);

	@Override
	public Map<String, Object> getTemplateData(String tableName, char fieldSeparator, String packageName, String className) {
		DataBaseService dbs = new DataBaseServiceImpl();
		Random random = new Random();
		Map<String, Object> templateData = new HashMap<String, Object>();
		templateData.put("version",PropUtils.getPorp("version"));
		templateData.put("serialVersionUID",String.valueOf(random.nextLong()));
		templateData.put("tableName", tableName);
		templateData.put("packageName", packageName);
		templateData.put("className", className);
		templateData.put("project",PropUtils.getPorp("project"));
		templateData.put("updatePojo", JavaBeanMap.getUpdatePojoBean(className));
		templateData.put("queryPojo",JavaBeanMap.getQueryPojoBean(className));
		templateData.put("pojo_packageName", PackageNames.getPojoPackageName(tableName));
		templateData.put("queryPojo_packageName",PackageNames.getSearchPojoPackageName(tableName));
		templateData.put("updatePojo_packageName",PackageNames.getUpdatePojoPackageName(tableName));
		templateData.put("dao_packageName", PackageNames.getDaoPackageName(tableName));
		templateData.put("mapper_packageName", PackageNames.getDaoPackageName(tableName));
		templateData.put("service_packageName", PackageNames.getServicePackageName(tableName));
		templateData.put("serviceImpl_packageName", PackageNames.getServiceImplPackageName(tableName));
		templateData.put("controller_packageName", PackageNames.getControllerPackageName(tableName));
		templateData.put("properties", dbs.getTableInfo(fieldSeparator, tableName));
		templateData.put("requestMappingAddr", TableNeededMap.requestMappingMap.get(tableName));
		log.info("当前模版所用的表名为："+tableName+"，当前模版所用的包名为："+packageName+"，当前模版所用的类名为："+className);
		return templateData;
	}

	@Override
	public Map<String, Object> getTemplateTestData(String tableName, char fieldSeparator, String packageName, String className) {
		DataBaseService dbs = new DataBaseServiceImpl();
		Map<String, Object> templateData = new HashMap<String, Object>();
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
		templateData.put("updatePojo", JavaBeanMap.getUpdatePojoBean(className));
		templateData.put("queryPojo",JavaBeanMap.getQueryPojoBean(className));
		templateData.put("pojo_packageName", PackageNames.getPojoPackageName(tableName));
		templateData.put("queryPojo_packageName",PackageNames.getSearchPojoPackageName(tableName));
		templateData.put("updatePojo_packageName",PackageNames.getUpdatePojoPackageName(tableName));
		templateData.put("dao_packageName", PackageNames.getDaoPackageName(tableName));
		templateData.put("mapper_packageName", PackageNames.getDaoPackageName(tableName));
		templateData.put("service_packageName", PackageNames.getServicePackageName(tableName));
		templateData.put("serviceImpl_packageName", PackageNames.getServiceImplPackageName(tableName));
		templateData.put("controller_packageName", PackageNames.getControllerPackageName(tableName));
		templateData.put("properties", dbs.getTableInfo(fieldSeparator, tableName));
		log.info("当前模版所用的表名为："+tableName+"，当前模版所用的包名为："+packageName+"，当前模版所用的类名为："+className);
		return templateData;
	}

}
