package ${service_packageName};

/**
* @author
* @date ${.now?string("yyyy-MM-dd HH:mm")}
*/
public interface ${fileName}Service {
	String insert${className}(String json);

	String select${className}(String json);

	String update${className}(String json);

	String delete${className}(String json);
}