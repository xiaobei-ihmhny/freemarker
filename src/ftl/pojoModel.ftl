package ${packageName};

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 * 对应的表为(${tableName}) 
 */
public class ${className} {
	
	<#list properties as pro>
    private ${pro.proType} ${pro.proName};
    </#list>
    
    //属性的get和set方法
	<#list properties as pro>
    public ${pro.proType} get${pro.proName?cap_first}() {
    	return ${pro.proName};
    }
    public void set${pro.proName?cap_first}(${pro.proType} ${pro.proName}) {
    	this.${pro.proName} = ${pro.proName};
    }
    </#list>
}