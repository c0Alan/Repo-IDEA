<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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

<div class="container" style="margin-top: 10px; margin-left: 10px;">
    Hello world! <br/>
    <a href="${pageContext.request.contextPath}/jstl/catch.jsp">catch</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/choose.jsp">choose</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/forEach.jsp">forEach</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/forTokens.jsp">forTokens</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/if.jsp">if</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/import.jsp">import</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/out.jsp">out</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/redirect.jsp">redirect</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/remove.jsp">remove</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/set.jsp">set</a><br/>
    <a href="${pageContext.request.contextPath}/jstl/url.jsp">url</a><br/>

</div>

</body>
</html>