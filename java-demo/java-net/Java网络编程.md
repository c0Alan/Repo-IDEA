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

2. 安装ipv6支持

   ```bash
   netsh interface ipv6 install
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

​	在使用DNS缓存时有两点需要注意：

1. 可以根据实际情况来设置networkaddress.cache.ttl属性的值。一般将这个属性的值设为-1。
  但如果访问的是动态映射的域名（如使用动态域名服务将域名映射成ADSL的动态IP）, 
  就可能产生IP地址变化后，客户端得到的还是原来的IP地址的情况。

2. 在设置networkaddress.cache.negative.ttl属性值时最好不要将它设为-1，
  否则如果一个域名因为暂时的故障而无法访问，那么程序再次访问这个域名时，
  即使这个域名恢复正常，程序也无法再访问这个域名了。除非重新运行程序。

  

## 地址类型

**一、isAnyLocalAddress方法**

​    当IP地址是通配符地址时返回true，否则返回false。这个通配符地址对于拥有多个网络接口（如两块网卡）的计算机非常拥有。使用通配符地址可以允许在服务器主机接受来自任何网络接口的客户端连接。IPv4的通配符地址是0.0.0.0。IPv6的通配符地址是0:0:0:0:0:0:0:0，也可以简写成::。

**二、isLoopbackAddress方法**

当IP地址是loopback地址时返回true，否则返回false。loopback地址就是代表本机的IP地址。IPv4的loopback地址的范围是127.0.0.0 ~ 127.255.255.255，也就是说，只要第一个字节是127，就是lookback地址。如127.1.2.3、127.0.200.200都是loopback地址。IPv6的loopback地址是0:0:0:0:0:0:0:1，也可以简写成::1。我们可以使用ping命令来测试lookback地址。

虽然127.255.255.255也是loopback地址，但127.255.255.255在Windows下是无法ping通的。这是因为127.255.255.255是广播地址，在Windows下对发给广播地址的请求不做任何响应，而在其他操作系统上根据设置的不同，可能会得到不同的结果。

**三、isLinkLocalAddress方法** 

当IP地址是本地连接地址(LinkLocalAddress)时返回true，否则返回false。IPv4的本地连接地址的范围是169.254.0.0 ~ 169.254.255.255。IPv6的本地连接地址的前12位是FE8，其他的位可以是任意取值，如FE88::、FE80::ABCD::都是本地连接地址。

**四、isSiteLocalAddress方法**

当IP地址是地区本地地址（SiteLocalAddress）时返回true，否则返回false。IPv4的地址本地地址分为三段：10.0.0.0 ~ 10.255.255.255、172.16.0.0 ~ 172.31.255.255、192.168.0.0 ~ 192.168.255.255。IPv6的地区本地地址的前12位是FEC，其他的位可以是任意取值，如FED0::、FEF1::都是地区本地地址。

**五、isMulticastAddress方法**         

当IP地址是广播地址（MulticastAddress）时返回true，否则返回false。通过广播地址可以向网络中的所有计算机发送信息，而不是只向一台特定的计算机发送信息。IPv4的广播地址的范围是224.0.0.0 ~ 239.255.255.255。IPv6的广播地址第一个字节是FF，其他的字节可以是任意值。关于广播地址的详细内容将在以后的章节中讨论。

**六、isMCGlobal方法**

​    当IP地址是全球范围的广播地址时返回true，否则返回false。全球范围的广播地址可以向Internet中的所有的计算机发送信息。IPv4的广播地址除了224.0.0.0和第一个字节是239的IP地址都是全球范围的广播地址。IPv6的全球范围的广播地址中第一个字节是FF，第二个字节的范围是0E ~ FE，其他的字节可以是任意值，如FFBE::、FF0E::都是全球范围的广播地址。

**七、isMCLinkLocal方法**

​    当IP地址是子网广播地址时返回true，否则返回false。使用子网的广播地址只能向子网内的计算机发送信息。IPv4的子网广播地址的范围是224.0.0.0 ~ 224.0.0.255。IPv6的子网广播地址的第一个字节是FF，第二个字节的范围是02 ~ F2，其他的字节可以是任意值，如FFB2::、FF02:ABCD::都是子网广播地址。 

**八、isMCNodeLocal方法**

当IP地址是本地接口广播地址时返回true，否则返回false。本地接口广播地址不能将广播信息发送到产生广播信息的网络接口，即使是同一台计算机的另一个网络接口也不行。所有的IPv4广播地址都不是本地接口广播地址。IPv6的本地接口广播地址的第一个字节是FF，第二个节字的范围是01 ~ F1，其他的字节可以是任意值，如FFB1::、FF01:A123::都是本地接口广播地址。

**九、isMCOrgLocal方法** 

当IP地址是组织范围的广播地址时返回ture，否则返回false。使用组织范围广播地址可以向公司或企业内部的所有的计算机发送广播信息。IPv4的组织范围广播地址的第一个字节是239，第二个字节不小于192，第三个字节不大于195，如239.193.100.200、239.192.195.0都是组织范围广播地址。IPv6的组织范围广播地址的第一个字节是FF，第二个字节的范围是08 ~ F8，其他的字节可以是任意值，如FF08::、FF48::都是组织范围的广播地址。

**十、isMCSiteLocal方法**

当IP地址是站点范围的广播地址时返回true，否则返回false。使用站点范围的广播地址，可以向站点范围内的计算机发送广播信息。IPv4的站点范围广播地址的范围是239.255.0.0 ~ 239.255.255.255，如239.255.1.1、239.255.0.0都是站点范围的广播地址。IPv6的站点范围广播地址的第一个字节是FF，第二个字节的范围是05 ~ F5，其他的字节可以是任意值，如FF05::、FF45::都是站点范围的广播地址。

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