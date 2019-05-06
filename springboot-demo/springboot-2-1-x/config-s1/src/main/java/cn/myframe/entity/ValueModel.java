package cn.myframe.entity;

import lombok.Data;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Data
@Component
@PropertySource("classpath:application.yml")
public class ValueModel {

    /** 注入普通字符串 */
    @Value("I LOVE YOU!")
    private String normal;

    /** 注入操作系统属性 */
    @Value("#{systemProperties['os.name']}")
    private String osName;

    /** 注入表达式结果 */
    @Value("#{T(java.lang.Math).random() * 100.0}")
    private String randomNumber;

    /** 注入其他Bean属性 */
    @Value("#{user.address}")
    private String address;

    /** 注入文件资源 */
    @Value("classpath:/test.txt")
    private Resource testFile;

    /** 注入网址资源 */
    @Value("http://www.baidu.com")
    private Resource testUrl;

    /** 注入配置文件 */
    @Value("${myframe.user.name}")
    private String userName;

    /** 注入配置文件 */
    @Autowired
    private Environment environment;

    /** 注入配置文件 */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource() {
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(address);
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(userName);
            System.out.println(environment.getProperty("myframe.user.name"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
