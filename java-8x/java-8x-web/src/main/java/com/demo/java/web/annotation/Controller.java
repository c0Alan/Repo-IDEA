package com.demo.java.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @ClassName: Controller
* @Description: 自定义Controller注解
* @author: 孤傲苍狼
* @date: 2014-11-16 下午6:16:40
*
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Controller {

    public String value() default "";
}