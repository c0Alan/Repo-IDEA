<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*"%>
<%
    String refName = (String)session.getAttribute("name");
    Date refDate = (Date)session.getAttribute("date");
%>
<h1>姓名：<%=refName%></h1>
<h1>日期：<%=refDate%></h1>