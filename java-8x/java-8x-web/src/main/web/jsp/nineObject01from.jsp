<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<meta charset="UTF-8">
<head>
    <title>九个内置对象 nineObject01from.jsp</title>
</head>
<%
    pageContext.setAttribute("name1", "pageContext");  // forward 为空, redirect 为空
    request.setAttribute("name2", "request"); // redirect 为空
    session.setAttribute("name3", "session"); // 不同浏览器为空
    application.setAttribute("name4", "application"); // 全局有效application=servletContext
    config.getServletContext().setAttribute("name5", "servletContext");

    response.sendRedirect("/jsp/nineObject01to01.jsp");
%>
<%--<jsp:forward page="/jsp/nineObject01to01.jsp"/>--%>