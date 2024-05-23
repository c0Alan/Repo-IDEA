<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>敏感词过滤器</title>
</head>

<body>
<form action="${pageContext.request.contextPath}/servlet/ServletDemo2" method="post">
    留言:
    <textarea rows="8" cols="70" name="message">aaa</textarea>
    <input type="submit" value="发表">
</form>
</body>
</html>