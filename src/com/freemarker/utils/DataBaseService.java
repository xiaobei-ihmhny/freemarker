package com.freemarker.utils;

import java.util.List;
import java.util.Map;

import com.freemarker.model.FieldBean;

/**
 * 此类用于处理数据库的表和字段
 * @author Legend
 *
 */
public interface DataBaseService {
	
	
	/**
	 * 从数据库中获取所有的表名
	 * @param separator 表名之间的分隔符
	 * @return
	 */
	public Map<String, String> getAllTableNames(char separator);
	
	/**
	 * 获取数据库中指定表的相关信息
	 * @param separator 表字段分隔符
	 * @param tableName 表名
	 * @return
	 */
	public List<FieldBean> getTableInfo(char separator, String tableName);
	
	/**
	 * 将指定的字段变为java类型(一般为去"_"，首字母大写)
	 * @param separator 指定的分隔符
	 * @param field 数据库字段
	 * @return 相应的java类型
	 */
	public String convertField(char separator, String field);
	
	/**
	 * 将数据库表名转换为对应的Pojo类名
	 * @param separator 表名之间的分隔符
	 * @param tableName 表名
	 * @return 表名对应的Pojo类名
	 */
	public String convertTableNameToPojo(char separator, String tableName);
}
