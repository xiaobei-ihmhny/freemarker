package ${service_packageName};

import java.util.List;
import ${pojo_packageName}.${className};
import ${queryPojo_packageName}.${queryPojo};
import ${updatePojo_packageName}.${updatePojo};

/**
 * Package: ${packageName}
 * User:
 * Email:
 * Date: ${.now?string("yyyy/MM/dd")}
 * Time: ${.now?string("HH:mm")}
 * Description:
 */
public interface ${className}Service {

    int deleteById(Long id);

    int save(${updatePojo} ${updatePojo?uncap_first});

    int saveSelective(${updatePojo} ${updatePojo?uncap_first});

    ${className} findById(Long id);

    int modifyById(${updatePojo} ${updatePojo?uncap_first});

    List<${className}> findByParams(${queryPojo} ${queryPojo?uncap_first});

    long findCountByParams(${queryPojo} ${queryPojo?uncap_first});
}