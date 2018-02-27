package com.ihmhny.freemarker.main;

import com.ihmhny.freemarker.model.FileNameMap;
import com.ihmhny.freemarker.model.FileSavePathMap;
import com.ihmhny.freemarker.model.PackageNames;
import com.ihmhny.freemarker.model.TableNeededMap;
import com.ihmhny.freemarker.utils.DataBaseService;
import com.ihmhny.freemarker.utils.DataBaseServiceImpl;
import com.ihmhny.freemarker.utils.GenerateDirUtils;
import com.ihmhny.freemarker.utils.PropUtils;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * 程序入口类
 * @author Legend
 *
 */
public class RunEntrance {

	/* 表中字段分隔符 */
	private static char fieldSeparator = PropUtils.getPorp("fieldSeparator").toCharArray()[0];
	/* 数据表名 */
	private static String tableName = null;
	/* 数据表对应的类名 */
	private static String className = null;
	/* 数据表对应的文件名 */
	private static String fileName = null;
	/*  */
	private static Logger log = Logger.getLogger(RunEntrance.class);

	public static void main(String[] args) {

		DataBaseService dbs = new DataBaseServiceImpl();
		//从数据库中获取所有需要的表名
		Map<String, String> tableNames = dbs.getAllTableNames(fieldSeparator);
		for(Map.Entry<String, String> entry : tableNames.entrySet()){
			tableName = entry.getKey();
			className = entry.getValue();
			//只生成list中包含的表
			//if(TableNeededMap.needTablesList.contains(tableName)){
			//只生成map中包含的表，并指定表名对应的类名
			if(TableNeededMap.needTablesMap.containsKey(tableName)){

				/* 生成查询pojo、操作pojo、pojo、dao、mapper、service、serviceImpl、controller目录 */
				GenerateDirUtils.generateDir(FileSavePathMap.getPojoSavePath(tableName)
						,FileSavePathMap.getDaoFilePath(tableName)
						,FileSavePathMap.getMapperFilePath()
						,FileSavePathMap.getServiceFilePath(tableName)
						,FileSavePathMap.getServiceImplFilePath(tableName)
						,FileSavePathMap.getControllerFilePath(tableName));
				className = TableNeededMap.needTablesMap.get(tableName);
				fileName = TableNeededMap.fileNameMap.get(tableName);

				log.info("当前的表名为："+tableName+"，类名为："+TableNeededMap.needTablesMap.get(tableName) + "，文件名为：" + className);
				/* 生成pojo对象 */
//				CodeMeachine.generate(FileSavePathMap.getPojoSavePath(tableName), PropUtils.getPorp("pojoFtlFileName"), tableName, fieldSeparator, PackageNames.getPojoPackageName(tableName), className,FileNameMap.getPojoFileName(className));
				/* 生成dao对象 */
//				CodeMeachine.generate(FileSavePathMap.getDaoFilePath(tableName), PropUtils.getPorp("mapperInterfaceFtlFileName"), tableName, fieldSeparator, PackageNames.getDaoPackageName(tableName), className,FileNameMap.getDaoFileName(fileName));
				/* 生成mapper.xml文件 */
				CodeMeachine.generate(FileSavePathMap.getMapperFilePath(), PropUtils.getPorp("mapperXMlFtlFileName"), tableName, fieldSeparator, "", className,FileNameMap.getMapperFileName(fileName));
				/* 生成service接口 */
//				CodeMeachine.generate(FileSavePathMap.getServiceFilePath(tableName), PropUtils.getPorp("serviceFtlFileName"), tableName, fieldSeparator, PackageNames.getServicePackageName(tableName), className,FileNameMap.getServiceFileName(fileName));
				/* 生成serviceImpl实现类 */
//				CodeMeachine.generate(FileSavePathMap.getServiceImplFilePath(tableName), PropUtils.getPorp("serviceImplFtlFileName"), tableName, fieldSeparator, PackageNames.getServiceImplPackageName(tableName), className,FileNameMap.getServiceImplFileName(fileName));
				/* 生成controller类 */
//				CodeMeachine.generate(FileSavePathMap.getControllerFilePath(tableName), PropUtils.getPorp("controllerFtlFileName"), tableName, fieldSeparator, PackageNames.getControllerTestPackageName(tableName), className,FileNameMap.getControllerFileName(className));

			}
		}

	}
}
