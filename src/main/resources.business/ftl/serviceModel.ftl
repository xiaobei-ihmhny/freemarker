package ${service_packageName};

import ${pojo_packageName}.${className};
import ${queryPojo_packageName}.${queryPojo};
import java.util.List;

/**
 * // TODO
 * @author // TODO yourname
 * @version 1.0
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */
public interface ${className}Service {

    /**
     * // TODO 添加注释
     * @param id
     * @return
     */
    ${className} getById(Long id);

    /**
     * // TODO
     * @param ${queryPojo?uncap_first}
     * @return
     */
    List<${className}> listByParams(${queryPojo} ${queryPojo?uncap_first});

    /**
     * // TODO
     * @param ${className?uncap_first}
     * @return
     */
    int save(${className} ${className?uncap_first});

    /**
     * // TODO
     * @param ${className?uncap_first}
     * @return
     */
    int updateById(${className} ${className?uncap_first});

    /**
     * // TODO
     * @param id
     * @return
     */
    int removeById(Long id);

    /**
     * // TODO
     * @param ${className?uncap_first}
     * @return
     */
    int saveFull(${className} ${className?uncap_first});


}