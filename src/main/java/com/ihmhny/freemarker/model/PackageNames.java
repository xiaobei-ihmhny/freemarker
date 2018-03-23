package com.ihmhny.freemarker.model;

import com.ihmhny.freemarker.utils.PropUtils;

import java.util.Map;

/**
 * 获取所有的包路径
 *
 * @author Xiaobei
 * @create 2017-06-28 20:16
 */
public class PackageNames {

    /**
     * 获取所有的配置信息的map集合
     */
    private static Map<String, String> propertisMap = PropUtils.getAllProps();

    /**
     * 获取当前的生成环境
     */
    private static String env = PropUtils.getPorp("env");

    /**
     * 获取表名对应的模块名
     * @param tableName 表名
     * @return 表名对应的模块名
     */
    public static String getModuleName(String tableName){
        return TableNeededMap.moduleMap.get(tableName);
    }

    /**
     * 获取pojo包路径
     * @param tableName 表名
     * @return pojo的包路径
     */
    public static String getPojoPackageName(String tableName){
        String moduleName = getModuleName(tableName);
        return propertisMap.get("packageName")
                + propertisMap.get("pojoPackageName") + ("."+ (moduleName ==null?"": moduleName));
    }

    /**
     * 获取查询pojo的包路径
     * @param tableName 表名
     * @return 查询pojo的包路径
     */
    public static String getSearchPojoPackageName(String tableName){
        String moduleName = getModuleName(tableName);
        return propertisMap.get("packageName")
                 + propertisMap.get("searchPojoPackageName") + ("."+ (moduleName ==null?"": moduleName));
    }

    /**
     * 获取更新pojo的包路径
     * @param tableName 表名
     * @return 更新pojo的包路径
     */
    public static String getUpdatePojoPackageName(String tableName){
        String moduleName = getModuleName(tableName);
        return propertisMap.get("packageName")
                + propertisMap.get("updatePojoPackageName") + ("."+ (moduleName ==null?"": moduleName));
    }

    /**
     * 获取dao的包路径
     * @param tableName 表名
     * @return 更新dao的包路径
     */
    public static String getDaoPackageName(String tableName){
        String moduleName = getModuleName(tableName);
        return propertisMap.get("packageName")
                + propertisMap.get("daoPackageName") + ("."+ (moduleName ==null?"": moduleName));
    }

    /**
     * 获取service的包路径
     * @param tableName 表名
     * @return service的包路径
     */
    public static String getServicePackageName(String tableName){
        String moduleName = getModuleName(tableName);
        return propertisMap.get("packageName")
                + propertisMap.get("servicePackageName") + ("."+ (moduleName ==null?"": moduleName));
    }

    /**
     * 获取serviceimpl的包路径
     * @param tableName 表名
     * @return serviceimpl的包路径
     */
    public static String getServiceImplPackageName(String tableName){
        String moduleName = getModuleName(tableName);
        return propertisMap.get("packageName")
                + propertisMap.get("serviceImplPackageName") + ("."+ (moduleName ==null?"": moduleName)) + ".impl";
    }

    /**
     * 获取controller的包路径
     * @param tableName 表名
     * @return controller的包路径
     */
    public static String getControllerPackageName(String tableName){
//        String moduleName = getModuleName(tableName);
        return propertisMap.get("packageName")
                + propertisMap.get("controllerPackageName");
    }

    /**
     * 获取测试类的包路径
     * @param tableName 表名
     * @return 测试类的包路径
     */
    public static String getTestPackageName(String tableName){
        String moduleName = getModuleName(tableName);
        return propertisMap.get("packageName")
                + propertisMap.get("testPackageName") + ("."+ (moduleName ==null?"": moduleName));

    }


    /**
     * 获取测试类Dao的包路径
     * @param tableName 表名
     * @return 测试类的包路径
     */
    public static String getDaoTestPackageName(String tableName){
        String moduleName = getModuleName(tableName);
        return propertisMap.get("packageName")
                + propertisMap.get("daoTestPackageName") + ("."+ (moduleName ==null?"": moduleName));

    }


    /**
     * 获取测试类Service的包路径
     * @param tableName 表名
     * @return 测试类的包路径
     */
    public static String getServiceTestPackageName(String tableName){
        String moduleName = getModuleName(tableName);
        return propertisMap.get("packageName")
                + propertisMap.get("serviceTestPackageName") + ("."+ (moduleName ==null?"": moduleName));

    }

    /**
     * 获取测试类的Controller包路径
     * @param tableName 表名
     * @return 测试类的包路径
     */
    public static String getControllerTestPackageName(String tableName){
        String moduleName = getModuleName(tableName);
        return propertisMap.get("packageName")
                + propertisMap.get("controllerTestPackageName") + ("."+ (moduleName ==null?"": moduleName));

    }

}
