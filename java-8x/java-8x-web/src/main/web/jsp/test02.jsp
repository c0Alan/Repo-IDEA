<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<meta charset="UTF-8">
<head>
    <title>pageContext的findAttribute方法查找属性值</title>
</head>
<%
    pageContext.setAttribute("name1", "pageContext");
    request.setAttribute("name2", "request");
    session.setAttribute("name3", "session");
    application.setAttribute("name4", "application");
%>
<%
    //使用pageContext的findAttribute方法查找属性，由于取得的值为Object类型，因此必须使用String强制向下转型，转换成String类型
    //查找name1属性，按照顺序"page→request→session→application"在这四个对象中去查找
    String refName1 = (String)pageContext.findAttribute("name1");
    String refName2 = (String)pageContext.findAttribute("name2");
    String refName3 = (String)pageContext.findAttribute("name3");
    String refName4 = (String)pageContext.findAttribute("name4");
    String refName5 = (String)pageContext.findAttribute("name5");//查找一个不存在的属性
%>
<h1>pageContext.findAttribute方法查找到的属性值：</h1>
<h3>pageContext对象的name1属性：<%=refName1%></h3>
<h3>request对象的name2属性：<%=refName2%></h3>
<h3>session对象的name3属性：<%=refName3%></h3>
<h3>application对象的name4属性：<%=refName4%></h3>
<h3>查找不存在的name5属性：<%=refName5%></h3>
<hr/>
<h1>使用EL表达式进行输出：</h1>
<h3>pageContext对象的name1属性：${name1}</h3>
<h3>request对象的name2属性：${name2}</h3>
<h3>session对象的name3属性：${name3}</h3>
<h3>application对象的name4属性：${name4}</h3>
<h3>不存在的name5属性：${name5}</h3>