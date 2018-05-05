<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>First Jsp</title>
</head>

<body>
<%
    out.print("Hello Jsp" + "<br/>");
%>
<%
    session.setAttribute("name", "session对象");//使用session对象,设置session对象的属性
    out.print(session.getAttribute("name") + "<br/>");//获取session对象的属性
    pageContext.setAttribute("name", "pageContext对象");//使用pageContext对象,设置pageContext对象的属性
    out.print(pageContext.getAttribute("name") + "<br/>");//获取pageContext对象的属性
    application.setAttribute("name", "application对象");//使用application对象,设置application对象的属性
    out.print(application.getAttribute("name") + "<br/>");//获取application对象的属性
    out.print("Hello Jsp" + "<br/>");//使用out对象
    out.print("服务器调用index.jsp页面时翻译成的类的名字是：" + page.getClass() + "<br/>");//使用page对象
    out.print("处理请求的Servlet的名字是：" + config.getServletName() + "<br/>");//使用config对象
    out.print(response.getContentType() + "<br/>");//使用response对象
    out.print(request.getContextPath() + "<br/>");//使用request对象
%>
</body>
</html>