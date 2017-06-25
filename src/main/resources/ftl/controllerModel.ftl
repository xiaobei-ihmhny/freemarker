package ${controller_packageName};

import ${pojo_packageName}.${className};
import ${service_packageName}.${className}Service;
import ${vo_packageName}.${voClassName};
import com.elionyz.common.base.AbstractBaseController;
import com.elionyz.common.base.JsonResult;
import com.elionyz.common.base.PageResult;
import com.elionyz.common.utils.JsonResultUtil;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Xiaobei
 * @version ${version}
 * @project ${project}
 * @class_name ${className}
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */
@Controller
@RequestMapping("${requestMappingAddr}")
public class ${className}Controller extends AbstractBaseController{

    @Resource
    private ${className}Service ${className?uncap_first}Service;

    /**
     * 列表
     * @param request 请求参数，必须含有PageNo和PageSize，以便进行分页
     * @param ${voClassName?uncap_first} 分页查询实体
     * @return
     */
    @ResponseBody
    @RequestMapping("list")
    public JsonResult<PageResult> list(HttpServletRequest request, ${voClassName} ${voClassName?uncap_first}){
        PageResult list = ${className?uncap_first}Service.selectByParams(${voClassName?uncap_first});
        return JsonResultUtil.createJsonResult(list);
    }

    /**
     * 根据id删除
     * @param id 主键id
     * @return 删除结果
     */
    @ResponseBody
    @RequestMapping("deleteById")
    public JsonResult<Null> deleteById(Integer id) {
        int result = ${className?uncap_first}Service.deleteById(id);
        return JsonResultUtil.createJsonResult(null,result==1?true:false,result==1?"删除成功":"删除失败");
    }

    /**
     * 插入
     * @param ${className?uncap_first} 要插入的对象
     * @return 插入的结果
     */
    @ResponseBody
    @RequestMapping("insert")
    public JsonResult<Null> insert(${className} ${className?uncap_first}) {
        int result = ${className?uncap_first}Service.insert(${className?uncap_first});
        return JsonResultUtil.createJsonResult(null,result==1?true:false,result==1?"插入成功":"插入失败");
    }

    /**
     * 部分插入
     * @param ${className?uncap_first} 要插入的对象
     * @return 插入的结果
     */
    @ResponseBody
    @RequestMapping("insertSelective")
    public JsonResult<Null> insertSelective(${className} ${className?uncap_first}) {
        int result = ${className?uncap_first}Service.insertSelective(${className?uncap_first});
        return JsonResultUtil.createJsonResult(null,result==1?true:false,result==1?"部分插入成功":"部分插入失败");
    }

    /**
     * 根据主键id查询
     * @param id 主键id
     * @return 查询到的实体
     */
    @ResponseBody
    @RequestMapping("selectById")
    public JsonResult<${className}> selectById(Integer id) {
        ${className} ${className?uncap_first} = ${className?uncap_first}Service.selectById(id);
        return JsonResultUtil.createJsonResult(${className?uncap_first});
    }

    /**
     * 根据主键id更新
     * @param ${className?uncap_first} 要更新的实体
     * @return 更新的结果
     */
    @ResponseBody
    @RequestMapping("updateById")
    public JsonResult<Null> updateById(${className} ${className?uncap_first}) {
        int result = ${className?uncap_first}Service.updateById(${className?uncap_first});
        return JsonResultUtil.createJsonResult(null,result==1?true:false,result==1?"更新成功":"更新失败");
    }

<#--    /**
     * 条件查询
     * @param goodsVO 包含条件信息的实体
     * @return 条件查询的结果
     */
    @ResponseBody
    @RequestMapping("selectByParams")
    public JsonResult<PageResult<${className}>> selectByParams(${voClassName} ${voClassName?uncap_first}) {
        PageResult<${className}> pageResult = ${className?uncap_first}Service.selectByParams(${voClassName?uncap_first});
        return JsonResultUtil.createJsonResult(pageResult);
    }-->
}