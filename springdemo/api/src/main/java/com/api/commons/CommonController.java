package com.api.commons;

import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CommonController {
    @RequestMapping("/")
    public String index(HttpServletResponse response) throws IOException {
//        response.sendRedirect("/mybatis/index2.html");
//        response.sendRedirect("/redis/index2.html");
        return "redirect:/mybatis/index3.html";
    }
}
