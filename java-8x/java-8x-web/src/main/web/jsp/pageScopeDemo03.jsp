<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%
    String refName = (String)pageContext.getAttribute("name");
    Date refDate = (Date)pageContext.getAttribute("date");
%>
<h1>姓名：<%=refName%></h1>
<h1>日期：<%=refDate%></h1>