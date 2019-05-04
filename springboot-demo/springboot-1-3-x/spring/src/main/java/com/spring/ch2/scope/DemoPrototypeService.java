package com.spring.ch2.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 原型
 * 
 * @author liuxilin
 * @date 2018/6/10 18:42
 */
@Service
@Scope("prototype")//1
public class DemoPrototypeService {

}
