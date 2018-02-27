package com.jd.ecc.system.controller;

import com.jd.ecc.system.emnu.FeignSystemServiceEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("${requestMappingAddr}")
public class ${className}Controller extends BaseController {

    @RequestMapping("/insert${className}")
    public String insertSystemDict() {
        Map<String, Object> map = new HashMap<String, Object>();
		<#list properties as pro>
	    <#if pro.proName!="id" && pro.proName!="createTime" && pro.proName!="updateTime" >
	    map.put("${pro.proName}","0"); //${pro.columnComment}
        </#if>
	    </#list>
        return callFeignServer(FeignSystemServiceEnum.${feignInsertEnumKey}, map);
    }

    @RequestMapping("/select${className}")
    public String select${className}() {
        return callFeignServer(FeignSystemServiceEnum.${feignSelectEnumKey}, new HashMap<String, Object>());
    }

    @RequestMapping("/delete${className}")
    public String delete${className}(Integer id){
        Map<String, Object> map = new HashMap<>();
	    map.put("id","0");
        return callFeignServer(FeignSystemServiceEnum.${feignDeleteEnumKey},map);
    }

    @RequestMapping("/update${className}")
    public String update${className}(){
        Map<String, Object> map = new HashMap<>();
		<#list properties as pro>
        <#if pro.proName!="id" && pro.proName!="createTime" && pro.proName!="updateTime" >
	    map.put("${pro.proName}","0"); //${pro.columnComment}
        </#if>
	    </#list>
        return callFeignServer(FeignSystemServiceEnum.${feignUpdateEnumKey}, map);
    }
}