package ${controllerTestPackageName};

import com.elionyz.common.base.AbstractBaseController;
import com.elionyz.common.base.JsonResult;
import com.elionyz.common.base.PageResult;
import com.elionyz.yunshang.common.base.GetFieldUtil;
import com.elionyz.yunshang.common.base.JsonUtils;
import ${pojo_packageName}.${className};
import ${vo_packageName}.${voClassName};
import org.apache.ibatis.jdbc.Null;
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
 * @author Xiaobei
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
            JsonResult<Null> insert = ${className?uncap_first}Controller.insert(${className?uncap_first});
            if(insert.isSuccess())successTimes++;
            logger.info("新增结果为：" + (insert.isSuccess() ? "成功" : "失败") + "," + "当前类=${className}ControllerTest.testInsertBatch()");
        }
        logger.info("共计新增数量为：" + successTimes + "条," + "当前类=${className}ControllerTest.testInsertBatch()");
    }

    /**
     * 测试分页查询
     * 请求参数，必须含有PageNo和PageSize，以便进行分页
     * @return 得到的${voClassName}对象
     */
    @Test
    public void testList(){
        ${voClassName} ${voClassName?uncap_first} = get${voClassName}();
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setAttribute("pageNo",1);
        request.setAttribute("pageSize",10);
        JsonResult<PageResult> jsonResult = ${className?uncap_first}Controller.list(request, ${voClassName?uncap_first});
        String result = JsonUtils.toJson(jsonResult);
        logger.info("请求结果为：" + result + "," + "当前类=${className}ControllerTest.testList()");
    }

    /**
     * 测试根据id删除记录
     */
    @Test
    public void testDeleteById(){
        ${className} ${className?uncap_first} = get${className}(1);
        JsonResult<Null> jsonResult = ${className?uncap_first}Controller.deleteById(${className?uncap_first}.getId());
        String result = JsonUtils.toJson(jsonResult);
        logger.info("请求结果为：" + result + "," + "当前类=${className}ControllerTest.testDeleteById()");
    }

    /**
     * 测试全部字段插入
     */
    @Test
    public void testInsert(){
        ${className} ${className?uncap_first} = get${className}(null);
        JsonResult<Null> jsonResult = ${className?uncap_first}Controller.insert(${className?uncap_first});
        String result = JsonUtils.toJson(jsonResult);
        logger.info("请求结果为：" + result + "," + "当前类=${className}ControllerTest.testInsert()");
    }

    /**
     * 测试部分字段写入
     */
    @Test
    public void testInsertSelective(){
        ${className} ${className?uncap_first} = get${className}(null);
        JsonResult<Null> jsonResult = ${className?uncap_first}Controller.insertSelective(${className?uncap_first});
        String result = JsonUtils.toJson(jsonResult);
        logger.info("请求结果为：" + result + "," + "当前类=${className}ControllerTest.testInsertSelective()");
    }

    /**
     * 测试根据主键查询
     */
    @Test
    public void testSelectById(){
        ${className} ${className?uncap_first} = get${className}(1);
        JsonResult<${className}> jsonResult = ${className?uncap_first}Controller.selectById(${className?uncap_first}.getId());
        String result = JsonUtils.toJson(jsonResult);
        logger.info("请求结果为：" + result + "," + "当前类=${className}ControllerTest.testSelectById()");
    }

    /**
     * 测试根据主键更新
     */
    @Test
    public void testUpdateById(){
        ${className} ${className?uncap_first} = get${className}(1);
        JsonResult<Null> jsonResult = ${className?uncap_first}Controller.updateById(${className?uncap_first});
        String result = JsonUtils.toJson(jsonResult);
        logger.info("请求结果为：" + result + "," + "当前类=${className}ControllerTest.testUpdateById()");
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
