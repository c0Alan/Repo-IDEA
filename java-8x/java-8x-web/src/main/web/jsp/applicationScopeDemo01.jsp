<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%
    //此时设置的属性任何用户都可以取得
    application.setAttribute("name","孤傲苍狼");  //设置属性
    application.setAttribute("date",new Date());
%>
<h1><a href="${pageContext.request.contextPath}/jsp/applicationScopeDemo02.jsp">applicationScopeDemo02</a></h1>