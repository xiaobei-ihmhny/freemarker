package ${service_packageName};

import com.ihmhny.common.base.BaseService;
import ${pojo_packageName}.${className};
import ${queryPojo_packageName}.${queryPojo};
import ${updatePojo_packageName}.${updatePojo};
/**
 * @author xiaobei
 * @version ${version}
 * @project ${project}
 * @class_name ${className}Service
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */
public interface ${className}Service extends BaseService<Integer,${className},${updatePojo},${queryPojo}>{
}