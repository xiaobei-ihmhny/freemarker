package ${pojo_packageName};

/**
 * @author
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */
public class ${className}Entity {
	<#list properties as pro>
    private ${pro.proType} ${pro.proName}; //${pro.columnComment}

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