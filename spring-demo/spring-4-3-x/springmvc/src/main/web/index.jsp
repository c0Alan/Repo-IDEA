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
</head>
<body>

<div class="container" style="margin-top: 10px; margin-left: 10px;">
    <h2>测试列表</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>测试内容</th>
            <th>测试链接</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Hello World</td>
            <td><a href="helloworld">Hello World</a></td>
        </tr>
        <tr>
            <td>简单的 RequestMapping</td>
            <td><a href="mvc/testRequestMapping">testRequestMapping</a></td>
        </tr>
        <tr>
            <td>测试 GET 方法 (method = RequestMethod.POST, 所以报错)</td>
            <td><a href="mvc/testMethod">testMethod</a></td>
        </tr>
        <tr>
            <td>测试 POST 方法</td>
            <td>
                <form action="mvc/testMethod" method="POST">
                    <input class="btn btn-primary" type="submit" value="submit"/>
                </form>
            </td>
        </tr>
        <tr>
            <td>设置请求参数及请求头(修改年龄不等于10, 及请求头就不会报错了)</td>
            <td><a href="mvc/testParamsAndHeaders?username=atguigu&age=10">testParamsAndHeaders</a></td>
        </tr>
        <tr>
            <td>测试 Ant 风格路劲</td>
            <td><a href="mvc/testAntPath/mnxyz/abc">testAntPath</a></td>
        </tr>
        <tr>
            <td>测试 路径参数</td>
            <td><a href="mvc/testPathVariable/1">testPathVariable</a></td>
        </tr>
        <tr>
            <td>Restful 风格的get 查</td>
            <td><a href="mvc/testRest/1">Test Rest Get</a></td>
        </tr>
        <tr>
            <td>Restful 风格的 post 增</td>
            <td>
                <form action="mvc/testRest" method="post">
                    <input type="submit" class="btn btn-primary" value="TestRest POST"/>
                </form>
            </td>
        </tr>
        <tr>
            <td>Restful 风格的 delete 删</td>
            <td>
                <form action="mvc/testRest/1" method="post">
                    <input type="hidden" name="_method" value="DELETE"/>
                    <input type="submit" class="btn btn-primary" value="TestRest DELETE"/>
                </form>
            </td>
        </tr>
        <tr>
            <td>Restful 风格的 put 改</td>
            <td>
                <form action="mvc/testRest/1" method="post">
                    <input type="hidden" name="_method" value="PUT"/>
                    <input type="submit" class="btn btn-primary" value="TestRest PUT"/>
                </form>
            </td>
        </tr>
        <tr>
            <td>@RequestParam</td>
            <td><a href="mvc/testRequestParam?username=atguigu&age=11">Test RequestParam</a>
            </td>
        </tr>
        <tr>
            <td>@RequestHeader</td>
            <td><a href="mvc/testRequestHeader">Test RequestHeader</a>
            </td>
        </tr>
        <tr>
            <td>@CookieValue</td>
            <td><a href="mvc/testCookieValue">Test CookieValue</a>
            </td>
        </tr>
        <tr>
            <td>构造 pojo</td>
            <td>
                <form action="mvc/testPojo" method="post" >
                    <div class="form-group">
                        <label class="col-sm-2 control-label">
                            username:
                        </label>
                        <div class="col-sm-10">
                            <input class="form-control" type="text" name="username"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">
                            password:
                        </label>
                        <div class="col-sm-10">
                            <input class="form-control" type="password" name="password"/>
                        </div>

                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">
                            email:
                        </label>
                        <div class="col-sm-10">
                            <input class="form-control" type="text" name="email"/>
                        </div>

                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">
                            age:
                        </label>
                        <div class="col-sm-10">
                            <input class="form-control" type="text" name="age"/>
                        </div>

                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">
                            city:
                        </label>
                        <div class="col-sm-10">
                            <input class="form-control" type="text" name="address.city"/>
                        </div>

                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">
                            province:
                        </label>
                        <div class="col-sm-10">
                            <input class="form-control" type="text" name="address.province"/>
                        </div>

                    </div>
                    <input type="submit" value="Submit"/>
                </form>
            </td>
        </tr>

        <tr>
            <td>Servlet Api, HttpServletRequest, HttpServletResponse, Writer 等</td>
            <td><a href="mvc/testServletAPI">Test ServletAPI</a>
            </td>
        </tr>

        <tr>
            <td>构造 ModelAndView</td>
            <td><a href="mvc/testModelAndView">Test ModelAndView</a>
            </td>
        </tr>

        <tr>
            <td>构造 Map</td>
            <td><a href="mvc/testMap">Test Map</a>
            </td>
        </tr>

        <tr>
            <td>测试 @SessionAttributes</td>
            <td><a href="mvc/testSessionAttributes">Test SessionAttributes</a>
            </td>
        </tr>

        <tr>
            <td>测试 @ModelAttribute</td>
            <td>
                <form action="mvc/testModelAttribute" method="Post">
                    <input type="hidden" name="id" value="1"/>
                    username: <input type="text" name="username" value="Tom"/>
                    <br>
                    email: <input type="text" name="email" value="tom@atguigu.com"/>
                    <br>
                    age: <input type="text" name="age" value="12"/>
                    <br>
                    <input type="submit" value="Submit"/>
                </form>
            </td>
        </tr>

        <tr>
            <td>测试 视图和视图解析器</td>
            <td><a href="mvc/testViewAndViewResolver">Test ViewAndViewResolver</a>
            </td>
        </tr>

        <tr>
            <td>测试 视图</td>
            <td><a href="mvc/testView">Test View</a>
            </td>
        </tr>

        <tr>
            <td>测试 重定向</td>
            <td><a href="mvc/testRedirect">Test Redirect</a>
            </td>
        </tr>

        </tbody>
    </table>

</div>

</body>
</html>