<%@ page contentType="text/html;charset=GBK"%>
<%@ page import="java.util.*"%>
<%
    //��ʱ���õ������κ��û�������ȡ��
    application.setAttribute("name","�°�����");  //��������
    application.setAttribute("date",new Date());
%>
<h1><a href="${pageContext.request.contextPath}/jsp/applicationScopeDemo02.jsp">applicationScopeDemo02</a></h1>