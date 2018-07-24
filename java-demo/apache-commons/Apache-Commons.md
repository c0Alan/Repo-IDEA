1. BCEL
  汇编语言级别的类字节码处理工具.
  BCEL全称Apache Byte Code Engineering Library,BCEL 每项内容操作在JVM汇编语言的级别.
  BCEL是 Java classworking 最广泛使用的一种框架,它可以让您深入 JVM 汇编语言进行类操作的细节。
  BCEL与 Javassist 有不同的处理字节码方法, BCEL在实际的JVM 指令层次上进行操作(BCEL拥有丰富的JVM 指令级支持)而Javassist 所强调的源代码级别的工作。

2. Beanutils
  Commons-BeanUtils 提供对 Java 反射和自省API的包装.

3. BSF
  Bean Scripting Framework(BSF)是一个支持在Java应用程序内调用脚本语言 (Script), 并且支持脚本语言直接访问Java对象和方法的一个开源项目。

// 4. Betwixt
实现java bean与xml相互转换.

5. Chain
  Chain 提供实现组织复杂的处理流程的“责任链模式”.

6. CLI
  CLI 提供针对命令行参数, 选项, 选项组, 强制选项等的简单API.

7. Codec
  Codec 包含一些通用的编码解码算法。包括一些语音编码器,  Hex, Base64, 以及URL encoder.

8. Collections
  Commons-Collections 提供一个类包来扩展和增加标准的 Java Collection框架

9. Configuration
  Commons-Configuration 工具对各种各式的配置和参考文件提供读取帮助.

10. Compress
    文件打包 压缩类库.

11. Crypto
    Apache Commons Crypto 是一个加密库, 使用 AES-NI (Advanced Encryption Standard New Instructions) 进行优化。
    提供了加密级别和流级别的 API。开发者可以使用最少代码来实现高性能的 AES 加解密应用。

12. CSV
    CSV(Comma-Separated Values)逗号分隔值(有时也称为字符分隔值), 因为分隔字符也可以不是逗号), 文件是以纯文本形式存储表格数据, 包括数字和文本。
    CSV 处理工具类.

13. Daemon
    一种 unix-daemon-like java 代码的替代机制

14. DBCP
    Commons-DBCP 提供数据库连接池服务

15. DbUtils
    DbUtils 是一个 JDBC helper 类库, 完成数据库任务的简单的资源清除代码.

16. Digester
    Commons-Digester 是一个 XML-Java对象的映射工具, 用于解析 XML配置文件.

// 17. Discovery
Commons-Discovery 提供工具来定位资源 (包括类) , 通过使用各种模式来映射服务/引用名称和资源名称。

18. Email
    邮件工具, 它对JavaMail API进行了封装，用起来特变方便.

19. Exec
    Java调用外部程序类库Apache Commons Exce，这个类库提供非阻塞方法调用外部程序。
    Apache commons exec库提供了监视狗Watchdog来设监视进程的执行超时，同时也还实现了同步和异步功能。

// 20. EL
Commons-EL 提供在JSP2.0规范中定义的EL表达式的解释器.

21. FileUpload
    FileUpload 使得在你可以在应用和Servlet中容易的加入强大和高性能的文件上传能力

22. Functor
    函数式编程工具包.
    Apache Commons Functor 库包括大量基本构造,可以在涉及闭包和高阶函数的复杂使用场景中重复使用。

23. HttpClient
    Commons-HttpClient 提供了可以工作于HTTP协议客户端的一个框架.

24. Imaging (was Sanselan)
    纯Java的图像库。

25. IO
    IO 是一个 I/O 工具集

26. JCI
    Java 编译器接口

27. JCS
    Java缓存系统

28. Jelly
    Jelly是一个基于 XML 的脚本和处理引擎。 Jelly 借鉴了 JSP 定指标签, Velocity, Cocoon和Xdoclet中的脚本引擎的许多优点。Jelly 可以用在命令行,  Ant 或者 Servlet之中。

29. JEXL
    Jexl是一个表达式语言, 通过借鉴来自于Velocity的经验扩展了JSTL定义的表达式语言。.

30. JXPath
    Commons-JXPath 提供了使用Xpath语法操纵符合Java类命名规范的 JavaBeans的工具。也支持 maps, DOM 和其他对象模型.

31. Lang
    Commons-Lang 提供了许多许多通用的工具类集, 提供了一些java.lang中类的扩展功能

32. Logging
    Commons-Logging 是一个各种 logging API实现的包裹类.

// 33. Latka
Commons-Latka 是一个HTTP 功能测试包, 用于自动化的QA,验收和衰减测试.

// 34. Launcher
Launcher 组件是一个交叉平台的Java 应用载入器。Commons-launcher 消除了需要批处理或者Shell脚本来载入Java 类。.原始的 Java 类来自于Jakarta Tomcat 4.0 项目

35. Math
    Math 是一个轻量的, 自包含的数学和统计组件, 解决了许多非常通用但没有及时出现在Java标准语言中的实践问题.

// 36. Modeler
Commons-Modeler 提供了建模兼容JMX规范的Mbean的机制.

37. Net
    Net 是一个网络工具集, 基于 NetComponents 代码, 包括 FTP 客户端等等。

38. Pool
    Commons-Pool 提供了通用对象池接口, 一个用于创建模块化对象池的工具包, 以及通常的对象池实现.

39. Proxy
    创建动态代理的包。
    Apache Commons Proxy 是Apache 的一个之项目，封装了 Java 对象代理的一些常用方法。又叫做 动态代理。
    动态代理的作用非常大，在很多底层框架中都会用得到，比如struts，Spring等都用到了动态代理，
    它的原理很简单，就是将你要使用的类，重新生成一个子类或本类，这样框架就可以利用这个新生成的类做一些事情，比如在该类的方法前后加一些代码。

// 40. Primitives
Commons-Primitives提供了一个更小, 更快和更易使用的对Java基本类型的支持。当前主要是针对基本类型的 collection。.

41. Sanselan (see Imaging)
42. SCXML
    SCXML（State Chart XML），简单地说就是状态图的xml描述文件。
    这里的状态图和UML里面的状态图是基本一致的，都是继承自Harel Start Chart。

43. Validator
    The commons-validator提供了一个简单的, 可扩展的框架来在一个XML文件中定义校验器 (校验方法)和校验规则。支持校验规则的和错误消息的国际化。

44. VFS
    Apache commons VFS又叫做 Apache Commons Virtual FileSystem。是一组功能强大的对各类资源的访问接口.
    Apache VFS 提供了一种虚拟文件系统，能够让你通过程序很方便的和位于本地文件系统，FTP文件系统，HTTP文件打交道。