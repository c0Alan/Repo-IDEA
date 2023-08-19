package com.demo.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

/**
 *
 * @author liuxilin
 * @date 2022/3/5 18:22
 */
@EnableSwagger2WebFlux
@Configuration
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("sch-gateway")
                .description("sch-gateway")
                .version("1.0")
                .contact(new Contact("c0","https://blog.csdn.net/c0tianning",""))
                .build();
    }

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        ApiSelectorBuilder builder = new Docket(DocumentationType.SWAGGER_2)
                .enableUrlTemplating(false)
                .apiInfo(apiInfo())
                // 选择那些路径和api会生成document
                .select()
                // 对所有api进行监控
                .apis(RequestHandlerSelectors.any())
                //这里可以自定义过滤
                .paths(this::filterPath);

        return builder.build();
    }

    private boolean filterPath(String path) {
        boolean ret = path.endsWith("/error");
        if (ret) {
            return false;
        }
        //这块可以写其他的过滤逻辑
        return true;
    }


}