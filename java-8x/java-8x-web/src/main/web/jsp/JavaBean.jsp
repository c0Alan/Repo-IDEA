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
<%
    //person对象在上面已经使用jsp:useBean标签实例化了，因此在这里可以直接使用person对象
    //使用setXxx方法为对象的属性赋值
    //为person对象的name属性赋值
    person.setName("孤傲苍狼");
    //为person对象的Sex属性赋值
    person.setSex("男");
    //为person对象的Age属性赋值
    person.setAge(24);
    //为person对象的married属性赋值
    person.setMarried(false);
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>jsp:useBean标签使用范例</title>
</head>

<body>
<%--使用getXxx()方法获取对象的属性值 --%>
<h2>姓名：<%=person.getName()%></h2>
<h2>性别：<%=person.getSex()%></h2>
<h2>年龄：<%=person.getAge()%></h2>
<h2>已婚：<%=person.isMarried()%></h2>
</body>
</html>