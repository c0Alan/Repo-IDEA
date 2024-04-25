package com.demo.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.springboot.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags= "UserController")
@Controller
public class UserController {
    @Reference(interfaceClass = UserService.class, version = "2.6.0", check = false)
    private UserService userService;

    @GetMapping("/count")
    @ResponseBody
    public String getCount() {
        int count = userService.getCount();
        return "当前在线的人数为:" + count;
    }
}
