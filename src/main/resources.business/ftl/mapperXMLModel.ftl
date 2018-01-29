<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${dao_packageName}.${fileName}Mapper">
<resultMap id="${className}Map" type="${pojo_packageName}.${className}Entity">
	<id column="id" property="id" />
	<#list properties as pro>
	<#if pro.columnName!="id">
    <result column="${pro.columnName}" property="${pro.proName}" />
    </#if>
	</#list>
</resultMap>

    <!-- 根据主键查询 -->
    <select id="selectById" resultMap="${className}Map" parameterType="java.lang.Long" >
        SELECT
		<#list properties as pro><#if pro_has_next>${pro.columnName}, <#else>${pro.columnName}</#if></#list>
        FROM ${tableName}
        WHERE
        id = ${r"#{"}id${r",jdbcType=INTEGER}"}
    </select>

    <!-- 查询 -->
    <select id="select${className}" parameterType="${pojo_packageName}.${className}Entity" resultMap="${className}Map">
        SELECT
		<#list properties as pro><#if pro_has_next>${pro.columnName}, <#else>${pro.columnName}</#if></#list>
        FROM ${tableName}
        <where>
		<#list properties as pro>
			<#if pro.columnName!="id">
                <if test="${pro.proName} != null" >
                    AND ${pro.columnName} = ${r"#{"}${pro.proName}${r"}"}
                </if>
			</#if>
		</#list>
        </where>
    </select>


    <!--全部插入-->
    <insert id="insert" parameterType="${pojo_packageName}.${className}Entity" >
        INSERT INTO ${tableName} (
		<#list properties as pro><#if pro_has_next>${pro.columnName}, <#else>${pro.columnName}</#if></#list>
        ) VALUES (
		<#list properties as pro><#if pro_has_next>${r"#{"}${pro.proName}${r"}"}, <#else>${r"#{"}${pro.proName}${r"}"}</#if></#list>
        )
    </insert>

    <!--部分字段插入-->
    <insert id="insert${className}" keyProperty="id" parameterType="${pojo_packageName}.${className}Entity" useGeneratedKeys="true">
        INSERT INTO ${tableName}
        <trim prefix="(" suffix=")" suffixOverrides="," >
		<#list properties as pro>
            <if test="${pro.proName} != null" >
			${pro.columnName},
            </if>
		</#list>
        </trim>
        <trim prefix="VALUES (" suffix=")" suffixOverrides="," >
		<#list properties as pro>
            <if test="${pro.proName} != null" >
			${r"#{"}${pro.proName}${r"}"},
            </if>
		</#list>
        </trim>
    </insert>

    <!--部分字段更新-->
    <update id="update${className}" parameterType="${pojo_packageName}.${className}Entity" >
        UPDATE ${tableName}
        <set >
		<#list properties as pro>
			<#if pro.columnName!="id">
                <if test="${pro.proName} != null" >
				${pro.columnName} = ${r"#{"}${pro.proName}${r"}"},
                </if>
			</#if>
		</#list>
        </set>
        WHERE
        id = ${r"#{"}id${r",jdbcType=INTEGER}"}
    </update>

    <!-- 根据主键删除 -->
    <delete id="delete${className}" parameterType="java.lang.Long" >
        DELETE
        FROM ${tableName}
        WHERE
        id = ${r"#{"}id${r",jdbcType=INTEGER}"}
    </delete>

</mapper>
