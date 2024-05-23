<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%
    String refName = (String)application.getAttribute("name");
    Date refDate = (Date)application.getAttribute("date");
%>
<h1>ÐÕÃû£º<%=refName%></h1>
<h1>ÈÕÆÚ£º<%=refDate%></h1>