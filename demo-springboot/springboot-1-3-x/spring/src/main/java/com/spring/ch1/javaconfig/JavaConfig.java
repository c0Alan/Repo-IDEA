package com.spring.ch1.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义配置类
 * 
 * @author liuxilin
 * @date 2018/6/10 17:26
 */
@Configuration
public class JavaConfig {
    /**
     * 实例化bean, bean 名称为方法名
     * @return
     */
    @Bean //2
    public FunctionService functionService() {
        return new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService() {
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService()); // 注入依赖的bean
        return useFunctionService;

    }

    /**
     * 通过方法传参的方式注入依赖bean
     */
//	@Bean 
//	public UseFunctionService useFunctionService(FunctionService functionService){//4
//		UseFunctionService useFunctionService = new UseFunctionService();
//		useFunctionService.setFunctionService(functionService);
//		return useFunctionService;
//	}
}
