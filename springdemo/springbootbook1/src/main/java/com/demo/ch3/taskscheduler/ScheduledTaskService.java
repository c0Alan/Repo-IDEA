package com.demo.ch3.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduledTaskService {
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void printTime(){
        System.out.println("隔5秒执行一次: " + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 22 10 ? * *")
    public void fixedTimeTask(){
        System.out.println("指定时间执行的任务: " + dateFormat.format(new Date()));
    }
}
