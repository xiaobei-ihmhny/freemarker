package ${packageName};

import ${pojo_packageName}.${className};
import ${queryPojo_packageName}.${queryPojo};
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * // TODO
 * @author // TODO yourname
 * @version 1.0
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */
public interface ${className}Mapper {

    ${className} getById(@Param("id") Long id);

    List<${className}> listByParams(${queryPojo} ${queryPojo?uncap_first});

    int insert(${className} ${className?uncap_first});

    int updateById(${className} ${className?uncap_first});

    int deleteById(@Param("id") Long id);

    int insertFull(${className} ${className?uncap_first});

}