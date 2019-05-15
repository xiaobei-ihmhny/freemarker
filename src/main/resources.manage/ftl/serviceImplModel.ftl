package ${serviceImpl_packageName};

import com.ihmhny.common.base.AbstractBaseService;
import com.ihmhny.common.base.BaseMapper;
import ${mapper_packageName}.${className}Mapper;
import ${pojo_packageName}.${className};
import ${queryPojo_packageName}.${queryPojo};
import ${updatePojo_packageName}.${updatePojo};
import ${service_packageName}.${className}Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author xiaobei-ihmhny
 * @version ${version}
 * @project ${project}
 * @class_name ${className}ServiceImpl
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */
@Service("${ className }Service")
public class ${ className }ServiceImpl extends AbstractBaseService<Integer,${className},${updatePojo},${queryPojo}> implements ${ className }Service{

    @Resource
    private ${className }Mapper ${className?uncap_first}Mapper;


    @Override
    protected BaseMapper getMapper() {
        return ${className?uncap_first}Mapper;
    }

    <#--@Override-->
    <#--public int deleteById(Integer id) {-->
        <#--return ${className?uncap_first}Mapper.deleteById(id);-->
    <#--}-->

    <#--@Override-->
    <#--public int insert(${ className } ${className?uncap_first}) {-->
        <#--return ${className?uncap_first}Mapper.insert(${className?uncap_first});-->
    <#--}-->

    <#--@Override-->
    <#--public int insertSelective(${className} ${className?uncap_first}) {-->
        <#--return ${className?uncap_first}Mapper.insertSelective(${className?uncap_first});-->
    <#--}-->

    <#--@Override-->
    <#--public int batchInsert(List<${className}> list) {-->
        <#--return ${className?uncap_first}Mapper.batchInsert(list);-->
    <#--}-->

    <#--@Override-->
    <#--public ${ className } selectById(Integer id) {-->
        <#--return ${className?uncap_first}Mapper.selectById(id);-->
    <#--}-->

    <#--@Override-->
    <#--public int updateById(${className} ${className?uncap_first}) {-->
        <#--return ${className?uncap_first}Mapper.updateById(${className?uncap_first});-->
    <#--}-->

    <#--@Override-->
    <#--public Long selectCount(${className} ${className?uncap_first}) {-->
        <#--return Long.valueOf(0);-->
    <#--}-->

    <#--@Override-->
    <#--public <Q extends BaseQueryParams> PageResult<${className}> selectByParams(Q queryParams) {-->
        <#--List<${className}> list = ${className?uncap_first}Mapper.selectByParams(queryParams);-->
        <#--return queryPageResult(list);-->
    <#--}-->

    <#--@Override-->
    <#--public <Q extends BaseQueryParams> Long selectCountByParams(Q queryParams) {-->
        <#--return null;-->
    <#--}-->
    
}
