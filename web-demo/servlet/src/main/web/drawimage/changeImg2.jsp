<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>在Form表单中使用验证码</title>
    <script type="text/javascript">
        //刷新验证码
        function changeImg(obj,createTypeFlag){
            document.getElementById(obj.id).src="${pageContext.request.contextPath}/servlet/DrawImage?createTypeFlag="+createTypeFlag+"&"+Math.random();
        }
    </script>
</head>

<body>
<form action="${pageContext.request.contextPath}/servlet/CheckServlet" method="post">
    数字字母混合验证码：<input type="text" name="validateCode"/>
    <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/servlet/DrawImage" id="validateCodeImg1" onclick="changeImg(this,'nl')">
    <br/>
    中文验证码：<input type="text" name="validateCode"/>
    <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/servlet/DrawImage?createTypeFlag=ch" id="validateCodeImg2" onclick="changeImg(this,'ch')">
    <br/>
    英文验证码：<input type="text" name="validateCode"/>
    <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/servlet/DrawImage?createTypeFlag=l" id="validateCodeImg3" onclick="changeImg(this,'l')">
    <br/>
    数字验证码：<input type="text" name="validateCode"/>
    <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/servlet/DrawImage?createTypeFlag=n" id="validateCodeImg4" onclick="changeImg(this,'n')">
    <br/>
    <input type="submit" value="提交">
</form>
</body>
</html>