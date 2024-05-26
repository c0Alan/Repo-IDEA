<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <title>500(服务器错误)错误友好提示页面</title>
    <!-- 3秒钟后自动跳转回首页 -->
    <meta http-equiv="refresh" content="3;url=${pageContext.request.contextPath}/index.jsp">
</head>
<body>
<img alt="对不起，服务器出错了，请联系管理员解决！"
     src="${pageContext.request.contextPath}/img/500Error.png"/><br/>
3秒钟后自动跳转回首页，如果没有跳转，请点击<a href="${pageContext.request.contextPath}/index.jsp">这里</a>
</body>
</html>