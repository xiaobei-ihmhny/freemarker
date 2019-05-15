package ${controller_packageName};

import ${pojo_packageName}.${className};
import ${queryPojo_packageName}.${queryPojo};
import ${service_packageName}.${className}Service;
import com.tlwok.common.domain.PageResult;
import com.tlwok.common.result.Result;
import com.tlwok.common.validator.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * // TODO
 * @author // TODO yourname
 * @version 1.0
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */
@Controller
@RequestMapping("${requestMappingAddr}")
@Api(tags = "说明类的用途")
public class ${className}Controller {

    @Autowired
    private ${className}Service ${className?uncap_first}Service;

	/**
     *
     * @param ${className?uncap_first}
     * @return
     */
    @ApiOperation(value = "保存", notes = "")
    @PostMapping(value = "/save",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Result<Integer> save(${className} ${className?uncap_first}) {
        int saveResult = ${className?uncap_first}Service.save(${className?uncap_first});
        return Result.success(saveResult);
    }

    /**
    *
    * @param id
    * @return
    */
    @ApiOperation(value = "单个查询", notes = "")
    @GetMapping(value = "/getById",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Result<${className}> getById(Long id){
        ${className} ${className?uncap_first} = ${className?uncap_first}Service.getById(id);
        return Result.success(${className?uncap_first});
    }

    /**
    *
    * @param ${queryPojo?uncap_first}
    * @return
    */
    @ApiOperation(value = "列表查询", notes = "只能分页查询, 不支持全查")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "pageNum", value = "开始页码", required = true, dataType = "int"),
        @ApiImplicitParam(paramType="query", name = "pageSize", value = "页面大小", required = true, dataType = "int")
    })
    @Page
    @GetMapping(value = "/list",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public PageResult<${className}> listByParams(${queryPojo} ${queryPojo?uncap_first}) {
        List<${className}> ${className?uncap_first}List = ${className?uncap_first}Service.listByParams(${queryPojo?uncap_first});
        return new PageResult<>(${className?uncap_first}List);
    }

    /**
    *
    * @param ${className?uncap_first}
    * @return
    */
    @ApiOperation(value = "更新", notes = "")
    @PostMapping(value = "/update",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Result<Integer> update(AfterSaleArbitration ${className?uncap_first}) {
        int updateResult = ${className?uncap_first}Service.updateById(${className?uncap_first});
        return Result.success(updateResult);
    }

    /**
    *
    * @param id
    * @return
    */
    @ApiOperation(value = "删除", notes = "")
    @PostMapping(value = "/delete",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Result<Integer> delete(Long id){
        int deleteResult = ${className?uncap_first}Service.removeById(id);
        return Result.success(deleteResult);
    }
}