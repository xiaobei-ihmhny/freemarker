package ${controller_packageName};

import com.alibaba.fastjson.JSON;
import com.jd.bdp.ai.iot.common.PageResult;
import ${pojo_packageName}.${className};
import ${queryPojo_packageName}.${queryPojo};
import ${updatePojo_packageName}.${updatePojo};
import ${service_packageName}.${className}Service;
import com.jd.bdp.ai.iot.web.common.AbstractBaseController;
import com.jd.bdp.ai.iot.web.utils.VelocityUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Package: ${controller_packageName}
 * User:
 * Email:
 * Date: ${.now?string("yyyy/MM/dd")}
 * Time: ${.now?string("HH:mm")}
 * Description:
 */
@Controller
@RequestMapping(value = "${className?uncap_first}", produces = "text/json;charset=UTF-8")
public class ${className}Controller extends AbstractBaseController {

    @Resource
    private ${className}Service ${className?uncap_first}Service;

	/**
	 * @author
     * @param ${queryPojo?uncap_first} 查询参数
     * @description 根据给定参数查询列表
     * @return 查询结果
	 */
    @ResponseBody
    @RequestMapping(value = "list")
    public String findByParams(${queryPojo} ${queryPojo?uncap_first}){
        PageResult<${className}> ${className?uncap_first}List = ${className?uncap_first}Service.queryByParams(${queryPojo?uncap_first});
        return JSON.toJSONString(${className?uncap_first}List);
    }

    /**
     * @author
     * @param id 主键id
     * @description 根据给定参数查询列表
     * @return 查询到的记录
     */
    @ResponseBody
    @RequestMapping(value = "findById")
    public String findById(Long id){
        ${className} ${className?uncap_first} = ${className?uncap_first}Service.getById(id);
        return JSON.toJSONString(${className?uncap_first});
    }

    /**
     * @author
     * @param ${updatePojo?uncap_first} 新增实体参数
     * @description 根据给定参数保存数据
     * @return 保存操作结果
     */
    @ResponseBody
    @RequestMapping(value = "saveSelective", method = RequestMethod.POST)
    public String saveSelective(${updatePojo} ${updatePojo?uncap_first}){
        int result = ${className?uncap_first}Service.saveSelective(${updatePojo?uncap_first});
        return JSON.toJSONString(result);
    }

    /**
     * @author
     * @param ${updatePojo?uncap_first} 修改后的实体参数
     * @description 根据给定参数保存数据
     * @return 保存操作结果
     */
    @ResponseBody
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(${updatePojo} ${updatePojo?uncap_first}){
        int result = ${className?uncap_first}Service.save(${updatePojo?uncap_first});
        return JSON.toJSONString(result);
    }

    /**
     * @author
     * @param ${updatePojo?uncap_first} 修改后的实体参数
     * @description 根据给定参数修改数据
     * @return 修改操作结果
     */
    @ResponseBody
    @RequestMapping(value = "modifyById", method = RequestMethod.POST)
    public String modifyById(${updatePojo} ${updatePojo?uncap_first}){
        int result = ${className?uncap_first}Service.modifyById(${updatePojo?uncap_first});
        return JSON.toJSONString(result);
    }

    /**
     * @author
     * @param id 主键id
     * @description 根据给定参数删除数据
     * @return 删除操作结果
     */
    @ResponseBody
    @RequestMapping(value = "removeById")
    public String removeById(long id){
        int result = ${className?uncap_first}Service.removeById(id);
        return JSON.toJSONString(result);
    }

    /**
     * @author
     * @param id 主键id
     * @description 根据给定参数修改数据
     * @return 查询指定条件下查询到的记录数
     */
    @ResponseBody
    @RequestMapping(value = "findCount")
    public String findCount(${queryPojo} ${queryPojo?uncap_first}){
        long count = ${className?uncap_first}Service.getCountByParams(${queryPojo?uncap_first});
        return JSON.toJSONString(count);
    }
}