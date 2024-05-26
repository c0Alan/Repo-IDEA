<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@ page import="java.util.concurrent.TimeUnit" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<meta charset="UTF-8">
<head>
    <title>使用pageContext的forward方法跳转页面</title>
</head>
pppppppppppppppppppppppp
<%
    //使用pageContext的forward方法跳转到pageContextDemo05.jsp页面，/代表了当前的web应用

//    response.sendRedirect("/jsp/test02.jsp"); // 正常编码
    pageContext.forward("/jsp/test02.jsp"); // 乱码
    //使用pageContext.forward(relativeUrlPath)替代RequestDispatcher.forward(relativeUrlPath)
    //使用RequestDispatcher的forward方法实现的跳转方式
//    pageContext.getRequest().getRequestDispatcher("/pageContextDemo05.jsp").forward(request, response);
%>