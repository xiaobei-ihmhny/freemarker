package com.freemarker.main;

import java.util.Map;

import com.freemarker.datastrc.DataService;
import com.freemarker.datastrc.DataServiceImpl;
import com.freemarker.utils.FreeMarkerUtils;

public class CodeMeachine {

	private static FreeMarkerUtils freeMarkerUtils = new FreeMarkerUtils();
	private static DataService dataService = new DataServiceImpl();
	
	/**
	 * 根据数据库表生成相应的测试类
	 * @param generateFilePath 生成测试类文件的位置
	 * @param templateName 模板文件名
	 * @param tableName 数据库表名
	 * @param fieldSeparator 数据库表中字段的分隔符
	 * @param packageName 生成文件的包路径名
	 * @param className 表对应的实例类名
	 * @param fileName 文件名
	 */
	public static void generateTest(String generateFilePath, String templateName, String tableName, char fieldSeparator, String packageName,String className,String fileName){
		Map<String, Object> templateData = dataService.getTemplateTestData(tableName, fieldSeparator, packageName, className);
		freeMarkerUtils.generateFile(templateName, templateData, generateFilePath+fileName);
	}
	
	/**
	 * 根据数据库表生成相应的文件
	 * @param generateFilePath 生成文件的位置
	 * @param templateName 模板文件名
	 * @param tableName 数据库表名
	 * @param fieldSeparator 数据库表中字段的分隔符
	 * @param packageName 生成文件的包路径名
	 * @param className 表对应的实例类名
	 * @param fileName 文件名
	 */
	public static void generate(String generateFilePath, String templateName, String tableName, char fieldSeparator, String packageName,String className,String fileName){
		Map<String, Object> templateData = dataService.getTemplateData(tableName, fieldSeparator, packageName, className);
		freeMarkerUtils.generateFile(templateName, templateData, generateFilePath+fileName);
	}
}
