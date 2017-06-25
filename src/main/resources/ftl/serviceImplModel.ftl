package ${serviceImpl_packageName};

import com.elionyz.common.base.AbstractBaseService;
import com.elionyz.common.base.BaseQueryParams;
import com.elionyz.common.base.PageResult;
import ${mapper_packageName}.${className}Mapper;
import ${pojo_packageName}.${className};
import ${service_packageName}.${className}Service;
import ${vo_packageName}.${voClassName};
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Xiaobei
 * @version ${version}
 * @project ${project}
 * @class_name ${className}
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */
@Service("${ className }Service")
public class ${ className }ServiceImpl extends AbstractBaseService<${voClassName},${className}> implements ${ className }Service{

    @Resource
    private ${ className }Mapper ${className?uncap_first}Mapper;

    @Override
    public int deleteById(Integer id) {
        return ${className?uncap_first}Mapper.deleteById(id);
    }

    @Override
    public int insert(${ className } ${className?uncap_first}) {
        return ${className?uncap_first}Mapper.insert(${className?uncap_first});
    }

    @Override
    public int insertSelective(${className} ${className?uncap_first}) {
        return ${className?uncap_first}Mapper.insertSelective(${className?uncap_first});
    }

    @Override
    public int batchInsert(List<${className}> list) {
        return ${className?uncap_first}Mapper.batchInsert(list);
    }

    @Override
    public ${ className } selectById(Integer id) {
        return ${className?uncap_first}Mapper.selectById(id);
    }

    @Override
    public int updateById(${className} ${className?uncap_first}) {
        return ${className?uncap_first}Mapper.updateById(${className?uncap_first});
    }

    @Override
    public Long selectCount(${className} ${className?uncap_first}) {
        return Long.valueOf(0);
    }

    @Override
    public <Q extends BaseQueryParams> PageResult<${className}> selectByParams(Q queryParams) {
        List<${className}> list = ${className?uncap_first}Mapper.selectByParams(queryParams);
        return queryPageResult(list);
    }

    @Override
    public <Q extends BaseQueryParams> Long selectCountByParams(Q queryParams) {
        return null;
    }
    
}
