<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.demo.java.web.listener.JavaBeanDemo1"%>
<%@page import="com.demo.java.web.listener.JavaBeanDemo2"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Spring MVC DEMOS</title>

    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
一访问JSP页面，HttpSession就创建了，创建好的Session的Id是：${pageContext.session.id}

<%--编写ServletContextAttributeListenerTest.jsp测试页面--%>
<%
    //往application域对象中添加属性
    application.setAttribute("name", "孤傲苍狼");
    //替换application域对象中name属性的值
    application.setAttribute("name", "gacl");
    //移除application域对象中name属性
    application.removeAttribute("name");
%>

<%--编写RequestAndSessionAttributeListenerTest.jsp测试页面--%>
<%
    //往session域对象中添加属性
    session.setAttribute("aa", "bb");
    //替换session域对象中aa属性的值
    session.setAttribute("aa", "xx");
    //移除session域对象中aa属性
    session.removeAttribute("aa");

    //往request域对象中添加属性
    request.setAttribute("aa", "bb");
    //替换request域对象中aa属性的值
    request.setAttribute("aa", "xx");
    //移除request域对象中aa属性
    request.removeAttribute("aa");
%>

<%--JavaBeanDemo1 测试--%>
<%
    //将javabean对象绑定到Session中
    session.setAttribute("bean",new JavaBeanDemo1("孤傲苍狼"));
    //从Session中删除javabean对象
    session.removeAttribute("bean");
%>

<%--jsp 测试 HttpSessionActivationListener接口 代码如下--%>
<%
    session.setAttribute("bean",new JavaBeanDemo2("孤傲苍狼"));
%>

<div class="container" style="margin-top: 10px; margin-left: 10px;">

    <h2>测试列表</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>测试内容</th>
            <th>测试链接</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>i18n01</td>
            <td><a href="${pageContext.request.contextPath}/i18n/i18n01.jsp">i18n01</a></td>
        </tr>
        <tr>
            <td>i18n02</td>
            <td><a href="${pageContext.request.contextPath}/i18n/i18n02.jsp">i18n02</a></td>
        </tr>
        <tr>
            <td>中文乱码-超链接(get方式请求)</td>
            <td><c:url value="/servlet/ServletDemo1" scope="page" var="servletDemo1">
                <%--构建的url的附带的中文参数 ，参数名是：username，值是：王安石--%>
                <c:param name="username" value="王安石"></c:param>
            </c:url>
                <%--使用get的方式访问 --%>
                <a href="${servletDemo1}">超链接(get方式请求)</a></td>
        </tr>
        <tr>
            <td>中文乱码-post方式提交</td>
            <td><%--使用post方式提交表单 --%>
                <form action="${pageContext.request.contextPath}/servlet/ServletDemo1" method="post">
                    用户名：<input type="text" name="username" value="柳宗元"/>
                    <input type="submit" value="post方式提交">
                </form>
            </td>
        </tr>
        <tr>
            <td>html标签转义</td>
            <td>
                <form action="${pageContext.request.contextPath}/servlet/ServletDemo2" method="post">
                    留言:
                    <textarea rows="8" cols="70" name="message">
           <script type="text/javascript">
           while (true) {
               alert("死循环了，我会不停地弹出了");
           }
           </script>
        <a href="http://www.cnblogs.com">访问博客园</a>
           </textarea>
                    <input type="submit" value="发表">
                </form>
            </td>
        </tr>
        </tbody>
    </table>
</div>

</body>
</html>