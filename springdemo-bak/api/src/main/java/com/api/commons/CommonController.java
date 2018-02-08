package com.api.commons;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CommonController {

    public CommonController() {
        System.out.println("CommonController inited");

    }

    @RequestMapping("/")
    public String index(HttpServletResponse response) throws IOException {
//        response.sendRedirect("/mybatis/index2.html");
//        response.sendRedirect("/redis/index2.html");
        return "redirect:/shiro/templates/index3.html";
    }
}
