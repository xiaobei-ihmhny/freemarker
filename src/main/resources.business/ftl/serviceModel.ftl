package ${service_packageName};

import java.util.List;
import ${pojo_packageName}.${className};
import ${queryPojo_packageName}.${queryPojo};
import ${updatePojo_packageName}.${updatePojo};
import com.jd.bdp.ai.iot.service.common.BaseService;

/**
 * Package: ${service_packageName}
 * User:
 * Email:
 * Date: ${.now?string("yyyy/MM/dd")}
 * Time: ${.now?string("HH:mm")}
 * Description:
 */
public interface ${className}Service extends BaseService<Long, ${className}, ${updatePojo}, ${queryPojo}> {

}