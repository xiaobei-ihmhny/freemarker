package com.ihmhny.freemarker.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @author xiaobei-ihmhny
 * @version 1.2
 * @project yzys
 * @class_name JDBCUtils
 * @date 2017-10-26 10:18
 * @description 基础的jdbc相关的工具类
 */
public class JDBCUtils {

	private static DataSource source = new ComboPooledDataSource();
	
	private static Logger log = Logger.getLogger(JDBCUtils.class);
	
	private JDBCUtils(){}
	
	/**
	 * 获取数据源
	 * @return
	 */
	public static DataSource getSource(){
		return source;
	}
	
	/**
	 * 获取一个连接对象
	 * @return
	 */
	public static Connection getConn(){
		try {
			return source.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 根据提供的sql语句获取结果集对象
	 * 问题：无法释放连接！！！！！！！
	 * @param sql 要执行的sql语句
	 * @return 结果集对象
	 */
	public static ResultSet getResultSet(String sql){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			return rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}
	
	/**
	 * 关闭数据库连接(实际是还连接)
	 * @param conn 连接对象
	 * @param stat 传输器
	 * @param rs 结果集
	 */
	public static void close(Connection conn, Statement stat, ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			rs = null;
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			try {
				if(stat != null){
					stat.close();
				}
			} catch (SQLException e) {
				stat = null;
				e.printStackTrace();
				throw new RuntimeException(e);
			} finally {
				if(conn != null){
					try {
						conn.close();
					} catch (SQLException e) {
						conn = null;
						e.printStackTrace();
						throw new RuntimeException(e);
					}
				}
			}
		}
	}
}












