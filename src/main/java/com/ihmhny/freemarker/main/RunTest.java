package com.ihmhny.freemarker.main;

import com.ihmhny.freemarker.model.FileNameMap;
import com.ihmhny.freemarker.model.FileSavePathMap;
import com.ihmhny.freemarker.model.PackageNames;
import com.ihmhny.freemarker.model.TableNeededMap;
import com.ihmhny.freemarker.utils.PropUtils;

import java.util.*;

/**
 * 运行前测试
 *
 * @author Xiaobei
 * @create 2017-07-01 17:05
 */
public class RunTest {

    /**
     * 测试相关包名，类名，路径名是否正确，以降低出错的概率
     * @param args
     */
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("=====当前的生成环境为：" + ("product".equals(PropUtils.getPorp("env"))?"生产环境":"测试环境"));
        System.out.println("=====要生成的表如下：");
        List<String> keyList = new ArrayList<>();
        Set<Map.Entry<String, String>> entrySet = TableNeededMap.needTablesMap.entrySet();
        for(Map.Entry<String, String> set : entrySet){
            System.out.println("表："+set.getKey() + "===" + set.getValue());
            keyList.add(set.getKey());
        }
        String tableName = keyList.get(random.nextInt(keyList.size()));
        String className = TableNeededMap.needTablesMap.get(tableName);
        tableName = "yz_log_act";
        className = "LogAct";
        System.out.println("=====表名为："+tableName);
        System.out.println("=====类名为："+className);
        System.out.println("=====要生成的表的存放路径如下：");
        System.out.println("pojo保存路径"+FileSavePathMap.getPojoSavePath(tableName));
        System.out.println("searchPojo保存路径"+FileSavePathMap.getSearchPojoSavePath(tableName));
        System.out.println("updatePojo保存路径"+FileSavePathMap.getUpdatePojoFilePath(tableName));
        System.out.println("mapper接口保存路径"+FileSavePathMap.getDaoFilePath(tableName));
        System.out.println("mapper.xml测试类保存路径"+FileSavePathMap.getMapperFilePath());
        System.out.println("mapper_ext.xml测试类保存路径"+FileSavePathMap.getMapperExtFilePath());
        System.out.println("service接口保存路径"+FileSavePathMap.getServiceFilePath(tableName));
        System.out.println("serviceImpl保存路径"+FileSavePathMap.getServiceImplFilePath(tableName));
        System.out.println("controller保存路径"+FileSavePathMap.getControllerFilePath(tableName));
        System.out.println("dao测试类保存路径"+FileSavePathMap.getDaoTestFilePath(tableName));
        System.out.println("service测试类保存路径"+FileSavePathMap.getServiceTestFilePath(tableName));
        System.out.println("controller测试类保存路径"+FileSavePathMap.getControllerTestFilePath(tableName));
        System.out.println("=====要使用的模板文件名如下：");
        System.out.println("searchPojo模板文件名为：" + PropUtils.getPorp("searchVOFtlFileName"));
        System.out.println("updatePojo模板文件名为：" + PropUtils.getPorp("updateVOFtlFileName"));
        System.out.println("pojo模板文件名为：" + PropUtils.getPorp("pojoFtlFileName"));
        System.out.println("mapper接口模板文件名为：" + PropUtils.getPorp("mapperInterfaceFtlFileName"));
        System.out.println("mapper.xml模板文件名为：" + PropUtils.getPorp("mapperXMlFtlFileName"));
        System.out.println("mapper扩展模板文件名为：" + PropUtils.getPorp("mapperExtXmlFtlFileName"));
        System.out.println("service模板文件名为：" + PropUtils.getPorp("serviceFtlFileName"));
        System.out.println("serviceImpl模板文件名为：" + PropUtils.getPorp("serviceImplFtlFileName"));
        System.out.println("controller模板文件名为：" + PropUtils.getPorp("controllerFtlFileName"));
        System.out.println("dao测试模板文件名为：" + PropUtils.getPorp("daoTestFtlFileName"));
        System.out.println("service测试模板文件名为：" + PropUtils.getPorp("serviceTestFtlFileName"));
        System.out.println("contorller测试模板文件名为：" + PropUtils.getPorp("controllerTestFtlFileName"));
        System.out.println("=====要生成的包名如下：");
        System.out.println("searchPojo包路径为：" + PackageNames.getSearchPojoPackageName(tableName));
        System.out.println("updatePojo包路径为：" + PackageNames.getUpdatePojoPackageName(tableName));
        System.out.println("pojo包路径为：" + PackageNames.getPojoPackageName(tableName));
        System.out.println("mapper接口包路径为：" + PackageNames.getDaoPackageName(tableName));
        System.out.println("service接口包路径为：" + PackageNames.getServicePackageName(tableName));
        System.out.println("serviceImpl包路径为：" + PackageNames.getServiceImplPackageName(tableName));
        System.out.println("controller包路径为：" + PackageNames.getControllerTestPackageName(tableName));
        System.out.println("dao测试类包路径为：" + PackageNames.getDaoTestPackageName(tableName));
        System.out.println("service测试类包路径为：" + PackageNames.getServiceTestPackageName(tableName));
        System.out.println("controller测试类包路径为：" + PackageNames.getControllerTestPackageName(tableName));
        System.out.println("=====要生成文件的文件名如下：");
        System.out.println("searchPojo文件的文件名："+ FileNameMap.getSearchPojoFileName(className));
        System.out.println("updatePojo文件的文件名："+ FileNameMap.getUpdatePojoFileName(className));
        System.out.println("pojo文件的文件名："+ FileNameMap.getPojoFileName(className));
        System.out.println("mapper接口文件的文件名："+ FileNameMap.getDaoFileName(className));
        System.out.println("mapper.xml文件的文件名："+ FileNameMap.getMapperFileName(className));
        System.out.println("mapper扩展文件的文件名："+ FileNameMap.getMapperExtFileName(className));
        System.out.println("service文件的文件名："+ FileNameMap.getServiceFileName(className));
        System.out.println("serviceimpl文件的文件名："+ FileNameMap.getServiceImplFileName(className));
        System.out.println("controller文件的文件名："+ FileNameMap.getControllerFileName(className));
        System.out.println("dao测试文件的文件名："+ FileNameMap.getDaoTestFileName(className));
        System.out.println("service测试文件的文件名："+ FileNameMap.getServiceTestFileName(className));
        System.out.println("controller测试文件的文件名："+ FileNameMap.getControllerTestFileName(className));

    }

}
