package ${queryPojo_packageName};

import com.ihmhny.common.base.BaseQueryParams;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xiaobei-ihmhny
 * @version ${version}
 * @project ${project}
 * @class_name ${queryPojo}
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */
public class ${queryPojo} extends BaseQueryParams {
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
}