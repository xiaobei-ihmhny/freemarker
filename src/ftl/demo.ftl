package ${ packageName };

import java.sql.Timestamp;
import java.util.*;

/**
 *
 *对应表(${ tableName })
 */
 
public class ${ className } {
	
	<#list properties as pro>  
    private ${pro.proType} ${pro.proName} get${pro.proName?cap_first}() ${pro.columnName};  
	</#list>
	
	int insert(${ className } ${className?uncap_first});
	

}