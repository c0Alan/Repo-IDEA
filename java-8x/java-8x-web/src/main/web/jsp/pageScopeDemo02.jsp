<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%
    pageContext.setAttribute("name", "孤傲苍狼");
    pageContext.setAttribute("date", new Date());
//    response.sendRedirect("/jsp/pageScopeDemo03.jsp");
%>
<%--使用jsp:forward标签进行服务器端跳转--%>
<jsp:forward page="/jsp/pageScopeDemo03.jsp"/>