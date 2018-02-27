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
        needTablesMap.put("role", "role");
        needTablesMap.put("system_button", "SystemButton");
        needTablesMap.put("system_cache", "SystemCache");
        needTablesMap.put("system_dict", "SystemDict");
        needTablesMap.put("system_function", "SystemFunction");
        needTablesMap.put("system_menu", "SystemMenu");
        needTablesMap.put("system_sms_template", "SystemSmsTemplate");
        needTablesMap.put("tenant", "tenant");
        needTablesMap.put("tenant_button", "TenantButton");
        needTablesMap.put("tenant_domain", "TenantDomain");
        needTablesMap.put("tenant_function", "TenantFunction");
        needTablesMap.put("tenant_menu", "TenantMenu");
        needTablesMap.put("tenant_sms_template", "TenantSmsTemplate");
        needTablesMap.put("user", "user");
        //===============================================//
        needTablesList.add("role");
        needTablesList.add("system_button");
        needTablesList.add("system_cache");
        needTablesList.add("system_dict");
        needTablesList.add("system_function");
        needTablesList.add("system_menu");
        needTablesList.add("system_sms_template");
        needTablesList.add("tenant");
        needTablesList.add("tenant_button");
        needTablesList.add("tenant_domain");
        needTablesList.add("tenant_function");
        needTablesList.add("tenant_menu");
        needTablesList.add("tenant_sms_template");
        needTablesList.add("user");
        //===============================================//
        fileNameMap.put("role", "role");
        fileNameMap.put("system_button", "SystemServerButton");
        fileNameMap.put("system_cache", "SystemServerCache");
        fileNameMap.put("system_dict", "SystemServerDict");
        fileNameMap.put("system_function", "SystemServerFunction");
        fileNameMap.put("system_menu", "SystemServerMenu");
        fileNameMap.put("system_sms_template", "SystemServerSms_template");
        fileNameMap.put("tenant", "tenant");
        fileNameMap.put("tenant_button", "TenantServerButton");
        fileNameMap.put("tenant_domain", "TenantServerDomain");
        fileNameMap.put("tenant_function", "TenantServerFunction");
        fileNameMap.put("tenant_menu", "TenantServerMenu");
        fileNameMap.put("tenant_sms_template", "TenantServerSms_template");
        fileNameMap.put("user", "user");
        //===============================================//
        systemMap.put("role", "role");
        systemMap.put("system_button", "system");
        systemMap.put("system_cache", "system");
        systemMap.put("system_dict", "system");
        systemMap.put("system_function", "system");
        systemMap.put("system_menu", "system");
        systemMap.put("system_sms_template", "system");
        systemMap.put("tenant", "tenant");
        systemMap.put("tenant_button", "tenant");
        systemMap.put("tenant_domain", "tenant");
        systemMap.put("tenant_function", "tenant");
        systemMap.put("tenant_menu", "tenant");
        systemMap.put("tenant_sms_template", "tenant");
        systemMap.put("user", "user");
        //===============================================//
        moduleMap.put("role", "role");
        moduleMap.put("system_button", "button");
        moduleMap.put("system_cache", "cache");
        moduleMap.put("system_dict", "dict");
        moduleMap.put("system_function", "function");
        moduleMap.put("system_menu", "menu");
        moduleMap.put("system_sms_template", "sms_template");
        moduleMap.put("tenant", "tenant");
        moduleMap.put("tenant_button", "button");
        moduleMap.put("tenant_domain", "domain");
        moduleMap.put("tenant_function", "function");
        moduleMap.put("tenant_menu", "menu");
        moduleMap.put("tenant_sms_template", "sms_template");
        moduleMap.put("user", "user");
        //===============================================//
        requestMappingMap.put("role", "role");
        requestMappingMap.put("system_button", "system/button");
        requestMappingMap.put("system_cache", "system/cache");
        requestMappingMap.put("system_dict", "system/dict");
        requestMappingMap.put("system_function", "system/function");
        requestMappingMap.put("system_menu", "system/menu");
        requestMappingMap.put("system_sms_template", "system/sms");
        requestMappingMap.put("tenant", "tenant");
        requestMappingMap.put("tenant_button", "tenant/button");
        requestMappingMap.put("tenant_domain", "tenant/domain");
        requestMappingMap.put("tenant_function", "tenant/function");
        requestMappingMap.put("tenant_menu", "tenant/menu");
        requestMappingMap.put("tenant_sms_template", "tenant/sms");
        requestMappingMap.put("user", "user");
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
