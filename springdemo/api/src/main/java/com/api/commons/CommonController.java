package com.api.commons;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CommonController {

    public CommonController() {
        System.out.println("CommonController created!");
    }

    @RequestMapping("/")
    public String index(HttpServletResponse response) throws IOException {
        /** mybatis redis hibernate */
        return "redirect:/hibernate/index.html";
    }
}
