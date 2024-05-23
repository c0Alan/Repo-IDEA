package com.demo.java.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 统计当前在线用户个数
 * 
 * @author liuxl
 * @date 2018/5/18 13:19
 */
public class OnLineCountListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer onLineCount = (Integer) context.getAttribute("onLineCount");
        if(onLineCount==null){
            context.setAttribute("onLineCount", 1);
        }else{
            onLineCount++;
            context.setAttribute("onLineCount", onLineCount);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer onLineCount = (Integer) context.getAttribute("onLineCount");
        if(onLineCount==null){
            context.setAttribute("onLineCount", 1);
        }else{
            onLineCount--;
            context.setAttribute("onLineCount", onLineCount);
        }
    }
}