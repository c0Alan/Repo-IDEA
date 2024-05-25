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
    <a href="${pageContext.request.contextPath}/index1.jsp">index1.jsp</a><br/>
    <a href="${pageContext.request.contextPath}/index2.jsp">index2.jsp</a><br/>
    <a href="${pageContext.request.contextPath}/index3.jsp">index3.jsp</a><br/>
    <a href="${pageContext.request.contextPath}/index4.jsp">index4.jsp</a><br/>
    <a href="${pageContext.request.contextPath}/index5.jsp">index5.jsp</a><br/>
    <a href="${pageContext.request.contextPath}/index6.jsp">index6.jsp</a><br/>

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