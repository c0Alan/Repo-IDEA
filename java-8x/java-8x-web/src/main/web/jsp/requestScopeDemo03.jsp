<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*"%>
<%
    request.setAttribute("name","孤傲苍狼");
    request.setAttribute("date",new Date());
    String refName = (String)request.getAttribute("name");
    Date refDate = (Date)request.getAttribute("date");
%>
<h1>姓名：<%=refName%></h1>
<h1>日期：<%=refDate%></h1>
<h1>
    <%--使用超链接的形式跳转，这是客户端跳转，URL地址会改变--%>
    <a href="${pageContext.request.contextPath}/jsp/requestScopeDemo04.jsp">跳转到requestScopeDemo04.jsp</a>
</h1>