# mybatis 框架
1. 什么是框架
    - 框架是我们软件开发中的一套解决方案，不同的框架解决的是不同的问题。
    - 使用框架的好处：
    > 框架封装了许多的细节，使开发者可以使用极简的方式实现功能，大大提高开发效率

2. 三层架构
   - 表现层：用于展示数据
   - 业务层：处理业务需求
   - 持久层：负责和数据库进行交互

3. 持久层技术解决方案
   - JDBC 技术：
     - Connectiong
     - PrepareStatement
     - ResultSet
   - Spring 的 JdbcTemplate：
     - Spring 对 jdbc 的简单封装
   - Apache 的 DBUtils：
     - 也是对 jdbc 的简单封装


## mybatis 入门
### mybatis 概述
mybatis 是一个优秀的基于 java 的持久层框架，它内部封装了 jdbc，使开发者只需要关注 sql 语句本身，而不需要花费精力去处理加载驱动、创建连接、创建 statement 等繁杂的过程。

mybatis 通过 xml 或注解的方式将要执行的各种 statement 配置起来，并通过 java 对象和 statement 中 sql 的动态参数进行映射生成最终执行的 sql 语句，最后由 mybatis 框架执行 sql 并将结果映射为 java 对象并返回。

采用 ORM 思想解决了实体和数据库映射的问题，对 jdbc 进行了封装，屏蔽了 jdbc api 底层访问细节，使我们不用与 jdbc api 打交道，就可以完成对数据库的持久化操作。

### mybatis 环境搭建
1. 创建 maven 工程并导入坐标
2. 创建实体类和 dao 的接口
3. 创建 Mybatis 的主配置文件 —— SqlMapConfig.xml
4. 创建映射配置文件 —— UserDao.xml

### mybatis 入门案例
1. 读取配置文件
2. 创建 SqlSessionFactory 工厂
3. 使用工厂生产 SqlSession 对象
4. 使用 SqlSession 创建 Dao 接口 的代理对象
5. 使用代理对象执行方法
6. 释放资源

### 自定义 mybatis 框架


## mybatis 基本使用
### mybatis 的单表 crud 操作
### mybatis 的参数和返回值
### mybatis 的 dao 编写
### mybatis 配置的细节
#### 几个标签的使用


## mybatis 的深入和多表
### mybatis 的连接池
### mybatis 的事务控制及设计方法
### mybatis 的多表查询
#### 一对多（多对一）
#### 多对多


## mybatis 的缓存和注解开发
### mybatis 中的加载时机（查询时机）
### mybatis 中的一级缓存和二级缓存
### mybatis 的注解开发
#### 单表 CRUD
#### 多表查询


