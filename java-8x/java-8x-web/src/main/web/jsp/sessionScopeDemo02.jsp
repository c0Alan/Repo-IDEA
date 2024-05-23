<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*"%>
<%
    String refName = (String)session.getAttribute("name");
    Date refDate = (Date)session.getAttribute("date");
%>
<h1>姓名：<%=refName%></h1>
<h1>日期：<%=refDate%></h1>
<%--使用超链接这种客户端跳转--%>
<h1><a href="${pageContext.request.contextPath}/jsp/sessionScopeDemo03.jsp">sessionScopeDemo03</a></h1>