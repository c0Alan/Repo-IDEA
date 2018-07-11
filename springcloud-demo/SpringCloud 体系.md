# 注解大全

@EnableEurekaServer 

@EnableDiscoveryClient 

# 基础知识

Spring Cloud是一个基于Spring Boot实现的云应用开发工具，它为基于JVM的云应用开发中的配置管理、服务发现、断路器、智能路由、微代理、控制总线、全局锁、决策竞选、分布式会话和集群状态管理等操作提供了一种简单的开发方式。

Spring Cloud包含了多个子项目（针对分布式系统中涉及的多个不同开源产品），比如：Spring Cloud Config、Spring Cloud Netflix、Spring Cloud CloudFoundry、Spring Cloud AWS、Spring Cloud Security、Spring Cloud Commons、Spring Cloud Zookeeper、Spring Cloud CLI等项目。

什么是微服务架构
-- 与单体系统的区别
-- 如何实施微服务
为什么选择Spring Cloud
Spring Cloud简介
版本说明
# 微服务构建

Spring Boot

框架简介
快速入门
-- 项目构建与解析
-- 实现RESTful API
配置详解
-- 配置文件
-- 自定义参数
-- 参数引用
-- 使用随机数
-- 命令行参数
-- 多环境配置
-- 加载顺序
监控与管理
-- 初识actuator
-- 原生端点
小结
# 服务治理-服务发现 

## Spring Cloud Eureka

Spring Cloud Eureka 是Spring Cloud Netflix 微服务套件中的一部分，它基于Netflix
Eureka 做了二次封装，主要负责完成微服务架构中的服务治理功能。

服务治理
-- Netflix Eureka
--搭建服务注册中心
--注册服务提供者
--高可用注册中心
--服务发现与消费
Eureka详解
--基础架构
--服务治理机制
--源码分析
配置详解
--服务注册类配置
--服务实例类配置
跨平台支持
# 客户端负载均衡

## Spring Cloud Ribbon

客户端负载均衡
RestTemplate详解
-- GET请求
-- POST请求
-- PUT请求
-- DELETE请求
源码分析
-- 负载均衡器
-- 负载均衡策略
配置详解
--自动化配置
-- Camden版本对RibbonClient配置的优化
-- 参数配置
-- 与Eureka结合
重试机制
# 服务容错保护-断路器 

## Spring Cloud Hystrix

快速入门
原理分析
-- 工作流程
-- 断路器原理
-- 依赖隔离
使用详解
-- 创建请求命令
-- 定义服务降级
-- 异常处理
-- 命令名称、分组以及线程池划分
-- 请求缓存
-- 请求合并
属性详解
-- Command属性
-- collapser属性
-- threadPool属性
Hystrix仪表盘
Turbine集群监控
-- 构建监控聚合服务
-- 与消息代理结合
# 声明式服务调用

## Spring Cloud Feign

快速入门
参数绑定
继承特性
Ribbon配置
全局配置
指定服务配置
重试机制
Hystrix配置
全局配置
禁用Hystrix
指定命令配置
服务降级配置
其他配置
# API网关服务-智能路由

## Spring Cloud Zuul

快速入门
-- 构建网关
-- 请求路由
-- 请求过滤
路由详解
-- 传统路由配置
-- 服务路由配置
-- 服务路由的默认规则
-- 自定义路由映射规则
-- 路径匹配
-- 路由前缀
-- 本地跳转
-- Cookie与头信息
-- Hystrix和Ribbon支持
过滤器详解
-- 过滤器
-- 请求生命周期
-- 核心过滤器
-- 异常处理
-- 禁用过滤器
动态加载
-- 动态路由
-- 动态过滤器
# 分布式配置中心

## Spring Cloud Config

快速入门
-- 构建配置中心
-- 配置规则详解
-- 客户端配置映射
服务端详解
-- 基础架构
-- Git配置仓库
-- SVN配置仓库
-- 本地仓库
-- 本地文件系统
-- 健康监测
-- 属性覆盖
-- 安全保护
-- 加密解密
-- 高可用配置
客户端详解
-- URI指定配置中心
-- 服务化配置中心
-- 失败快速响应与重试
-- 获取远程配置
-- 动态刷新配置
# 消息总线

## Spring Cloud Bus

消息代理
RabbitMQ实现消息总线
-- 基本概念
-- 安装与使用
-- 快速入门
-- 整合Spring Cloud Bus
-- 原理分析
-- 指定刷新范围
-- 架构优化
-- RabbitMQ配置
Kafka实现消息总线
-- Kafka简介
-- 快速入门
--整合Spring Cloud Bus
-- Kafka配置
深入理解
-- 源码分析
-- 其他消息代理的支持

# 消息驱动的微服务

## Spring Cloud Stream

快速入门
核心概念
-- 绑定器
-- 发布-订阅模式
-- 消费组
-- 消息分区
使用详解
-- 开启绑定功能
-- 绑定消息通道
-- 消息生产与消费
-- 响应式编程
-- 消费组与消息分区
-- 消息类型
绑定器详解
-- 绑定器SPI
-- 自动化配置
-- 多绑定器配置
-- RabbitMQ与Kafka绑定器
配置详解
-- 基础配置
-- 绑定通道配置
-- 绑定器配置

# 分布式服务跟踪

## Spring Cloud Sleuth

快速入门
-- 准备工作
-- 实现跟踪
跟踪原理
抽样收集
与Logstash整合
与Zipkin整合
-- HTTP收集
-- 消息中间件收集
-- 收集原理
-- 数据存储
-- API接口

# 服务注册与发现（Eureka、Consul）

## eureka-server

服务注册中心

通过`@EnableEurekaServer`注解启动一个服务注册中心提供给其他应用进行对话。 

## eureka-client

服务提供方

在应用主类中通过加上`@EnableDiscoveryClient`注解，该注解能激活Eureka中的DiscoveryClient实现，这样才能实现Controller中对服务信息的输出。

## consul-client

(Spring Cloud Consul) 另一种服务提供方

Spring Cloud Consul项目是针对Consul的服务治理实现。Consul是一个分布式高可用的系统，它包含多个组件，但是作为一个整体，在微服务架构中为我们的基础设施提供服务发现和服务配置的工具。它包含了下面几个特性：

- 服务发现
- 健康检查
- Key/Value存储
- 多数据中心

由于Spring Cloud Consul项目的实现，我们可以轻松的将基于Spring Boot的微服务应用注册到Consul上，并通过此实现微服务架构中的服务治理。 

# Spring Cloud构建微服务架构：服务消费（基础）

```
通过上一篇《Spring Cloud构建微服务架构：服务注册与发现》，我们已经成功地将服务提供者：eureka-client或consul-client注册到了Eureka服务注册中心或Consul服务端上了，同时我们也通过DiscoveryClient接口的getServices获取了当前客户端缓存的所有服务清单，那么接下来我们要学习的就是：如何去消费服务提供者的接口？
```

如何去消费服务提供者的接口？

## 使用LoadBalancerClient

从LoadBalancerClient接口的命名中，我们就知道这是一个负载均衡客户端的抽象定义

## eureka-server 

服务注册中心 

## eureka-client 

服务提供者 

## eureka-consumer 

服务消费者 

# Spring Cloud构建微服务架构：服务消费（Ribbon）

```
通过上一篇《Spring Cloud构建微服务架构：服务消费（基础）》，我们已经学会如何通过LoadBalancerClient接口来获取某个服务的具体实例，并根据实例信息来发起服务接口消费请求。但是这样的做法需要我们手工的去编写服务选取、链接拼接等繁琐的工作，对于开发人员来说非常的不友好。所以，下来我们看看Spring Cloud中针对客户端负载均衡的工具包：Spring Cloud Ribbon。
```

## Spring Cloud Ribbon

服务消费者 

```
Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具。它是一个基于HTTP和TCP的客户端负载均衡器。它可以通过在客户端中配置ribbonServerList来设置服务端列表去轮询访问以达到均衡负载的作用。

当Ribbon与Eureka联合使用时，ribbonServerList会被DiscoveryEnabledNIWSServerList重写，扩展成从Eureka注册中心中获取服务实例列表。同时它也会用NIWSDiscoveryPing来取代IPing，它将职责委托给Eureka来确定服务端是否已经启动。

而当Ribbon与Consul联合使用时，ribbonServerList会被ConsulServerList来扩展成从Consul获取服务实例列表。同时由ConsulPing来作为IPing接口的实现。

我们在使用Spring Cloud Ribbon的时候，不论是与Eureka还是Consul结合，都会在引入Spring Cloud Eureka或Spring Cloud Consul依赖的时候通过自动化配置来加载上述所说的配置内容，所以我们可以快速在Spring Cloud中实现服务间调用的负载均衡。
```

```xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-ribbon</artifactId>
</dependency>
```



## eureka-server

## eureka-client

## eureka-consumer-ribbon

# Spring Cloud构建微服务架构：服务消费（Feign）

## Spring Cloud Feign

服务消费者 

```
Spring Cloud Feign是一套基于Netflix Feign实现的声明式服务调用客户端。它使得编写Web服务客户端变得更加简单。我们只需要通过创建接口并用注解来配置它既可完成对Web服务接口的绑定。它具备可插拔的注解支持，包括Feign注解、JAX-RS注解。它也支持可插拔的编码器和解码器。Spring Cloud Feign还扩展了对Spring MVC注解的支持，同时还整合了Ribbon和Eureka来提供均衡负载的HTTP客户端实现。
```



## eureka-server

## eureka-client

## eureka-consumer-feign

# Spring Cloud构建微服务架构：分布式配置中心

```
	Spring Cloud Config是Spring Cloud团队创建的一个全新项目，用来为分布式系统中的基础设施和微服务应用提供集中化的外部配置支持，它分为服务端与客户端两个部分。其中服务端也称为分布式配置中心，它是一个独立的微服务应用，用来连接配置仓库并为客户端提供获取配置信息、加密/解密信息等访问接口；而客户端则是微服务架构中的各个微服务应用或基础设施，它们通过指定的配置中心来管理应用资源与业务相关的配置内容，并在启动的时候从配置中心获取和加载配置信息。Spring Cloud Config实现了对服务端和客户端中环境变量和属性配置的抽象映射，所以它除了适用于Spring构建的应用程序之外，也可以在任何其他语言运行的应用程序中使用。由于Spring Cloud Config实现的配置中心默认采用Git来存储配置信息，所以使用Spring Cloud Config构建的配置服务器，天然就支持对微服务应用配置信息的版本管理，并且可以通过Git客户端工具来方便的管理和访问配置内容。当然它也提供了对其他存储方式的支持，比如：SVN仓库、本地化文件系统。
```

## config-server-git 

```xml
<dependencies>
	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-config-server</artifactId>
	</dependency>
</dependencies>
```

@EnableConfigServer 

```
访问配置信息的URL与配置文件的映射关系如下：

/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
```

## config-client

```xml
<dependencies>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-config</artifactId>
	</dependency>
</dependencies>
```

```xml
上述配置参数与Git中存储的配置文件中各个部分的对应关系如下：

spring.application.name：对应配置文件规则中的{application}部分
spring.cloud.config.profile：对应配置文件规则中的{profile}部分
spring.cloud.config.label：对应配置文件规则中的{label}部分
spring.cloud.config.uri：配置中心config-server的地址
```

**注意：上面这些属性必须配置在bootstrap.properties中，这样config-server中的配置信息才能被正确加载。** 



