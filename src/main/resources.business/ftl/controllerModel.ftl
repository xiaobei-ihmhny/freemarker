package ${controller_packageName};

import ${pojo_packageName}.${className};
import ${queryPojo_packageName}.${queryPojo};
import ${updatePojo_packageName}.${updatePojo};
import ${service_packageName}.${className}Service;
import com.jd.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Package: ${packageName}
 * User:
 * Email:
 * Date: ${.now?string("yyyy/MM/dd")}
 * Time: ${.now?string("HH:mm")}
 * Description:
 */
@Controller
@RequestMapping(value = "${className?uncap_first}", produces = "text/json;charset=UTF-8")
public class ${className}Controller {

    @Resource
    private ${className}Service ${className?uncap_first}Service;

	/**
	 * Package: ${packageName}
	 * User:
	 * Email:
	 * Date: ${.now?string("yyyy/MM/dd")}
	 * Time: ${.now?string("HH:mm")}
	 * Description:
	 */
    @ResponseBody
    @RequestMapping(value = "findByParams")
    public String findByParams(${queryPojo} ${queryPojo?uncap_first}){
        List<${className}> ${className?uncap_first}List = ${className?uncap_first}Service.findByParams(${queryPojo?uncap_first});
        return JSON.toJSONString(${className?uncap_first}List);
    }

	/**
	 * Package: ${packageName}
	 * User:
	 * Email:
	 * Date: ${.now?string("yyyy/MM/dd")}
	 * Time: ${.now?string("HH:mm")}
	 * Description:
	 */
    @ResponseBody
    @RequestMapping(value = "findById")
    public String findById(Long id){
        ${className} ${className?uncap_first} = ${className?uncap_first}Service.findById(id);
        return JSON.toJSONString(${className?uncap_first});
    }

	/**
	 * Package: ${packageName}
	 * User:
	 * Email:
	 * Date: ${.now?string("yyyy/MM/dd")}
	 * Time: ${.now?string("HH:mm")}
	 * Description:
	 */
    @ResponseBody
    @RequestMapping(value = "saveSelective", method = RequestMethod.POST)
    public String saveSelective(${updatePojo} ${updatePojo?uncap_first}){
        int result = ${className?uncap_first}Service.saveSelective(${updatePojo?uncap_first});
        return JSON.toJSONString(result);
    }

	/**
	 * Package: ${packageName}
	 * User:
	 * Email:
	 * Date: ${.now?string("yyyy/MM/dd")}
	 * Time: ${.now?string("HH:mm")}
	 * Description:
	 */
    @ResponseBody
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(${updatePojo} ${updatePojo?uncap_first}){
        int result = ${className?uncap_first}Service.save(${updatePojo?uncap_first});
        return JSON.toJSONString(result);
    }

	/**
	 * Package: ${packageName}
	 * User:
	 * Email:
	 * Date: ${.now?string("yyyy/MM/dd")}
	 * Time: ${.now?string("HH:mm")}
	 * Description:
	 */
    @ResponseBody
    @RequestMapping(value = "modifyById", method = RequestMethod.POST)
    public String modifyById(${updatePojo} ${updatePojo?uncap_first}){
        int result = ${className?uncap_first}Service.modifyById(${updatePojo?uncap_first});
        return JSON.toJSONString(result);
    }

	/**
	 * Package: ${packageName}
	 * User:
	 * Email:
	 * Date: ${.now?string("yyyy/MM/dd")}
	 * Time: ${.now?string("HH:mm")}
	 * Description:
	 */
    @ResponseBody
    @RequestMapping(value = "deleteById")
    public String deleteById(long id){
        int result = ${className?uncap_first}Service.deleteById(id);
        return JSON.toJSONString(result);
    }

	/**
	 * Package: ${packageName}
	 * User:
	 * Email:
	 * Date: ${.now?string("yyyy/MM/dd")}
	 * Time: ${.now?string("HH:mm")}
	 * Description:
	 */
    @ResponseBody
    @RequestMapping(value = "findCount")
    public String findCount(${queryPojo} ${queryPojo?uncap_first}){
        long count = ${className?uncap_first}Service.findCountByParams(${queryPojo?uncap_first});
        return JSON.toJSONString(count);
    }
}