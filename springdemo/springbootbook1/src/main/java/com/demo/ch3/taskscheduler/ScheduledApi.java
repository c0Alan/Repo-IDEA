package com.demo.ch3.taskscheduler;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScheduledApi {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
    }
}
