package com.ihmhny.freemarker.utils;

import com.ihmhny.freemarker.model.FieldBean;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * @author xiaobei-ihmhny
 * @version 1.2
 * @project yzys
 * @class_name DataBaseServiceImpl
 * @date 2017-10-26 10:05
 * @description 执行具体的sql操作并封装相关信息
 */
public class DataBaseServiceImpl implements DataBaseService {
	
	private static Logger log = Logger.getLogger(DataBaseServiceImpl.class);
	/**
	 * 存放所有的表名的Map集合，key为表名，value为表对应的实例类名
	 */
//	public static Map<String, String> tableNames = new HashMap<String, String>();
	
	/**
	 * 存放数据库表的信息的javabean
	 */
//	public static List<FieldBean> beanList = new ArrayList<FieldBean>(); 
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public List<FieldBean> getTableInfo(char separator, String tableName) {
		
		try {
			List<FieldBean> beanList = new ArrayList<FieldBean>();
			
			String sql = "select * from " + tableName + " limit 0,1";
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			//列下标从1开始
			for(int i=1; i<=rsMetaData.getColumnCount(); i++){
				String columnName = rsMetaData.getColumnName(i);
				String columnType = rsMetaData.getColumnTypeName(i);
				String proName = convertField(separator, columnName);
				//修改java类型转换方法：
//				String proType = getTypeName(rsMetaData.getColumnType(i));
				String proType = getJavaTypeName(columnType);
				FieldBean fieldBean = new FieldBean();
				fieldBean.setColumnName(columnName);
				fieldBean.setColumnType(columnType);
				fieldBean.setProName(proName);
				fieldBean.setProType(proType);
				//查询字段备注信息
				sql = "SELECT column_comment FROM INFORMATION_SCHEMA.Columns WHERE table_name= \'" + tableName +  "\' AND COLUMN_NAME = \'" + columnName + "\'";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					String comment = rs.getString("column_comment");
					fieldBean.setColumnComment(comment);
				}
				//查询字段备注信息
				beanList.add(fieldBean);
			}
			return beanList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
	}

	@Override
	public Map<String, String> getAllTableNames(char separator) {
		Map<String, String> tableNames = new TreeMap<>();
		try {
			String sql = "show tables";
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String tableName = rs.getString(1);
				log.info("当前读取的数据库表为："+tableName);
				//key为数据库表名
				//value为数据库去分隔符且每个分隔符后首字母大写的字符串
				tableNames.put(tableName, convertTableNameToPojo(separator, tableName));
			}
		} catch (Exception e) {
			log.error("读取数据库失败，失败信息为："+e.getMessage());
		}
		return tableNames;
	}

	/**
	 * 将数据库类型转换为相应的java类型
	 * @param type 数据库类型
	 * @return
	 */
	private String getTypeName(int type){
		String typeName = String.class.getSimpleName();
		
		switch (type) {
			case Types.VARCHAR:
			case Types.CHAR:
			case Types.CLOB://还有TEXT类型
				break;
			case Types.BIT:
			case Types.BOOLEAN:
				typeName=Boolean.class.getSimpleName();
				break;
			case Types.TINYINT:
			case Types.INTEGER:
			case Types.SMALLINT://还有MEDIUMINT
			case Types.NUMERIC:
				typeName=Integer.class.getSimpleName();
				break;
			case Types.BIGINT:
				typeName= BigInteger.class.getSimpleName();
				break;
			case Types.FLOAT:
				typeName=Float.class.getSimpleName();
				break;
			case Types.DOUBLE:
				typeName=Double.class.getSimpleName();
				break;
			case Types.DECIMAL:
				typeName = BigDecimal.class.getSimpleName();
				break;
			case Types.DATE:
			case Types.TIME://DATETIME
			case Types.TIMESTAMP:
				typeName=Date.class.getSimpleName();
				break;
			default:
				break;
		}
		return typeName;
	}


	private String getJavaTypeName(String columnType) {
		String javaTypeName = "String";
		switch (columnType) {
			case "VARCHAR" :
			case "CHAR":
			case "CLOB":
			case "TEXT":
				javaTypeName = "String";
				break;
			case "BLOB":
				javaTypeName="byte[]";
				break;
			case "BIT":
			case "BOOLEAN":
				javaTypeName="Boolean";
				break;
			case "INT":
			case "TINYINT":
			case "INTEGER":
			case "SMALLINT":
			case "MEDIUMINT":
				javaTypeName="Integer";
				break;
			case "BIGINT":
				javaTypeName="Long";
				break;
			case "FLOAT":
				javaTypeName="Float";
				break;
			case "DOUBLE":
				javaTypeName="Double";
				break;
			case "DECIMAL":
				javaTypeName="BigDecimal";
				break;
			case "DATE":
			case "TIME":
			case "DATETIME":
			case "TIMESTAMP":
				javaTypeName="Date";
				break;
			default:
				break;
		}
		return javaTypeName;
	}

	@Override
	public String convertField(char separator, String field) {
		String variable = field.toLowerCase();
		//判断字符串中是否含有分隔符
		if(variable.indexOf(separator) > -1){//如果有
			char[] varChar = variable.toCharArray();
			for(int i=0; i<varChar.length; i++){
				if(varChar[i] == separator && i < varChar.length-1){
					varChar[i+1] = Character.toUpperCase(varChar[i+1]);
				}
			}
			variable = new String(varChar).replaceAll(Character.toString(separator), "");
		}
		return variable;
	}

	@Override
	public String convertTableNameToPojo(char separator, String tableName) {
//		if(tableName.indexOf(separator) > -1){
//			tableName = tableName.substring(tableName.indexOf(separator));
//		}
		String variable = tableName.toLowerCase();
		//判断字符串中是否含有分隔符
		if(variable.indexOf(separator) > -1){//如果有
			char[] varChar = variable.toCharArray();
			//首字母大写
			varChar[0] = Character.toUpperCase(varChar[0]);
			for(int i=1; i<varChar.length; i++){
				if(varChar[i] == separator && i < varChar.length-1){
					varChar[i+1] = Character.toUpperCase(varChar[i+1]);
				}
			}
			variable = new String(varChar).replaceAll(Character.toString(separator), "");
			log.info("生成pojo："+variable+"成功");
		}
		return variable;
	}

	@Override
	public String getAllRequestMappingAddr(char separator, String tableName) {
		String variable = tableName.toLowerCase();
		//将所有的分隔符替换为"/
		variable = variable.replace("_","/");
		return variable;
	}

	@Override
	public String getVOName(String className) {
		return className+"VO";
	}

	@Override
	public List<String> getAllSetMethod(char separator, String tableName) {

		try {
			List<String> setMethodList = new ArrayList<>();
			String setMethod = "";
			String sql = "select * from " + tableName + " limit 0,1";
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			//列下标从1开始
			for(int i=1; i<=rsMetaData.getColumnCount(); i++){
				String columnName = rsMetaData.getColumnName(i);
				String columnType = rsMetaData.getColumnTypeName(i);
				String proName = convertField(separator, columnName);
				String proType = getJavaTypeName(columnType);
				//获取形如：.setFieldName("122");的set方法字符串
				setMethod = getSetMethod(proName,proType);
				setMethodList.add(setMethod);
			}
			return setMethodList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.close(conn, ps, rs);
		}
	}

	@Override
	public String getSetMethod(String fieldName, String FieldType) {
		String result = "set" + toUperCaseString(fieldName)+"(";
		if (FieldType.contains("byte[]")) {
			result += "new byte[]{0,1}" ;
		} else if (FieldType.contains("Boolean")) {
			result += "true" ;
		} else if (FieldType.contains("Integer")) {
			result += "1" ;
		} else if (FieldType.contains("Long")) {
			result += "111l";
		} else if (FieldType.contains("Float")) {
			result += "new Float(232.22)";
		} else if (FieldType.contains("Double")) {
			result += "new Double(111)";
		} else if (FieldType.contains("BigDecimal")) {
			result += "new BigDecimal(222)";
		} else if (FieldType.contains("Date")) {
			result += "new Date()";
		} else {
			result += "\"111\"";
		}
		result += ")";
		return result;
	}

	@Override
	public List<String> getPropList(String prop, String separator) {
		List<String> propList = new ArrayList<>();
		String propKey = PropUtils.getPorp(prop);
		if(propKey!=null && propKey.contains(separator)){
			String[] splits = propKey.split(separator);
			for(String split : splits){
				propList.add(split);
			}
			return propList;
		}
		return null;
	}

	@Override
	public String getModuleName(String tableName, char separator) {
		return tableName.split(String.valueOf(separator))[0];
	}

	/**
	 * 首字母大写
	 * @param name
	 * @return
	 */
	private static String toUperCaseString(String name) {
		char[] cs = name.toCharArray();
		cs[0]-=32;
		return String.valueOf(cs);
	}


}
