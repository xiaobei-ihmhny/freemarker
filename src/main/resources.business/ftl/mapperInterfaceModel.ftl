package ${packageName};

import com.jd.bdp.ai.iot.dao.common.BaseMapper;
import ${pojo_packageName}.${className};
import ${queryPojo_packageName}.${queryPojo};
import ${updatePojo_packageName}.${updatePojo};

import java.util.List;

/**
 * Package: ${packageName}
 * User:
 * Email:
 * Date: ${.now?string("yyyy/MM/dd")}
 * Time: ${.now?string("HH:mm")}
 * Description:
 */
public interface ${className}Mapper extends BaseMapper<Long,${className},${updatePojo},${queryPojo}> {

}
