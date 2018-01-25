package com.api.commons;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class CommonController {
    @RequestMapping("/")
    public void index(HttpServletResponse response) throws IOException {
//        response.sendRedirect("/mybatis/index2.html");
        response.sendRedirect("/redis/index2.html");
    }
}
