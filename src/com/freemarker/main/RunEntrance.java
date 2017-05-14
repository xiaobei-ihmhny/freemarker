package com.freemarker.main;

import java.util.Map;

import org.apache.log4j.Logger;

import com.freemarker.utils.DataBaseService;
import com.freemarker.utils.DataBaseServiceImpl;
import com.freemarker.utils.GenerateDirUtils;
import com.freemarker.utils.PropUtils;

/**
 * 程序入口类
 * @author Legend
 *
 */
public class RunEntrance {

	/* 表中字段分隔符 */
	private static char fieldSeparator = PropUtils.getPorp("fieldSeparator").toCharArray()[0]; 
//	private static char fieldSeparator = '_'; 
	/* 文件生成目录的路径 */
	private static String generateFilePath = PropUtils.getPorp("generateFilePath");
//	private static String generateFilePath = "D:\\demo\\";
	/* pojo文件存放路径 */
	private static String pojoFilePath = PropUtils.getPorp("pojoFilePath");
	/* dao文件存放路径 */
	private static String daoFilePath = PropUtils.getPorp("daoFilePath");
	/* mapper文件存放路径 */
	private static String mapperFilePath = PropUtils.getPorp("mapperFilePath");
	/* service文件存放路径 */
	private static String serviceFilePath = PropUtils.getPorp("serviceFilePath");
	/* serviceImpl生成文件的包路径 */
	private static String serviceImplFilePath = PropUtils.getPorp("serviceImplFilePath");
	/* 生成文件的包路径 */
	private static String packageName = PropUtils.getPorp("packageName");
//	private static String packageName = "com.logistics.";
	/* 数据表名 */
	private static String tableName = null;
	/* 数据表对应的类名 */
	private static String className = null;
	/*  */
	private static Logger log = Logger.getLogger(RunEntrance.class);
	
	public static void main(String[] args) {
		
		/* 生成pojo、dao、mapper、service、serviceImpl目录 */
		GenerateDirUtils.generateDir(generateFilePath+pojoFilePath,generateFilePath+daoFilePath,generateFilePath+mapperFilePath,generateFilePath+serviceFilePath,generateFilePath+serviceImplFilePath);
		
		DataBaseService dbs = new DataBaseServiceImpl();
		//从数据库中获取所有需要的表名
		Map<String, String> tableNames = dbs.getAllTableNames(fieldSeparator);
		for(Map.Entry<String, String> entry : tableNames.entrySet()){
			tableName = entry.getKey();
			className = entry.getValue();
			log.info("当前的表名为："+tableName+"，类名为："+className);
			CodeMeachine.generate(generateFilePath + pojoFilePath, "pojoModel.ftl", tableName, fieldSeparator, packageName+"db.entity", className,className+".java");
			CodeMeachine.generate(generateFilePath + daoFilePath, "mapperInterfaceModel.ftl", tableName, fieldSeparator, packageName+"db.dao", className,className+"Mapper.java");
			CodeMeachine.generate(generateFilePath + mapperFilePath, "mapperXMLModel.ftl", tableName, fieldSeparator, packageName+"db.mapper", className,className+"Mapper.xml");
			CodeMeachine.generate(generateFilePath + serviceFilePath, "serviceModel.ftl", tableName, fieldSeparator, packageName+"service", className,className+"Service.java");
			CodeMeachine.generate(generateFilePath + serviceImplFilePath, "serviceImplModel.ftl", tableName, fieldSeparator, packageName+"service.impl", className,className+"ServiceImpl.java");
			
		}
		
	}
}
