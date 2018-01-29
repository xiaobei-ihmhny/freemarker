package ${serviceImpl_packageName};

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import ${pojo_packageName}.${className}Entity;
import ${mapper_packageName}.${fileName}Mapper;
import ${service_packageName}.${fileName}Service;
import com.jd.ecc.system.server.feign.SnowflakeServerFeignClient;
import com.jd.ecc.system.server.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 
 * @date ${.now?string("yyyy-MM-dd HH:mm")}
 */
@Service
public class ${fileName}ServiceImpl implements ${fileName}Service {
    private static Logger log = LoggerFactory.getLogger(${fileName}ServiceImpl.class);

    @Autowired
    SnowflakeServerFeignClient snowflakeServerFeignClient;

    @Resource
    ${fileName}Mapper ${fileName?uncap_first}Mapper;

    /**
     * 
     * @param json
     * @return
     */
    @Override
    public String insert${className}(String json) {
        try {
            ${className}Entity ${className?uncap_first} = JSON.parseObject(json, new TypeReference<${className}Entity>() {});
            String id = snowflakeServerFeignClient.getDictId();
            if (id.equals("0")) {
                log.error("新增数据时获取主键id出错");
                return ResponseUtil.getErrorJson();
            } else if (id.startsWith("{")) {// 断路返回服务异常
                return id;
            } else {
                ${className?uncap_first}.setId(Long.valueOf(id));
                ${fileName?uncap_first}Mapper.insert${className}(${className?uncap_first});
                return ResponseUtil.getSuccessJson();
            }
        } catch (Exception e) {
            log.error("新增数据出错:" + e.getMessage());
        }
        return ResponseUtil.getErrorJson();
    }

    /**
     * 
     * @param json
     * @return
     */
    @Override
    public String select${className}(String json) {
        try {
            ${className}Entity ${className?uncap_first} = JSON.parseObject(json, new TypeReference<${className}Entity>() {});
            List<${className}Entity> list = ${fileName?uncap_first}Mapper.select${className}(${className?uncap_first});
            return ResponseUtil.getSuccessJson(list);
        } catch (Exception e) {
            log.error("查询数据出错:" + e.getMessage());
        }
        return ResponseUtil.getErrorJson();
    }

    /**
     * 
     * @param json
     * @return
     */
    @Override
    public String update${className}(String json) {
        try {
            ${className}Entity ${className?uncap_first} = JSON.parseObject(json, new TypeReference<${className}Entity>() {});
            ${fileName?uncap_first}Mapper.update${className}(${className?uncap_first});
            return ResponseUtil.getSuccessJson();
        } catch (Exception e) {
            log.error("修改数据出错:" + e.getMessage());
        }
        return ResponseUtil.getErrorJson();
    }


    /**
     * 
     * @param json
     * @return
     */
    @Override
    public String delete${className}(String json) {
        try {
            ${className}Entity ${className?uncap_first} = JSON.parseObject(json, new TypeReference<${className}Entity>() {});
            ${fileName?uncap_first}Mapper.delete${className}(${className?uncap_first});
            return ResponseUtil.getSuccessJson();
        } catch (Exception e) {
            log.error("修改数据出错:" + e.getMessage());
        }
        return ResponseUtil.getErrorJson();
    }
}
