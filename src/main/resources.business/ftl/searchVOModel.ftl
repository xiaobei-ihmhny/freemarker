package ${queryPojo_packageName};

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jd.bdp.ai.iot.common.BaseQueryParams;

/**
 * Package: ${queryPojo_packageName}
 * User:
 * Email:
 * Date: ${.now?string("yyyy/MM/dd")}
 * Time: ${.now?string("HH:mm")}
 * Description:
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ${queryPojo} extends BaseQueryParams {
    <#list properties as pro>
    <#if pro.columnName!="id">
    /**
     * ${pro.columnComment}
     */
    private ${pro.proType} ${pro.proName};
    </#if>

    </#list>
    /**
     * 以何字段排序
     */
    private String orderBy;

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
}