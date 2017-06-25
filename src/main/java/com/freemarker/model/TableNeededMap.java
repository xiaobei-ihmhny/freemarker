package com.freemarker.model;

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

    /**
     * 表名的集合
     */
    public static List<String> needTablesList = new ArrayList<>();

    static {
//        needTablesMap.put("__ys_goods_warehouse","GoodsWarehouse");
//        needTablesMap.put("ams_user","User");
//        needTablesMap.put("ams_user_corp_info","UserCorpInfo");
//        needTablesMap.put("ams_user_file","UserFile");
//        needTablesMap.put("ams_user_img","UserImg");
//        needTablesMap.put("ams_user_log","UserLog");
//        needTablesMap.put("ams_user_menu","UserMenu");
//        needTablesMap.put("ams_user_ref_role","UserRefRole");
//        needTablesMap.put("ams_user_role","UserRole");
//        needTablesMap.put("ams_user_role_ref_menu","UserRoleRefMenu");
//        needTablesMap.put("ams_user_validation_message","UserValidationMessage");
        needTablesMap.put("bms_common_region","CommonRegion");
        needTablesMap.put("bms_goods","Goods");
        needTablesMap.put("bms_goods_brand","GoodsBrand");
        needTablesMap.put("bms_goods_category","GoodsCategory");
        needTablesMap.put("bms_goods_sku","GoodsSku");
        needTablesMap.put("bms_warehouse","WareHouse");
//        needTablesMap.put("ys_contract_order","ContractOrder");
//        needTablesMap.put("ys_contract_template","ContractTemplate");
//        needTablesMap.put("ys_contract_user_bankinfo","ContractUserBankinfo");
//        needTablesMap.put("ys_goods_buy","GoodsBuy");
//        needTablesMap.put("ys_goods_sell","GoodsSell");
//        needTablesMap.put("ys_goods_sell_file","GoodsSellFile");
//        needTablesMap.put("ys_order_buy","OrderBuy");
//        needTablesMap.put("ys_order_log","OrderLog");
//        needTablesMap.put("ys_user_customer","UserCustomer");
//        needTablesMap.put("ys_user_customer_cer","UserCustomerCer");
//        needTablesMap.put("ys_user_customer_cer_file","UserCustomerCerFile");

        needTablesList.add("__ys_goods_warehouse");
        needTablesList.add("ams_user");
        needTablesList.add("ams_user_corp_info");
        needTablesList.add("ams_user_file");
        needTablesList.add("ams_user_img");
        needTablesList.add("ams_user_log");
        needTablesList.add("ams_user_menu");
        needTablesList.add("ams_user_ref_role");
        needTablesList.add("ams_user_role");
        needTablesList.add("ams_user_role_ref_menu");
        needTablesList.add("ams_user_validation_message");
        needTablesList.add("bms_common_region");
        needTablesList.add("bms_goods");
        needTablesList.add("bms_goods_brand");
        needTablesList.add("bms_goods_category");
        needTablesList.add("bms_goods_sku");
        needTablesList.add("bms_goods_sku1");
        needTablesList.add("bms_warehouse");
        needTablesList.add("ys_contract_order");
        needTablesList.add("ys_contract_template");
        needTablesList.add("ys_contract_user_bankinfo");
        needTablesList.add("ys_goods_buy");
        needTablesList.add("ys_goods_sell");
        needTablesList.add("ys_goods_sell_file");
        needTablesList.add("ys_order_buy");
        needTablesList.add("ys_order_log");
        needTablesList.add("ys_user_customer");
        needTablesList.add("ys_user_customer_cer");
        needTablesList.add("ys_user_customer_cer_file");
    }

}
