package ${controller_packageName};

import ${pojo_packageName}.${className};
import ${queryPojo_packageName}.${queryPojo};
import ${updatePojo_packageName}.${updatePojo};
import ${service_packageName}.${className}Service;
import com.ihmhny.common.base.AbstractBaseController;
import com.ihmhny.common.base.JsonResult;
import com.ihmhny.common.base.PageResult;
import com.ihmhny.common.utils.JsonResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author xiaobei
 * @version ${version}
 * @project ${project}
 * @class_name ${className}Controller
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */
@Controller
@RequestMapping("${requestMappingAddr}")
public class ${className}Controller extends AbstractBaseController {

    @Resource
    private ${className}Service ${className?uncap_first}Service;

    /**
     * 列表
     * @param request 请求参数，必须含有PageNo和PageSize，以便进行分页
     * @param ${queryPojo?uncap_first} 分页查询实体
     * @return
     */
    @ResponseBody
    @RequestMapping("list")
    public JsonResult<PageResult<${className}>> list(HttpServletRequest request, ${queryPojo} ${queryPojo?uncap_first}){
        PageResult<${className}> list = ${className?uncap_first}Service.queryByParams(${queryPojo?uncap_first});
        return JsonResultUtil.createJsonResult(list);
    }

    /**
     * 根据id删除
     * @param id 主键id
     * @return 删除结果
     */
    @ResponseBody
    @RequestMapping("removeById")
    public JsonResult removeById(Integer id) {
        return JsonResultUtil.createJsonResult(${className?uncap_first}Service.removeById(id)==1);
    }

    /**
     * 插入
     * @param ${updatePojo?uncap_first} 要插入的对象
     * @return 插入的结果
     */
    @ResponseBody
    @RequestMapping("save")
    public JsonResult save(${updatePojo} ${updatePojo?uncap_first}) {
        return JsonResultUtil.createJsonResult(${className?uncap_first}Service.save(${updatePojo?uncap_first})==1);
    }

    /**
     * 部分插入
     * @param ${updatePojo?uncap_first} 要插入的对象
     * @return 插入的结果
     */
    @ResponseBody
    @RequestMapping("saveSelective")
    public JsonResult saveSelective(${updatePojo} ${updatePojo?uncap_first}) {
        return JsonResultUtil.createJsonResult(${className?uncap_first}Service.saveSelective(${updatePojo?uncap_first})==1);
    }

    /**
     * 根据主键id查询
     * @param id 主键id
     * @return 查询到的实体
     */
    @ResponseBody
    @RequestMapping("getById")
    public JsonResult<${className}> getById(Integer id) {
        ${className} ${className?uncap_first} = ${className?uncap_first}Service.getById(id);
        return JsonResultUtil.createJsonResult(${className?uncap_first});
    }

    /**
     * 根据主键id更新
     * @param ${updatePojo?uncap_first} 要更新的实体
     * @return 更新的结果
     */
    @ResponseBody
    @RequestMapping("modifyById")
    public JsonResult modifyById(${updatePojo} ${updatePojo?uncap_first}) {
        int result = ${className?uncap_first}Service.modifyById(${updatePojo?uncap_first});
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