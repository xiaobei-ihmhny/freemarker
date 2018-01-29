package ${packageName};

import ${pojo_packageName}.${className}Entity;

import java.util.List;

/**
 * @author
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */
public interface ${fileName}Mapper {

    void insert${className}(${className}Entity ${className?uncap_first}Entity);

    List<${className}Entity> select${className}(${className}Entity ${className?uncap_first}Entity);

    void update${className}(${className}Entity ${className?uncap_first}Entity);

    void delete${className}(${className}Entity ${className?uncap_first}Entity);

}