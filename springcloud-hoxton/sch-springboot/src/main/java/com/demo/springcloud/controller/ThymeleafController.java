package com.demo.springcloud.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * thymeleaf 接口示例
 * 参考：https://blog.csdn.net/qq_60506984/article/details/128403838
 *
 * @author liuxl
 * @date 2024/9/17
 */
@Api(tags = "thymeleaf接口示例")
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
    @GetMapping("/index")
    public String find(Model model) {
        //向请求作用域中写入数据
        model.addAttribute("data", "Hello Thymeleaf");
        //返回视图
        return "index";
    }
}
