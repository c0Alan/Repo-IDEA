package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springboot.dao.PersonRepository;
import com.springboot.support.CustomRepositoryFactoryBean;

/**
 * 自定义 Repository
 * 在自己直类上配置 @EnableJpaRepositories ，并指定repositoryFactoryBeanClass ，
 * 让我们自定义的 Repository 实现起效口
 * 如果我们不需要自定义Repository 实现，则在Spring Data JPA 里无须添加@EnableJpaRepositories 注解，
 * 因为@SpringBootApplication包含的@EnableAutoConfiguration 已经开启了对Spring Data JPA 的支持
 *
 * @author liuxilin
 * @date 2018/6/13 22:57
 */
@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
public class Ch82Application {
    @Autowired
    PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(Ch82Application.class, args);

    }
}
