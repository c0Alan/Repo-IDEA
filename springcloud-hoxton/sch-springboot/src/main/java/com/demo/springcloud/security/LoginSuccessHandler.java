package com.demo.springcloud.security;

import cn.hutool.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 登录成功处理
 *
 * @author liuxl
 * @date 2024/9/17
 */
@Slf4j
@Component("loginSuccessHandler")
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        // 获取前端传到后端的全部参数
        Enumeration enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = (String) enu.nextElement(); System.out.println("参数- " + paraName + " : " + request.getParameter(paraName));
        }
        logger.info("登录认证成功");
        //这里写你登录成功后的逻辑，可加验证码验证等

        //ajax请求认证方式
        JSONObject resultObj = new JSONObject();
        resultObj.put("code", HttpStatus.OK.value());
        resultObj.put("msg","登录成功");
        resultObj.put("authentication",objectMapper.writeValueAsString(authentication));
        response.getWriter().write(resultObj.toString());

        //表单认证方式
        //this.getRedirectStrategy().sendRedirect(request, response, "/index");//重定向
    }
}