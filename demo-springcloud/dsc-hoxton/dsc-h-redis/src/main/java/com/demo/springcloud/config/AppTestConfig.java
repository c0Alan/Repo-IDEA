package com.demo.springcloud.config;

import com.demo.springcloud.entity.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author liuxilin
 * @date 2022年02月20日 11:02
 */
@Data
@Slf4j
@ConfigurationProperties(prefix = "app.test")
@Configuration
public class AppTestConfig {

    List<User> users;

    @PostConstruct
    public void init() {

        log.debug("{}", users);
    }
}
