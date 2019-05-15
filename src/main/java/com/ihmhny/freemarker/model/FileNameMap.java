package com.ihmhny.freemarker.model;

import com.ihmhny.freemarker.utils.PropUtils;

/**
 * 从配置文件中读取相关配置，获取所有生成文件的文件名
 *
 * @author xiaobei-ihmhny
 * @create 2017-06-28 23:39
 */
public class FileNameMap {

    public static String getUpdatePojoFileName(String className){
        return className + PropUtils.getPorp("updatePojoSuffixName");
    }

    public static String getSearchPojoFileName(String className){
        return className + PropUtils.getPorp("searchPojoSuffixName");
    }

    public static String getPojoFileName(String className){
        return className + PropUtils.getPorp("pojoSuffixName");
    }

    public static String getDaoFileName(String className){
        return className + PropUtils.getPorp("DaoSuffixName");
    }

    public static String getMapperFileName(String className){
        return className + PropUtils.getPorp("MapperSuffixName");
    }

    public static String getMapperExtFileName(String className){
        return className + PropUtils.getPorp("MapperExtSuffixName");
    }

    public static String getServiceFileName(String className){
        return className + PropUtils.getPorp("ServiceSuffixName");
    }

    public static String getServiceImplFileName(String className){
        return className + PropUtils.getPorp("ServiceImplSuffixName");
    }

    public static String getControllerFileName(String className){
        return className + PropUtils.getPorp("ControllerSuffixName");
    }

    public static String getDaoTestFileName(String className){
        return className + PropUtils.getPorp("DaoTestSuffixName");
    }

    public static String getServiceTestFileName(String className){
        return className + PropUtils.getPorp("ServiceTestSuffixName");
    }

    public static String getControllerTestFileName(String className){
        return className + PropUtils.getPorp("ControllerTestSuffixName");
    }

}
