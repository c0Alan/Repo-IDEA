<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*"%>
<%
    //取得requestScopdemo01.jsp设置的属性
    String refName = (String)request.getAttribute("name");
    Date refDate = (Date)request.getAttribute("date");
%>
<h1>姓名：<%=refName%></h1>
<h1>日期：<%=refDate%></h1>