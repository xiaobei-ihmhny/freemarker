# freemarker1.2

**主要利用freemarker模板引擎，实现代码自动生成**

- 概述：

> 此工程主要用于项目初期生成一些通用的模板代码，包括：controller、service、serviceImpl、mapper、mapper.xml，在项目后期用处不大。

- 更新：

1. 可以在更换数据库后，手动快速生成相关的表与类名之间的对应关系（按驼峰规则），类与所属模块之间的关系，控制类与请求路径之间的关系。
2. 可以指定生成对数据库中的部分表进行代码生成。
3. 对数据库表的操作中加入了读取表注释的功能，可以自动为生成的javabean对象加上注释
4. 可以指定文件生成的存放路径，目前的规则是文件存在则覆盖，不存在则新增。
5. 配置了两种环境，可通过pom.xml文件进行配置文件的选择。

<div align="center"> <img src="freemarker相关类说明.png" width=""/> </div><br>
