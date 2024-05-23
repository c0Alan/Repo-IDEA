package com.demo.java.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监听HttpSession域对象的创建和销毁
 * MyHttpSessionListener类实现了HttpSessionListener接口，
 * 因此可以对HttpSession对象的创建和销毁这两个动作进行监听。
 *
 * @author liuxilin
 * @date 2018/5/17 22:36
 */
public class MyHttpSessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(se.getSession() + "创建了！！");
    }

    /* HttpSession的销毁时机需要在web.xml中进行配置，如下：
     * <session-config>
              <session-timeout>1</session-timeout>
          </session-config>
          这样配置就表示session在1分钟之后就被销毁
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session销毁了！！");
    }
}