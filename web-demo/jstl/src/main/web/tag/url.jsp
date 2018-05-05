<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--引入JSTL核心标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>JSTL: -- url标签实例</title>
</head>

<body>
<c:out value="url标签使用"></c:out>
<h4>使用url标签生成一个动态的url，并把值存入session中.</h4>
<hr/>
<c:url value="http://www.baidu.com" var="url" scope="session">
</c:url>
<a href="${url}">百度首页(不带参数)</a>
<hr/>
<h4>
    配合 &lt;c:param&gt;标签给url加上指定参数及参数值，生成一个动态的url然后存储到paramUrl变量中
</h4>
<c:url value="http://www.baidu.com" var="paramUrl">
    <c:param name="userName" value="孤傲苍狼"/>
    <c:param name="pwd">123456</c:param>
</c:url>
<a href="${paramUrl}">百度首页(带参数)</a>
</body>
</html>