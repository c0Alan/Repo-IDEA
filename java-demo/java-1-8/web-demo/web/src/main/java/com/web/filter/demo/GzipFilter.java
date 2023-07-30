package com.web.filter.demo;

import com.web.wrapper.BufferResponse;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * response增强案例——压缩响应正文内容
 * 压缩过滤器，将web应用中的文本都经过压缩后再输出到浏览器
 *
 * @author liuxilin
 * @date 2018/5/17 21:58
 */
public class GzipFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        BufferResponse myresponse = new BufferResponse(response);
        chain.doFilter(request, myresponse);
        //拿出缓存中的数据，压缩后再打给浏览器
        byte out[] = myresponse.getBuffer();
        System.out.println("原始大小:" + out.length);

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        //压缩输出流中的数据
        GZIPOutputStream gout = new GZIPOutputStream(bout);
        gout.write(out);
        gout.close();

        byte gzip[] = bout.toByteArray();
        System.out.println("压缩后的大小:" + gzip.length);

        response.setHeader("content-encoding", "gzip");
        response.setContentLength(gzip.length);
        response.getOutputStream().write(gzip);
    }

    public void destroy() {

    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }
}