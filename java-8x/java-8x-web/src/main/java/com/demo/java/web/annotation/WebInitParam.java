package com.demo.java.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @ClassName: WebInitParam
* @Description: 定义Servlet的初始化参数注解
* @author: 孤傲苍狼
* @date: 2014-10-1 下午3:25:53
*
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WebInitParam {
    //参数名
    String paramName() default "";
    //参数的值
    String paramValue() default "";
}