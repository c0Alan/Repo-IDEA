# 简单实例

# 基本配置

### 6.1.1 入口类和@SpringBootApplication
### 6.1.2 关闭特定的自动配置
### 6.1.3 定制Banner
### 6.1.4 Spring Boot 的配置文件
### 6.1.5 starter pom
### 6.1.6 使用xml 配置
## 6.2 外部配置
### 6.2.1 命令行参数配置
### 6.2.2 常规属性配置
### 6.2.3 类型安全的配置（基于properties）
## 6.3 日志配置
## 6.4 Profile 配置
## 6.5 Spring Boot 运行原理
### 6.5.1 运作原理
### 6.5.2 核心注解
### 6.5.3 实例分析
### 6.5.4 实战
# Web 开发
## 7.1 Spring Boot 的Web 开发支持
## 7.2 Thymeleaf 模板引擎
### 7.2.1 Thymeleaf 基础知识
### 7.2.2 与Spring MVC 集成
### 7.2.3 Spring Boot 的Thymeleaf 支持
### 7.2.4 实战
## 7.3 Web 相关配置
### 7.3.1 Spring Boot 提供的自动配置
### 7.3.2 接管Spring Boot 的Web 配置
### 7.3.3 注册Servlet、Filter、Listener
## 7.4 Tomcat 配置
### 7.4.1 配置Tomcat
### 7.4.2 代码配置Tomcat
### 7.4.3 替换Tomcat
### 7.4.4 SSL 配置
## 7.5 Favicon 配置
### 7.5.1 默认的Favicon
### 7.5.2 关闭Favicon
### 7.5.3 设置自己的Favicon
## 7.6 WebSocket
### 7.6.1 什么是WebSocket
### 7.6.2 Spring Boot 提供的自动配置
### 7.6.3 实战
## 7.7 基于Bootstrap 和AngularJS 的现代Web 应用
### 7.7.1 Bootstrap
### 7.7.2 AngularJS
### 7.7.3 实战
# 数据访问

Spring Data 系列

## 8.1 引入Docker
### 8.1.1 Docker 的安装
### 8.1.2 Docker 常用命令及参数
### 8.1.3 下载本书所需的Docker 镜像
### 8.1.4 异常处理
## 8.2 Spring Data JPA
### 8.2.1 点睛Spring Data JPA
### 8.2.2 Spring Boot 的支持
### 8.2.3 实战
## 8.3 Spring Data REST
### 8.3.1 点睛Spring Data REST
### 8.3.2 Spring Boot 的支持
### 8.3.3 实战
## 8.4 声名式事务
### 8.4.1 Spring 的事务机制
### 8.4.2 声名式事务
### 8.4.3 注解事务行为
### 8.4.4 类级别使用@Transactional
### 8.4.5 Spring Data JPA 的事务支持
### 8.4.6 Spring Boot 的事务支持
### 8.4.7 实战
## 8.5 数据缓存Cache
### 8.5.1 Spring 缓存支持
### 8.5.2 Spring Boot 的支持
### 8.5.3 实战
### 8.5.4 切换缓存技术
## 8.6 非关系型数据库NoSQL
### 8.6.1 MongoDB
### 8.6.2 Redis
# Quartz

## JobDetail

defines a particular Job. JobDetail instances can be built with the JobBuilder API.

## Calendar

## Trigger

defines when a particular job is triggered.

# Spring Boot 企业级开发

## 9.1 安全控制Spring Security
### 9.1.1 Spring Security 快速入门
### 9.1.2 Spring Boot 的支持
### 9.1.3 实战
## 9.2 批处理Spring Batch
### 9.2.1 Spring Batch 快速入门
### 9.2.2 Spring Boot 的支持
### 9.2.3 实战
## 9.3 异步消息
### 9.3.1 企业级消息代理
### 9.3.2 Spring 的支持
### 9.3.3 Spring Boot 的支持
### 9.3.4 JMS 实战
### 9.3.5 AMQP 实战
## 9.4 系统集成Spring Integration
### 9.4.1 Spring Integration 快速入门
### 9.4.2 Message
### 9.4.3 Channel
### 9.4.4 Message EndPoint
### 9.4.5 Spring Integration Java DSL
### 9.4.6 实战
# 第10章 Spring Boot 开发部署与测试
10.1 开发的热部署
10.1.1 模板热部署
10.1.2 Spring Loaded
10.1.3 JRebel
10.1.4 spring-boot-devtools
10.2 常规部署
10.2.1 jar 形式
10.2.2 war 形式
10.3 云部署——基于Docker 的部署
10.3.1 Dockerfile
10.3.2 安装Docker
10.3.3 项目目录及文件
10.3.4 编译镜像
10.3.5 运行
10.4 Spring Boot 的测试
10.4.1 新建Spring Boot 项目
10.4.2 业务代码
10.4.3 测试用例
10.4.4 执行测试
# 第11章 应用监控
11.1 http
11.1.1 新建Spring Boot 项目
11.1.2 测试端点
11.1.3 定制端点
11.1.4 自定义端点
11.1.5 自定义HealthIndicator
11.2 JMX
11.3 SSH
11.3.1 新建Spring Boot 项目
11.3.2 运行
11.3.3 常用命令
11.3.4 定制登录用户
11.3.5 扩展命令
# 第12章 分布式系统开发
12.1 微服务、原生云应用
12.2 Spring Cloud 快速入门
12.2.1 配置服务
12.2.2 服务发现
12.2.3 路由网关
12.2.4 负载均衡
12.2.5 断路器
12.3 实战
12.3.1 项目构建
12.3.2 服务发现——Discovery（Eureka Server）
12.3.3 配置——Config（Config Server）
12.3.4 服务模块——Person 服务
12.3.5 服务模块——Some 服务
12.3.6 界面模块——UI（Ribbon,Feign）
12.3.7 断路器监控——Monitor（DashBoard）
12.3.8 运行
12.4 基于Docker 部署
12.4.1 Dockerfile 编写
12.4.2 Docker Compose
12.4.3 Docker-compose.yml 编写
12.4.4 运行
附录A
A.1 基于JHipster 的代码生成
A.2 常用应用属性配置列表[1] 

## 

# 常用注解

## 基本注解

## @Conditional 系列

