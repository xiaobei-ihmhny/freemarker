package com.ihmhny.freemarker.test;

import com.ihmhny.freemarker.utils.GenerateNeedMap;
import org.junit.Test;

/**
 * 测试对应关系生成情况
 *
 * @author xiaobei-ihmhny
 * @create 2017-07-01 16:01
 */
public class GenerateNeedMapTest {

    /**
     * 测试表名和实体名之间对应关系
     */
    @Test
    public void testConvertTableNameToPojo(){
        char separator = '_';
        String tableName = "ys_contract";
        String s = GenerateNeedMap.convertTableNameToPojo(separator, tableName);
        System.out.println(s);
    }

    /**
     * 测试表名和模块名之间的对应关系
     */
    @Test
    public void testConvertTableNameToModule(){
        char separator = '_';
        String tableName = "ys_contract";
        String s = GenerateNeedMap.convertTableNameToModule(separator, tableName);
        System.out.println(s);
    }

    @Test
    public void testconvertTableNameToRequestMappingName(){
        char separator = '_';
        String tableName = "bms_user_customer_cer_file";
        String s = GenerateNeedMap.convertTableNameToRequestMappingName(separator, tableName);
        System.out.println(s);
    }

    /**
     * 测试从数据库获取所有的表名
     */
    @Test
    public void testPrintTableNameToPojoMap(){
        GenerateNeedMap.printTableNameToPojoMap("needTablesMap",'_');
    }

    /**
     * 测试从数据库获取所有的模块名
     */
    @Test
    public void testPrintTableNameToModuleMap(){
        GenerateNeedMap.printTableNameToModuleMap("moduleMap",'_');
    }

    /**
     * 测试从数据库获取所有的表名
     */
    @Test
    public void testPrintTableNamesMap(){
        GenerateNeedMap.printTableNamesMap("needTablesList",'_');
    }

    @Test
    public void testPrintRequestMappingMap(){
        GenerateNeedMap.printRequestMappingMap("requestMappingMap",'_');
    }



}
