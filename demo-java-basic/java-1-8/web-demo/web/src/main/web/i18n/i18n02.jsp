<%@ page language="java"  import="java.util.*" pageEncoding="UTF-8"%>
<%--导入国际化标签库 --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>国际化(i18n)测试</title>
</head>
<%--
    //加载i18n资源文件，request.getLocale()获取访问用户所在的国家地区
    ResourceBundle myResourcesBundle = ResourceBundle.getBundle("me.gacl.i18n.resource.myproperties",request.getLocale());
--%>
<body>
<%--
<form action="" method="post">
    <%=myResourcesBundle.getString("username")%>：<input type="text" name="username"/><br/>
    <%=myResourcesBundle.getString("password")%>：<input type="password" name="password"/><br/>
    <input type="submit" value="<%=myResourcesBundle.getString("submit")%>">
</form>
--%>

<fmt:setBundle var="bundle"  basename="myproperties" scope="page"/>
<form action="">
    <fmt:message key="username" bundle="${bundle}"/><input type="text" name="username"><br/>
    <fmt:message key="password" bundle="${bundle}"/><input type="password" name="password"><br/>
    <input type="submit" value="<fmt:message key="submit" bundle="${bundle}"/>">
</form>
</body>
</html>