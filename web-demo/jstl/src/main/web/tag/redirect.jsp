<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--引入JSTL核心标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>JSTL: -- redirect标签实例</title>
</head>

<body>
<c:redirect url="http://www.baidu.com">
    <%--在重定向时使用<c:param>标签为URL添加了两个参数：uname=GACL和password=123 --%>
    <c:param name="uname">GACL</c:param>
    <c:param name="password">123</c:param>
</c:redirect>
</body>
</html>