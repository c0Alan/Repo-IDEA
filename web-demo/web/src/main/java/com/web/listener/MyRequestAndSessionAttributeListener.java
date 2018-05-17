package com.web.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.text.MessageFormat;

/**
 * 编写监听器监听HttpSession和HttpServletRequest域对象的属性值变化情况
 * 
 * @author liuxilin
 * @date 2018/5/17 22:46
 */
public class MyRequestAndSessionAttributeListener implements
        HttpSessionAttributeListener, ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        String str = MessageFormat.format(
                "ServletRequest域对象中添加了属性:{0}，属性值是:{1}"
                ,srae.getName()
                ,srae.getValue());
        System.out.println(str);
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        String str =MessageFormat.format(
                "ServletRequest域对象中删除属性:{0}，属性值是:{1}"
                ,srae.getName()
                ,srae.getValue());
        System.out.println(str);
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        String str =MessageFormat.format(
                "ServletRequest域对象中替换了属性:{0}的值"
                ,srae.getName());
        System.out.println(str);
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        String str =MessageFormat.format(
                "HttpSession域对象中添加了属性:{0}，属性值是:{1}"
                ,se.getName()
                ,se.getValue());
        System.out.println(str);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        String str =MessageFormat.format(
                "HttpSession域对象中删除属性:{0}，属性值是:{1}"
                ,se.getName()
                ,se.getValue());
        System.out.println(str);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        String str =MessageFormat.format(
                "HttpSession域对象中替换了属性:{0}的值"
                ,se.getName());
        System.out.println(str);
    }
}