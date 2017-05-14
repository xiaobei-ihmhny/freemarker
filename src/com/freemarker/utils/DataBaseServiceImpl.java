package com.freemarker.utils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.freemarker.model.FieldBean;

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
			
			String sql = "select * from " + tableName;
			conn = JDBCUtils.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsMetaData = rs.getMetaData();
			//列下标从1开始
			for(int i=1; i<=rsMetaData.getColumnCount(); i++){
				String columnName = rsMetaData.getColumnName(i);
				String columnType = rsMetaData.getColumnTypeName(i);
				String proName = convertField(separator, columnName);
				String proType = getTypeName(rsMetaData.getColumnType(i));
				FieldBean fieldBean = new FieldBean();
				fieldBean.setColumnName(columnName);
				fieldBean.setColumnType(columnType);
				fieldBean.setProName(proName);
				fieldBean.setProType(proType);
				
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
		Map<String, String> tableNames = new HashMap<String, String>();
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
		case Types.BLOB:
		case Types.NVARCHAR:
			break;
		case Types.INTEGER:
		case Types.NUMERIC:
			typeName=Integer.class.getSimpleName();
			break;
		case Types.SMALLINT:
			typeName = Short.class.getSimpleName();
			break;
		case Types.TINYINT:
			typeName = Byte.class.getSimpleName();
			break;
		case Types.DATE:
		case Types.TIMESTAMP:
			typeName=Date.class.getSimpleName();
			break;
		case Types.BOOLEAN:
			typeName=Boolean.class.getSimpleName();
			break;
		case Types.FLOAT:
			typeName=Float.class.getSimpleName();
			break;
		case Types.DECIMAL:
			typeName = BigDecimal.class.getSimpleName();
			break;
		default:
			break;
		}
		return typeName;
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
		if(tableName.indexOf(separator) > -1){
			tableName = tableName.substring(tableName.indexOf(separator));
		}
		String variable = tableName.toLowerCase();
		//判断字符串中是否含有分隔符
		if(variable.indexOf(separator) > -1){//如果有
			char[] varChar = variable.toCharArray();
			for(int i=0; i<varChar.length; i++){
				if(varChar[i] == separator && i < varChar.length-1){
					varChar[i+1] = Character.toUpperCase(varChar[i+1]);
				}
			}
			variable = new String(varChar).replaceAll(Character.toString(separator), "");
			log.info("生成pojo："+variable+"成功");
		}
		return variable;
	}

}
