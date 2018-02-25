package com.demo.ch2.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {
    @Bean
    @Profile("dev")
    public ProfileBean devProfileBean(){
        return new ProfileBean("this is dev profile bean");
    }

    @Bean
    @Profile("prod")
    public ProfileBean prodProfileBean(){
        return new ProfileBean("this is prod profile bean");
    }
}
