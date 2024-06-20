package com.demo.springcloud.aop;
 
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
 
/**
 * aop 面向切面编程，日志切面功能
 * 参考：https://blog.csdn.net/weixin_41605937/article/details/115335283
 *
 * @author liuxl
 * @date 2024/6/17
 */
//@Aspect
//@Component
public class LogAspect2 {
 
    @Pointcut("execution(public * com.demo.springcloud.controller..*.*(..))*")
    public void pointCut(){};
 
    @Before("pointCut()")
    public void logStart(){
        System.out.println("查询之前打印日志....");
    }
 
    @After("pointCut()")
    public void logEnd(){
        System.out.println("查询之后打印日志....");
    }
 
    @AfterReturning("pointCut()")
    public void logReturn(){
        System.out.println("查询之后正常返回....");
    }
 
    @AfterThrowing("pointCut()")
    public void logException(){
        System.out.println("查询之后返回异常....");
    }
}