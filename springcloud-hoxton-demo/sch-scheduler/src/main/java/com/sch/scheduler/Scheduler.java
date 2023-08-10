package com.sch.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 参考：https://blog.csdn.net/nbzhaomao/article/details/125730315
 *
 * @author liuxilin
 * @date 2023-08-10 22:59
 */
@Slf4j
@Component
public class Scheduler {


    /**
     * cron表达式，每6s执行一次
     * 到点才执行
     */
    @Scheduled(cron = "*/8 * * * * ?")
    private void scheduler1() {
        log.info("cron定时任务");
    }

    /**
     * fixedDelay表示上次调用结束后与下次调用之间的固定时间，单位是毫秒
     * 启动即刻执行
     */
    @Scheduled(fixedDelay = 8 * 1000)
    private void scheduler2() {
        log.info("fixedDelay定时任务");
    }
}
