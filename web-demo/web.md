# http

## 请求行

　　请求行中的GET称之为请求方式，请求方式有：POST、GET、HEAD、OPTIONS、DELETE、TRACE、PUT，常用的有： GET、 POST
　　用户如果没有设置，默认情况下浏览器向服务器发送的都是get请求，例如在浏览器直接输地址访问，点超链接访问等都是get，用户如想把请求方式改为post，可通过更改表单的提交方式实现。
　　不管POST或GET，都用于向服务器请求某个WEB资源，这两种方式的区别主要表现在数据传递上：如果请求方式为GET方式，则可以在请求的URL地址后以?的形式带上交给服务器的数据，多个数据之间以&进行分隔，例如：GET /mail/1.html?name=abc&password=xyz HTTP/1.1
　　GET方式的特点：在URL地址后附带的参数是有限制的，其数据容量通常不能超过1K。
　　如果请求方式为POST方式，则可以在请求的实体内容中向服务器发送数据，Post方式的特点：传送的数据量无限制。

## 消息头

　　HTTP请求中的常用消息头

　　accept:浏览器通过这个头告诉服务器，它所支持的数据类型
　　Accept-Charset: 浏览器通过这个头告诉服务器，它支持哪种字符集
　　Accept-Encoding：浏览器通过这个头告诉服务器，支持的压缩格式
　　Accept-Language：浏览器通过这个头告诉服务器，它的语言环境
　　Host：浏览器通过这个头告诉服务器，想访问哪台主机
　　If-Modified-Since: 浏览器通过这个头告诉服务器，缓存数据的时间
　　Referer：浏览器通过这个头告诉服务器，客户机是哪个页面来的  防盗链
　　Connection：浏览器通过这个头告诉服务器，请求完后是断开链接还是何持链接

## 常用响应头

　　HTTP响应中的常用响应头(消息头)
　　Location: 服务器通过这个头，来告诉浏览器跳到哪里
　　Server：服务器通过这个头，告诉浏览器服务器的型号
　　Content-Encoding：服务器通过这个头，告诉浏览器，数据的压缩格式
　　Content-Length: 服务器通过这个头，告诉浏览器回送数据的长度
　　Content-Language: 服务器通过这个头，告诉浏览器语言环境
　　Content-Type：服务器通过这个头，告诉浏览器回送数据的类型
　　Refresh：服务器通过这个头，告诉浏览器定时刷新
　　Content-Disposition: 服务器通过这个头，告诉浏览器以下载方式打数据
　　Transfer-Encoding：服务器通过这个头，告诉浏览器数据是以分块方式回送的
　　Expires: -1  控制浏览器不要缓存
　　Cache-Control: no-cache
　　Pragma: no-cache

# Servlet

## Servlet的运行过程

Servlet程序是由WEB服务器调用，web服务器收到客户端的Servlet访问请求后：
① Web服务器首先检查是否已经装载并创建了该Servlet的实例对象。如果是，则直接执行第④步，否则，执行第②步。
② 装载并创建该Servlet的一个实例对象。 
③ 调用Servlet实例对象的init()方法。
④ 创建一个用于封装HTTP请求消息的HttpServletRequest对象和一个代表HTTP响应消息的HttpServletResponse对象，然后调用Servlet的service()方法并将请求和响应对象作为参数传递进去。
⑤ WEB应用程序被停止或重新启动之前，Servlet引擎将卸载Servlet，并在卸载之前调用Servlet的destroy()方法。 

## Servlet与普通Java类的区别　　

　　Servlet是一个供其他Java程序（Servlet引擎）调用的Java类，它不能独立运行，它的运行完全由Servlet引擎来控制和调度。
　　针对客户端的多次Servlet请求，通常情况下，服务器只会创建一个Servlet实例对象，也就是说Servlet实例对象一旦创建，它就会驻留在内存中，为后续的其它请求服务，直至web容器退出，servlet实例对象才会销毁。
　　在Servlet的整个生命周期内，Servlet的init方法只被调用一次。而对一个Servlet的每次访问请求都导致Servlet引擎调用一次servlet的service方法。对于每次访问请求，Servlet引擎都会创建一个新的HttpServletRequest请求对象和一个新的HttpServletResponse响应对象，然后将这两个对象作为参数传递给它调用的Servlet的service()方法，service方法再根据请求方式分别调用doXXX方法。

　　如果在<servlet>元素中配置了一个<load-on-startup>元素，那么WEB应用程序在启动时，就会装载并创建Servlet的实例对象、以及调用Servlet实例对象的init()方法。
    举例：

```xml
<servlet>
	<servlet-name>invoker</servlet-name>
	<servlet-class>
		org.apache.catalina.servlets.InvokerServlet
	</servlet-class>
	<load-on-startup>1</load-on-startup>
</servlet>
```



　用途：为web应用写一个InitServlet，这个servlet配置为启动时装载，为整个web应用创建必要的数据库表和数据。

## 缺省Servlet

　　如果某个Servlet的映射路径仅仅为一个正斜杠（/），那么这个Servlet就成为当前Web应用程序的缺省Servlet。 
　　凡是在web.xml文件中找不到匹配的<servlet-mapping>元素的URL，它们的访问请求都将交给缺省Servlet处理，也就是说，缺省Servlet用于处理所有其他Servlet都不处理的访问请求。 

## ServletConfig

当servlet配置了初始化参数后，web容器在创建servlet实例对象时，会自动将这些初始化参数封装到ServletConfig对象中，并在调用servlet的init方法时，将ServletConfig对象传递给servlet。进而，我们通过ServletConfig对象就可以得到当前servlet的初始化参数信息。

## ServletContext对象

　　WEB容器在启动时，它会为每个WEB应用程序都创建一个对应的ServletContext对象，它代表当前web应用。
　　ServletConfig对象中维护了ServletContext对象的引用，开发人员在编写servlet时，可以通过ServletConfig.getServletContext方法获得ServletContext对象。
　　由于一个WEB应用中的所有Servlet共享同一个ServletContext对象，因此Servlet对象之间可以通过ServletContext对象来实现通讯。ServletContext对象通常也被称之为context域对象。

## HttpServletResponse

## HttpServletRequest

# JSP



# JSTL

## 核心标签库使用说明

　　JSTL的核心标签库标签共13个，使用这些标签能够完成JSP页面的基本功能，减少编码工作。

　　从功能上可以分为4类：表达式控制标签、流程控制标签、循环标签、URL操作标签。
　　　　（1）**表达式控制标签**：**out标签、set标签、remove标签、catch标签。**
　　　　（2）**流程控制标签**：**if标签、choose标签、when标签、otherwise标签**。
　　　　（3）**循环标签**：**forEach标签、forTokens标签**。
　　　　（4）**URL操作标签**：**import标签、url标签、redirect标签、param标签**。

　　在JSP页面引入核心标签库的代码为：**<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>**

# EL表达式

## 获取数据

　　使用EL表达式获取数据语法："**${标识符}**"
　　EL表达式语句在执行时，会调用pageContext.findAttribute方法，用标识符为关键字，分别从page、request、session、application四个域中查找相应的对象，找到则返回相应对象，找不到则返回”” （注意，不是null，而是空字符串）。

　　EL表达式可以很轻松获取JavaBean的属性，或获取数组、Collection、Map类型集合的数据



## 隐含对象

　　EL表达式语言中定义了11个隐含对象，使用这些隐含对象可以很方便地获取web开发中的一些常见对象，并读取这些对象的数据。
　　语法：**${隐式对象名称}**：获得对象的引用

| 序号 | 隐含对象名称     | 描       述                                                  |
| ---- | ---------------- | ------------------------------------------------------------ |
| 1    | pageContext      | 对应于JSP页面中的pageContext对象（注意：取的是pageContext对象。） |
| 2    | pageScope        | 代表page域中用于保存属性的Map对象                            |
| 3    | requestScope     | 代表request域中用于保存属性的Map对象                         |
| 4    | sessionScope     | 代表session域中用于保存属性的Map对象                         |
| 5    | applicationScope | 代表application域中用于保存属性的Map对象                     |
| 6    | param            | 表示一个保存了所有请求参数的Map对象                          |
| 7    | paramValues      | 表示一个保存了所有请求参数的Map对象，它对于某个请求参数，返回的是一个string[] |
| 8    | header           | 表示一个保存了所有http请求头字段的Map对象，注意：如果头里面有“-” ，例Accept-Encoding，则要header[“Accept-Encoding”] |
| 9    | headerValues     | 表示一个保存了所有http请求头字段的Map对象，它对于某个请求参数，返回的是一个string[]数组。注意：如果头里面有“-” ，例Accept-Encoding，则要headerValues[“Accept-Encoding”] |
| 10   | cookie           | 表示一个保存了所有cookie的Map对象                            |
| 11   | initParam        | 表示一个保存了所有web应用初始化参数的map对象                 |

# i18n

# JDBC

## 基本概念

### 2.2、DriverManager类讲解

　　Jdbc程序中的DriverManager用于加载驱动，并创建与数据库的链接，这个API的常用方法：

DriverManager.registerDriver(new Driver())
DriverManager.getConnection(url, user, password)，
　　注意：在实际开发中并不推荐采用registerDriver方法注册驱动。原因有二：
　　　　1、查看Driver的源代码可以看到，如果采用此种方式，会导致驱动程序注册两次，也就是在内存中会有两个Driver对象。
　　　　2、程序依赖mysql的api，脱离mysql的jar包，程序将无法编译，将来程序切换底层数据库将会非常麻烦。

　　推荐方式：Class.forName("com.mysql.jdbc.Driver");
　　采用此种方式不会导致驱动对象在内存中重复出现，并且采用此种方式，程序仅仅只需要一个字符串，不需要依赖具体的驱动，使程序的灵活性更高。

### 2.3、数据库URL讲解

　　URL用于标识数据库的位置，通过URL地址告诉JDBC程序连接哪个数据库，URL的写法为：
协议:子协议:[]//主机:端口/数据库 ? 参数名:参数值

常用数据库URL地址的写法：

Oracle写法：jdbc:oracle:thin:@localhost:1521:sid
SqlServer写法：jdbc:microsoft:sqlserver://localhost:1433; DatabaseName=sid
MySql写法：jdbc:mysql://localhost:3306/sid
　　如果连接的是本地的Mysql数据库，并且连接使用的端口是3306，那么的url地址可以简写为： jdbc:mysql:///数据库

### 2.4、Connection类讲解

　　Jdbc程序中的Connection，它用于代表数据库的链接，Collection是数据库编程中最重要的一个对象，客户端与数据库所有交互都是通过connection对象完成的，这个对象的常用方法：

createStatement()：创建向数据库发送sql的statement对象。
prepareStatement(sql) ：创建向数据库发送预编译sql的PrepareSatement对象。
prepareCall(sql)：创建执行存储过程的callableStatement对象。
setAutoCommit(boolean autoCommit)：设置事务是否自动提交。
commit() ：在链接上提交事务。
rollback() ：在此链接上回滚事务。

### 2.5、Statement类讲解

　　Jdbc程序中的Statement对象用于向数据库发送SQL语句， Statement对象常用方法：

executeQuery(String sql) ：用于向数据发送查询语句。
executeUpdate(String sql)：用于向数据库发送insert、update或delete语句
execute(String sql)：用于向数据库发送任意sql语句
addBatch(String sql) ：把多条sql语句放到一个批处理中。
executeBatch()：向数据库发送一批sql语句执行。

### 2.6、ResultSet类讲解

　　Jdbc程序中的ResultSet用于代表Sql语句的执行结果。Resultset封装执行结果时，采用的类似于表格的方式。ResultSet 对象维护了一个指向表格数据行的游标，初始的时候，游标在第一行之前，调用ResultSet.next() 方法，可以使游标指向具体的数据行，进行调用方法获取该行的数据。
　　ResultSet既然用于封装执行结果的，所以该对象提供的都是用于获取数据的get方法：
　　获取任意类型的数据
　　　　getObject(int index)
　　　　getObject(string columnName)
　　获取指定类型的数据，例如：
　　　　getString(int index)
　　　　getString(String columnName)

　　ResultSet还提供了对结果集进行滚动的方法：

next()：移动到下一行
Previous()：移动到前一行
absolute(int row)：移动到指定行
beforeFirst()：移动resultSet的最前面。
afterLast() ：移动到resultSet的最后面。

### 2.7、释放资源

　　Jdbc程序运行完后，切记要释放程序在运行过程中，创建的那些与数据库进行交互的对象，这些对象通常是ResultSet, Statement和Connection对象，特别是Connection对象，它是非常稀有的资源，用完后必须马上释放，如果Connection不能及时、正确的关闭，极易导致系统宕机。Connection的使用原则是尽量晚创建，尽量早的释放。
　　为确保资源释放代码能运行，资源释放代码也一定要放在finally语句中。

## 事务的四大特性(ACID)

### 1、原子性（Atomicity）

原子性是指事务是一个不可分割的工作单位，事务中的操作要么全部成功，要么全部失败。比如在同一个事务中的SQL语句，要么全部执行成功，要么全部执行失败

### 2、一致性（Consistency）

官网上事务一致性的概念是：事务必须使数据库从一个一致性状态变换到另外一个一致性状态。以转账为例子，A向B转账，假设转账之前这两个用户的钱加起来总共是2000，那么A向B转账之后，不管这两个账户怎么转，A用户的钱和B用户的钱加起来的总额还是2000，这个就是事务的一致性。

### 3、隔离性（Isolation）

事务的隔离性是多个用户并发访问数据库时，数据库为每一个用户开启的事务，不能被其他事务的操作数据所干扰，多个并发事务之间要相互隔离。

### 4、持久性（Durability）

​	持久性是指一个事务一旦被提交，它对数据库中数据的改变就是永久性的，接下来即使数据库发生故障也不应该对其有任何影响
　　事务的四大特性中最麻烦的是隔离性，下面重点介绍一下事务的隔离级别

## 事务的隔离级别

　　多个线程开启各自事务操作数据库中数据时，数据库系统要负责隔离操作，以保证各个线程在获取数据时的准确性。

1、事务不考虑隔离性可能会引发的问题　　
　　如果事务不考虑隔离性，可能会引发如下问题：

　　1、脏读
　　　　　脏读指一个事务读取了另外一个事务未提交的数据。

　　　　　这是非常危险的，假设Ａ向Ｂ转帐100元，对应sql语句如下所示
    　　　　　　1.update account set money=money+100 where name='B';    
    　　　　　　2.update account set money=money-100  where name='A';
    　　　 当第1条sql执行完，第2条还没执行(A未提交时)，如果此时Ｂ查询自己的帐户，就会发现自己多了100元钱。如果A等B走后再回滚，B就会损失100元。　　

　　2、不可重复读
　　不可重复读指在一个事务内读取表中的某一行数据，多次读取结果不同。
　　例如银行想查询A帐户余额，第一次查询A帐户为200元，此时A向帐户内存了100元并提交了，银行接着又进行了一次查询，此时A帐户为300元了。银行两次查询不一致，可能就会很困惑，不知道哪次查询是准的。
　　不可重复读和脏读的区别是，脏读是读取前一事务未提交的脏数据，不可重复读是重新读取了前一事务已提交的数据。
　　很多人认为这种情况就对了，无须困惑，当然是后面的为准。我们可以考虑这样一种情况，比如银行程序需要将查询结果分别输出到电脑屏幕和写到文件中，结果在一个事务中针对输出的目的地，进行的两次查询不一致，导致文件和屏幕中的结果不一致，银行工作人员就不知道以哪个为准了。

　　3、虚读(幻读)
　　虚读(幻读)是指在一个事务内读取到了别的事务插入的数据，导致前后读取不一致。
　　如丙存款100元未提交，这时银行做报表统计account表中所有用户的总额为500元，然后丙提交了，这时银行再统计发现帐户为600元了，造成虚读同样会使银行不知所措，到底以哪个为准。

2、事务隔离性的设置语句
　　MySQL数据库共定义了四种隔离级别：

Serializable(串行化)：可避免脏读、不可重复读、虚读情况的发生。
Repeatable read(可重复读)：可避免脏读、不可重复读情况的发生。
Read committed(读已提交)：可避免脏读情况发生。
Read uncommitted(读未提交)：最低级别，以上情况均无法保证。

### 使用MySQL数据库演示不同隔离级别下的并发问题

　　同时打开两个窗口模拟2个用户并发访问数据库
1、当把事务的隔离级别设置为read uncommitted时，会引发脏读、不可重复读和虚读
　　A窗口
　　　　set transaction isolation level  read uncommitted;--设置A用户的数据库隔离级别为Read uncommitted(读未提交)
　　　　start transaction;--开启事务
　　　　select * from account;--查询A账户中现有的钱，转到B窗口进行操作
　　　　select * from account--发现a多了100元，这时候A读到了B未提交的数据（脏读）

　　B窗口
　　　　start transaction;--开启事务
　　　　update account set money=money+100 where name='A';--不要提交，转到A窗口查询
2、当把事务的隔离级别设置为read committed时，会引发不可重复读和虚读，但避免了脏读
　　A窗口
　　　　set transaction isolation level  read committed;
　　　　start transaction;
　　　　select * from account;--发现a帐户是1000元，转到b窗口
　　　　select * from account;--发现a帐户多了100,这时候，a读到了别的事务提交的数据，两次读取a帐户读到的是不同的结果（不可重复读）
　　B窗口
　　　　start transaction;
　　　　update account set money=money+100 where name='aaa';
　　　　commit;--转到a窗口
3、当把事务的隔离级别设置为repeatable read(mysql默认级别)时，会引发虚读，但避免了脏读、不可重复读
　　A窗口
　　　　set transaction isolation level repeatable read;
　　　　start transaction;
　　　　select * from account;--发现表有4个记录，转到b窗口
　　　　select * from account;--可能发现表有5条记录，这时候发生了a读取到另外一个事务插入的数据（虚读）
　　B窗口
　　　　start transaction;
　　　　insert into account(name,money) values('ggg',1000);
　　　　commit;--转到a窗口
4、当把事务的隔离级别设置为Serializable时，会避免所有问题
　　A窗口
　　　　set transaction isolation level Serializable;
　　　　start transaction;
　　　　select * from account;--转到b窗口
　　B窗口
　　　　start transaction;
　　　　insert into account(name,money) values('ggg',1000);--发现不能插入，只能等待a结束事务才能插入

## 元数据介绍

　　元数据指的是"数据库"、"表"、"列"的定义信息。

### 1、DataBaseMetaData元数据

　　Connection.getDatabaseMetaData()获得代表DatabaseMetaData元数据的DatabaseMetaData对象。
　　DataBaseMetaData对象的常用方法：

getURL()：返回一个String类对象，代表数据库的URL。
getUserName()：返回连接当前数据库管理系统的用户名。
getDatabaseProductName()：返回数据库的产品名称。
getDatabaseProductVersion()：返回数据库的版本号。
getDriverName()：返回驱动驱动程序的名称。
getDriverVersion()：返回驱动程序的版本号。
isReadOnly()：返回一个boolean值，指示数据库是否只允许读操作。

### 2、ParameterMetaData元数据

　　PreparedStatement.getParameterMetaData() 获得代表PreparedStatement元数据的ParameterMetaData对象。 
　　Select * from user where name=? And password=?
　　ParameterMetaData对象的常用方法：

getParameterCount()： 获得指定参数的个数
getParameterType(int param)：获得指定参数的sql类型，MySQL数据库驱动不支持

### 3、ResultSetMetaData元数据

　　ResultSet. getMetaData() 获得代表ResultSet对象元数据的ResultSetMetaData对象。 
　　ResultSetMetaData对象的常用方法：

getColumnCount() 返回resultset对象的列数
getColumnName(int column) 获得指定列的名称
getColumnTypeName(int column)获得指定列的类型