package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.springboot.dao.PersonRepository;
import com.springboot.support.CustomRepositoryFactoryBean;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = CustomRepositoryFactoryBean.class)
public class Ch82Application {
	@Autowired
	PersonRepository personRepository;
	
	
    public static void main(String[] args) {
        SpringApplication.run(Ch82Application.class, args);
        
    }
    
 
}
