package com.demo.java.web.filter;

import com.demo.java.web.dao.UserDao;
import com.demo.java.web.domain.User;
import com.demo.java.web.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理用户自动登录的过滤器：AutoLoginFilter
 *
 * @author liuxl
 * @date 2018/5/18 13:13
 */
public class AutoLoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        //如果已经登录了，就直接chain.doFilter(request, response)放行
        if (request.getSession().getAttribute("user") != null) {
            chain.doFilter(request, response);
            return;
        }

        //1.得到用户带过来的authlogin的cookie
        String value = null;
        Cookie cookies[] = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if (cookies[i].getName().equals("autologin")) {
                value = cookies[i].getValue();
            }
        }

        //2.得到 cookie中的用户名和密码 
        if (value != null) {
            String username = value.split("\\.")[0];
            String password = value.split("\\.")[1];

            //3.调用dao获取用户对应的密码
            UserDao dao = new UserDao();
            User user = dao.find(username);
            String dbpassword = user.getPassword();

            //4.检查用户带过来的md5的密码和数据库中的密码是否匹配,如匹配则自动登陆
            if (password.equals(WebUtils.md5(dbpassword))) {
                request.getSession().setAttribute("user", user);
            }
        }

        chain.doFilter(request, response);
    }

    public void destroy() {

    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }
}