package com.demo.ch2.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("com.demo.ch2.el")
@PropertySource("classpath:com/demo/ch2/el/test.properties")
public class ElConfig {
    @Value("Hello")
    private String hello;

    @Value("#{systemProperties['os.name']}")
    private String osName;

    @Value("#{ T(java.lang.Math).random() * 100.0 }") //3
    private double randomNumber;

    @Value("#{elService.serviceName}") //4
    private String serviceName;

    @Value("classpath:com/demo/ch2/el/test.txt") //5
    private Resource testFile;

    @Value("http://www.baidu.com") //6
    private Resource testUrl;

    @Value("${book.name}") //7
    private String bookName;

    @Autowired
    private Environment environment; //7

    @Bean //7
    public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource() {
        try {
            System.out.println(hello);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(serviceName);

            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
