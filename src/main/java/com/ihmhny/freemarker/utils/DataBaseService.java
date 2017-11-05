package com.ihmhny.freemarker.utils;

import com.ihmhny.freemarker.model.FieldBean;

import java.util.List;
import java.util.Map;

/**
 * @author xiaobei
 * @version 1.2
 * @project yzys
 * @class_name DataBaseService
 * @date 2017-10-26 10:05
 * @description 此接口用于处理数据库的表和字段之间的对应关系
 */
public interface DataBaseService {
	
	
	/**
	 * 从数据库中获取所有的表名
	 * @param separator 表名之间的分隔符
	 * @return
	 */
	Map<String, String> getAllTableNames(char separator);
	
	/**
	 * 获取数据库中指定表的相关信息
	 * @param separator 表字段分隔符
	 * @param tableName 表名
	 * @return
	 */
	List<FieldBean> getTableInfo(char separator, String tableName);
	
	/**
	 * 将指定的字段变为java类型(一般为去"_"，首字母大写)
	 * @param separator 指定的分隔符
	 * @param field 数据库字段
	 * @return 相应的java类型
	 */
	String convertField(char separator, String field);
	
	/**
	 * 将数据库表名转换为对应的Pojo类名
	 * @param separator 表名之间的分隔符
	 * @param tableName 表名
	 * @return 表名对应的Pojo类名
	 */
	String convertTableNameToPojo(char separator, String tableName);

	/**
	 * 将数据库表名转换为对应的请求地址
	 * @param separator 表名之间的分隔符
	 * @param tableName 表名
     * @return 表名对应的请求地址
	 * 此外简单的处理为：ams_user 对应的请求地址为 ams/user
     */
	String getAllRequestMappingAddr(char separator, String tableName);

	/**
	 * 由类名获取相应的VO对象的名称
	 * @param className 类名
	 * @return VO对象的名称
     */
	String getVOName(String className);

	/**
	 * 获取所有字段的set方法的集合
	 * @param separator 表中的分隔符
	 * @param tableName 表名
     * @return
     */
	List<String> getAllSetMethod(char separator, String tableName);

	/**
	 * 获取指定类型字段的set方法
	 * @param fieldName 字段名
	 * @param fieldType 字段类型
     * @return
     */
	String getSetMethod(String fieldName, String fieldType);

	/**
	 * 获取配置文件中的某些配置的list集合
	 * @param prop properties文件中的属性名
	 * @param separator properties文件中的属性的分隔符
	 * @return 属性值的list集合
     */
	List<String> getPropList(String prop, String separator);

	/**
	 * 获取数据库表对应的模块名
	 * @param tableName 数据库表名
	 * @param separator properties文件中的属性的分隔符
	 * @return 模块名
     */
	String getModuleName(String tableName, char separator);
}
