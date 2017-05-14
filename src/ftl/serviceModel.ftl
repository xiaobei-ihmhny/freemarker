package ${packageName};

import com.logistics.common.dao.Page;
import com.logistics.db.entity.${className};


/**
 * 
 */
 
public interface ${className}Service {

    int deleteByPrimaryKey(Integer id);

    int insert(${className} ${className?uncap_first});

    int insertSelective(${className} ${className?uncap_first});

    ${className} selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(${className} ${className?uncap_first});

    int updateByPrimaryKey(${className} ${className?uncap_first});
    
    boolean save(${className} info,int uid);
    
	<#list properties as pro>
	<#if pro.columnName == "uid">
    Page list(int uid, int pageNo, int pageSize);

    boolean del(int id,int uid);
    </#if>
    </#list>
}