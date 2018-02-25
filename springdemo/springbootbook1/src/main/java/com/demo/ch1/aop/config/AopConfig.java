package com.demo.ch1.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.demo.ch1.aop")
@EnableAspectJAutoProxy
public class AopConfig {
}
