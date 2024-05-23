<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>forward</title>
</head>
<body>
aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
<%
    out.print("我是in1.jsp文件的内容 ");
    out.print("参数为:" + request.getParameter("param"));
%>
</body>
</html>