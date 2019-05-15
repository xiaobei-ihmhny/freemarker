package ${controller_packageName};

import com.ihmhny.common.base.AbstractBaseController;
import com.ihmhny.common.base.JsonResult;
import com.ihmhny.common.base.PageResult;
import com.ihmhny.common.utils.GetFieldUtil;
import com.ihmhny.common.utils.JsonUtils;
import ${pojo_packageName}.${className};
import ${queryPojo_packageName}.${queryPojo};
import ${updatePojo_packageName}.${updatePojo};
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ${className}Controller测试代码类
 * @author xiaobei-ihmhny
 * @version ${version}
 * @project ${project}
 * @class_name ${className}ControllerTest
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */

@ContextConfiguration(locations = {
        <#--"classpath:applicationContext.xml","classpath:applicationContext-mybatis.xml","classpath:spring-mvc.xml"-->
        <#list contextConfiguration as conf><#if conf_has_next>"classpath:${conf}",<#else>"classpath:${conf}"</#if></#list>
        })
@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional//加入事务回滚
public class ${className}ControllerTest extends AbstractBaseController {

    @Resource
    private ${className}Controller ${className?uncap_first}Controller;

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
     * 获取${queryPojo}对象
     * @return 得到的${queryPojo}对象
     */
    public ${queryPojo} get${queryPojo}(){
        ${queryPojo} ${queryPojo?uncap_first} = new ${queryPojo}();
        <#list setMethodList as setMethod>
		<#if setMethod!="setId(1)">
//	    ${queryPojo?uncap_first}.${setMethod};
		</#if>
	    </#list>
        return ${queryPojo?uncap_first};
    }

    /**
     * 获取${updatePojo}对象
     * @return 得到的${updatePojo}对象
     */
    public ${updatePojo} get${updatePojo}(Integer id){
        ${updatePojo} ${updatePojo?uncap_first} = new ${updatePojo}();
        ${updatePojo?uncap_first}.setId(id);
        <#list setMethodList as setMethod>
		<#if setMethod!="setId(1)">
	    ${updatePojo?uncap_first}.${setMethod};
		</#if>
	    </#list>
        return ${updatePojo?uncap_first};
    }

    /**
     * 批量生成测试数据
     */
    @Test
    public void testBatchSave(){
        ${updatePojo} ${updatePojo?uncap_first} = get${updatePojo}(null);
        int batchTimes = 10;
        int successTimes = 0;
        for(int i = 0; i < batchTimes; i++) {
            JsonResult insert = ${className?uncap_first}Controller.save(${updatePojo?uncap_first});
            if(insert.isSuccess())successTimes++;
            logger.info("新增结果为：" + (insert.isSuccess() ? "成功" : "失败") + "," + "当前类=${className}ControllerTest.testBatchSave()");
        }
        logger.info("共计新增数量为：" + successTimes + "条," + "当前类=${className}ControllerTest.testBatchSave()");
    }

    /**
     * 测试分页查询
     * 请求参数，必须含有PageNo和PageSize，以便进行分页
     * @return 得到的${queryPojo}对象
     */
    @Test
    public void testList(){
        ${queryPojo} ${queryPojo?uncap_first} = get${queryPojo}();
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setAttribute("pageNo",1);
        request.setAttribute("pageSize",10);
        JsonResult<PageResult<${className}>> jsonResult = ${className?uncap_first}Controller.list(request, ${queryPojo?uncap_first});
        String result = JsonUtils.toJson(jsonResult);
        logger.info("请求结果为：" + result + "," + "当前类=${className}ControllerTest.testList()");
    }

    /**
     * 测试根据id删除记录
     */
    @Test
    public void testRemoveById(){
        ${className} ${className?uncap_first} = get${className}(1);
        JsonResult jsonResult = ${className?uncap_first}Controller.removeById(${className?uncap_first}.getId());
        String result = JsonUtils.toJson(jsonResult);
        logger.info("请求结果为：" + result + "," + "当前类=${className}ControllerTest.testRemoveById()");
    }

    /**
     * 测试全部字段插入
     */
    @Test
    public void testSave(){
        ${updatePojo} ${updatePojo?uncap_first} = get${updatePojo}(null);
        JsonResult jsonResult = ${className?uncap_first}Controller.save(${updatePojo?uncap_first});
        String result = JsonUtils.toJson(jsonResult);
        logger.info("请求结果为：" + result + "," + "当前类=${className}ControllerTest.testSave()");
    }

    /**
     * 测试部分字段写入
     */
    @Test
    public void testSaveSelective(){
        ${updatePojo} ${updatePojo?uncap_first} = get${updatePojo}(null);
        JsonResult jsonResult = ${className?uncap_first}Controller.saveSelective(${updatePojo?uncap_first});
        String result = JsonUtils.toJson(jsonResult);
        logger.info("请求结果为：" + result + "," + "当前类=${className}ControllerTest.testSaveSelective()");
    }

    /**
     * 测试根据主键查询
     */
    @Test
    public void testGetById(){
        ${className} ${className?uncap_first} = get${className}(1);
        JsonResult<${className}> jsonResult = ${className?uncap_first}Controller.getById(${className?uncap_first}.getId());
        String result = JsonUtils.toJson(jsonResult);
        logger.info("请求结果为：" + result + "," + "当前类=${className}ControllerTest.testGetById()");
    }

    /**
     * 测试根据主键更新
     */
    @Test
    public void testModifyById(){
        ${updatePojo} ${updatePojo?uncap_first} = get${updatePojo}(1);
        JsonResult jsonResult = ${className?uncap_first}Controller.modifyById(${updatePojo?uncap_first});
        String result = JsonUtils.toJson(jsonResult);
        logger.info("请求结果为：" + result + "," + "当前类=${className}ControllerTest.testModifyById()");
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
//        ${className} ${className?uncap_first} = new ${className}();
//        ${updatePojo} ${updatePojo?uncap_first} = new ${updatePojo}();
//        ${queryPojo} ${queryPojo?uncap_first} = new ${queryPojo}();
//        GetFieldUtil.printSetMethod(${className?uncap_first}.getClass());
//        GetFieldUtil.printSetMethod(${updatePojo?uncap_first}.getClass());
//        GetFieldUtil.printSetMethod(${queryPojo?uncap_first}.getClass());
    }
}
