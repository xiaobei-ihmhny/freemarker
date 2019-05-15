package com.ihmhny.freemarker.model;

import com.ihmhny.freemarker.utils.PropUtils;

import java.util.Map;

/**
 * 获取所有的类名
 *
 * @author xiaobei-ihmhny
 * @create 2017-06-29 8:53
 */
public class JavaBeanMap {


    /**
     * 获取所有的配置信息的map集合
     */
    private static Map<String, String> propertisMap = PropUtils.getAllProps();

    /**
     * 获取更新pojo类名
     * @param className
     * @return
     */
    public static String getUpdatePojoBean(String className){
        return className + propertisMap.get("updatePojoSuffix");
    }

    /**
     * 获取查询pojo类名
     * @param className
     * @return
     */
    public static String getQueryPojoBean(String className){
        return className + propertisMap.get("queryPojoSuffix");
    }

}
