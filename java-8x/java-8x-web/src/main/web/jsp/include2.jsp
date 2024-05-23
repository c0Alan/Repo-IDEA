<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<h1>JspIncludeTagDemo02.jsp</h1>
<%!
    int i=10;
%>

<h1>JspIncludeTagDemo02.jsp中i的值为：<%=i%></h1>
<%--<h1><%@include file="/jsp/include.jsp"%></h1>--%>
<h1><jsp:include page="/jsp/include.jsp" /></h1>