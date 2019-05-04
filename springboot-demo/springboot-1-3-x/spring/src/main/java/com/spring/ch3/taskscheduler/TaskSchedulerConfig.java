package com.spring.ch3.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.spring.ch3.taskscheduler")
@EnableScheduling // 开启定时任务支持
public class TaskSchedulerConfig {

}
