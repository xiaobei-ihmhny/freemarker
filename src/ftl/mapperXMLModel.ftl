<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.logistics.db.dao.${className}Mapper">
<resultMap id="${className?uncap_first}Map" type="com.logistics.db.entity.${className}">
	<id column="id" property="id" />
	<#list properties as pro>
	<#if pro.columnName!="id">
    <result column="${pro.columnName}" property="${pro.proName}" />
    </#if>
	</#list>
</resultMap>
	<!-- 数据库字段的集合 -->
	<sql id = "Base_Column_List" >
		<#list properties as pro><#if pro_has_next>${pro.columnName}, <#else>${pro.columnName}</#if></#list>
	</sql>

	<!-- 对象属性的集合 -->
	<sql id = "Base_Property_List" >
		<#list properties as pro><#if pro_has_next>${r"#{"}${pro.proName}${r"}"}, <#else>${r"#{"}${pro.proName}${r"}"}</#if></#list>
	</sql>
	
	<!-- 根据主键查询 -->
	<select id="selectByPrimaryKey" resultMap="${className?uncap_first}Map" parameterType="java.lang.Integer" >
		SELECT
		<include refid="Base_Column_List" />
		FROM ${tableName}
		WHERE
		id = ${r"#{"}id${r",jdbcType=INTEGER}"}
	</select>
	
	<!-- 根据主键删除 -->
	<delete id="deleteByPrimaryKey" parameterType="java.lang.Integer" >
		DELETE
		FROM ${tableName}
    	WHERE
    	id = ${r"#{"}id${r",jdbcType=INTEGER}"}
	</delete>
	
	<!--插入-->
	<insert id="insert" parameterType="com.logistics.db.entity.${className}" >
		INSERT INTO ${tableName} (
			<include refid="Base_Column_List" />
		) VALUES (
			<include refid="Base_Property_List" />
		)
	</insert>
	
	<!--部分字段插入-->
	<insert id="insertSelective" parameterType="com.logistics.db.entity.${className}" >
		INSERT INTO ${tableName}
		<trim prefix="(" suffix=")" suffixOverrides="," >
			<#list properties as pro>
			<if test="${pro.columnName} != null" >
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
	<update id="updateByPrimaryKeySelective" parameterType="com.logistics.db.entity.${className}" >
		UPDATE ${tableName}
		<set >
			<#list properties as pro>
			<#if pro.columnName!="id">
			<if test="${pro.columnName} != null" >
				${pro.columnName} = ${r"#{"}${pro.proName}${r"}"},
			</if>
			</#if>
			</#list>
		</set>
		WHERE 
		id = ${r"#{"}id${r",jdbcType=INTEGER}"}
	</update>
	
	<!--更新-->
	<update id="updateByPrimaryKey" parameterType="com.logistics.db.entity.${className}" >
		UPDATE ${tableName}
		SET
		<#list properties as pro>
		<#if pro.columnName!="id">
		<#if pro_has_next>${pro.columnName}=${r"#{"}${pro.proName}${r"}"},<#else>${pro.columnName}=${r"#{"}${pro.proName}${r"}"}</#if>
		</#if>
		</#list>
		WHERE
		id = ${r"#{"}id${r",jdbcType=INTEGER}"}
	</update>
	
	<!-- 查询 -->
	<select id="${className?cap_first}List" resultMap="${className?uncap_first}Map" parameterType="java.lang.Integer" >
		SELECT
		<include refid="Base_Column_List" />
		FROM ${tableName}
		WHERE
		AND uid = ${r"#{"}uid${r",jdbcType=INTEGER}"}
		ORDER BY id DESC
	</select>
	
</mapper>
