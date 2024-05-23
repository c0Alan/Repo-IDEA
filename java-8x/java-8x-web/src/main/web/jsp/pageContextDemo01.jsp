<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*"%>
<%
    //此时设置的属性只能够在本页中取得
    pageContext.setAttribute("name","孤傲苍狼");  //设置属性
    pageContext.setAttribute("date",new Date()); //设置属性
    //注意：这里设置的两个属性的名字分别为name和date，这两个是字符串类型的数据，但对应的属性值MLDN和new Date这个两个值却不是字符串类型，而是两个Object类型的数据。
%>
<%
    //取得设置的属性
    String refName = (String)pageContext.getAttribute("name");
    //由于取得的值为Object类型，因此必须使用String强制向下转型，转换成String类型
    Date refDate = (Date)pageContext.getAttribute("date");
%>
<h1>姓名：<%=refName%></h1>
<h1>日期：<%=refDate%></h1>