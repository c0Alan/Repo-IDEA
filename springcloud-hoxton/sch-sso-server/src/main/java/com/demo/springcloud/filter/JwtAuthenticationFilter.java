package com.demo.springcloud.filter;


import cn.hutool.core.collection.CollectionUtil;
import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.utils.JwtHS256Util;
import com.demo.springcloud.utils.RequestUtils;
import com.demo.springcloud.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 认证过滤器
 *
 * @author CaoChenLei
 */
@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;


    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        SysUser sysUser = RequestUtils.read(request, SysUser.class);
        String usercode = sysUser.getUsercode();
        usercode = usercode != null ? usercode : "";
        String password = sysUser.getPassword();
        password = password != null ? password : "";
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(usercode, password);
        return authenticationManager.authenticate(authRequest);
    }

    /**
     * 认证成功所执行的方法
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) {
        SysUser sysUser = new SysUser();
        sysUser.setUsercode(authResult.getName());
        sysUser.setRoleIds(CollectionUtil.join(authResult.getAuthorities(), ","));
        String token = JwtHS256Util.createJwt(sysUser);
        response.addHeader("Authorization", "Bearer " + token);
        ResponseUtils.write(response, HttpServletResponse.SC_OK, "用户认证通过！");
    }

    /**
     * 认证失败所执行的方法
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) {
        //清理上下文
        SecurityContextHolder.clearContext();
        log.error("认证失败：", failed);
        //判断异常类
        if (failed instanceof InternalAuthenticationServiceException) {
            ResponseUtils.write(response, HttpServletResponse.SC_FORBIDDEN, "认证服务不正常！");
        } else if (failed instanceof UsernameNotFoundException) {
            ResponseUtils.write(response, HttpServletResponse.SC_FORBIDDEN, "用户账户不存在！");
        } else if (failed instanceof BadCredentialsException) {
            ResponseUtils.write(response, HttpServletResponse.SC_FORBIDDEN, "用户密码是错的！");
        } else if (failed instanceof AccountExpiredException) {
            ResponseUtils.write(response, HttpServletResponse.SC_FORBIDDEN, "用户账户已过期！");
        } else if (failed instanceof LockedException) {
            ResponseUtils.write(response, HttpServletResponse.SC_FORBIDDEN, "用户账户已被锁！");
        } else if (failed instanceof CredentialsExpiredException) {
            ResponseUtils.write(response, HttpServletResponse.SC_FORBIDDEN, "用户密码已失效！");
        } else if (failed instanceof DisabledException) {
            ResponseUtils.write(response, HttpServletResponse.SC_FORBIDDEN, "用户账户已被锁！");
        }
    }
}