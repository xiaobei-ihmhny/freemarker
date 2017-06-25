package com.freemarker.datastrc;

import java.util.Map;

/**
 * 此类用于组织模板文件需要的原数据
 * @author Legend
 *
 */
public interface DataService {

	/**
	 * 根据表名获取模板要用的Map数据
	 * @param tableName 表名
	 * @param fieldSeparator 字段分隔符
	 * @param packageName 包名
	 * @param className 类名
	 * @return
	 */
	Map<String, Object> getTemplateData(String tableName, char fieldSeparator, String packageName, String className);

	/**
	 * 根据表名获取测试模板所需要的Map数据
	 * @param tableName 表名
	 * @param fieldSeparator 字段分隔符
	 * @param packageName 包名
	 * @param className 类名
     * @return
     */
	Map<String,Object> getTemplateTestData(String tableName, char fieldSeparator, String packageName, String className);
}
