package ${packageName};

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
public interface ${className}Mapper {

    int deleteById(Long id);

    int insert(${updatePojo} ${updatePojo?uncap_first});

    int insertSelective(${updatePojo} ${updatePojo?uncap_first});

    ${className} selectById(Long id);

    int updateById(${updatePojo} ${updatePojo?uncap_first});

    List<${className}> selectByParams(${queryPojo} ${queryPojo?uncap_first});

    long selectCountByParams(${queryPojo} ${queryPojo?uncap_first});
}
