<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>ServletContextAttributeListener监听器测试</title>
</head>

<body>
<%
    //往application域对象中添加属性
    application.setAttribute("name", "孤傲苍狼");
    //替换application域对象中name属性的值
    application.setAttribute("name", "gacl");
    //移除application域对象中name属性
    application.removeAttribute("name");
%>
</body>
</html>