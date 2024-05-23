<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.demo.java.web.listener.JavaBeanDemo1" %>
<!DOCTYPE HTML>
<html>
<head>
    <title></title>
</head>

<body>
<%
    //将javabean对象绑定到Session中
    session.setAttribute("bean",new JavaBeanDemo1("孤傲苍狼"));
    //从Session中删除javabean对象
    session.removeAttribute("bean");
%>
</body>
</html>