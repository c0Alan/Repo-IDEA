<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%
    String refName = (String)application.getAttribute("name");
    Date refDate = (Date)application.getAttribute("date");
%>
<h1>������<%=refName%></h1>
<h1>���ڣ�<%=refDate%></h1>