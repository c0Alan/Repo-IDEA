# 基本网络概念

网络

网络的分层

主机网络层/应用层

网际层/网络层

传输层

应用层

IP、TCP和UDP

IP 地址 和 域名

端口

Internet

Internet 地址分块

## 网络地址转换

NAT

防火墙

代理服务器

客户／服务器模型

Internet标准

IETF RFC

W3C 推荐

# 流

输出流
输入流
过滤器流

数据流

阅读器和书写器

# 线程

运行线程
从线程返回信息
同步
死锁
线程调度
线程池干DExecutor

# Internet地址



## 常用命令

1. 通过 ping 获取 ip 地址

   ```bash
   ping www.baidu.com
   ```

InetAddress类
Inet4Address和Inet6Address
NetworkInterface类
一些有用的程序

## 地址分类

A类IP地址
范围：0.0.0.0 –– 127.255.255.255，标准的子网掩码是255.0.0.0
B类IP地址
范围：128.0.0.0 –– 191.255.255.255，标准的子网掩码是255.255.0.0
C类IP地址
范围：192.0.0.0 –– 223.255.255.255，标准的子网掩码是255.255.255.0

## 域名

顶层域名
顶层域名可分为类型顶层域名和地域顶层域名。如www.microsoft.com、www.w3c.org中的com和org就是类型顶层域名，它们分别代表商业(com)和非盈利组织(org)。而www.dearbook.com.cn中的cn就是地域顶层域名，它表示了中国(cn)。主要的类型顶层域名有com(商业)、edu(教育)、gov(政府)、int(国际组织)、mil(美国军方)、net（网络部门）、org(非盈利组织)。大多数国家都有自己的地域顶层域名，如中国(cn)、美国(us)、英国(uk)等。
顶级域名
如www.microsoft.com中的microsoft.com就是一个顶级域名。在Email地址的“@”后面跟的都是顶级域名，如abc@126.com、mymail@sina.com等。
二级域名
如blog.csdn.net就是顶级域名csdn.net的二级域名。有很多人认为www.csdn.net是顶级域名，其实这是一种误解。实际上www.csdn.net是顶级域名csdn.net的二级域名。www.csdn.net和blog.csdn.net在本质上是一样的，只是我们已经习惯了使用www表示一个使用HTTP或HTTPS协议的网址，因此，给人的误解就是www.csdn.net是一个顶级域名。
三级域名
如abc.photo.163.com就是二级域名photo.163.com的三级域名。有很多blog或电子相册之类的网站都为每个用户分配一个三级域名。

## DNS 缓存

​	在通过DNS查找域名的过程中，可能会经过多台中间DNS服务器才能找到指定的域名，因此，在DNS服务器上查找域名是非常昂贵的操作。在Java中为了缓解这个问题，提供了DNS缓存。当InetAddress类第一次使用某个域名（如www.csdn.net）创建InetAddress对象后，JVM就会将这个域名和它从DNS上获得的信息（如IP地址）都保存在DNS缓存中。当下一次InetAddress类再使用这个域名时，就直接从DNS缓存里获得所需的信息，而无需再访问DNS服务器。 

# URL和URI

URI
URL类
URI类
X—WWW—form—urlencoded
代理
通过GET与服务器端程序通信
访问口令保护的网站

# HTTP

HTTP协议
HTTP方法
请求主体
Cookie

# URLConnection

打开URLConnecUon
读取服务器的数据
读取首部
缓存
配置连接
配置客户端请求HTTP首部
向服务器写入数据
uRLConnection的安全考虑
猜测MIME媒体类型
HttDURLConnection

# 客户端Socket

使用Socket
用Telnet研究协议
构造和连接Socket
设置Socket选项
Socket异常
GUl应用中的Socket

# 服务器Socket

使用ServerSocket
日志
构造服务器Socket
获得服务器Socket的有关信息
Socket选项
HTTP月E务器

# 安全Socket

保护通信
创建安全客户端Sl3cket.
选择密码组
事件处理器
会话管理
客户端模式
创建安全服务器Socket
配置SSLServerSocket

# 非阻塞I／O

一个示例客户端
一个示例服务器
缓冲区
通道
就绪选择

# UDP

UDP协议
UDP客户端
UDP服务器
DatagramPacket类
DatagramSocket类
一些有用的应用程序
DatagramChannel

# IP组播

组播
使用组播Socket
两个简单示例