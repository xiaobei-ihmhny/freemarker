package ${serviceImpl_packageName};

import ${mapper_packageName}.${className}Mapper;
import ${pojo_packageName}.${className};
import ${queryPojo_packageName}.${queryPojo};
import ${updatePojo_packageName}.${updatePojo};
import ${service_packageName}.${className}Service;
import org.springframework.stereotype.Service;

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
@Service("${className}Service")
public class ${className}ServiceImpl implements ${className}Service {

    @Resource
    private ${className}Mapper ${className?uncap_first}Mapper;

	/**
	 * Package: ${packageName}
	 * User:
	 * Email:
	 * Date: ${.now?string("yyyy/MM/dd")}
	 * Time: ${.now?string("HH:mm")}
	 * Description:
	 */
    @Override
    public int deleteById(Long id) {
        return ${className?uncap_first}Mapper.deleteById(id);
    }

	/**
	 * Package: ${packageName}
	 * User:
	 * Email:
	 * Date: ${.now?string("yyyy/MM/dd")}
	 * Time: ${.now?string("HH:mm")}
	 * Description:
	 */
    @Override
    public int save(${updatePojo} ${className?uncap_first}UpdateParams) {
        return ${className?uncap_first}Mapper.insert(${className?uncap_first}UpdateParams);
    }

	/**
	 * Package: ${packageName}
	 * User:
	 * Email:
	 * Date: ${.now?string("yyyy/MM/dd")}
	 * Time: ${.now?string("HH:mm")}
	 * Description:
	 */
    @Override
    public int saveSelective(${updatePojo} ${className?uncap_first}UpdateParams) {
        return ${className?uncap_first}Mapper.insertSelective(${className?uncap_first}UpdateParams);
    }

	/**
	 * Package: ${packageName}
	 * User:
	 * Email:
	 * Date: ${.now?string("yyyy/MM/dd")}
	 * Time: ${.now?string("HH:mm")}
	 * Description:
	 */
    @Override
    public ${className} findById(Long id) {
        return ${className?uncap_first}Mapper.selectById(id);
    }

	/**
	 * Package: ${packageName}
	 * User:
	 * Email:
	 * Date: ${.now?string("yyyy/MM/dd")}
	 * Time: ${.now?string("HH:mm")}
	 * Description:
	 */
    @Override
    public int modifyById(${updatePojo} ${className?uncap_first}UpdateParams) {
        return ${className?uncap_first}Mapper.updateById(${className?uncap_first}UpdateParams);
    }

	/**
	 * Package: ${packageName}
	 * User:
	 * Email:
	 * Date: ${.now?string("yyyy/MM/dd")}
	 * Time: ${.now?string("HH:mm")}
	 * Description:
	 */
    @Override
    public List<${className}> findByParams(${queryPojo} ${className?uncap_first}QueryParams) {
        return ${className?uncap_first}Mapper.selectByParams(${className?uncap_first}QueryParams);
    }

	/**
	 * Package: ${packageName}
	 * User:
	 * Email:
	 * Date: ${.now?string("yyyy/MM/dd")}
	 * Time: ${.now?string("HH:mm")}
	 * Description:
	 */
    @Override
    public long findCountByParams(${queryPojo} ${className?uncap_first}QueryParams) {
        return ${className?uncap_first}Mapper.selectCountByParams(${className?uncap_first}QueryParams);
    }
}