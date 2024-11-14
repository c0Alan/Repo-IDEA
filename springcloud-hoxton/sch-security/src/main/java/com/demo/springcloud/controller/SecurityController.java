package com.demo.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录认证接口
 * 参考：https://www.cnblogs.com/Chary/p/17972919
 * 
 * @author liuxl
 * @date 2024/9/17
 */
@Slf4j
@Controller
@RequestMapping("/security")
public class SecurityController {
    
    
    @GetMapping("/login")
    public String loginPage(){
        log.info("login page");
        return "login";
    }

    /*@GetMapping("/index")
    @PreAuthorize("hasAnyRole('1','2')")
    public void index(HttpServletResponse response) throws IOException {
        log.info("index page");
        response.sendRedirect("/index");
    }*/

    @GetMapping("/index")
    @PreAuthorize("hasAnyRole('1','2')")
    public String index(Model model) {
        log.info("index page");
        model.addAttribute("data", "Hello Thymeleaf");
        return "index";
    }


    @GetMapping("/admin")
    @PreAuthorize("hasAnyRole('1')")
    @ResponseBody
    public String printAdmin(){
        log.info("hello admin");
        return "admin";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('1','2')")
    public String printUser(){
        log.info("hello user");
        return "user";
    }

    /**
     * 找不到页面
     */
    @GetMapping("/404")
    public String notFoundPage() {
        return "/error/404";
    }
    /**
     * 未授权
     */
    @GetMapping("/403")
    public String accessError() {
        return "/error/403";
    }
    /**
     * 服务器错误
     */
    @GetMapping("/500")
    public String internalError() {
        return "/error/500";
    }
}