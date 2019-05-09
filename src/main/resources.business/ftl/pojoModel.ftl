package ${pojo_packageName};

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
/**
 * @author xiaobei
 * @version 1.0
 * @className ${className}
 * @description 对应表${tableName}
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */
public class ${className} implements Serializable {

    private static final long serialVersionUID = ${serialVersionUID}L;

	<#list properties as pro>
    /**
    * ${pro.columnComment}
    */
    private ${pro.proType} ${pro.proName};

    </#list>
    
    <#--//属性的get和set方法-->
	<#list properties as pro>
    <#if pro.columnName!="id">
    public ${pro.proType} get${pro.proName?cap_first}() {
    	return ${pro.proName};
    }

    public void set${pro.proName?cap_first}(${pro.proType} ${pro.proName}) {
    	this.${pro.proName} = ${pro.proName};
    }
    </#if>

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