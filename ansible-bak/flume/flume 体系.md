# 安装配置

​	大数据的业务处理中，数据采集占据重要的地位，而在互联网中大量数据产生的来源之一便是网络日志。flume是分布式的日志收集系统，它将各个服务器中的数据收集起来并送到指定的地方去，可以是文件、可以是hdfs。有关flume架构更加详细的介绍大家可以参考 [安静的技术控 Flume架构以及应用介绍](http://blog.csdn.net/a2011480169/article/details/51544664) 

## 安装

```bash
# 添加 Flume
tar -zxvf apache-flume-1.8.0-bin.tar.gz 
mv apache-flume-1.8.0 /usr/share/flume 
mv apache-flume-1.8.0 /usr/share/flume 

# 配置flume环境变量 
vi /etc/profile
export FLUME_HOME=/opt/flume/apache-flume-1.8.0-bin
export PATH=$PATH:$FLUME_HOME/bin

# 使环境变量生效
source /etc/profile 

flume-ng version

```

## 启动

```bash
bin/flume-ng agent -c conf -f conf/kafka-flume-mppdb-conf.properties -n a1 -Dflume.root.logger=INFO,console
```

## 启动参数

```bash
+ exec /opt/java/jdk1.8.0_151/bin/java -Xmx20m -Dflume.root.logger=INFO,console -cp '/opt/flume/apache-flume-1.8.0-bin/conf:/opt/flume/apache-flume-1.8.0-bin/lib/*:/lib/*' -Djava.library.path= org.apache.flume.node.Application -f conf/kafka-flume-mppdb-conf.properties -n a1
```



## NetCat Source

案例一： NetCat Source：监听一个指定的网络端口，即只要应用程序向这个端口里面写数据，这个source组件就可以获取到信息。

```bash
flume官网中NetCat Source描述：

Property Name Default     Description
channels       –     
type           –     The component type name, needs to be netcat
bind           –  日志需要发送到的主机名或者Ip地址，该主机运行着netcat类型的source在监听          
port           –  日志需要发送到的端口号，该端口号要有netcat类型的source在监听   1234567
```

配置文件 netcat.conf ：

```bash
# 指定Agent的组件名称（a），一个进程
a.sources=r1
a.channels=c1
a.sinks=k1

a.sources.r1.type=netcat
a.sources.r1.bind=master
a.sources.r1.port=8888
a.sources.r1.channels=c1

a.channels.c1.type=memory
a.channels.c1.capacity=1000
a.channels.c1.transactionCapacity=1000

a.sinks.k1.channel=c1
a.sinks.k1.type=logger
```

启动flume agent a 服务端：

```bash
flume-ng agent -n a1 -c ../conf -f ../conf/netcat.conf -Dflume.root.logger=DEBUG,console
flume-ng agent -c ../conf -f ../conf/flume-conf.properties -n a1 -Dflume.root.logger=INFO,console
kafka-flume-mppdb-conf.properties

flume-ng agent -c ../conf -f ../conf/kafka-flume-mppdb-conf.properties -n a1 -Dflume.root.logger=INFO,console

#-Dflume.root.logger=DEBUG,console 设置控制台打印

#telnet master 8888 2334/hello/1232
```


# 拦截器



# Event

# Source

## RPC Source

## Avro Source

## Avro Sink

## Thrift Source



# 	Channel

Channel 选择器

# Sink

Sink处理器

Sink组







# Flume：构建高可用、可扩展的海量日志采集系统目录
源码地址: https://github.com/harishreedharan/usingflumecode
第1 章 认识Apache Hadoop 和Apache HBase
分布式文件系统HDFS
HDFS 的数据格式
处理HDFS 中的数据
Apache HBase
总结
参考文献
第2 章 用Apache Flume 处理流数据
我们需要Flume
Flume 是否适合呢？
Flume Agent 内部原理
配置Flume Agent
Flume Agent 之间的相互通信
复杂的流
复制数据到不同目的地
动态路由
Flume 的无数据丢失保证，Channel 和事务
Flume Channel 中的事务
Agent 失败和数据丢失
批量的重要性
重复怎么样？
运行Flume Agent
总结
参考文献
第3 章 源（Source）
Source 的生命周期
Sink-to-Source 通信
Avro Source
Thrift Source
RPC Sources 的失败处理
HTTP Source
针对HTTP Source 写处理程序*
Spooling Directory Source
使用Deserializers 读取自定义格式*
Spooling Directory Source 性能
Syslog Source
Exec Source
JMS Source
转换JMS 消息为Flume 事件*
编写自定义Source*
Event-Driven Source 和Pollable Source
总结
参考文献
第4 章 Channel
事务工作流
Flume 自带的Channel
Memory Channel
File Channel
总结
参考文献
第5 章 Sink
Sink 的生命周期
优化Sink 的性能
写入到HDFS ：HDFS Sink
理解Bucket
配置HDFS Sink
使用序列化器控制数据格式*
HBase Sink
用序列化器将Flume 事件转换成HBase Put 和Increment*
RPC Sink
Avro Sink
Thrift Sink
Morphline Solr Sink
Elastic Search Sink
自定义数据格式*
其他Sink ：Null Sink、Rolling File Sink 和Logger Sink
编写自定义Sink*
总结
参考文献
第6 章 拦截器、Channel 选择器、Sink 组和
Sink 处理器
拦截器
时间戳拦截器
主机拦截器
静态拦截器
正则过滤拦截器
Morphline 拦截器
UUID 拦截器
编写拦截器*
Channel 选择器
复制Channel 选择器
多路复用Channel 选择器
自定义Channel 选择器*
Sink 组和Sink 处理器
Load-Balancing Sink 处理器
Failover Sink 处理器
总结
参考文献
第7 章 发送数据到Flume*
构建Flume 事件
Flume 客户端SDK
创建Flume RPC 客户端
RPC 客户端接口
所有RPC 客户端的公共配置参数
默认RPC 客户端
Load-Balancing RPC 客户端
Failover RPC 客户端
Thrift RPC 客户端
嵌入式Agent
配置嵌入式Agent
log4j Appender
Load-Balancing log4j Appender
总结
参考文献
第8 章 规划、部署和监控Flume
规划一个Flume 部署
修复时间
我的Flume Channel 需要多少容量？
多少层？
通过跨数据中心链接发送数据
层分片
部署Flume
部署自定义代码
监控Flume
从自定义组件报告度量