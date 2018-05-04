<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page import="java.net.URLEncoder" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>request接收中文参数乱码问题</title>
</head>

<body>
<form action="<%=request.getContextPath()%>/servlet/RequestDemo04" method="post">
    用户名：<input type="text" name="userName"/>
    <input type="submit" value="post方式提交表单">
</form>

<%--如果URL地址后面如果跟了中文数据，那么中文参数最好使用URL编码进行处理--%>
<a href="${pageContext.request.contextPath}/servlet/RequestDemo05?userName=gacl&name=<%=URLEncoder.encode("徐达沛", "UTF-8")%>">点击</a>
</body>
</html>