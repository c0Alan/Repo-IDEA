package com.demo.java.web.controller;

import com.demo.java.web.annotation.Controller;
import com.demo.java.web.annotation.RequestMapping;
import com.demo.java.web.annotation.View;

/**
 * 模拟实现 springmvc 的 Controller, 通过 AnnotationHandleServlet 实现
 * 使用Controller注解标注LoginUI类
 */
@Controller
public class LoginUI {

    //使用RequestMapping注解指明forward1方法的访问路径
    @RequestMapping("LoginUI/Login2")
    public View forward1(){
        //执行完forward1方法之后返回的视图
        return new View("/jsp/springmvcLogin2.jsp");
    }

    //使用RequestMapping注解指明forward2方法的访问路径
    @RequestMapping("LoginUI/Login3")
    public View forward2(){
        //执行完forward2方法之后返回的视图
        return new View("/jsp/springmvcLogin3.jsp");
    }
}