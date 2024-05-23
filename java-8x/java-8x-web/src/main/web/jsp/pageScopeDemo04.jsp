<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; utf-8">
    <title>jsp:useBean</title>
</head>

<body>
<% request.setCharacterEncoding("utf-8"); %>
<%
    pageContext.setAttribute("name", "孤傲苍狼", PageContext.SESSION_SCOPE);  //设置属性，并指明属性范围
    pageContext.setAttribute("date", new Date(), PageContext.SESSION_SCOPE); //设置属性，并指明属性范围
//    response.sendRedirect("/jsp/pageScopeDemo05.jsp");
%>
<jsp:forward page="/jsp/pageScopeDemo05.jsp"/>

</body>
</html>