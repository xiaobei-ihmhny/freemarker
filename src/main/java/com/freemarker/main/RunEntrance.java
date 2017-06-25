package com.freemarker.main;

import java.util.Map;

import com.freemarker.model.TableNeededMap;
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
	/* 文件生成目录的路径 */
	private static String generateFilePath = PropUtils.getPorp("generateFilePath");
	/* vo文件存放路径 */
	private static String voFilePath = PropUtils.getPorp("voFilePath");
	/* pojo文件存放路径 */
	private static String pojoFilePath = PropUtils.getPorp("pojoFilePath");
	/* dao文件存放路径 */
	private static String daoFilePath = PropUtils.getPorp("daoFilePath");
	/* mapper文件存放路径 */
	private static String mapperFilePath = PropUtils.getPorp("mapperFilePath");
	/* service文件存放路径 */
	private static String serviceFilePath = PropUtils.getPorp("serviceFilePath");
	/* serviceImpl文件存放路径 */
	private static String serviceImplFilePath = PropUtils.getPorp("serviceImplFilePath");
	/* controller文件存放路径 */
	private static String controllerFilePath = PropUtils.getPorp("controllerFilePath");
	/* 生成pojo文件的包路径 */
	private static String pojoPackageName = PropUtils.getPorp("pojoPackageName");
	/* 生成dao文件的包路径 */
	private static String daoPackageName = PropUtils.getPorp("daoPackageName");
	/* 生成mapper文件的包路径 */
	private static String mapperPackageName = PropUtils.getPorp("mapperPackageName");
	/* 生成service文件的包路径 */
	private static String servicePackageName = PropUtils.getPorp("servicePackageName");
	/* 生成serviceImpl文件的包路径 */
	private static String serviceImplPackageName = PropUtils.getPorp("serviceImplPackageName");
	/* 生成controller文件的包路径 */
	private static String controllerPackageName = PropUtils.getPorp("controllerPackageName");
	/*=====================================测试相关配置==========================================*/
	/* testFilePath */
	private static String testFilePath = PropUtils.getPorp("testFilePath");
	/* daoTestFilePath */
	private static String daoTestFilePath = PropUtils.getPorp("daoTestFilePath");
	/* serviceTestFilePath */
	private static String serviceTestFilePath = PropUtils.getPorp("serviceTestFilePath");
	/* controllerTestFilePath */
	private static String controllerTestFilePath = PropUtils.getPorp("controllerTestFilePath");

	/* 数据表名 */
	private static String tableName = null;
	/* 数据表对应的类名 */
	private static String className = null;
	/*  */
	private static Logger log = Logger.getLogger(RunEntrance.class);
	
	public static void main(String[] args) {
		/* 生成vo、pojo、dao、mapper、service、serviceImpl、controller目录 */
		GenerateDirUtils.generateDir(generateFilePath+voFilePath
				,generateFilePath + pojoFilePath
				,generateFilePath + daoFilePath
				,generateFilePath + mapperFilePath
				,generateFilePath + serviceFilePath
				,generateFilePath + serviceImplFilePath
				,generateFilePath + controllerFilePath
				,testFilePath + daoTestFilePath
				,testFilePath + serviceTestFilePath
				,testFilePath + controllerTestFilePath);

		DataBaseService dbs = new DataBaseServiceImpl();
		//从数据库中获取所有需要的表名
		Map<String, String> tableNames = dbs.getAllTableNames(fieldSeparator);
		for(Map.Entry<String, String> entry : tableNames.entrySet()){
			tableName = entry.getKey();
			className = entry.getValue();
			//只生成list中包含的表
//			if(TableNeededMap.needTablesList.contains(tableName)){
			//只生成map中包含的表，并指定表名对应的类名
			if(TableNeededMap.needTablesMap.containsKey(tableName)){
				className = TableNeededMap.needTablesMap.get(tableName);
				log.info("当前的表名为："+tableName+"，类名为："+className);
				/* 生成vo对象 */
				CodeMeachine.generate(generateFilePath + voFilePath, "VOModel.ftl", tableName, fieldSeparator, pojoPackageName, className,className+"VO.java");
				/* 生成pojo对象 */
				CodeMeachine.generate(generateFilePath + pojoFilePath, "pojoModel.ftl", tableName, fieldSeparator, pojoPackageName, className,className+".java");
				/* 生成dao对象 */
				CodeMeachine.generate(generateFilePath + daoFilePath, "mapperInterfaceModel.ftl", tableName, fieldSeparator, daoPackageName, className,className+"Mapper.java");
				/* 生成mapper.xml文件 */
				CodeMeachine.generate(generateFilePath + mapperFilePath, "mapperXMLModel.ftl", tableName, fieldSeparator, mapperPackageName, className,className+"Mapper.xml");
				/* 生成service接口 */
				CodeMeachine.generate(generateFilePath + serviceFilePath, "serviceModel.ftl", tableName, fieldSeparator, servicePackageName, className,className+"Service.java");
				/* 生成serviceImpl实现类 */
				CodeMeachine.generate(generateFilePath + serviceImplFilePath, "serviceImplModel.ftl", tableName, fieldSeparator, serviceImplPackageName, className,className+"ServiceImpl.java");
				/* 生成controller类 */
				CodeMeachine.generate(generateFilePath + controllerFilePath, "controllerModel.ftl", tableName, fieldSeparator, controllerPackageName, className,className+"Controller.java");
				/* 生成dao测试类 */
				CodeMeachine.generateTest(testFilePath + daoTestFilePath, "daoTestModel.ftl", tableName, fieldSeparator, controllerPackageName, className,className+"MapperTest.java");
				/* 生成service测试类 */
				CodeMeachine.generateTest(testFilePath + serviceTestFilePath, "serviceTestModel.ftl", tableName, fieldSeparator, controllerPackageName, className,className+"ServiceTest.java");
				/* 生成controller测试类 */
				CodeMeachine.generateTest(testFilePath + controllerTestFilePath, "controllerTestModel.ftl", tableName, fieldSeparator, controllerPackageName, className,className+"ControllerTest.java");

			}
		}
		
	}
}
