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

    public static Map<String,String> systemMap = new HashMap<>();

    public static Map<String,String> fileNameMap = new HashMap<>();

    public static Map<String,String> requestMappingMap = new HashMap<>();


    /**
     * 表名的集合
     */
    public static List<String> needTablesList = new ArrayList<>();

    static {
//        needTablesMap.put("system_button", "SystemButton");
//        needTablesMap.put("system_dict", "SystemDict");
//        needTablesMap.put("system_function", "SystemFunction");
        needTablesMap.put("system_menu", "SystemMenu");
//        needTablesMap.put("tenant_button", "TenantButton");
//        needTablesMap.put("tenant_dict", "TenantDict");
//        needTablesMap.put("tenant_function", "TenantFunction");
//        needTablesMap.put("tenant_menu", "TenantMenu");
        //===============================================//
        needTablesList.add("system_button");
        needTablesList.add("system_dict");
        needTablesList.add("system_function");
        needTablesList.add("system_menu");
        needTablesList.add("tenant_button");
        needTablesList.add("tenant_dict");
        needTablesList.add("tenant_function");
        needTablesList.add("tenant_menu");
        //===============================================//
        fileNameMap.put("system_button", "SystemServerButton");
        fileNameMap.put("system_dict", "SystemServerDict");
        fileNameMap.put("system_function", "SystemServerFunction");
        fileNameMap.put("system_menu", "SystemServerMenu");
        fileNameMap.put("tenant_button", "TenantServerButton");
        fileNameMap.put("tenant_dict", "TenantServerDict");
        fileNameMap.put("tenant_function", "TenantServerFunction");
        fileNameMap.put("tenant_menu", "TenantServerMenu");
        //===============================================//
        systemMap.put("system_button", "system");
        systemMap.put("system_dict", "system");
        systemMap.put("system_function", "system");
        systemMap.put("system_menu", "system");
        systemMap.put("tenant_button", "tenant");
        systemMap.put("tenant_dict", "tenant");
        systemMap.put("tenant_function", "tenant");
        systemMap.put("tenant_menu", "tenant");
        //===============================================//
        moduleMap.put("system_button", "button");
        moduleMap.put("system_dict", "dict");
        moduleMap.put("system_function", "function");
        moduleMap.put("system_menu", "menu");
        moduleMap.put("tenant_button", "button");
        moduleMap.put("tenant_dict", "dict");
        moduleMap.put("tenant_function", "function");
        moduleMap.put("tenant_menu", "menu");
        //===============================================//
        requestMappingMap.put("system_button", "/button");
        requestMappingMap.put("system_dict", "/dict");
        requestMappingMap.put("system_function", "/function");
        requestMappingMap.put("system_menu", "/menu");
        requestMappingMap.put("tenant_button", "/button");
        requestMappingMap.put("tenant_dict", "/dict");
        requestMappingMap.put("tenant_function", "/function");
        requestMappingMap.put("tenant_menu", "/menu");
    }


    public static void main(String[] args){
        char fieldSeparator = PropUtils.getPorp("fieldSeparator").toCharArray()[0];
        System.out.println("    //===============================================//");
        GenerateNeedMap.printTableNameToPojoMap("needTablesMap",fieldSeparator);
        System.out.println("    //===============================================//");
        GenerateNeedMap.printTableNamesMap("needTablesList",fieldSeparator);
        System.out.println("    //===============================================//");
        GenerateNeedMap.printTableNameToFileNameMap("fileNameMap",fieldSeparator);
        System.out.println("    //===============================================//");
        GenerateNeedMap.printTableNameToSystemMap("systemMap",fieldSeparator);
        System.out.println("    //===============================================//");
        GenerateNeedMap.printTableNameToModuleMap("moduleMap",fieldSeparator);
        System.out.println("    //===============================================//");
        GenerateNeedMap.printRequestMappingMap("requestMappingMap",fieldSeparator);
    }

}
