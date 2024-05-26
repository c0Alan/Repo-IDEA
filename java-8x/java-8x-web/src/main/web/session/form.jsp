<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Form表单</title>
</head>

<body>
<form action="${pageContext.request.contextPath}/servlet/DoFormServlet" method="post">
    用户名：<input type="text" name="username">
    <input type="submit" value="提交" id="submit">
</form>
</body>
</html>