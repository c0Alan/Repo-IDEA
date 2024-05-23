package com.demo.java.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用Decorator模式包装request对象实现敏感字符过滤功能
 *
 * @author liuxilin
 * @date 2018/5/17 21:53
 */
public class DirtyFilter implements Filter {

    private FilterConfig config = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        DirtyRequest dirtyrequest = new DirtyRequest(request);

        chain.doFilter(dirtyrequest, response);
    }

    @Override
    public void destroy() {

    }

    /**
     * 获取敏感字符
     *
     * @return
     */
    private List<String> getDirtyWords() {
        List<String> dirtyWords = new ArrayList<String>();
        String dirtyWordPath = config.getInitParameter("dirtyWord");
        InputStream inputStream = config.getServletContext().getResourceAsStream(dirtyWordPath);
        InputStreamReader is = null;
        try {
            is = new InputStreamReader(inputStream, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(is);
        String line;
        try {
            while ((line = reader.readLine()) != null) {//如果 line为空说明读完了
                dirtyWords.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dirtyWords;
    }

    /**
     * 使用Decorator模式包装request对象，实现敏感字符过滤功能
     */
    class DirtyRequest extends HttpServletRequestWrapper {

        private List<String> dirtyWords = getDirtyWords();
        private HttpServletRequest request;

        public DirtyRequest(HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        /* 重写getParameter方法，实现对敏感字符的过滤
         * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
         */
        @Override
        public String getParameter(String name) {

            String value = this.request.getParameter(name);
            if (value == null) {
                return null;
            }

            for (String dirtyWord : dirtyWords) {
                if (value.contains(dirtyWord)) {
                    System.out.println("内容中包含敏感词：" + dirtyWord + "，将会被替换成***");
                    //替换敏感字符
                    value = value.replace(dirtyWord, "***");
                }
            }
            return value;
        }
    }
}