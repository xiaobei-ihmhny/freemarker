package ${packageName};

import com.ihmhny.common.base.BaseMapper;
import ${pojo_packageName}.${className};
import ${queryPojo_packageName}.${queryPojo};
import ${updatePojo_packageName}.${updatePojo};
/**
 * @author xiaobei-ihmhny
 * @version ${version}
 * @project ${project}
 * @table_name ${tableName}
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */
public interface ${className}Mapper extends BaseMapper<Integer,${className},${updatePojo},${queryPojo}> {

}