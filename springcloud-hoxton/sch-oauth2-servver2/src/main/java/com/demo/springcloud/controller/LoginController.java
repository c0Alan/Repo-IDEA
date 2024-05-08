package com.demo.springcloud.controller;


import com.demo.springcloud.entity.BaseController;
import com.demo.springcloud.service.SysUserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录管理
 *
 * @author lc
 */
@Api(tags = "登录管理")
@Slf4j
@CrossOrigin
@Controller
public class LoginController extends BaseController {

    @Autowired
    private SysUserService userService;

    /**
     * 自定义登录页面
     *
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 登录成功后显示的首页
     *
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("oauth/exit")
    public void exit(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, null, null);
        try {
            System.out.println(request.getHeader("referer"));
            response.sendRedirect(request.getHeader("referer"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
