package ${serviceTestPackageName};

import com.ihmhny.common.base.AbstractBaseController;
import com.ihmhny.common.base.PageResult;
import com.ihmhny.common.utils.GetFieldUtil;
import com.ihmhny.common.utils.JsonUtils;
import ${pojo_packageName}.${className};
import ${queryPojo_packageName}.${queryPojo};
import ${updatePojo_packageName}.${updatePojo};
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ${className}Service测试代码类
 * @author xiaobei
 * @version ${version}
 * @project ${project}
 * @class_name ${className}ServiceTest
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */

@ContextConfiguration(locations = {
        <#--"classpath:applicationContext.xml","classpath:applicationContext-mybatis.xml","classpath:spring-mvc.xml"-->
        <#list contextConfiguration as conf><#if conf_has_next>"classpath:${conf}",<#else>"classpath:${conf}"</#if></#list>
        })
@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional//加入事务回滚
public class ${className}ServiceTest extends AbstractBaseService<${voClassName},${className}> {

    @Resource
    private ${className}Service ${className?uncap_first}Service;

    /**
     * 获取${className}对象
     * @return 得到的${className}对象
     */
    public ${className} get${className}(Integer id){
        ${className} ${className?uncap_first} = new ${className}();
        ${className?uncap_first}.setId(id);
        <#list setMethodList as setMethod>
		<#if setMethod!="setId(1)">
	    ${className?uncap_first}.${setMethod};
		</#if>
	    </#list>
        return ${className?uncap_first};
    }

    /**
     * 获取${voClassName}对象
     * @return 得到的${voClassName}对象
     */
    public ${voClassName} get${voClassName}(){
        ${voClassName} ${voClassName?uncap_first} = new ${voClassName}();
        <#list setMethodList as setMethod>
		<#if setMethod!="setId(1)">
//	    ${voClassName?uncap_first}.${setMethod};
		</#if>
	    </#list>
        return ${voClassName?uncap_first};
    }

    /**
     * 批量生成测试数据
     */
    @Test
    public void testInsertBatch(){
        ${className} ${className?uncap_first} = get${className}(null);
        int batchTimes = 10;
        int successTimes = 0;
        for(int i = 0; i < batchTimes; i++) {
            int result = ${className?uncap_first}Service.insert(${className?uncap_first});
            if(result==1)successTimes++;
            logger.info("新增结果为：" + (result == 1 ? "成功" : "失败") + "," + "当前类=${className}ServiceTest.testInsertBatch()");
        }
        logger.info("共计新增数量为：" + successTimes + "条," + "当前类=${className}ServiceTest.testInsertBatch()");
    }

    /**
     * 测试条件查询
     */
    @Test
    public void testSelectByParams(){
        ${voClassName} ${voClassName?uncap_first} = get${voClassName}();
        PageResult<${className}> pageResult = ${className?uncap_first}Service.selectByParams(${voClassName?uncap_first});
        String result = JsonUtils.toJson(pageResult);
        logger.info("请求结果为：" + result + "," + "当前类=${className}ServiceTest.testSelectByParams()");
    }

    /**
     * 测试根据id删除记录
     */
    @Test
    public void testDeleteById(){
        ${className} ${className?uncap_first} = get${className}(1);
        int result = ${className?uncap_first}Service.deleteById(${className?uncap_first}.getId());
        logger.info("请求结果为：" + result + "," + "当前类=${className}ServiceTest.testDeleteById()");
    }

    /**
     * 测试全部字段插入
     */
    @Test
    public void testInsert(){
        ${className} ${className?uncap_first} = get${className}(null);
        int result = ${className?uncap_first}Service.insert(${className?uncap_first});
        logger.info("新增结果为：" + (result == 1 ? "成功" : "失败") + "," + "当前类=${className}ServiceTest.testInsert()");
    }

    /**
     * 测试部分字段写入
     */
    @Test
    public void testInsertSelective(){
        ${className} ${className?uncap_first} = get${className}(null);
        int result = ${className?uncap_first}Service.insertSelective(${className?uncap_first});
        logger.info("部分新增结果为：" + (result == 1 ? "成功" : "失败") + "," + "当前类=${className}ServiceTest.testInsertSelective()");
    }

    /**
     * 测试根据主键查询
     */
    @Test
    public void testSelectById(){
        ${className} ${className?uncap_first} = get${className}(1);
        ${className} selectResult = ${className?uncap_first}Service.selectById(${className?uncap_first}.getId());
        String result = JsonUtils.toJson(selectResult);
        logger.info("查询结果为：" + result + "," + "当前类=${className}ServiceTest.testSelectById()");
    }

    /**
     * 测试根据主键更新
     */
    @Test
    public void testUpdateById(){
        ${className} ${className?uncap_first} = get${className}(1);
        int result = ${className?uncap_first}Service.updateById(${className?uncap_first});
        logger.info("更新结果为：" + (result == 1 ? "成功" : "失败") + "," + "当前类=${className}ServiceTest.testUpdateById()");
    }
<#--
    /**
     * 测试条件查询
     */
    @Test
    public void testSelectByParams(){
        ${voClassName} ${voClassName?cap_first} = get${voClassName}();
        JsonResult<PageResult<${className}>> jsonResult = ${className}Controller.selectByParams(${voClassName?cap_first});
        String result = JsonUtils.toJson(jsonResult);
        logger.info("请求结果为：" + result + "," + "当前类=${className}ControllerTest.testSelectByParams()");
    }-->

    /**
     * 生成测试实体
     */
    @Test
    public void testGetFieldUtil(){
        ${className} ${className?uncap_first} = new ${className}();
        GetFieldUtil.printSetMethod(${className?uncap_first}.getClass());
    }
}
