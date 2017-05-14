package ${packageName};

import com.logistics.common.dao.Page;
import com.logistics.db.dao.${className}Mapper;
import com.logistics.db.entity.${className};
import com.logistics.service.BaseService;
import com.logistics.service.${className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 */
 
@Service("${ className }Service")
public class ${ className }ServiceImpl extends BaseService implements ${ className }Service{

    @Autowired
    private ${ className }Mapper ${className?uncap_first}Mapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return ${className?uncap_first}Mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(${ className } ${className?uncap_first}) {
        return ${className?uncap_first}Mapper.insert(${className?uncap_first});
    }

    @Override
    public int insertSelective(${ className } ${className?uncap_first}) {
        return ${className?uncap_first}Mapper.insertSelective(${className?uncap_first});
    }

    @Override
    public ${ className } selectByPrimaryKey(Integer id) {
        return ${className?uncap_first}Mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(${ className } ${className?uncap_first}) {
        return ${className?uncap_first}Mapper.updateByPrimaryKeySelective(${className?uncap_first});
    }

    @Override
    public int updateByPrimaryKey(${ className } ${className?uncap_first}) {
        return ${className?uncap_first}Mapper.updateByPrimaryKey(${className?uncap_first});
    }
    
    @Override
    public boolean save(${className} info,int uid) {
        ${className} corp = ${className?uncap_first}Mapper.selectByPrimaryKey(uid);
        if(corp!=null){
            if(info.getId()!=uid)return false;
            ${className?uncap_first}Mapper.updateByPrimaryKeySelective(info);
            return true;
        }
        info.setId(uid);
        ${className?uncap_first}Mapper.insertSelective(info);
        return true;
    }
    
    <#list properties as pro>
	<#if pro.columnName == "uid">
     @Override
    public Page list(int uid,int pageNo, int pageSize) {
        ${className} corp = new ${className}();
        corp.setUid(uid);
        return mybatisPageDao.query(corp, pageNo, pageSize, "${className?uncap_first}List");
    }

    //@Override
    public boolean save2(${className} info, int uid) {
        if(info.getId() != null){
            ${className} corp = ${className?uncap_first}Mapper.selectByPrimaryKey(info.getId());
            if(corp.getUid() != uid)return false;
            ${className?uncap_first}Mapper.updateByPrimaryKeySelective(info);
            return true;
        }
        info.setUid(uid);
        ${className?uncap_first}Mapper.insertSelective(info);
        return false;
    }

    @Override
    public boolean del(int id, int uid) {
        ${className} corp = ${className?uncap_first}Mapper.selectByPrimaryKey(id);
        if(corp.getUid()!=uid)return false;
        ${className?uncap_first}Mapper.deleteByPrimaryKey(id);
        return true;
    }
    </#if>
    </#list>
    
    //11.14新增
    
    
}
