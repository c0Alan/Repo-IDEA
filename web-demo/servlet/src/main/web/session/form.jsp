<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Form表单</title>
    <script type="text/javascript" src="form.js"></script>
</head>

<body>
<%--<form action="${pageContext.request.contextPath}/servlet/DoFormServlet" onsubmit="return dosubmit()" method="post">--%>
<form action="${pageContext.request.contextPath}/servlet/dulsubmit/DoFormServlet2" method="post">
<%--<form action="${pageContext.request.contextPath}/servlet/DoFormServlet" method="post">--%>
    <%--使用隐藏域存储生成的token--%>
    <input type="hidden" name="token" value="<%=session.getAttribute("token") %>">
    用户名：<input type="text" name="username">
    <input type="submit" value="提交" id="submit">
</form>
</body>
</html>