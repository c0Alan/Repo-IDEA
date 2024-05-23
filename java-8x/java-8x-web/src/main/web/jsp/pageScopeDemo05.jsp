<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; utf-8">
    <title>jsp:useBean</title>
</head>

<body>
<% request.setCharacterEncoding("UTF-8") ;%>

<%
    //使用request对象获取属性
    String refName = (String)request.getAttribute("name");
    Date refDate = (Date)request.getAttribute("date");
    //也可以使用pageContext对象获取属性，只要在获取时指明对象的属性范围即可
    String refName2 = (String)pageContext.getAttribute("name", PageContext.SESSION_SCOPE);
    Date refDate2 = (Date)pageContext.getAttribute("date", PageContext.SESSION_SCOPE);
%>
使用request对象获取属性：
<h1>姓名：<%=refName%></h1>
<h1>日期：<%=refDate%></h1>
使用pageContext对象获取属性：
<h1>姓名：<%=refName2%></h1>
<h1>日期：<%=refDate2%></h1>

</body>
</html>