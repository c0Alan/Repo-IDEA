# 无 web.xml 启动
在Spring-web项目中有类SpringServletContainerInitializer，它实现了Servlet3.0的ServletContainerInitializer接口，且优先级会高于xml中配置的listener。在SpringServletContainerInitializer中有注解@HandlesTypes(WebApplicationInitializer.class)，具体如下：
因为这个类声明了HandlesTypes，并指定了类型为WebApplicationInitializer.class，在Servlet3.0+中web容器启动时，会扫描类路径下所有的WebApplicationInitializer接口实现类，并提供一个set集合给onStartup方法执行。
onStartup方法执行时，会遍历该set，并使用newInstance()方式进行实例化，实例化后依据@Order注解进行排序，最后在依次调用onStartup(ServletContext)方法，完成初始化。
# 静态资源映射
# 拦截器配置
# @ControllerAdvice
# 其他配置
# 文件上传配置
# 自定义HttpMessageConverter
# 服务器端推送技术
# 测试

# 常用注解