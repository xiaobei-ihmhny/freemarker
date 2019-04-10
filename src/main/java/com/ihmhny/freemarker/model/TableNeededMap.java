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
        needTablesMap.put("goods", "goods");
        needTablesMap.put("miaosha_goods", "miaoshaGoods");
        needTablesMap.put("miaosha_order", "miaoshaOrder");
        needTablesMap.put("miaosha_user", "MiaoshaUser");
        needTablesMap.put("order_info", "orderInfo");
        needTablesMap.put("user", "user");
        //===============================================//
        needTablesList.add("goods");
        needTablesList.add("miaosha_goods");
        needTablesList.add("miaosha_order");
        needTablesList.add("miaosha_user");
        needTablesList.add("order_info");
        needTablesList.add("user");
        //===============================================//
        moduleMap.put("goods", "goods");
        moduleMap.put("miaosha_goods", "trade");
        moduleMap.put("miaosha_order", "trade");
        moduleMap.put("miaosha_user", "trade");
        moduleMap.put("order_info", "order");
        moduleMap.put("user", "user");
        //===============================================//
        requestMappingMap.put("goods", "goods");
        requestMappingMap.put("miaosha_goods", "miaosha/goods");
        requestMappingMap.put("miaosha_order", "miaosha/order");
        requestMappingMap.put("miaosha_user", "miaosha/user");
        requestMappingMap.put("order_info", "order/info");
        requestMappingMap.put("user", "user");
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
