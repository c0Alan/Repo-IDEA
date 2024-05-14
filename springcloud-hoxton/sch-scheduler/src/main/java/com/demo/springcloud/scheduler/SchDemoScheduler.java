package com.demo.springcloud.scheduler;

import com.demo.springcloud.remote.SchDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author liuxilin
 * @date 2023-08-10 22:59
 */
@Slf4j
@Component
public class SchDemoScheduler {

    @Autowired
    SchDemoService schDemoService;


    /**
     * cron表达式，每6s执行一次
     */
    @Scheduled(cron = "*/3 * * * * ?")
    private void callHello() {
        String result = schDemoService.hello("scheduler");
        log.info(result);
    }

}
