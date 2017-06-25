package ${pojo_packageName};

import com.elionyz.common.base.IdEntity;
import java.math.BigDecimal;
import java.util.Date;
/**
 * @author Xiaobei
 * @version ${version}
 * @project ${project}
 * @class_name ${className}
 * @table_name ${tableName}
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */
public class ${className} extends IdEntity<Integer> {
	<#list properties as pro>
    <#if pro.columnName!="id">
    private ${pro.proType} ${pro.proName}; //${pro.columnComment}
    </#if>

    </#list>
    
    //属性的get和set方法
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