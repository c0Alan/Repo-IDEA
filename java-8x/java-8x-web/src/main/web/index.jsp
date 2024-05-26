<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Spring MVC DEMOS</title>

    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<h1>这是首页!</h1>
<div class="container" style="margin-top: 10px; margin-left: 10px;">

    <p>============================== Http协议 ==============================</p>
    <a href="${pageContext.request.contextPath}/servlet/ServletDemo01">/servlet/ServletDemo01: 设置Location响应头，实现请求重定向</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/ServletDemo02">/servlet/ServletDemo02: 设置响应头Content-Encoding来告诉浏览器，服务器发送回来的数据压缩后的格式</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/ServletDemo03">/servlet/ServletDemo03: 设置content-type响应头，指定回送数据类型</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/ServletDemo04">/servlet/ServletDemo04: 设置refresh响应头，让浏览器定时刷新</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/ServletDemo05">/servlet/ServletDemo05: 设置content-disposition响应头，让浏览器下载文件</a><br/>


    <p>============================== Servlet开发 ==============================</p>
    <a href="${pageContext.request.contextPath}/servlet/ServletDemo1?username=liuxl">/servlet/ServletDemo1: 简单示例</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/ServletDemo3">/servlet/ServletDemo3: 线程安全问题</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/ServletConfigDemo1">/servlet/ServletConfigDemo1: 通过ServletConfig获取Servlet的初始化参数</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/ServletContextDemo1">/servlet/ServletContextDemo1: 多个Servlet通过ServletContext对象实现数据共享，写</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/ServletContextDemo2">/servlet/ServletContextDemo2: 多个Servlet通过ServletContext对象实现数据共享，读</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/ServletContextDemo3">/servlet/ServletContextDemo3: 使用context-param标签配置WEB应用的初始化参数</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/ServletContextDemo4">/servlet/ServletContextDemo4: 用servletContext实现请求转发</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/ServletContextDemo6">/servlet/ServletContextDemo6: 使用servletContext读取资源文件</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/ServletContextDemo7">/servlet/ServletContextDemo7: 使用类装载器读取资源文件</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/ServletDemo5">/servlet/ServletDemo5: 在客户端缓存Servlet的输出</a><br/>

    <p>============================== HttpServletResponse对象 ==============================</p>
    <a href="${pageContext.request.contextPath}/servlet/ResponseDemo01">/servlet/ResponseDemo01: 使用OutputStream、PrintWriter流向客户端浏览器输出中文数据或数字</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/ResponseDemo02?type=downloadFileByOutputStream">/servlet/ResponseDemo02?type=downloadFileByOutputStream: 使用Response实现文件下载</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/ResponseDemo02?type=downloadChineseFileByOutputStream">/servlet/ResponseDemo02?type=downloadChineseFileByOutputStream: 使用Response实现文件下载</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/ResponseDemo02?type=downloadFileByPrintWriter">/servlet/ResponseDemo02?type=downloadFileByPrintWriter: 使用Response实现文件下载</a><br/>

    <p>============================== 通过Servlet生成验证码图片 ==============================</p>
    <a href="${pageContext.request.contextPath}/servlet/DrawImage">/servlet/DrawImage: 生成验证码图片</a><br/>
    <a href="${pageContext.request.contextPath}/drawimage/changeImg.jsp">随机验证码,字母加数字</a><br/>
    <a href="${pageContext.request.contextPath}/drawimage/changeImg2.jsp">随机验证码,多种类型验证码</a><br/>

    <p>============================== HttpServletRequest对象 ==============================</p>
    <a href="${pageContext.request.contextPath}/servlet/RequestDemo01?param1=aaa&param2=bbb">/servlet/RequestDemo01: 通过request对象获取客户端请求信息</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/RequestDemo02">/servlet/RequestDemo02: 通过request对象获取客户端请求头信息</a><br/>
    <a href="${pageContext.request.contextPath}/request/request.jsp">/request/request.jsp: 获得客户机请求参数(客户端提交的数据)</a><br/>
    <a href="${pageContext.request.contextPath}/request/request02.jsp">/request/request02.jsp: 以POST方式提交表单中文参数的乱码问题</a><br/>
    <a href="${pageContext.request.contextPath}/request/request04.jsp">/request/request04.jsp: 以GET方式提交表单中文参数的乱码问题</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/RequestDemo06">/servlet/RequestDemo06: Request对象实现请求转发</a><br/>

    <p>============================== Cookie、Session ==============================</p>
    <a href="${pageContext.request.contextPath}/servlet/CookieDemo01">/servlet/CookieDemo01: 获取用户上一次访问的时间</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/CookieDemo02">/servlet/CookieDemo02: 删除cookie</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/SessionDemo1">/servlet/SessionDemo1: session实现原理</a><br/>
    <a href="${pageContext.request.contextPath}/session/form.jsp">/session/form.jsp: 表单重复提交的常见应用场景</a><br/>
    <a href="${pageContext.request.contextPath}/session/form2.jsp">/session/form2.jsp: 利用JavaScript防止表单重复提交</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/FormServlet">/servlet/FormServlet: 利用Session防止表单重复提交</a><br/>

    <p>============================== JSP ==============================</p>
    <a href="${pageContext.request.contextPath}/jsp/firstJsp.jsp">/jsp/firstJsp.jsp: First Jsp</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/errorPageTest.jsp">/jsp/errorPageTest.jsp: 使用errorPage属性指明出错后跳转的错误页面</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/test02.jsp">/jsp/test02.jsp: 使用pageContext的findAttribute方法查找属性值</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/test03.jsp">/jsp/test03.jsp: pageContext访问其它域</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/test04.jsp">/jsp/test04.jsp: 使用pageContext的forward方法跳转到其他页面</a><br/>

    <p>============================== JSP属性范围 ==============================</p>
    <a href="${pageContext.request.contextPath}/jsp/pageContextDemo01.jsp">/jsp/pageContextDemo01.jsp: page属性范围</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/pageScopeDemo02.jsp">/jsp/pageScopeDemo02.jsp: page属性范围</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/pageScopeDemo04.jsp">/jsp/pageScopeDemo04.jsp: page属性范围</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/requestScopeDemo01.jsp">/jsp/requestScopeDemo01.jsp: request属性范围</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/requestScopeDemo03.jsp">/jsp/requestScopeDemo03.jsp: request属性范围</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/sessionScopeDemo01.jsp">/jsp/sessionScopeDemo01.jsp: session属性范围</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/applicationScopeDemo01.jsp">/jsp/applicationScopeDemo01.jsp: application属性范围</a><br/>


    <p>============================== JSP JavaBean ==============================</p>
    <a href="${pageContext.request.contextPath}/jsp/JavaBean.jsp">/jsp/JavaBean.jsp: JavaBean示例</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/JavaBean2.jsp">/jsp/JavaBean2.jsp: 使用jsp:setProperty标签设置person对象的属性值</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/JavaBean3.jsp">/jsp/JavaBean3.jsp: jsp:setProperty使用请求参数为bean的属性赋值</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/JavaBean4.jsp">/jsp/JavaBean4.jsp: jsp:setProperty用所有的请求参数为bean的属性赋值</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/JavaBean5.jsp">/jsp/JavaBean5.jsp: 使用jsp:getProperty获取bean对象的属性值</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/calculator.jsp">/jsp/calculator.jsp: JSP+JavaBean开发模式编写计算器</a><br/>

    <p>============================== 基于Servlet+JSP+JavaBean开发模式的用户登录注册 ==============================</p>
    <a href="${pageContext.request.contextPath}/loginIndex.jsp">/loginIndex.jsp: 登录界面</a><br/>

    <p>============================== EL表达式简介 ==============================</p>
    <a href="${pageContext.request.contextPath}/tag/calculate.jsp">/tag/calculate.jsp: el表达式运算符</a><br/>
    <a href="${pageContext.request.contextPath}/tag/getData.jsp">/tag/getData.jsp: el表达式获取数据</a><br/>
    <a href="${pageContext.request.contextPath}/tag/innerrObject.jsp">/tag/innerrObject.jsp: el隐式对象</a><br/>
    <a href="${pageContext.request.contextPath}/customLib/CustomLib.jsp">/customLib/CustomLib.jsp: 使用EL调用Java方法</a><br/>
    <a href="${pageContext.request.contextPath}/function/ELFunction.jsp">/function/ELFunction.jsp: EL函数库中的方法使用范例</a><br/>

    <p>============================== JSTL标签库 ==============================</p>
    <a href="${pageContext.request.contextPath}/jstl/catch.jsp">catch</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/choose.jsp">choose</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/forEach.jsp">forEach</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/forTokens.jsp">forTokens</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/if.jsp">if</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/import.jsp">import</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/out.jsp">out</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/redirect.jsp">redirect</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/remove.jsp">remove</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/set.jsp">set</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/url.jsp">url</a><br/>

    <p>============================== 过滤器(Filter) ==============================</p>
    <a href="${pageContext.request.contextPath}/jsp/CharacterEncodingFilter.jsp">CharacterEncodingFilter.jsp</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/HtmlFilter.jsp">HtmlFilter.jsp</a><br/>

    <p>============================== 监听器(Listener) ==============================</p>
    <a href="${pageContext.request.contextPath}/jsp/Listener.jsp">Listener.jsp</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/ServletContextAttributeListenerTest.jsp">ServletContextAttributeListenerTest.jsp</a><br/>
    <a href="${pageContext.request.contextPath}/jsp/RequestAndSessionAttributeListenerTest.jsp">RequestAndSessionAttributeListenerTest.jsp</a><br/>

    <p>============================== 自定义 @WebServlet 注解，模拟实现 Servlet 的功能 ==============================</p>
    <a href="${pageContext.request.contextPath}/servlet/LoginUI.do">/servlet/LoginUI.do: 跳转登录页面</a><br/>
    <a href="${pageContext.request.contextPath}/WebServletLogin.jsp">/WebServletLogin.jsp: 登录页面</a><br/>
    <a href="${pageContext.request.contextPath}/gacl/LoginServlet!loginHandle.do?usename=gacl&pwd=xdp">/gacl/LoginServlet!loginHandle.do: 接口访问</a><br/>

    <p>============================== 模拟实现 springmvc @Controller、@RequestMapping 注解 ==============================</p>
    <a href="${pageContext.request.contextPath}/LoginUI/Login2.do">/LoginUI/Login2.do: 跳转登录页面</a><br/>
    <a href="${pageContext.request.contextPath}/LoginUI/Login3.do">/LoginUI/Login3.do: 跳转登录页面</a><br/>
    <a href="${pageContext.request.contextPath}/login/handle.do?usename=gacl&pwd=xdp">/login/handle.do: 接口访问</a><br/>

    <p>============================== 文件上传下载 ==============================</p>
    <a href="${pageContext.request.contextPath}/jsp/upload.jsp">/jsp/upload.jsp: 文件上传界面</a><br/>
    <a href="${pageContext.request.contextPath}/servlet/ListFileServlet">/servlet/ListFileServlet: 文件下载列表</a><br/>

    <p>============================== jdbc操作 ==============================</p>
    <a href="${pageContext.request.contextPath}/jdbc/DataSourceJNDIServlet">/servlet/DataSourceJNDIServlet: JNDI数据库连接池</a><br/>
    <a href="${pageContext.request.contextPath}/jdbc/AccountServlet">/servlet/AccountServlet: 模拟controller、service、dao三层访问链路及事务回滚</a><br/>

</div>
<hr/>
<label style="color: #007bff;">${msg}</label>
</body>

</html>