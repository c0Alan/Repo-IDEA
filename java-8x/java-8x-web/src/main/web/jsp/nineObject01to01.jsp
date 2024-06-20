<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<meta charset="UTF-8">
<head>
    <title>九个内置对象 nineObject01to01.jsp</title>
</head>

<%
    out.println("request: " + request.getClass());
    out.print("</br>");
    out.println("response: " + response.getClass());
    out.print("</br>");
    out.println("session: " + session.getClass());
    out.print("</br>");
    out.println("application: " + application.getClass());
    out.print("</br>");
    out.println("page: " + page.getClass());
    out.print("</br>");
    out.println("pageContext: " + pageContext.getClass());
    out.print("</br>");
    out.println("config: " + config.getClass());
    out.print("</br>");
    out.println("out: " + out.getClass());
    out.print("</br>");
    //使用pageContext的findAttribute方法查找属性，由于取得的值为Object类型，因此必须使用String强制向下转型，转换成String类型
    //查找name1属性，按照顺序"page→request→session→application"在这四个对象中去查找
    String refName1 = (String)pageContext.findAttribute("name1"); // forward 为空, redirect 为空
    String refName2 = (String)pageContext.findAttribute("name2"); // redirect 为空
    String refName3 = (String)pageContext.findAttribute("name3"); // 不同浏览器为空
    String refName4 = (String)pageContext.findAttribute("name4");
    String refName5 = (String)pageContext.findAttribute("name5"); // 查找一个不存在的属性
    String refName6 = (String)pageContext.findAttribute("name6"); // 查找一个不存在的属性

%>
<h1>pageContext.findAttribute方法查找到的属性值：</h1>
<h3>pageContext对象的name1属性：<%=refName1%></h3>
<h3>request对象的name2属性：<%=refName2%></h3>
<h3>session对象的name3属性：<%=refName3%></h3>
<h3>application对象的name4属性：<%=refName4%></h3>
<h3>servletContext对象的name5属性：<%=refName5%></h3>
<h3>查找不存在的name5属性：<%=refName6%></h3>
<hr/>
<h1>使用EL表达式进行输出：</h1>
<h3>pageContext对象的name1属性：${name1}</h3>
<h3>request对象的name2属性：${name2}</h3>
<h3>session对象的name3属性：${name3}</h3>
<h3>application对象的name4属性：${name4}</h3>
<h3>servletContext对象的name5属性：${name5}</h3>
<h3>不存在的name6属性：${name6}</h3>