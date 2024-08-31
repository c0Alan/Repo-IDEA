package com.demo.springcloud.aop;

import com.demo.springcloud.entity.RequestLogDto;
import com.demo.springcloud.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * aop 面向切面编程，日志切面功能
 * 参考：https://blog.csdn.net/cowbin2012/article/details/85251655
 *
 * @author liuxl
 * @date 2024/6/17
 */
@Slf4j
@Aspect
@Order(3)   // 有多个日志时，ORDER可以定义切面的执行顺序（数字越大，前置越后执行，后置越前执行）
@Component
public class LogAspect {

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.demo.springcloud.controller..*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        log.info("AOP日志, URL : " + request.getRequestURL().toString());
        log.info("AOP日志, HTTP_METHOD : " + request.getMethod());
        log.info("AOP日志, IP : " + request.getRemoteAddr());
        log.info("AOP日志, CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("AOP日志, ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "log()")
    public void doAfterReturning(Object ret) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        if (ret instanceof ResponseResult){
            ((ResponseResult)ret).setRequestId(RequestLogDto.getRequestId(request));
        }

        // 处理完请求，返回内容
        log.info("AOP日志, RESPONSE : " + ret);
        log.info("AOP日志, SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }
}
