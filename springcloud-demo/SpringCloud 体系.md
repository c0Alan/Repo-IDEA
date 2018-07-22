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

# 服务消费（基础）

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

# 服务消费（Ribbon）

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

# 服务消费（Feign）

## Spring Cloud Feign

服务消费者 

```
Spring Cloud Feign是一套基于Netflix Feign实现的声明式服务调用客户端。它使得编写Web服务客户端变得更加简单。我们只需要通过创建接口并用注解来配置它既可完成对Web服务接口的绑定。它具备可插拔的注解支持，包括Feign注解、JAX-RS注解。它也支持可插拔的编码器和解码器。Spring Cloud Feign还扩展了对Spring MVC注解的支持，同时还整合了Ribbon和Eureka来提供均衡负载的HTTP客户端实现。
```



## eureka-server

## eureka-client

## eureka-consumer-feign

# 分布式配置中心

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

# 服务容错保护（Hystrix服务降级）

```
在微服务架构中，我们将系统拆分成了一个个的服务单元，各单元应用间通过服务注册与订阅的方式互相依赖。由于每个单元都在不同的进程中运行，依赖通过远程调用的方式执行，这样就有可能因为网络原因或是依赖服务自身问题出现调用故障或延迟，而这些问题会直接导致调用方的对外服务也出现延迟，若此时调用方的请求不断增加，最后就会出现因等待出现故障的依赖方响应而形成任务积压，线程资源无法释放，最终导致自身服务的瘫痪，进一步甚至出现故障的蔓延最终导致整个系统的瘫痪。如果这样的架构存在如此严重的隐患，那么相较传统架构就更加的不稳定。为了解决这样的问题，因此产生了断路器等一系列的服务保护机制。

针对上述问题，在Spring Cloud Hystrix中实现了线程隔离、断路器等一系列的服务保护功能。它也是基于Netflix的开源框架 Hystrix实现的，该框架目标在于通过控制那些访问远程系统、服务和第三方库的节点，从而对延迟和故障提供更强大的容错能力。Hystrix具备了服务降级、服务熔断、线程隔离、请求缓存、请求合并以及服务监控等强大功能。
```

Hystrix具备了服务降级、服务熔断、线程隔离、请求缓存、请求合并以及服务监控等强大功能。

```xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-hystrix</artifactId>
</dependency>
```

在应用主类中使用`@EnableCircuitBreaker`或`@EnableHystrix`注解开启Hystrix的使用 

## eureka-server 

服务注册中心 

## eureka-client 

服务提供者 

为了触发服务降级逻辑，我们可以将服务提供者`eureka-client`的逻辑加一些延迟，比如：

```java
@GetMapping("/dc")
public String dc() throws InterruptedException {
    Thread.sleep(5000L);
    String services = "Services: " + discoveryClient.getServices();
    System.out.println(services);
    return services;
}
```

​	重启`eureka-client`之后，再尝试访问`localhost:2101/consumer`，此时我们将获得的返回结果为：`fallback`。我们从`eureka-client`的控制台中，可以看到服务提供方输出了原本要返回的结果，但是由于返回前延迟了5秒，而服务消费方触发了服务请求超时异常，服务消费者就通过HystrixCommand注解中指定的降级逻辑进行执行，因此该请求的结果返回了`fallback`。这样的机制，对自身服务起到了基础的保护，同时还为异常情况提供了自动的服务降级切换机制。 

## eureka-consumer-ribbon-hystrix  

服务消费者 

在为具体执行逻辑的函数上增加`@HystrixCommand`注解来指定服务降级方法 

# 服务容错保护（Hystrix依赖隔离）

```
在上一篇《Spring Cloud构建微服务架构：服务容错保护（Hystrix服务降级）》中，我们已经体验了如何使用@HystrixCommand来为一个依赖资源定义服务降级逻辑。实现方式非常简单，同时对于降级逻辑还能实现一些更加复杂的级联降级等策略。之前对于使用Hystrix来实现服务容错保护时，除了服务降级之外，我们还提到过线程隔离、断路器等功能。那么在本篇中我们就来具体说说线程隔离。
```



## 依赖隔离

### 线程池

“舱壁模式”对于熟悉Docker的读者一定不陌生，Docker通过“舱壁模式”实现进程的隔离，使得容器与容器之间不会互相影响。而Hystrix则使用该模式实现线程池的隔离，它会为每一个Hystrix命令创建一个独立的线程池，这样就算某个在Hystrix命令包装下的依赖服务出现延迟过高的情况，也只是对该依赖服务的调用产生影响，而不会拖慢其他的服务。

通过对依赖服务的线程池隔离实现，可以带来如下优势：

- 应用自身得到完全的保护，不会受不可控的依赖服务影响。即便给依赖服务分配的线程池被填满，也不会影响应用自身的额其余部分。
- 可以有效的降低接入新服务的风险。如果新服务接入后运行不稳定或存在问题，完全不会影响到应用其他的请求。
- 当依赖的服务从失效恢复正常后，它的线程池会被清理并且能够马上恢复健康的服务，相比之下容器级别的清理恢复速度要慢得多。
- 当依赖的服务出现配置错误的时候，线程池会快速的反应出此问题（通过失败次数、延迟、超时、拒绝等指标的增加情况）。同时，我们可以在不影响应用功能的情况下通过实时的动态属性刷新（后续会通过Spring Cloud Config与Spring Cloud Bus的联合使用来介绍）来处理它。
- 当依赖的服务因实现机制调整等原因造成其性能出现很大变化的时候，此时线程池的监控指标信息会反映出这样的变化。同时，我们也可以通过实时动态刷新自身应用对依赖服务的阈值进行调整以适应依赖方的改变。
- 除了上面通过线程池隔离服务发挥的优点之外，每个专有线程池都提供了内置的并发实现，可以利用它为同步的依赖服务构建异步的访问。

总之，通过对依赖服务实现线程池隔离，让我们的应用更加健壮，不会因为个别依赖服务出现问题而引起非相关服务的异常。同时，也使得我们的应用变得更加灵活，可以在不停止服务的情况下，配合动态配置刷新实现性能配置上的调整。

虽然线程池隔离的方案带了如此多的好处，但是很多使用者可能会担心为每一个依赖服务都分配一个线程池是否会过多地增加系统的负载和开销。对于这一点，使用者不用过于担心，因为这些顾虑也是大部分工程师们会考虑到的，Netflix在设计Hystrix的时候，认为线程池上的开销相对于隔离所带来的好处是无法比拟的。同时，Netflix也针对线程池的开销做了相关的测试，以证明和打消Hystrix实现对性能影响的顾虑。

### 信号量

Hystrix中除了使用线程池之外，还可以使用信号量来控制单个依赖服务的并发度，信号量的开销要远比线程池的开销小得多，但是它不能设置超时和实现异步访问。所以，只有在依赖服务是足够可靠的情况下才使用信号量。在HystrixCommand和HystrixObservableCommand中2处支持信号量的使用：

- 命令执行：如果隔离策略参数execution.isolation.strategy设置为SEMAPHORE，Hystrix会使用信号量替代线程池来控制依赖服务的并发控制。
- 降级逻辑：当Hystrix尝试降级逻辑时候，它会在调用线程中使用信号量。

信号量的默认值为10，我们也可以通过动态刷新配置的方式来控制并发线程的数量。对于信号量大小的估算方法与线程池并发度的估算类似。仅访问内存数据的请求一般耗时在1ms以内，性能可以达到5000rps，这样级别的请求我们可以将信号量设置为1或者2，我们可以按此标准并根据实际请求耗时来设置信号量。

## 如何使用

​	说了那么多依赖隔离的好处，那么我们如何使用Hystrix来实现依赖隔离呢？其实，我们在上一篇定义服务降级的时候，已经自动的实现了依赖隔离。

​	在上一篇的示例中，我们使用了@HystrixCommand来将某个函数包装成了Hystrix命令，这里除了定义服务降级之外，Hystrix框架就会自动的为这个函数实现调用的隔离。所以，依赖隔离、服务降级在使用时候都是一体化实现的，这样利用Hystrix来实现服务容错保护在编程模型上就非常方便的，并且考虑更为全面。

​	除了依赖隔离、服务降级之外，还有一个重要元素：断路器。我们将在下一篇做详细的介绍，这三个重要利器构成了Hystrix实现服务容错保护的强力组合拳。

# 服务容错保护（Hystrix断路器）

## 断路器

断路器模式源于Martin Fowler的Circuit Breaker一文。“断路器”本身是一种开关装置，用于在电路上保护线路过载，当线路中有电器发生短路时，“断路器”能够及时的切断故障电路，防止发生过载、发热、甚至起火等严重后果。

在分布式架构中，断路器模式的作用也是类似的，当某个服务单元发生故障（类似用电器发生短路）之后，通过断路器的故障监控（类似熔断保险丝），直接切断原来的主逻辑调用。但是，在Hystrix中的断路器除了切断主逻辑的功能之外，还有更复杂的逻辑，下面我们来看看它更为深层次的处理逻辑。

以在[《Spring Cloud构建微服务架构：服务容错保护（Hystrix服务降级）》](http://blog.didispace.com/spring-cloud-starter-dalston-4-1)一文中实现的服务降级例子为示例，我们来说说断路器的工作原理。当我们把服务提供者`eureka-client`中加入了模拟的时间延迟之后，在服务消费端的服务降级逻辑因为hystrix命令调用依赖服务超时，触发了降级逻辑，但是即使这样，受限于Hystrix超时时间的问题，我们的调用依然很有可能产生堆积。

这个时候断路器就会发挥作用，那么断路器是在什么情况下开始起作用呢？这里涉及到断路器的三个重要参数：快照时间窗、请求总数下限、错误百分比下限。这个参数的作用分别是：

- 快照时间窗：断路器确定是否打开需要统计一些请求和错误数据，而统计的时间范围就是快照时间窗，默认为最近的10秒。
- 请求总数下限：在快照时间窗内，必须满足请求总数下限才有资格根据熔断。默认为20，意味着在10秒内，如果该hystrix命令的调用此时不足20次，即时所有的请求都超时或其他原因失败，断路器都不会打开。
- 错误百分比下限：当请求总数在快照时间窗内超过了下限，比如发生了30次调用，如果在这30次调用中，有16次发生了超时异常，也就是超过50%的错误百分比，在默认设定50%下限情况下，这时候就会将断路器打开。

那么当断路器打开之后会发生什么呢？我们先来说说断路器未打开之前，对于之前那个示例的情况就是每个请求都会在当hystrix超时之后返回`fallback`，每个请求时间延迟就是近似hystrix的超时时间，如果设置为5秒，那么每个请求就都要延迟5秒才会返回。当熔断器在10秒内发现请求总数超过20，并且错误百分比超过50%，这个时候熔断器打开。打开之后，再有请求调用的时候，将不会调用主逻辑，而是直接调用降级逻辑，这个时候就不会等待5秒之后才返回fallback。通过断路器，实现了自动地发现错误并将降级逻辑切换为主逻辑，减少响应延迟的效果。

在断路器打开之后，处理逻辑并没有结束，我们的降级逻辑已经被成了主逻辑，那么原来的主逻辑要如何恢复呢？对于这一问题，hystrix也为我们实现了自动恢复功能。当断路器打开，对主逻辑进行熔断之后，hystrix会启动一个休眠时间窗，在这个时间窗内，降级逻辑是临时的成为主逻辑，当休眠时间窗到期，断路器将进入半开状态，释放一次请求到原来的主逻辑上，如果此次请求正常返回，那么断路器将继续闭合，主逻辑恢复，如果这次请求依然有问题，断路器继续进入打开状态，休眠时间窗重新计时。

通过上面的一系列机制，hystrix的断路器实现了对依赖资源故障的端口、对降级策略的自动切换以及对主逻辑的自动恢复机制。这使得我们的微服务在依赖外部服务或资源的时候得到了非常好的保护，同时对于一些具备降级逻辑的业务需求可以实现自动化的切换与恢复，相比于设置开关由监控和运维来进行切换的传统实现方式显得更为智能和高效。

# Hystrix监控面板

在上一篇[《服务容错保护（hystrix断路器）》](http://blog.didispace.com/spring-cloud-starter-dalston-4-3)的介绍中，我们提到断路器是根据一段时间窗内的请求情况来判断并操作断路器的打开和关闭状态的。而这些请求情况的指标信息都是HystrixCommand和HystrixObservableCommand实例在执行过程中记录的重要度量信息，它们除了Hystrix断路器实现中使用之外，对于系统运维也有非常大的帮助。这些指标信息会以“滚动时间窗”与“桶”结合的方式进行汇总，并在内存中驻留一段时间，以供内部或外部进行查询使用，Hystrix Dashboard就是这些指标内容的消费者之一。 

## eureka-server

服务注册中心

## eureka-client

服务提供者

## eureka-consumer-ribbon-hystrix

使用ribbon和hystrix实现的服务消费者

## hystrix-dashboard 

Hystrix监控面板

```xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
</dependency>
```

访问：`http://localhost:1301/hystrix` 

Hystrix Dashboard的监控首页，该页面中并没有具体的监控信息。从页面的文字内容中我们可以知道，Hystrix Dashboard共支持三种不同的监控方式，依次为：

- 默认的集群监控：通过URL`http://turbine-hostname:port/turbine.stream`开启，实现对默认集群的监控。
- 指定的集群监控：通过URL`http://turbine-hostname:port/turbine.stream?cluster=[clusterName]`开启，实现对clusterName集群的监控。
- 单体应用的监控：通过URL`http://hystrix-app:port/hystrix.stream`开启，实现对具体某个服务实例的监控。

前两者都对集群的监控，需要整合Turbine才能实现，这部分内容我们将在下一篇中做详细介绍。在本节中，我们主要实现对单个服务实例的监控，所以这里我们先来实现单个服务实例的监控。

既然Hystrix Dashboard监控单实例节点需要通过访问实例的`/hystrix.stream`接口来实现，自然我们需要为服务实例添加这个端点，而添加该功能的步骤也同样简单，只需要下面两步：

- 在服务实例`pom.xml`中的`dependencies`节点中新增`spring-boot-starter-actuator`监控模块以开启监控相关的端点，并确保已经引入断路器的依赖`spring-cloud-starter-hystrix`

```xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-hystrix</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

- 确保在服务实例的主类中已经使用`@EnableCircuitBreaker`或`@EnableHystrix`注解，开启了断路器功能。

到这里已经完成了所有的配置，我们可以在Hystrix Dashboard的首页输入`http://localhost:2101/hystrix.stream`，已启动对“eureka-consumer-ribbon-hystrix”的监控，点击“Monitor Stream”按钮，此时我们可以看到如下页面

在对该页面介绍前，我们先看看在首页中我们还没有介绍的两外两个参数：

- Delay：该参数用来控制服务器上轮询监控信息的延迟时间，默认为2000毫秒，我们可以通过配置该属性来降低客户端的网络和CPU消耗。
- Title：该参数对应了上图头部标题Hystrix Stream之后的内容，默认会使用具体监控实例的URL，我们可以通过配置该信息来展示更合适的标题。

回到监控页面，我们来详细说说其中各元素的具体含义：

我们可以在监控信息的左上部分找到两个重要的图形信息：一个实心圆和一条曲线。

- 实心圆：共有两种含义。它通过颜色的变化代表了实例的健康程度，如下图所示，它的健康度从绿色、黄色、橙色、红色递减。该实心圆除了颜色的变化之外，它的大小也会根据实例的请求流量发生变化，流量越大该实心圆就越大。所以通过该实心圆的展示，我们就可以在大量的实例中快速的发现故障实例和高压力实例。
- 曲线：用来记录2分钟内流量的相对变化，我们可以通过它来观察到流量的上升和下降趋势。

# Hystrix监控数据聚合

## eureka-server

服务注册中心

## eureka-client

服务提供者

## eureka-consumer-ribbon-hystrix

使用ribbon和hystrix实现的服务消费者

## hystrix-dashboard

用于展示eureka-consumer-ribbon-hystrix服务的Hystrix数据

## Turbine 

## turbine-amqp 

```xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-turbine-amqp</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

# Feign的继承特性(伪RPC模式)

​	很多的方式来产生Feign的客户端程序，依然有很多开发者热衷于利用公共的依赖接口来连接服务提供者和服务消费者的方式。由此，Feign的继承特性就能很好的派上用处。 

接下来的示例将分为三个模块：

- 服务接口定义模块：通过Spring MVC注解定义抽象的interface服务接口
- 服务接口实现模块：实现服务接口定义模块的interface，该模块作为服务提供者注册到eureka
- 服务接口消费模块：服务接口定义模块的客户端实现，该模块通过注册到eureka来消费服务接口

## eureka-feign-api 

服务接口的定义

