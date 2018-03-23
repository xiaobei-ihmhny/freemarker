package ${pojo_packageName};

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * Package: ${packageName}
 * User:
 * Email:
 * Date: ${.now?string("yyyy/MM/dd")}
 * Time: ${.now?string("HH:mm")}
 * Description:
 */
public class ${className} implements Serializable {
	<#list properties as pro>
    /**
     * ${pro.columnComment}
     */
    private ${pro.proType} ${pro.proName};

    </#list>
    
    <#--//属性的get和set方法-->
	<#list properties as pro>
    <#--<#if pro.columnName!="id">-->
    public ${pro.proType} get${pro.proName?cap_first}() {
    	return ${pro.proName};
    }

    public void set${pro.proName?cap_first}(${pro.proType} ${pro.proName}) {
    	this.${pro.proName} = ${pro.proName};
    }
    <#--</#if>-->

    </#list>
    @Override
    public String toString() {
        return "${className}{" +
            "id=" + id +
            <#list properties as pro>
            <#if pro.columnName!="id">
            ", ${pro.proName}='" + ${pro.proName} + '\'' +
            </#if>
            </#list>
            '}';
    }
}