<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试JSP的forward指令</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
%>
<jsp:forward page="/jsp/forward2.jsp">
    <jsp:param value="guoguo蝈蝈" name="param"/>
</jsp:forward>
</body>
</html>