package ${serviceImpl_packageName};

import ${mapper_packageName}.${className}Mapper;
import ${pojo_packageName}.${className};
import ${queryPojo_packageName}.${queryPojo};
import ${service_packageName}.${className}Service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * // TODO
 * @author // TODO yourname
 * @version 1.0
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */
@Service("${ className }Service")
public class ${ className }ServiceImpl implements ${ className }Service{

    @Autowired
    private ${className }Mapper ${className?uncap_first}Mapper;

    /**
     * // TODO 数据库更新时一定要添加事务@Transactional(rollbackFor = Exception.class)
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeById(Long id) {
        return ${className?uncap_first}Mapper.deleteById(id);
    }

    /**
     * // TODO 数据库更新时一定要添加事务@Transactional(rollbackFor = Exception.class)
     * @param ${className?uncap_first}
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveFull(${className} ${className?uncap_first}) {
        return ${className?uncap_first}Mapper.insertFull(${className?uncap_first});
    }

    /**
     * // TODO 数据库更新时一定要添加事务@Transactional(rollbackFor = Exception.class)
     * @param ${className?uncap_first}
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(${className} ${className?uncap_first}) {
        return ${className?uncap_first}Mapper.insert(${className?uncap_first});
    }

    /**
     * // TODO
     * @param id
     * @return
     */
    @Override
    public ${className} getById(Long id) {
        return ${className?uncap_first}Mapper.getById(id);
    }

    /**
     * // TODO
     * @param ${queryPojo?uncap_first}
     * @return
     */
    @Override
    public List<${className}> listByParams(${queryPojo} ${queryPojo?uncap_first}) {
    	return ${className?uncap_first}Mapper.listByParams(${queryPojo?uncap_first});
    }

    /**
     * // TODO 数据库更新时一定要添加事务@Transactional(rollbackFor = Exception.class)
     * @param ${className?uncap_first}
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateById(${className} ${className?uncap_first}) {
    	return ${className?uncap_first}Mapper.updateById(${className?uncap_first});
    }

}
