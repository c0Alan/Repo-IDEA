# 参考

## 方志鹏

### 专栏博客

[方志鹏的专栏](https://www.fangzhipeng.com/)

[方志朋的博客](http://blog.csdn.net/forezp)

### 源码路径

https://gitee.com/forezp/SpringCloudLearning

## 翟永超

### 源码路径

Github：[https://github.com/dyc87112/SpringCloud-Learning/](https://github.com/dyc87112/SpringCloud-Learning/tree/master/4-Finchley)

Gitee：[https://gitee.com/didispace/SpringCloud-Learning/](https://gitee.com/didispace/SpringCloud-Learning/tree/master/4-Finchley)



# 版本说明

Spring Cloud Finchley; Spring Boot 2.0.3

# Spring Cloud Alibaba

[https://github.com/dyc87112/SpringCloud-Learning/](https://github.com/dyc87112/SpringCloud-Learning/tree/master/4-Finchley)

## [使用Nacos实现服务注册与发现](http://blog.didispace.com/spring-cloud-alibaba-1/)

dsc-f-nacos-server

dsc-f-nacos-client

## [支持的几种服务消费方式（RestTemplate、WebClient、Feign）](https://blog.didispace.com/spring-cloud-alibaba-2/)

dsc-f-nacos-server

dsc-f-nacos-client

## [使用Nacos作为配置中心](http://blog.didispace.com/spring-cloud-alibaba-3/)

dsc-f-nacos-server

dsc-f-nacos-client



# Eureka

- [服务的注册与发现（Eureka）(Finchley版本)](http://blog.csdn.net/forezp/article/details/81040925)
- 

eureka-server-s1:8761

service-hi-s1:8762

# ribbon

* [服务消费者（rest+ribbon）(Finchley版本)](http://blog.csdn.net/forezp/article/details/81040946)

eureka-server-s1:8761

service-hi-s1:8762,8763

service-ribbon-s1:8764

# Feign

* [服务消费者（Feign）(Finchley版本)](http://blog.csdn.net/forezp/article/details/81040965)

eureka-server-s1:8761

service-hi-s1:8762,8763

service-ribbon-s1:8764

service-feign-s1:8765

# Hystrix

* [断路器（Hystrix）(Finchley版本)](http://blog.csdn.net/forezp/article/details/81040990)

eureka-server-s1:8761

service-hi-s1:8762,8763

service-ribbon-s2:8764

service-feign-s2:8765

# zuul

* [ 路由网关(zuul)(Finchley版本)](http://blog.csdn.net/forezp/article/details/81041012)

eureka-server-s1:8761

service-hi-s1:8762,8763

service-ribbon-s2:8764

service-feign-s2:8765

service-zuul-s1:8769

# Spring Cloud Config

* [分布式配置中心(Spring Cloud Config)(Finchley版本)](http://blog.csdn.net/forezp/article/details/81041028)

config-server-s1:8888

config-client-s1:8881

* [高可用的分布式配置中心(Spring Cloud Config)(Finchley版本)](http://blog.csdn.net/forezp/article/details/81041045)

eureka-server-s1:8761

config-server-s1:8888

config-client-s1:8881

# Spring Cloud Bus

* [消息总线(Spring Cloud Bus)(Finchley版本)](http://blog.csdn.net/forezp/article/details/81041062)

eureka-server-s1:8761

config-server-s1:8888

config-client-s3:8881,8882

# Spring Cloud Sleuth

* [服务链路追踪(Spring Cloud Sleuth)(Finchley版本)](http://blog.csdn.net/forezp/article/details/81041078)

zipkin-server:9411

service-hi-s2:8762

service-miya-s1:8989

# Finchley

* [高可用的服务注册中心(Finchley版本)](http://blog.csdn.net/forezp/article/details/81041101)

eureka-server-s2:8761,8769

service-hi-s1:8762,8763

# Hystrix Dashboard

* [断路器监控(Hystrix Dashboard)(Finchley版本)](http://blog.csdn.net/forezp/article/details/81041113)

eureka-server-s1:8761

service-hi-s3:8762

# Hystrix Turbine

* [断路器聚合监控(Hystrix Turbine)(Finchley版本)](http://blog.csdn.net/forezp/article/details/81041125)

eureka-server-s1:8761

service-hi-s1:8762

service-lucy-s1:8763

service-turbine-s1:8764

# Spring Cloud Gateway

* [Spring Cloud Gateway初体验](https://blog.csdn.net/forezp/article/details/83792388)

gateway-filter-s1:8080

* [Spring Cloud Gateway 之Predict篇](https://blog.csdn.net/forezp/article/details/84926662)

gateway-predicate-s1

* [Spring Cloud Gateway 之filter篇](https://blog.csdn.net/forezp/article/details/85057268)

gateway-filter-s1

*  [Spring Cloud Gateway 之限流篇](https://blog.csdn.net/forezp/article/details/85081162)

gateway-limiter-s1

*  [spring cloud gateway之服务注册与发现](https://blog.csdn.net/forezp/article/details/85210153)

eureka-server-s1:8761

service-hi-s1:8762

service-gateway-s1:8081

# 源码篇：

* [深入理解Feign之源码解析](http://blog.csdn.net/forezp/article/details/73480304)
* [深入理解Eureka之源码解析](http://blog.csdn.net/forezp/article/details/73017664)
* [深入理解Ribbon之源码解析](http://blog.csdn.net/forezp/article/details/74820899)
*  [ 深入理解Hystrix之文档翻译](http://blog.csdn.net/forezp/article/details/75333088)
* [深入理解Zuul之源码解析](http://blog.csdn.net/forezp/article/details/76211680)

# 进阶篇

* [ Spring Cloud Sleuth超详细实战](http://blog.csdn.net/forezp/article/details/76795269)
* [拜托！面试请不要再问我Spring Cloud底层原理](https://blog.csdn.net/forezp/article/details/83999882)
*  [微服务注册中心如何承载大型系统的千万级访问？](https://blog.csdn.net/forezp/article/details/83999947)
*  [每秒上万并发下的Spring Cloud参数优化实战](https://blog.csdn.net/forezp/article/details/83999975)



