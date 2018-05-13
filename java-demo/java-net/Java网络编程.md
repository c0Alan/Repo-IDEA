# 常用命令

1. 通过 ping 获取 ip 地址

   ```bash
   ping www.baidu.com
   ```

2. 安装ipv6支持

   ```bash
   netsh interface ipv6 install
   ```

3. 查看本机端口使用情况

```bash
netstat -a -n | grep "LIST" # linux 
netstat -an | findstr 62018 # windows
```



# 基本网络概念

## 网络

## 网络的分层

## 主机网络层/应用层

## 网际层/网络层

## 传输层

## 应用层

## IP、TCP和UDP

## IP 地址 和 域名

## Internet

## Internet 地址分块

## 网络地址转换

## NAT

## 子网掩码

## 网关

## 端口

## 代理服务器

## 代理及端口映射 

## 防火墙

## 客户／服务器模型

## Internet标准

## IETF RFC

## W3C 推荐

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



1. 

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

# Socket

## 客户端Socket

使用Socket
用Telnet研究协议
构造和连接Socket
设置Socket选项
Socket异常
GUl应用中的Socket

### 一、连接服务器

在客户端可以通过两种方式来连接服务器，一种是通过IP的方式来连接服务器，而另外一种是通过域名方式来连接服务器。

### 二、发送和接收数据

在Socket类中最重要的两个方法就是getInputStream和getOutputStream。
这两个方法分别用来得到用于读取和写入数据的InputStream和OutputStream对象。
在这里的InputStream读取的是服务器程序向客户端发送过来的数据，
而OutputStream是客户端要向服务端程序发送的数据。
在编写实际的网络客户端程序时，是使用getInputStream，还是使用getOutputStream，
以及先使用谁后使用谁由具体的应用决定。
如通过连接邮电出版社网站(www.ptpress.com.cn)的80端口（一般为HTTP协议所使用的默认端口），
并且发送一个字符串，最后再读取从www.ptpress.com.cn返回的信息。
要注意如下两点：

1. 为了提高数据传输的效率，Socket类并没有在每次调用write方法后都进行数据传输，
   而是将这些要传输的数据写到一个缓冲区里（默认是8192个字节），
   然后通过flush方法将这个缓冲区里的数据一起发送出去，因此，bw.flush();是必须的。
2. 在发送字符串时之所以在Hello World后加上 “\r\n\r\n”，
   这是因为HTTP协议头是以“\r\n\r\n”作为结束标志（HTTP协议的详细内容将在以后讲解），
   因此，通过在发送字符串后加入“\r\n\r\n”，可以使服务端程序认为HTTP头已经结束，可以处理了。
   如果不加“\r\n\r\n”，那么服务端程序将一直等待HTTP头的结束，也就是“\r\n\r\n”。如果是这样，
   服务端程序就不会向客户端发送响应信息，而br.readLine()将因无法读以响应信息面被阻塞，直到连接超时。

### 三、关闭网络连接

到现在为止，我们对Socket类的基本使用方法已经有了初步的了解，但在Socket类处理完数据后，
最合理的收尾方法是使用Socket类的close方法关闭网络连接。虽然在中已经使用了close方法，
但使网络连接关闭的方法不仅仅只有close方法，下面就让我们看看Java在什么情况下可以使网络连接关闭。
可以引起网络连接关闭的情况有以下4种：

1. 直接调用Socket类的close方法。
2. 只要Socket类的InputStream和OutputStream有一个关闭，
   网络连接自动关闭（必须通过调用InputStream和OutputStream的close方法关闭流，才能使网络可爱接自动关闭）。
3. 在程序退出时网络连接自动关闭。
4. 将Socket对象设为null或未关闭最使用new Socket(…)建立新对象后，
   由JVM的垃圾回收器回收为Socket对象分配的内存空间后自动关闭网络连接。   
   虽然这4种方法都可以达到同样的目的，但一个健壮的网络程序最好使用第1种或第2种方法关闭网络连接。
   这是因为第3种和第4种方法一般并不会马上关闭网络连接，如果是这样的话，对于某些应用程序，
   将会遗留大量无用的网络连接，这些网络连接会占用大量的系统资源。
   在Socket对象被关闭后，我们可以通过isClosed方法来判断某个Socket对象是否处于关闭状态。
   然而使用isClosed方法所返回的只是Socket对象的当前状态，也就是说，不管Socket对象是否曾经连接成功过，
   只要处于关闭状态，isClosed就返回true。如果只是建立一个未连接的Socket对象，isClose则会返回false。

```java
Socket socket = new Socket();
System.out.println(socket.isClosed());
```

​	除了isClose方法，Socket类还有一个isConnected方法来判断Socket对象是否连接成功。
看到这个名字，也许读者会产生误解。其实isConnected方法所判断的并不是Socket对象的当前连接状态，
而是Socket对象是否曾经连接成功过，如果成功连接过，即使现在isClose返回true，isConnected仍然返回true。
因此，要判断当前的Socket对象是否处于连接状态，必须同时使用isClose和isConnected方法，
即只有当isClose返回false，isConnected返回true的时候Socket对象才处于连接状态。

​	虽然在大多数的时候可以直接使用Socket类或输入输出流的close方法关闭网络连接，
但有时我们只希望关闭OutputStream或InputStream，而在关闭输入输出流的同时，并不关闭网络连接。
这就需要用到Socket类的另外两个方法：shutdownInput和shutdownOutput，这两个方法只关闭相应的输入、输出流，
而它们并没有同时关闭网络连接的功能。和isClosed、isConnected方法一样，
Socket类也提供了两个方法来判断Socket对象的输入、输出流是否被关闭，
这两个方法是isInputShutdown()和isOutputShutdown()。

## 服务器Socket

使用ServerSocket
日志
构造服务器Socket
获得服务器Socket的有关信息
Socket选项
HTTP月E务器

### 创建

#### 一、通过构造方法绑定端口

#### 二、设置请求队列的长度

#### 三、绑定IP地址

在有多个网络接口或多个IP地址的计算机上可以使用如下的构造方法将服务端绑定在某一个IP地址上：

public ServerSocket(int port, int backlog, InetAddress bindAddr) throws IOException
bindAddr参数就是要绑定的IP地址。如果将服务端绑定到某一个IP地址上，就只有可以访问这个IP地址的客户端才能连接到服务器上。如一台机器上有两块网卡，一块网卡连接内网，另一块连接外网。如果用Java实现一个Email服务器，并且只想让内网的用户使用它。就可以使用这个构造方法将ServerSocket对象绑定到连接内网的IP地址上。这样外网就无法访问Email服务器了。可以使用如下代码来绑定IP地址：

```java
ServerSocket serverSocket = new
ServerSocket(1234, 0, InetAddress.getByName("192.168.18.10"));
```

​    上面的代码将IP地址绑定到了192.168.18.10上，因此，服务端程序只能使用绑定了这个IP地址的网络接口进行通讯。

#### 四、默认构造方法的使用

除了使用ServerSocket类的构造方法绑定端口外，还可以用ServerSocket的bind方法来完成构造方法所做的工作。要想使用bind方法，必须得用ServerSocket类的默认构造方法(没有参数的构造方法)来创建ServerSocket对象。bind方法有两个重载形式，它们的定义如下： 

```java
public void bind(SocketAddress endpoint) throws IOException
public void bind(SocketAddress endpoint, int backlog) throws IOException 
```



 bind方法不仅可以绑定端口，也可以设置请求队列的长度以及绑定IP地址。bind方法的作用是为了在建立ServerSocket对象后设置ServerSocket类的一些选项。而这些选项必须在绑定端口之前设置，一但绑定了端口后，再设置这些选项将不再起作用。下面的代码演示了bind方法的使用及如何设置ServerSocket类的选项。 

```java
ServerSocket serverSocket1 = new ServerSocket();
serverSocket1.setReuseAddress(true);
serverSocket1.bind(new InetSocketAddress(1234));
ServerSocket serverSocket2 = new ServerSocket();
serverSocket2.setReuseAddress(true);
serverSocket2.bind(new InetSocketAddress("192.168.18.10", 1234));
ServerSocket serverSocket3 = new ServerSocket();
serverSocket3.setReuseAddress(true);
serverSocket3.bind(new InetSocketAddress("192.168.18.10", 1234), 30);       

```

在上面的代码中设置了SO_REUSEADDR 选项（这个选项将在后面的文章中详细讨论）。如果使用下面的代码，这个选项将不起作用。

```java
ServerSocket serverSocket3 = new ServerSocket(1234);
serverSocket3.setReuseAddress(true);
```

在第6行绑定了IP地址和端口。使用构造方法是无法得到这个组合的（想绑定IP地址，必须得设置backlog参数），因此，bind方法比构造方法更灵活。

### 关闭

​	在客户端和服务端的数据交互完成后，一般需要关闭网络连接。对于服务端来说，需要关闭Socket和ServerSocket。

在关闭Socket后，客户端并不会马上感知自已的Socket已经关闭，也就是说，在服务端的Socket关闭后，客户端的Socket的isClosed和isConnected方法仍然会分别得到false和true。但对已关闭的Socket的输入输出流进行操作会抛出一个SocketException异常。
在关闭服务端的ServerSocket后，ServerSocket对象所绑定的端口被释放。这时客户端将无法连接服务端程序。

### 选项

ServerSocket类有以下三个选项：

1. SO_TIMEOUT： 设置accept方法的超时时间。

2. SO_REUSEADDR：设置服务端同一个端口是否可以多次绑定。

3. SO_RECBUF：设置接收缓冲区的大小。

4. 设置ServerSocket的性能偏好

   ```java
   public void setPerformancePreferences(int connectionTime, int latency, int bandwidth);
   ```

   

## 安全Socket

保护通信
创建安全客户端Sl3cket.
选择密码组
事件处理器
会话管理
客户端模式
创建安全服务器Socket
配置SSLServerSocket





## 网络地址的重用

所谓网络地址的重用表现在两个方面：

1. 通过建立一个SocketAddress对象，可以在多次连接同一个服务器时使用这个SocketAddress对象。
2. 在Socket类中提供了两个方法：getRemoteSocketAddress和getLocalSocketAddress，
  通过这两个方法可以得到服务器和本机的网络地址。而且所得到的网络地址在相应的Socket对象关闭后任然可以使用。

## Nagle算法

​	在默认情况下，客户端向服务器发送数据时，会根据数据包的大小决定是否立即发送。
当数据包中的数据很少时，如只有1个字节，而数据包的头却有几十个字节（IP头+TCP头）时，
系统会在发送之前先将较小的包合并到软大的包后，一起将数据发送出去。在发送下一个数据包时，
系统会等待服务器对前一个数据包的响应，当收到服务器的响应后，再发送下一个数据包，这就是所谓的Nagle算法；
在默认情况下，Nagle算法是开启的。

## 异常

public class IOException extends Exception
   这个异常是所有在Socket类的方法中抛出的异常的父类。因此，在使用Socket类时只要捕捉(catch)这个异常就可以了；当然，为了同时捕捉其它类中的方法的异常，也可以直接捕捉Exception。

public class SocketException extends IOException
   这个异常在Socket类的方法中使用得最频繁。它也代表了所有和网络有关的异常。但如果要想知道具体发生的哪一类的异常，就需要捕捉更具体的异常了。

public class ConnectException extends SocketException
    ConnectException异常通常发生在由于服务器忙而未响应或是服务器相应的监听端口未打开。如下面的语句将抛出一个ConnectException异常。

```java
Socket socket = new Socket("www.ptpress.com.cn", 1234);
```

public class BindException extends SocketException
   这个异常在多个Socket或ServerSocket对象绑定在同一个端口，而且未打开SO_REUSEADDR选项时发生。如下面的四条语句将抛出一个BindException异常：

```java
Socket socket1 = new Socket();

Socket socket2 = new Socket();

socket1.bind(new InetSocketAddress("127.0.0.1", 1234));

socket2.bind(new InetSocketAddress("127.0.0.1", 1234));

```

public class NoRouteToHostException extends SocketException
    这个异常在遇到防火墙或是路由无法找到主机的情况下发生。

public class UnknownHostException extends IOException
    这个异常在域名不正确时被抛出。如下面的语句将抛出一个UnKnownHostException异常：

```java
Socket socket1 = new Socket("www.ptpress123.com.cn", 80);
```

public class ProtocolException extends IOException
   这个异常并不经常被抛出。由于不明的原因，TCP/IP的数据包被破坏了，这时将抛出ProtocolException异常。

public class SocketTimeoutException extends InterruptedIOException
   如果在连接超时和读取数据超时时间过后，服务器仍然未响应，connect或read方法将抛出SocketTimeoutException异常。

## 端口

​	ServerSocket  在操作系统中规定1 ~ 1023为系统使用的端口号。端口号的最小值是1，最大值是65535。
在Windows中用户编写的程序可以绑定端口号小于1024的端口，
但在Linux/Unix下必须使用root登录才可以绑定小于1024的端口。

## flush 



# 非阻塞I／O

一个示例客户端
一个示例服务器
缓冲区
通道
就绪选择

## 概念

​	对于客户端来说，有两个地方可能会被阻塞：连接服务器（调用connect方法时）和读写数据。而在服务端也有两个地方可能会被阻塞：等待客户端请求（调用accept方法时）和读写数据（在一般情况下，写数据不会被阻塞，但如果网络环境比较差的时候，客户端和服务端的写数据操作也可能发生阻塞现象）。也就是说，可以设置超时时间的地方就可能被阻塞。而同步I/O中的同步就是指除了以下两种情况外程序会一直处于等待状态：

1. 连接服务器、读写数据或等待客户端请求正常地执行。
2. 在等待超时时间后，抛出了超时异常。

## 缓冲区

如果将同步I/O方式下的数据传输比做数据传输的零星方式（这里的零星是指在数据传输的过程中是以零星的字节方式进行的），那么就可以将非阻塞I/O方式下的数据传输比做数据传输的集装箱方式（在字节和低层数据传输之间，多了一层缓冲区，因此，可以将缓冲区看做是装载字节的集装箱）。大家可以想象，如果我们要运送比较少的货物，用集装箱好象有点不太合算，而如果要运送上百吨的货物，用集装箱来运送的成本会更低。在数据传输过程中也是一样，如果数据量很小时，使用同步I/O方式会更适合，如果数据量很大时（一般以G为单位），使用非阻塞I/O方式的效率会更高。因此，从理论上说，数据量越大，使用非阻塞I/O方式的单位成本就会越低。产生这种结果的原因和缓冲区的一些特性有着直接的关系。在本节中，将对缓冲区的一些主要特性进行讲解，使读者可以充分理解缓冲区的概念，并能通过缓冲区来提高程序的执行效率。

创建缓冲区

Java提供了七个基本的缓冲区，分别由七个类来管理，它们都可以在java.nio包中找到。这七个类如下所示：

ByteBuffer  

ShortBuffer
IntBuffer
CharBuffer
FloatBuffer
DoubleBuffer
LongBuffer
这七个类中的方法类似，只是它们的返回值或参数和相应的简单类型相对应，如ByteBuffer类的get方法返回了byte类型的数据，而put方法需要一个byte类型的参数。在CharBuffer类中的get和put方法返回和传递的数据类型就是char。这七个类都没有public构造方法，因此，它们不能通过new来创建相应的对象实例。这些类都可以通过两种方式来创建相应的对象实例。

1.通过静态方法allocate来创建缓冲区。

这七类都有一个静态的allocate方法，通过这个方法可以创建有最大容量限制的缓冲区对象。allocate的定义如下：

ByteBuffer类中的allocate方法：

public static ByteBuffer allocate(int capacity) 
IntBuffer类中的allocate方法：

public static IntBuffer allocate(int capacity) 
其他五个缓冲区类中的allocate 方法定义和上面的定义类似，只是返回值的类型是相应的缓冲区类。

allocate方法有一个参数capacity，用来指定缓冲区容量的最大值。capacity的不能小于0，否则会抛出一个IllegalArgumentException异常。使用allocate来创建缓冲区，并不是一下子就分配给缓冲区capacity大小的空间，而是根据缓冲区中存储数据的情况来动态分配缓冲区的大小（实际上，在低层Java采用了数据结构中的堆来管理缓冲区的大小），因此，这个capacity可以是一个很大的值，如1024*1024（1M）。allocate的使用方法如下：

ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
IntBuffer intBuffer = IntBuffer.allocate(1024); 
    在使用allocate创建缓冲区时应用注意，capacity的含义随着缓冲区的不同而不同。如创建字节缓冲区时，capacity指的是字节数。而在创建整型(int)缓冲区时，capacity指的是int型值的数目，如果转换成字数，capacity的值应该乘4。如上面代码中的intBuffer缓冲区最大可容纳的字节数是1024*4 = 4096个。

2.通过静态方法wrap来创建缓冲区。

使用allocate方法可以创建一个空的缓冲区。而wrap方法可以利用已经存在的数据来创建缓冲区。wrap方法可以将数组直接转换成相应类型的缓冲区。wrap方法有两种重载形式，它们的定义如下：

ByteBuffer类中的wrap方法：

public static ByteBuffer wrap(byte[] array)
public static ByteBuffer wrap(byte[] array, int offset, int length)
IntBuffer类中的wrap方法：

public static IntBuffer wrap(byte[] array)
public static IntBuffer wrap(byte[] array, int offset, int length)
其他五个缓冲区类中的wrap 方法定义和上面的定义类似，只是返回值的类型是相应的缓冲区类。

在wrap方法中的array参数是要转换的数组（如果是其他的缓冲区类，数组的类型就是相应的简单类型，如IntBuffer类中的wrap方法的array就是int[]类型）。offset是要转换的子数组的偏移量，也就是子数组在array中的开始索引。length是要转换的子数组的长度。利用后两个参数可以将array数组中的一部分转换成缓冲区对象。它们的使用方法如下：

```java
byte[] myByte = new byte[] { 1, 2, 3 };
int[] myInt = new int[] { 1, 2, 3, 4 };
ByteBuffer byteBuffer = ByteBuffer.wrap(myByte);
IntBuffer intBuffer = IntBuffer.wrap(myInt, 1, 2);
```

可以通过缓冲区类的capacity方法来得到缓冲区的大小。capacity方法的定义如下：

public final int capacity()
如果使用allocate方法来创建缓冲区，capacity方法的返回值就是capacity参数的值。而使用wrap方法来创建缓冲区，capacity方法的返回值是array数组的长度，但要注意，使用wrap来转换array的字数组时，capacity的长度仍然是原数组的长度，如上面代码中的intBuffer缓冲区的capacity值是4，而不是2。

除了可以将数组转换成缓冲区外，也可以通过缓冲区类的array方法将缓冲区转换成相应类型的数组。IntBuffer类的array方法的定义方法如下（其他缓冲区类的array的定义类似）：

public final int[] array()
    下面的代码演示了如何使用array方法将缓冲区转换成相应类型的数组。

```java
int[] myInt = new int[] { 1, 2, 3, 4, 5, 6 };
IntBuffer intBuffer = IntBuffer.wrap(myInt, 1, 3);
for (int v : intBuffer.array())
    System.out.print(v + " ");
```

在执行上面代码后，我们发现输出的结果是1 2 3 4 5 6，而不是2 3 4。这说明在将子数组转换成缓冲区的过程中实际上是将整个数组转换成了缓冲区，这就是用wrap包装子数组后，capacity的值仍然是原数组长度的真正原因。在使用array方法时应注意，在以下两种缓冲区中不能使用array方法：

只读的缓冲区
如果使用只读缓冲区的array方法，将会抛出一个ReadOnlyBufferException异常。

使用allocateDirect方法创建的缓冲区。
如果调用这种缓冲区中的array方法，将会抛出一个UnsupportedOperationException异常。

可以通过缓冲区类的hasArray方法来判断这个缓冲区是否可以使用array方法，如果返回true，则说明这个缓冲区可以使用array方法，否则，使用array方法将会抛出上述的两种异常之一。

注意： 使用array方法返回的数组并不是缓冲区数据的副本。被返回的数组实际上就是缓冲区中的数据，也就是说，array方法只返回了缓冲区数据的引用。当数组中的数据被修改后，缓冲区中的数据也会被修改，返之也是如此。关于这方面内容将在下一节“读写缓冲区中的数据”中详细讲解。
在上述的七个缓冲区类中，ByteBuffer类和CharBuffer类各自还有另外一种方法来创建缓冲区对象。

l ByteBuffer类

可以通过ByteBuffer类的allocateDirect方法来创建ByteBuffer对象。allocateDirect方法的定义如下：

public static ByteBuffer allocateDirect(int capacity) 
使用allocateDirect方法可以一次性分配capacity大小的连续字节空间。通过allocateDirect方法来创建具有连续空间的ByteBuffer对象虽然可以在一定程度上提高效率，但这种方式并不是平台独立的。也就是说，在一些操作系统平台上使用allocateDirect方法来创建ByteBuffer对象会使效率大幅度提高，而在另一些操作系统平台上，性能会表现得非常差。而且allocateDirect方法需要较长的时间来分配内存空间，在释放空间时也较慢。因此，在使用allocateDirect方法时应谨慎。

通过isDirect方法可以判断缓冲区对象（其他的缓冲区类也有isDirect方法，因为，ByteBuffer对象可以转换成其他的缓冲区对象，这部分内容将在后面讲解）是用哪种方式创建的，如果isDirect方法返回true，则这个缓冲区对象是用allocateDirect方法创建的，否则，就是用其他方法创建的缓冲区对象。

l CharBuffer类

我们可以发现，上述的七种缓冲区中并没有字符串缓冲区，而字符串在程序中却是最常用的一种数据类型。不过不要担心，虽然java.nio包中并未提供字符串缓冲区，但却可以将字符串转换成字符缓冲区（就是CharBuffer对象）。在CharBuffer类中的wrap方法除了上述的两种重载形式外，又多了两种重载形式，它们的定义如下：

public static CharBuffer wrap(CharSequence csq)
public static CharBuffer wrap(CharSequence csq, int start, int end)
其中csq参数表示要转换的字符串，但我们注意到csq的类型并不是String，而是CharSequence。CharSequence类Java中四个可以表示字符串的类的父类，这四个类是String、StringBuffer、StringBuilder和CharBuffer（大家要注意，StringBuffer和本节讲的缓冲区类一点关系都没有，这个类在java.lang包中）。也就是说，CharBuffer类的wrap方法可以将这四个类的对象转换成CharBuffer对象。

另外两个参数start和end分别是子字符串的开始索引和结束索引的下一个位置，如将字符串"1234"中的"23" 转换成CharBuffer对象的语句如下：

CharBuffer cb = CharBuffer.wrap("1234", 1, 3); 
    下面的代码演示了如何使用wrap方法将不同形式的字符串转换成CharBuffer对象。

```java
StringBuffer stringBuffer = new StringBuffer("通过StringBuffer创建CharBuffer对象");
StringBuilder stringBuilder = new StringBuilder("通过StringBuilder创建CharBuffer对象");
CharBuffer charBuffer1 = CharBuffer.wrap("通过String创建CharBuffer对象");
CharBuffer charBuffer2 = CharBuffer.wrap(stringBuffer);
CharBuffer charBuffer3 = CharBuffer.wrap(stringBuilder);
CharBuffer charBuffer4 = CharBuffer.wrap(charBuffer1, 1, 3);
```

## 读写缓冲区中的数据

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