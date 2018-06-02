package com.spring.demo02;
import com.spring.demo02.action.UserAction;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo03 {

    public static void main(String[] args) {

        //1. 创建 IOC 容器
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/demo02/applicationContext-annotation.xml");

        UserAction userAction = (UserAction) ctx.getBean("userAction");
        userAction.execute();
    }

}
