<%@ page language="java" import="java.util.*" errorPage="/error/error.jsp" pageEncoding="UTF-8" %>
<html>
<head>
    <title>测试page指令的errorPage属性</title>
</head>
<body>
<%
    //这行代码肯定会出错，因为除数是0，一运行就会抛出异常
    int x = 1 / 0;
%>
</body>
</html>