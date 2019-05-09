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
        needTablesMap.put("after_sale_arbitration", "AfterSaleArbitration");
        //===============================================//
        needTablesList.add("after_sale_arbitration");
        //===============================================//
        moduleMap.put("after_sale_arbitration", "after");
        //===============================================//
        requestMappingMap.put("after_sale_arbitration", "after/sale/arbitration");
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
