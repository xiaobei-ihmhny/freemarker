package ${packageName};

import com.logistics.db.entity.${className};

public interface ${className}Mapper {

    int deleteByPrimaryKey(Integer id);

    int insert(${className} ${className?uncap_first});

    int insertSelective(${className} ${className?uncap_first});

    ${className} selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(${className} ${className?uncap_first});

    int updateByPrimaryKey(${className} ${className?uncap_first});
}