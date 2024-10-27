package com.demo.springcloud.filter;


import com.demo.springcloud.entity.Payload;
import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.utils.JwtHS256Util;
import com.demo.springcloud.utils.ResponseUtils;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 验证过滤器
 *
 * @author CaoChenLei
 */
public class JwtVerificationFilter extends BasicAuthenticationFilter {

    public JwtVerificationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            String header = request.getHeader("Authorization");
            if (header == null || !header.startsWith("Bearer ")) {
                //如果token的格式错误，则提示用户非法登录
//                chain.doFilter(request, response);
                ResponseUtils.write(response, HttpServletResponse.SC_FORBIDDEN, "用户非法登录！");
            } else {
                //如果token的格式正确，则先要获取到token
                String token = header.replace("Bearer ", "");
                //使用公钥进行解密然后来验证token是否正确
                Payload<SysUser> payload = JwtHS256Util.getInfoFromToken(token, SysUser.class);
                SysUser sysUser = payload.getUserInfo();
                if (sysUser != null) {
                    //定义权限列表.
                    List<GrantedAuthority> authorities = new ArrayList<>();
                    for (String roleId : sysUser.getRoleIds().split(",")){
                        // 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
                        authorities.add(new SimpleGrantedAuthority(roleId));
                    }
                    UsernamePasswordAuthenticationToken authResult = new UsernamePasswordAuthenticationToken(sysUser.getUsercode(), null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(authResult);
                    chain.doFilter(request, response);
                } else {
                    ResponseUtils.write(response, HttpServletResponse.SC_FORBIDDEN, "用户验证失败！");
                }
            }
        } catch (ExpiredJwtException e) {
            ResponseUtils.write(response, HttpServletResponse.SC_FORBIDDEN, "请您重新登录！");
        }
    }
}