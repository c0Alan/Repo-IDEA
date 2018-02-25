package com.demo.ch1.aop.aspect;

import com.demo.ch1.aop.annotation.Action;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(com.demo.ch1.aop.annotation.Action)")
    public void logPointcut(){}

    @After("logPointcut()")
    public void afterLog(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method  method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截: " + action.name() + method.getDeclaringClass());
    }

    @Before("execution(* com.demo.ch1.aop.service.AopMethodService.*(..))")
    public void beforeLog(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法式拦截: " + method.getName() + method.getDeclaringClass());
    }
}
