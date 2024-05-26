<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--
在jsp中使用jsp:useBean标签来实例化一个Java类的对象
<jsp:useBean id="person" class="gacl.javabean.study.Person" scope="page"/>
    ┝<jsp:useBean>：表示在JSP中要使用JavaBean。
    ┝id:表示生成的实例化对象，凡是在标签中看见了id，则肯定表示一个实例对象。
    ┝class：此对象对应的包.类名称
    ┝scope：此javaBean的保存范围，四种范围：page、request、session、application
--%>
<jsp:useBean id="person" class="com.demo.java.web.domain.Person" scope="page"/>

<%--
    jsp:setProperty标签可以使用请求参数为bean的属性赋值
    param="param_name"用于接收参数名为param_name的参数值，然后将接收到的值赋给name属性
--%>
<jsp:setProperty property="name" name="person" param="param_name"/>

<!DOCTYPE HTML>
<html>
<head>
    <title>jsp:setProperty标签使用范例</title>
</head>

<body>
<%--使用getXxx()方法获取对象的属性值 --%>
<h2>姓名：<%=person.getName()%></h2>
</body>
</html>