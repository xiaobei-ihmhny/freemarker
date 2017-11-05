package ${queryPojo_packageName};

import com.ihmhny.common.base.BaseQueryParams;
import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author xiaobei
 * @version ${version}
 * @project ${project}
 * @class_name ${queryPojo}
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ${queryPojo} extends BaseQueryParams {
    <#list properties as pro>
    <#if pro.columnName!="id">
    private ${pro.proType} ${pro.proName}; //${pro.columnComment}
    </#if>

    <#if pro.proType=="String">
    private ${pro.proType} ${pro.proName}ByLike; //${pro.columnComment} like查询
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

    <#if pro.proType=="String">
    public ${pro.proType} get${pro.proName?cap_first}ByLike() {
        return ${pro.proName}ByLike;
    }

    public void set${pro.proName?cap_first}ByLike(${pro.proType} ${pro.proName}ByLike) {
        this.${pro.proName}ByLike = ${pro.proName}ByLike;
    }
    </#if>

    </#list>
}