package com.demo.ch1.aop.service;

import com.demo.ch1.aop.annotation.Action;
import org.springframework.stereotype.Service;

/**
 * 通过注解的方式实现 aop 操作
 */
@Service
public class AopAnnotationService {
    @Action(name="注解式拦截的add操作")
    public void add(){}
}
