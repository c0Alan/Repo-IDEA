package com.demo.ch1.aop;

import com.demo.ch1.aop.config.AopConfig;
import com.demo.ch1.aop.service.AopAnnotationService;
import com.demo.ch1.aop.service.AopMethodService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopApi {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        AopAnnotationService annotationService = (AopAnnotationService)context.getBean("aopAnnotationService");
        AopMethodService methodService = (AopMethodService)context.getBean("aopMethodService");
        annotationService.add();
        methodService.add();
        context.close();
    }
}
