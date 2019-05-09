package ${packageName};

import ${pojo_packageName}.${className};
import ${queryPojo_packageName}.${queryPojo};
/**
 * @author xiaobei
 * @version 1.0
 * @className ${className}
 * @description 对应表${tableName}
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */
public interface ${className}Mapper {

    int deleteById(Long id);

    int insert(${className} ${className?uncap_first});

    int insertSelective(${className} ${className?uncap_first});

    ${className} selectById(Long id);

    List<${className}> selectByParams(${className} ${className?uncap_first});

    int updateById(${className} ${className?uncap_first});
}