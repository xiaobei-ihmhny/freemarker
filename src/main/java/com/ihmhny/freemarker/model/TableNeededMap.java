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
//        needTablesMap.put("pub_pay_city", "PayCity");
//        needTablesMap.put("pub_pay_node", "PayNode");
//        needTablesMap.put("webup_manage_actlog", "ManageActlog");
//        needTablesMap.put("webup_manage_menu", "ManageMenu");
//        needTablesMap.put("webup_manage_menurole", "ManageMenurole");
//        needTablesMap.put("webup_manage_role", "ManageRole");
//        needTablesMap.put("webup_manage_user", "ManageUser");
        needTablesMap.put("yz_bank_freight_pay", "BankFreightPay");
        needTablesMap.put("yz_bank_sign", "BankSign");
        needTablesMap.put("yz_dict", "Dict");
        needTablesMap.put("yz_dict_area", "DictArea");
        needTablesMap.put("yz_dict_json_data", "DictJsonData");
        needTablesMap.put("yz_erp_config", "ErpConfig");
        needTablesMap.put("yz_erp_datalink", "ErpDatalink");
        needTablesMap.put("yz_erp_userconfig", "ErpUserconfig");
        needTablesMap.put("yz_freight_payhis", "FreightPayhis");
        needTablesMap.put("yz_info_car", "InfoCar");
        needTablesMap.put("yz_info_goods", "InfoGoods");
        needTablesMap.put("yz_info_goods_askprice", "InfoGoodsAskprice");
        needTablesMap.put("yz_log_act", "LogAct");
        needTablesMap.put("yz_pingan_account", "PinganAccount");
        needTablesMap.put("yz_pingan_bundle", "PinganBundle");
        needTablesMap.put("yz_pingan_cash_flow", "PinganCashFlow");
        needTablesMap.put("yz_pingan_inout_money", "PinganInoutMoney");
        needTablesMap.put("yz_pingan_log", "PinganLog");
        needTablesMap.put("yz_pingan_log_account", "PinganLogAccount");
        needTablesMap.put("yz_pingan_log_balance", "PinganLogBalance");
        needTablesMap.put("yz_pingan_log_cash_flow", "PinganLogCashFlow");
//        needTablesMap.put("yz_pingan_log_inout_money", "PinganLogInoutMoney");
//        needTablesMap.put("yz_transport_driver", "TransportDriver");
//        needTablesMap.put("yz_transport_info", "TransportInfo");
//        needTablesMap.put("yz_transport_judge", "TransportJudge");
//        needTablesMap.put("yz_transport_photo", "TransportPhoto");
//        needTablesMap.put("yz_transport_plan", "TransportPlan");
//        needTablesMap.put("yz_transport_tracing", "TransportTracing");
//        needTablesMap.put("yz_user", "User");
//        needTablesMap.put("yz_user_bankinfo", "UserBankinfo");
//        needTablesMap.put("yz_user_consignor_info", "UserConsignorInfo");
//        needTablesMap.put("yz_user_contract", "UserContract");
//        needTablesMap.put("yz_user_corp", "UserCorp");
//        needTablesMap.put("yz_user_driver_group", "UserDriverGroup");
//        needTablesMap.put("yz_user_driver_groupids", "UserDriverGroupids");
//        needTablesMap.put("yz_user_driver_info", "UserDriverInfo");
//        needTablesMap.put("yz_user_driver_offenline", "UserDriverOffenline");
//        needTablesMap.put("yz_user_drivercontract", "UserDrivercontract");
//        needTablesMap.put("yz_user_feedback", "UserFeedback");
//        needTablesMap.put("yz_user_loaninginfo", "UserLoaninginfo");
//        needTablesMap.put("yz_user_logistics_carinfo", "UserLogisticsCarinfo");
//        needTablesMap.put("yz_user_logistics_info", "UserLogisticsInfo");
//        needTablesMap.put("yz_user_logistics_rentcorp", "UserLogisticsRentcorp");
//        needTablesMap.put("yz_user_pullmsg", "UserPullmsg");
//        needTablesMap.put("yz_user_role", "UserRole");
//        needTablesMap.put("yz_user_safepass", "UserSafepass");
//        needTablesMap.put("yz_user_subscribe", "UserSubscribe");
//        needTablesMap.put("yz_user_verify_sn", "UserVerifySn");
//        needTablesMap.put("zjjz_cnaps_bankinfo", "CnapsBankinfo");
        //===============================================//
        needTablesList.add("pub_pay_city");
        needTablesList.add("pub_pay_node");
        needTablesList.add("webup_manage_actlog");
        needTablesList.add("webup_manage_menu");
        needTablesList.add("webup_manage_menurole");
        needTablesList.add("webup_manage_role");
        needTablesList.add("webup_manage_user");
        needTablesList.add("yz_bank_freight_pay");
        needTablesList.add("yz_bank_sign");
        needTablesList.add("yz_dict");
        needTablesList.add("yz_dict_area");
        needTablesList.add("yz_dict_json_data");
        needTablesList.add("yz_erp_config");
        needTablesList.add("yz_erp_datalink");
        needTablesList.add("yz_erp_userconfig");
        needTablesList.add("yz_freight_payhis");
        needTablesList.add("yz_info_car");
        needTablesList.add("yz_info_goods");
        needTablesList.add("yz_info_goods_askprice");
        needTablesList.add("yz_log_act");
        needTablesList.add("yz_pingan_account");
        needTablesList.add("yz_pingan_bundle");
        needTablesList.add("yz_pingan_cash_flow");
        needTablesList.add("yz_pingan_inout_money");
        needTablesList.add("yz_pingan_log");
        needTablesList.add("yz_pingan_log_account");
        needTablesList.add("yz_pingan_log_balance");
        needTablesList.add("yz_pingan_log_cash_flow");
        needTablesList.add("yz_pingan_log_inout_money");
        needTablesList.add("yz_transport_driver");
        needTablesList.add("yz_transport_info");
        needTablesList.add("yz_transport_judge");
        needTablesList.add("yz_transport_photo");
        needTablesList.add("yz_transport_plan");
        needTablesList.add("yz_transport_tracing");
        needTablesList.add("yz_user");
        needTablesList.add("yz_user_bankinfo");
        needTablesList.add("yz_user_consignor_info");
        needTablesList.add("yz_user_contract");
        needTablesList.add("yz_user_corp");
        needTablesList.add("yz_user_driver_group");
        needTablesList.add("yz_user_driver_groupids");
        needTablesList.add("yz_user_driver_info");
        needTablesList.add("yz_user_driver_offenline");
        needTablesList.add("yz_user_drivercontract");
        needTablesList.add("yz_user_feedback");
        needTablesList.add("yz_user_loaninginfo");
        needTablesList.add("yz_user_logistics_carinfo");
        needTablesList.add("yz_user_logistics_info");
        needTablesList.add("yz_user_logistics_rentcorp");
        needTablesList.add("yz_user_pullmsg");
        needTablesList.add("yz_user_role");
        needTablesList.add("yz_user_safepass");
        needTablesList.add("yz_user_subscribe");
        needTablesList.add("yz_user_verify_sn");
        needTablesList.add("zjjz_cnaps_bankinfo");
        //===============================================//
        moduleMap.put("pub_pay_city", "pub");
        moduleMap.put("pub_pay_node", "pub");
        moduleMap.put("webup_manage_actlog", "webup");
        moduleMap.put("webup_manage_menu", "webup");
        moduleMap.put("webup_manage_menurole", "webup");
        moduleMap.put("webup_manage_role", "webup");
        moduleMap.put("webup_manage_user", "webup");
        moduleMap.put("yz_bank_freight_pay", "yz");
        moduleMap.put("yz_bank_sign", "yz");
        moduleMap.put("yz_dict", "yz");
        moduleMap.put("yz_dict_area", "yz");
        moduleMap.put("yz_dict_json_data", "yz");
        moduleMap.put("yz_erp_config", "yz");
        moduleMap.put("yz_erp_datalink", "yz");
        moduleMap.put("yz_erp_userconfig", "yz");
        moduleMap.put("yz_freight_payhis", "yz");
        moduleMap.put("yz_info_car", "yz");
        moduleMap.put("yz_info_goods", "yz");
        moduleMap.put("yz_info_goods_askprice", "yz");
        moduleMap.put("yz_log_act", "yz");
        moduleMap.put("yz_pingan_account", "yz");
        moduleMap.put("yz_pingan_bundle", "yz");
        moduleMap.put("yz_pingan_cash_flow", "yz");
        moduleMap.put("yz_pingan_inout_money", "yz");
        moduleMap.put("yz_pingan_log", "yz");
        moduleMap.put("yz_pingan_log_account", "yz");
        moduleMap.put("yz_pingan_log_balance", "yz");
        moduleMap.put("yz_pingan_log_cash_flow", "yz");
        moduleMap.put("yz_pingan_log_inout_money", "yz");
        moduleMap.put("yz_transport_driver", "yz");
        moduleMap.put("yz_transport_info", "yz");
        moduleMap.put("yz_transport_judge", "yz");
        moduleMap.put("yz_transport_photo", "yz");
        moduleMap.put("yz_transport_plan", "yz");
        moduleMap.put("yz_transport_tracing", "yz");
        moduleMap.put("yz_user", "yz");
        moduleMap.put("yz_user_bankinfo", "yz");
        moduleMap.put("yz_user_consignor_info", "yz");
        moduleMap.put("yz_user_contract", "yz");
        moduleMap.put("yz_user_corp", "yz");
        moduleMap.put("yz_user_driver_group", "yz");
        moduleMap.put("yz_user_driver_groupids", "yz");
        moduleMap.put("yz_user_driver_info", "yz");
        moduleMap.put("yz_user_driver_offenline", "yz");
        moduleMap.put("yz_user_drivercontract", "yz");
        moduleMap.put("yz_user_feedback", "yz");
        moduleMap.put("yz_user_loaninginfo", "yz");
        moduleMap.put("yz_user_logistics_carinfo", "yz");
        moduleMap.put("yz_user_logistics_info", "yz");
        moduleMap.put("yz_user_logistics_rentcorp", "yz");
        moduleMap.put("yz_user_pullmsg", "yz");
        moduleMap.put("yz_user_role", "yz");
        moduleMap.put("yz_user_safepass", "yz");
        moduleMap.put("yz_user_subscribe", "yz");
        moduleMap.put("yz_user_verify_sn", "yz");
        moduleMap.put("zjjz_cnaps_bankinfo", "zjjz");
        //===============================================//
        requestMappingMap.put("pub_pay_city", "pub/pay/city");
        requestMappingMap.put("pub_pay_node", "pub/pay/node");
        requestMappingMap.put("webup_manage_actlog", "webup/manage/actlog");
        requestMappingMap.put("webup_manage_menu", "webup/manage/menu");
        requestMappingMap.put("webup_manage_menurole", "webup/manage/menurole");
        requestMappingMap.put("webup_manage_role", "webup/manage/role");
        requestMappingMap.put("webup_manage_user", "webup/manage/user");
        requestMappingMap.put("yz_bank_freight_pay", "yz/bank/freight/pay");
        requestMappingMap.put("yz_bank_sign", "yz/bank/sign");
        requestMappingMap.put("yz_dict", "yz/dict");
        requestMappingMap.put("yz_dict_area", "yz/dict/area");
        requestMappingMap.put("yz_dict_json_data", "yz/dict/json/data");
        requestMappingMap.put("yz_erp_config", "yz/erp/config");
        requestMappingMap.put("yz_erp_datalink", "yz/erp/datalink");
        requestMappingMap.put("yz_erp_userconfig", "yz/erp/userconfig");
        requestMappingMap.put("yz_freight_payhis", "yz/freight/payhis");
        requestMappingMap.put("yz_info_car", "yz/info/car");
        requestMappingMap.put("yz_info_goods", "yz/info/goods");
        requestMappingMap.put("yz_info_goods_askprice", "yz/info/goods/askprice");
        requestMappingMap.put("yz_log_act", "yz/log/act");
        requestMappingMap.put("yz_pingan_account", "yz/pingan/account");
        requestMappingMap.put("yz_pingan_bundle", "yz/pingan/bundle");
        requestMappingMap.put("yz_pingan_cash_flow", "yz/pingan/cash/flow");
        requestMappingMap.put("yz_pingan_inout_money", "yz/pingan/inout/money");
        requestMappingMap.put("yz_pingan_log", "yz/pingan/log");
        requestMappingMap.put("yz_pingan_log_account", "yz/pingan/log/account");
        requestMappingMap.put("yz_pingan_log_balance", "yz/pingan/log/balance");
        requestMappingMap.put("yz_pingan_log_cash_flow", "yz/pingan/log/cash/flow");
        requestMappingMap.put("yz_pingan_log_inout_money", "yz/pingan/log/inout/money");
        requestMappingMap.put("yz_transport_driver", "yz/transport/driver");
        requestMappingMap.put("yz_transport_info", "yz/transport/info");
        requestMappingMap.put("yz_transport_judge", "yz/transport/judge");
        requestMappingMap.put("yz_transport_photo", "yz/transport/photo");
        requestMappingMap.put("yz_transport_plan", "yz/transport/plan");
        requestMappingMap.put("yz_transport_tracing", "yz/transport/tracing");
        requestMappingMap.put("yz_user", "yz/user");
        requestMappingMap.put("yz_user_bankinfo", "yz/user/bankinfo");
        requestMappingMap.put("yz_user_consignor_info", "yz/user/consignor/info");
        requestMappingMap.put("yz_user_contract", "yz/user/contract");
        requestMappingMap.put("yz_user_corp", "yz/user/corp");
        requestMappingMap.put("yz_user_driver_group", "yz/user/driver/group");
        requestMappingMap.put("yz_user_driver_groupids", "yz/user/driver/groupids");
        requestMappingMap.put("yz_user_driver_info", "yz/user/driver/info");
        requestMappingMap.put("yz_user_driver_offenline", "yz/user/driver/offenline");
        requestMappingMap.put("yz_user_drivercontract", "yz/user/drivercontract");
        requestMappingMap.put("yz_user_feedback", "yz/user/feedback");
        requestMappingMap.put("yz_user_loaninginfo", "yz/user/loaninginfo");
        requestMappingMap.put("yz_user_logistics_carinfo", "yz/user/logistics/carinfo");
        requestMappingMap.put("yz_user_logistics_info", "yz/user/logistics/info");
        requestMappingMap.put("yz_user_logistics_rentcorp", "yz/user/logistics/rentcorp");
        requestMappingMap.put("yz_user_pullmsg", "yz/user/pullmsg");
        requestMappingMap.put("yz_user_role", "yz/user/role");
        requestMappingMap.put("yz_user_safepass", "yz/user/safepass");
        requestMappingMap.put("yz_user_subscribe", "yz/user/subscribe");
        requestMappingMap.put("yz_user_verify_sn", "yz/user/verify/sn");
        requestMappingMap.put("zjjz_cnaps_bankinfo", "zjjz/cnaps/bankinfo");

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
