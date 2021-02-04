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

1. 连接池

   我们在实际开发中都会使用连接池。
   因为它可以减少我们获取连接的时间。

   - 连接池就是用于存储连接的一个容器
   - 容器其实就是一个集合对象，该集合必须是线程安全的，不能两个线程拿到同一个连接池
   - 该集合还必须实现队列的特性：先进先出

2. mybatis 中的连接池

   mybatis 连接池提供了 3 种方式的配置：

   - 配置位置：
     - 主配置文件 SqlMapConfig.xml 中的 dataSource 标签，type 属性就是表示采用何种连接池方式
   - type 属性的取值：
     - POOLED
       - 采用传统的 javax.sql.DataSource 规范中的连接池，mybatis 中有针对规范的实现
     - UNPOOLED
       - 采用传统的获取连接的方式，虽然也实现了 javax.sql.DataSource 接口，但是并没有使用池的思想
     - JNDI
       - 采用服务器提供的 JNDI 技术实现，来获取 DataSource 对象，不同的服务器所能拿到的 DataSource 是不一样的
       - 注意：如果不是 web 或者 maven 的 war 工程，是不能使用的

### mybatis 的事务控制及设计方法

### mybatis 的多表查询

#### 一对多（多对一）

#### 多对多

## mybatis 的缓存和注解开发

### mybatis 中的加载时机（查询时机）

#### 延迟加载

在真正使用数据时才发起查询，不用的时候不查询，按需加载（懒查询）

#### 立即加载

不管用不用，只要一调用方法，马上发起查询

#### 表关系与加载方式

- 四种表关系
  - 一对多
  - 多对一
  - 一对一
  - 多对多
- 对应关系
  - 一对多，多对多：通常情况下采用延迟加载
  - 多对一，一对一：通常情况下采用立即加载

### mybatis 中的一级缓存和二级缓存

#### 什么是缓存

存在于内存中的临时数据

#### 为什么使用缓存

减少和数据库的交互次数，提高执行效率

#### 适用于缓存的情况

- 经常查询并且不经常改变
- 数据的正确与否对最终结果影响不大的

#### 一级缓存

指的是 Mybatis 中 SqlSession 对象的缓存。
当我们执行查询之后，查询的结果会同时存入到 SqlSession 为我们提供的一块区域中。该区域的结构是一个 Map。当我们再次查询同样的数据，mybatis 会先去 sqlsession 中查询是否有，有的话直接拿出来用。
当 SqlSession 对象消失时，mybatis 的一级缓存也就消失了。

#### 二次缓存

它指的是 Mybatis 中 SqlSessionFactory 对象的缓存。由同一个 SqlSessionFactory 对象创建的 SqlSession 共享其缓存。

- 二级缓存的使用步骤：
  1. 让 Mybatis 框架支持二级缓存（在 SqlMapConfig.xml 中配置）
  2. 让当前的映射文件支持二级缓存（在 IUserDao.xml 中配置）
  3. 让当前的操作支持二级缓存（在 select 标签中配置）

### mybatis 的注解开发

#### 单表 CRUD

#### 多表查询
