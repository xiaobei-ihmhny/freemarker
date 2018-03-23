package com.ihmhny.freemarker.model;

import com.ihmhny.freemarker.utils.GenerateNeedMap;
import com.ihmhny.freemarker.utils.PropUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 需要生成的表名和类名之间的对应关系
 *
 * @author Xiaobei
 * @create 2017-06-24 16:36
 */
public class TableNeededMap {

    /**
     * 表名与类名之间对应关系的map集合
     */
    public static Map<String,String> needTablesMap = new HashMap<>();

    public static Map<String,String> moduleMap = new HashMap<>();

    public static Map<String,String> requestMappingMap = new HashMap<>();


    /**
     * 表名的集合
     */
    public static List<String> needTablesList = new ArrayList<>();

    static {
//        needTablesMap.put("iot_category", "Category");
//        needTablesMap.put("iot_command", "Command");
//        needTablesMap.put("iot_device", "Device");
        needTablesMap.put("iot_product", "Product");
//        needTablesMap.put("iot_property", "Property");
//        needTablesMap.put("iot_property_enum", "PropertyEnum");
        //===============================================//
        needTablesList.add("iot_category");
        needTablesList.add("iot_command");
        needTablesList.add("iot_device");
        needTablesList.add("iot_product");
        needTablesList.add("iot_property");
        needTablesList.add("iot_property_enum");
        //===============================================//
        moduleMap.put("iot_category", "product");
        moduleMap.put("iot_command", "product");
        moduleMap.put("iot_device", "device");
        moduleMap.put("iot_product", "product");
        moduleMap.put("iot_property", "product");
        moduleMap.put("iot_property_enum", "product");
        //===============================================//
        requestMappingMap.put("iot_category", "iot/category");
        requestMappingMap.put("iot_command", "iot/command");
        requestMappingMap.put("iot_device", "iot/device");
        requestMappingMap.put("iot_product", "iot/product");
        requestMappingMap.put("iot_property", "iot/property");
        requestMappingMap.put("iot_property_enum", "iot/property/enum");
    }


    public static void main(String[] args){
        char fieldSeparator = PropUtils.getPorp("fieldSeparator").toCharArray()[0];
        System.out.println("    //===============================================//");
        GenerateNeedMap.printTableNameToPojoMap("needTablesMap",fieldSeparator);
        System.out.println("    //===============================================//");
        GenerateNeedMap.printTableNamesMap("needTablesList",fieldSeparator);
        System.out.println("    //===============================================//");
        GenerateNeedMap.printTableNameToModuleMap("moduleMap",fieldSeparator);
        System.out.println("    //===============================================//");
        GenerateNeedMap.printRequestMappingMap("requestMappingMap",fieldSeparator);
    }

}
