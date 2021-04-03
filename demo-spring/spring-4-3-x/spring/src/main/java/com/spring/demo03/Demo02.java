package com.spring.demo03;

import com.spring.demo03.xml.ArithmeticCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo02 {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("/demo03/applicationContext-xml.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");

        System.out.println(arithmeticCalculator.getClass().getName());

        int result = arithmeticCalculator.add(1, 2);
        System.out.println("result:" + result);

        result = arithmeticCalculator.div(1000, 0);
        System.out.println("result:" + result);
    }

}
