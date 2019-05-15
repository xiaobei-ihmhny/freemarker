package com.ihmhny.freemarker.model;

import com.ihmhny.freemarker.utils.PropUtils;

import java.util.Map;

/**
 * 从配置文件中读取相关配置，获取所有的文件保存路径
 *
 * @author xiaobei-ihmhny
 * @create 2017-06-28 21:15
 */
public class FileSavePathMap {

    /**
     * 获取所有的配置信息的map集合
     */
    private static Map<String, String> propertisMap = PropUtils.getAllProps();

    /**
     * 获取当前的生成环境
     */
    private static String env = PropUtils.getPorp("env");

    /**
     * 获取包全名对应的包全路径名
     * @param pojoPackageName 包全名
     * @return 包全名对应的包全路径名
     */
    private static String getSavePathByPackageName(String pojoPackageName) {
        String replace = pojoPackageName.replace(".", "\\");
        return replace + "\\";
    }

    /**
     * 获取查询pojo保存路径
     * @param tableName 表名
     * @return
     */
    public static String getSearchPojoSavePath(String tableName){
        String packagePath = getSavePathByPackageName(PackageNames.getSearchPojoPackageName(tableName));
        if("product".equals(env)){
            return propertisMap.get("generateFilePath") + propertisMap.get("searchPojoFilePath") + packagePath;
        }else {
            return propertisMap.get(env + "_generateFilePath") + propertisMap.get(env + "_searchPojoFilePath");
        }
    }

    /**
     * 获取更新pojo保存路径
     * @param tableName 表名
     * @return
     */
    public static String getUpdatePojoFilePath(String tableName){
        String packagePath = getSavePathByPackageName(PackageNames.getUpdatePojoPackageName(tableName));
        if("product".equals(env)){
            return propertisMap.get("generateFilePath") + propertisMap.get("updatePojoFilePath") + packagePath;
        }else {
            return propertisMap.get(env + "_generateFilePath") + propertisMap.get(env + "_updatePojoFilePath");
        }
    }

    /**
     * 获取pojo保存路径
     * @param tableName 表名
     * @return
     */
    public static String getPojoSavePath(String tableName){
        String packagePath = getSavePathByPackageName(PackageNames.getPojoPackageName(tableName));
        if("product".equals(env)){
            return propertisMap.get("generateFilePath") + propertisMap.get("pojoFilePath") + packagePath;
        }else {
            return propertisMap.get(env + "_generateFilePath") + propertisMap.get(env + "_pojoFilePath");
        }
    }

    /**
     * 获取mapper接口保存路径
     * @param tableName 表名
     * @return
     */
    public static String getDaoFilePath(String tableName){
        String packagePath = getSavePathByPackageName(PackageNames.getDaoPackageName(tableName));
        if("product".equals(env)){
            return propertisMap.get("generateFilePath") + propertisMap.get("daoFilePath") + packagePath;
        }else {
            return propertisMap.get(env + "_generateFilePath") + propertisMap.get(env + "_daoFilePath");
        }
    }

    /**
     * 获取mapper.xml文件保存路径
     * @return
     */
    public static String getMapperFilePath(){
        if("product".equals(env)){
            return propertisMap.get("generateFilePath") + propertisMap.get("mapperFilePath");
        }else {
            return propertisMap.get(env + "_generateFilePath") + propertisMap.get(env + "_mapperFilePath");
        }
    }

    /**
     * 获取mapper-ext.xml文件保存路径
     * @return
     */
    public static String getMapperExtFilePath(){
        if("product".equals(env)){
            return propertisMap.get("generateFilePath") + propertisMap.get("mapperExtFilePath");
        }else {
            return propertisMap.get(env + "_generateFilePath") + propertisMap.get(env + "_mapperExtFilePath");
        }
    }

    /**
     * 获取Service接口保存路径
     * @param tableName 表名
     * @return
     */
    public static String getServiceFilePath(String tableName){
        String packagePath = getSavePathByPackageName(PackageNames.getServicePackageName(tableName));
        if("product".equals(env)){
            return propertisMap.get("generateFilePath") + propertisMap.get("serviceFilePath") + packagePath;
        }else {
            return propertisMap.get(env + "_generateFilePath") + propertisMap.get(env + "_serviceFilePath");
        }
    }

    /**
     * 获取ServiceImpl保存路径
     * @param tableName 表名
     * @return
     */
    public static String getServiceImplFilePath(String tableName){
        String packagePath = getSavePathByPackageName(PackageNames.getServiceImplPackageName(tableName));
        if("product".equals(env)){
            return propertisMap.get("generateFilePath") + propertisMap.get("serviceImplFilePath") + packagePath;
        }else {
            return propertisMap.get(env + "_generateFilePath") + propertisMap.get(env + "_serviceImplFilePath");
        }
    }

    /**
     * 获取Controller保存路径
     * @param tableName 表名
     * @return
     */
    public static String getControllerFilePath(String tableName){
        String packagePath = getSavePathByPackageName(PackageNames.getControllerPackageName(tableName));
        if("product".equals(env)){
            return propertisMap.get("generateFilePath") + propertisMap.get("controllerFilePath") + packagePath;
        }else {
            return propertisMap.get(env + "_generateFilePath") + propertisMap.get(env + "_controllerFilePath");
        }
    }

    /**
     * 获取dao测试文件的保存路径
     * @param tableName 表名
     * @return
     */
    public static String getDaoTestFilePath(String tableName){
        String daoTestPackageName = getSavePathByPackageName(PackageNames.getDaoTestPackageName(tableName));
        if("product".equals(env)){
            return propertisMap.get("testFilePath") + daoTestPackageName;
        }else {
            return propertisMap.get(env + "_testFilePath") + propertisMap.get(env + "_daoTestFilePath");
        }
    }


    /**
     * 获取service测试文件的保存路径
     * @param tableName 表名
     * @return
     */
    public static String getServiceTestFilePath(String tableName){
        String servcieTestPackageName = getSavePathByPackageName(PackageNames.getServiceTestPackageName(tableName));
        if("product".equals(env)){
            return propertisMap.get("testFilePath") + servcieTestPackageName;
        }else {
            return propertisMap.get(env + "_testFilePath") + propertisMap.get(env + "_serviceTestFilePath");
        }
    }


    /**
     * 获取controller测试文件的保存路径
     * @param tableName 表名
     * @return
     */
    public static String getControllerTestFilePath(String tableName){
        String controllerTestPackageName = getSavePathByPackageName(PackageNames.getControllerTestPackageName(tableName));
        if("product".equals(env)){
            return propertisMap.get("testFilePath") + controllerTestPackageName;
        }else {
            return propertisMap.get(env + "_testFilePath") + propertisMap.get(env + "_controllerTestFilePath");
        }
    }


}
