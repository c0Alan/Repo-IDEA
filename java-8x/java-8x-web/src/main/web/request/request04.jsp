<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>request接收中文参数乱码问题</title>
</head>

<body>
<form action="${pageContext.request.contextPath}/servlet/RequestDemo04" method="get">
    姓名：<input type="text" name="name"/>
    <input type="submit" value="get方式提交表单">
</form>
</body>
</html>