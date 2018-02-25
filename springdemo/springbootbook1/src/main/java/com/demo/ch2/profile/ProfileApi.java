package com.demo.ch2.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProfileApi {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        String[] profiles = {"dev", "prod"};
        context.getEnvironment().setActiveProfiles(profiles);
        context.register(ProfileConfig.class);
        context.refresh();

        ProfileBean devBean = (ProfileBean) context.getBean("devProfileBean");
        ProfileBean prodBean = (ProfileBean) context.getBean("prodProfileBean");
        System.out.println(devBean.getContent());
        System.out.println(prodBean.getContent());
    }
}
