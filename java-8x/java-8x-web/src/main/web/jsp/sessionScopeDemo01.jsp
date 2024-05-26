<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*"%>
<%
    //此时设置的属性只能够在与本页相关的任何页面中取得
    session.setAttribute("name","孤傲苍狼");  //设置属性
    session.setAttribute("date",new Date());
//    response.sendRedirect("/jsp/sessionScopeDemo02.jsp");
%>
<%--使用服务器端跳转--%>
<jsp:forward page="/jsp/sessionScopeDemo02.jsp"/>