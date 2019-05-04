<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Spring MVC DEMOS</title>

    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/demo2.js"></script>
</head>
<body>

<div class="container" style="margin-top: 10px; margin-left: 10px;">
    <h2>Demo2 测试列表</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>测试内容</th>
            <th>测试链接</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>测试文件上传</td>
            <td>
                <%--依赖 spring-expression 包--%>
                <form action="demo2/testFileUpload" method="POST" enctype="multipart/form-data">
                    File: <input type="file" name="file"/>
                    Desc: <input type="text" name="desc"/>
                    <input type="submit" value="Submit"/>
                </form>
            </td>
        </tr>

        <tr>
            <td>列出所有员工列表</td>
            <td><a href="demo2/emps">List All Employees</a>
            </td>
        </tr>

        <tr>
            <td>测试 JSon 格式数据</td>
            <td><a href="demo2/testJson" id="testJson">Test Json</a>
            </td>
        </tr>

        <tr>
            <td>测试 数据转换器</td>
            <td>
                <%--<form action="demo2/testHttpMessageConverter" method="POST" enctype="multipart/form-data">--%>
                <form action="demo2/testHttpMessageConverter" method="POST">
                    <%--File: <input type="file" name="file"/>--%> <%--这里无法自动获取文件输入流, 暂时没有解决这个问题--%>
                    Desc: <input type="text" name="desc"/>
                    <input type="submit" value="Submit"/>
                </form>
            </td>
        </tr>

        <tr>
            <td>测试 @ResponseEntity</td>
            <td><a href="demo2/testResponseEntity">Test ResponseEntity</a>
            </td>
        </tr>

        <tr>
            <td>测试 I18n 国际化页面</td>
            <td><a href="demo2/i18n">I18N PAGE</a>
            </td>
        </tr>
        <tr>
            <td>测试 异常处理器 ExceptionHandlerExceptionResolver</td>
            <td><a href="demo2/testExceptionHandlerExceptionResolver?i=10">Test ExceptionHandlerExceptionResolver</a>
            </td>
        </tr>
        <tr>
            <td>测试 异常处理器 ResponseStatusExceptionResolver</td>
            <td><a href="demo2/testResponseStatusExceptionResolver?i=10">Test ResponseStatusExceptionResolver</a>
            </td>
        </tr>
        <tr>
            <td>测试 异常处理器 DefaultHandlerExceptionResolver</td>
            <td><a href="demo2/testDefaultHandlerExceptionResolver">Test DefaultHandlerExceptionResolver</a>
            </td>
        </tr>
        <tr>
            <td>测试 异常处理器 SimpleMappingExceptionResolver</td>
            <td><a href="demo2/testSimpleMappingExceptionResolver?i=2">Test SimpleMappingExceptionResolver</a>
            </td>
        </tr>
        </tbody>
    </table>
    <!--
        关于国际化:
        1. 在页面上能够根据浏览器语言设置的情况对文本(不是内容), 时间, 数值进行本地化处理
        2. 可以在 bean 中获取国际化资源文件 Locale 对应的消息
        3. 可以通过超链接切换 Locale, 而不再依赖于浏览器的语言设置情况

        解决:
        1. 使用 JSTL 的 fmt 标签
        2. 在 bean 中注入 ResourceBundleMessageSource 的示例, 使用其对应的 getMessage 方法即可
        3. 配置 LocalResolver 和 LocaleChangeInterceptor
    -->
</div>
</body>
</html>