package ${serviceImpl_packageName};

import com.jd.bdp.ai.iot.dao.common.BaseMapper;
import ${mapper_packageName}.${className}Mapper;
import ${pojo_packageName}.${className};
import ${queryPojo_packageName}.${queryPojo};
import ${updatePojo_packageName}.${updatePojo};
import ${service_packageName}.${className}Service;
import com.jd.bdp.ai.iot.service.common.AbstractBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Package: ${serviceImpl_packageName}
 * User:
 * Email:
 * Date: ${.now?string("yyyy/MM/dd")}
 * Time: ${.now?string("HH:mm")}
 * Description:
 */
@Service("${className}Service")
public class ${className}ServiceImpl extends AbstractBaseService<Long, ${className}, ${updatePojo}, ${queryPojo}>
        implements ${className}Service {

    @Resource
    private ${className}Mapper ${className?uncap_first}Mapper;

    @Override
    protected BaseMapper<Long, ${className}, ${updatePojo}, ${queryPojo}> getMapper() {
        return ${className?uncap_first}Mapper;
    }
}