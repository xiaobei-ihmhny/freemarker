package com.ihmhny.freemarker.utils;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author xiaobei
 * @version 1.2
 * @project yzys
 * @class_name GenerateNeedMap
 * @date 2017-07-01 15:45
 * @description 通过控制台打印表名与实体名、表名与映射名、表名与模块名的对应关系
 */
public class GenerateNeedMap {

    private static Logger log = Logger.getLogger(GenerateNeedMap.class);

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    /**
     * 打印表名和类名之间的对应关系
     * @param pojoMapName 存放表名和类名之间关系的map集合
     * @param separator 表名中字段的分隔符
     */
    public static void printTableNameToPojoMap(String pojoMapName, char separator) {
        try {
            String sql = "show tables";
            conn = JDBCUtils.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String tableName = rs.getString(1);
                //key为数据库表名
                String pojoName = convertTableNameToPojo(separator, tableName);
                String generateResult = pojoMapName + ".put(\"" + tableName + "\", \"" + pojoName + "\");";
                System.out.println(generateResult);
            }
        } catch (Exception e) {
            log.error("读取数据库失败，失败信息为："+e.getMessage());
        }
    }

    /**
     * 打印表名和模块名的对应关系
     * @param moduleMapName 存放表名和模块名之间关系的map集合
     * @param separator 表名中字段的分隔符
     */
    public static void printTableNameToModuleMap(String moduleMapName, char separator) {
        try {
            String sql = "show tables";
            conn = JDBCUtils.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String tableName = rs.getString(1);
                //key为数据库表名
                String moduleName = convertTableNameToModule(separator, tableName);
                String generateResult = moduleMapName + ".put(\"" + tableName + "\", \"" + moduleName + "\");";
                System.out.println(generateResult);
            }
        } catch (Exception e) {
            log.error("读取数据库失败，失败信息为："+e.getMessage());
        }
    }

    /**
     * 打印表名和映射名的对应关系
     * @param requestMappingMapName 存放表名和映射名之间关系的map集合
     * @param separator 表名中字段的分隔符
     */
    public static void printRequestMappingMap(String requestMappingMapName, char separator) {
        try {
            String sql = "show tables";
            conn = JDBCUtils.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String tableName = rs.getString(1);
                //key为数据库表名
                String requestMappingName = convertTableNameToRequestMappingName(separator, tableName);
                String generateResult = requestMappingMapName + ".put(\"" + tableName + "\", \"" + requestMappingName + "\");";
                System.out.println(generateResult);
            }
        } catch (Exception e) {
            log.error("读取数据库失败，失败信息为："+e.getMessage());
        }
    }

    /**
     * 打印表名和模块名的对应关系
     * @param tablesMapName 存放表名和模块名之间关系的map集合
     * @param separator 表名中字段的分隔符
     */
    public static void printTableNamesMap(String tablesMapName, char separator) {
        try {
            String sql = "show tables";
            conn = JDBCUtils.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String tableName = rs.getString(1);
                String generateResult = tablesMapName + ".add(\"" + tableName + "\");";
                System.out.println(generateResult);
            }
        } catch (Exception e) {
            log.error("读取数据库失败，失败信息为："+e.getMessage());
        }
    }

    /**
     * 将表名转换为模块名
     * @param separator 表名中分隔符
     * @param tableName 表名
     * @return 表名对应的模块名
     */
    public static String convertTableNameToModule(char separator, String tableName) {
        //判断字符串中是否含有分隔符
        String variable = tableName.toLowerCase();
        if(variable.indexOf(separator) > -1){//如果有
            //拿到模块名
            variable = variable.substring(0,variable.indexOf("_"));
        }
        return variable;
    }

    /**
     * 表名到实体名之间的对应关系
     * @param separator 表名中字段分隔符
     * @param tableName 表名
     * @return
     */
    public static String convertTableNameToPojo(char separator, String tableName){
        //判断字符串中是否含有分隔符
        String variable = tableName.toLowerCase();
        if(variable.indexOf(separator) > -1){//如果有
            //去掉模块名
            variable = variable.substring(variable.indexOf("_")+1);
            char[] varChar = variable.toCharArray();
            //首字母大写
            varChar[0] = Character.toUpperCase(varChar[0]);
            for(int i=1; i<varChar.length; i++){
                if(varChar[i] == separator && i < varChar.length-1){
                    varChar[i+1] = Character.toUpperCase(varChar[i+1]);
                }
            }
            variable = new String(varChar).replaceAll(Character.toString(separator), "");
        }
        return variable;
    }

    /**
     * 将表名转换为对应的映射名
     * @param separator 表名中的分隔符
     * @param tableName 表名
     * @return 表名对应的映射名
     */
    public static String convertTableNameToRequestMappingName(char separator, String tableName) {
        //判断字符串中是否含有分隔符
        String variable = tableName.toLowerCase();
        if(variable.indexOf(separator) > -1){//如果有
            variable = variable.replaceAll(String.valueOf(separator), "/");
        }
        return variable;
    }
}
