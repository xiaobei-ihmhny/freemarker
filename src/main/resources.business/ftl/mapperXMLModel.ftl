<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${dao_packageName}.${className}Mapper">
<resultMap id="${className}Map" type="${pojo_packageName}.${className}">
	<id column="id" property="id" jdbcType="BIGINT"/>
	<#list properties as pro>
	<#if pro.columnName!="id">
    <result column="${pro.columnName}" property="${pro.proName}" jdbcType="${pro.columnType}" />
    </#if>
	</#list>
</resultMap>
	<!-- 数据库字段的集合 -->
	<sql id = "Base_Column_List" >
		<#list properties as pro><#if pro_has_next>${pro.columnName}, <#else>${pro.columnName}</#if></#list>
	</sql>

	<!-- 对象属性的集合 -->
	<sql id = "Base_Property_List" >
		<#list properties as pro><#if pro_has_next>${r"#{"}${pro.proName}, jdbcType=${pro.columnType}${r"}"}, <#else>${r"#{"}${pro.proName}, jdbcType=${pro.columnType}${r"}"}</#if></#list>
	</sql>

    <!-- 根据主键删除 -->
    <delete id="deleteById" parameterType="java.lang.Integer" >
        DELETE
        FROM ${tableName}
        WHERE
        id = ${r"#{"}id${r",jdbcType=BIGINT}"}
	</delete>

    <!--全部插入-->
    <insert id="insert" parameterType="${updatePojo_packageName}.${updatePojo}" >
        INSERT INTO ${tableName} (
        <include refid="Base_Column_List" />
        ) VALUES (
        <include refid="Base_Property_List" />
        )
    </insert>

    <!--部分字段插入-->
    <insert id="insertSelective" keyProperty="id" parameterType="${updatePojo_packageName}.${updatePojo}" useGeneratedKeys="true">
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
			${r"#{"}${pro.proName}, jdbcType=${pro.columnType}${r"}"},
            </if>
		</#list>
        </trim>
    </insert>

    <!-- 根据主键查询 -->
    <select id="selectById" resultMap="${className}Map" parameterType="java.lang.Integer" >
        SELECT
        <include refid="Base_Column_List" />
        FROM ${tableName}
        WHERE
        id = ${r"#{"}id${r",jdbcType=BIGINT}"}
	</select>

	<!--部分字段更新-->
	<update id="updateById" parameterType="${updatePojo_packageName}.${updatePojo}" >
		UPDATE ${tableName}
		<set >
			<#list properties as pro>
			<#if pro.columnName!="id">
			<if test="${pro.proName} != null" >
				${pro.columnName} = ${r"#{"}${pro.proName}, jdbcType=${pro.columnType}${r"}"},
			</if>
			</#if>
			</#list>
		</set>
		WHERE 
		id = ${r"#{"}id${r",jdbcType=BIGINT}"}
	</update>
	
	<#--<!--更新&ndash;&gt;-->
	<#--<update id="updateByPrimaryKey" parameterType="${vo_packageName}.${className}VO" >-->
		<#--UPDATE ${tableName}-->
		<#--SET-->
		<#--<#list properties as pro>-->
		<#--<#if pro.columnName!="id">-->
		<#--<#if pro_has_next>${pro.columnName}=${r"#{"}${pro.proName}${r"}"},<#else>${pro.columnName}=${r"#{"}${pro.proName}${r"}"}</#if>-->
		<#--</#if>-->
		<#--</#list>-->
		<#--WHERE-->
		<#--id = ${r"#{"}id${r",jdbcType=INTEGER}"}-->
	<#--</update>-->
	
	<!-- 查询 -->
	<select id="selectByParams" parameterType="${queryPojo_packageName}.${queryPojo}" resultMap="${className}Map">
		SELECT
		<include refid="Base_Column_List" />
		FROM ${tableName}
        <where>
		<#list properties as pro>
		<#if pro.columnName!="id">
            <if test="${pro.proName} != null" >
			AND ${pro.columnName} = ${r"#{"}${pro.proName}, jdbcType=${pro.columnType}${r"}"}
			</if>
		</#if>
		</#list>
		</where>
        <if test="orderBy != null" >
            ORDER BY ${r"${"}orderBy${r"}"}
        </if>
		<#--<if test="orderBy == 'asc'" >-->
		<#--ORDER BY id asc-->
		<#--</if>-->
		<#--<if test="orderBy != 'asc'" >-->
		<#--ORDER BY id desc-->
		<#--</if>-->
		<#--<if test="orderBy == asc or orderBy == desc" >-->
			<#--ORDER BY id ${r"#{"}orderBy${r"}"}-->
		<#--</if>-->
	</select>

    <!-- 查询 -->
    <select id="selectCountByParams" parameterType="${queryPojo_packageName}.${queryPojo}" resultType="java.lang.Long">
        SELECT
		COUNT(0)
        FROM ${tableName}
        <where>
		<#list properties as pro>
			<#if pro.columnName!="id">
                <if test="${pro.proName} != null" >
                    AND ${pro.columnName} = ${r"#{"}${pro.proName}, jdbcType=${pro.columnType}${r"}"}
                </if>
			</#if>
		</#list>
        </where>
    </select>
</mapper>
