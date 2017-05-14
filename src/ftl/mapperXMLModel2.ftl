<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.logistics.db.dao.${className}Mapper">
<resultMap id="${className?uncap_first}Map" type="com.logistics.db.entity.${className}">
	<#list properties as pro>
    <result column="${pro.columnName}" property="${pro.proName}" />
	</#list>
</resultMap>
	<!-- 查询LIST -->
	<select id="getList" parameterType="hashmap" resultMap="${className?uncap_first}Map">
		SELECT
		<#list properties as pro><#if pro_has_next>${pro.columnName}, <#else>${pro.columnName}</#if></#list>
		FROM ${tableName}
	</select>
	
	<!-- 查询LIST个数 -->
	<select id="getListCount" parameterType="hashmap" resultType="int">
		SELECT
		COUNT(*) 
		FROM ${tableName}
	</select>
	
	<!-- 查询一个-->
	<select id="get" parameterType="java.lang.Long" resultMap="${className?uncap_first}Map">
		SELECT
		<#list properties as pro><#if pro_has_next>${pro.columnName}, <#else>${pro.columnName}</#if></#list>
		FROM ${tableName}
		WHERE
		id=${r"#{"}id${r"}"}
	</select>
	
	<!--插入-->
	<insert id="insert" parameterType="${className}">
		INSERT INTO ${tableName} (
			<#list properties as pro><#if pro_has_next>${pro.columnName}, <#else>${pro.columnName}</#if></#list>
		) VALUES (
			<#list properties as pro><#if pro_has_next>${r"#{"}${pro.proName}${r"}"}, <#else>${r"#{"}${pro.proName}${r"}"}</#if></#list>
		)
	</insert>
	
	<!-- 修改-->
	<update id="update" parameterType="${className}">
		UPDATE ${tableName}
		SET
		<#list properties as pro><#if pro_has_next>${pro.columnName}=${r"#{"}${pro.proName}${r"}"}, <#else>${pro.columnName}=${r"#{"}${pro.proName}${r"}"}</#if></#list>
		WHERE
		id=${r"#{"}id${r"}"}
	</update>
	
	<!-- 删除-->
	<delete id="delete" parameterType="java.lang.Long">
		DELETE
		FROM ${tableName}
		WHERE
		id=${r"#{"}id${r"}"}
	</delete>
	
	<!-- 批量删除 -->
	<delete id="batchDelete" parameterType="java.util.Arrays">
		DELETE
		FROM
		${tableName} WHERE id in
		<foreach collection="array" item="item" index="index"
			separator="," open="(" close=")">
			 ${r"#{"}item${r"}"}
		</foreach>
	</delete>

	<!-- 批量插入 -->
	<insert id="batchInsert" parameterType="java.util.List">
		insert into ${tableName}(
		<#list properties as pro><#if pro_has_next>${pro.columnName}, <#else>${pro.columnName}</#if></#list>
		) VALUES 
		<foreach collection="list" item="item" index="index" separator=",">
			( ${r"#{"}item${r"}"})
		</foreach>
	</insert>
	
</mapper>
