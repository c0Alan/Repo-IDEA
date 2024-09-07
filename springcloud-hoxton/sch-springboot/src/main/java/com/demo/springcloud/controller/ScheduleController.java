package com.demo.springcloud.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

/**
 * 动态定时任务
 *
 * @author liuxl
 * @date 2024/9/5
 */
@Api(tags = "动态定时任务")
@Slf4j
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    private final static Map<String, Task> taskMap = new HashMap<String, Task>();

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;


    /**
     * 创建定时任务
     */
    @ApiOperation(value = "startTask")
    @GetMapping("/startTask/{id}")
    public String start(@PathVariable("id") String id) {
        if (StringUtils.isNotEmpty(id) && !taskMap.containsKey(id)) {
            Task task = new Task(id);
            ScheduledFuture<?> future = threadPoolTaskScheduler.schedule(task.getRunnable(),
                    new Trigger() {
                        public Date nextExecutionTime(TriggerContext triggerContext) {
                            return new CronTrigger(task.getCron())
                                    .nextExecutionTime(triggerContext);
                        }
                    }
            );
            task.setScheduledFuture(future);
            taskMap.put(task.getTaskId(), task);
        }
        return "success";
    }

    /**
     * 更新定时任务的cron
     */
    @ApiOperation(value = "updateCron")
    @PostMapping("/updateCron/{id}")
    public String updateCron(@RequestBody String cron, @PathVariable("id") String id) {
        if (taskMap.containsKey(id)) {
            Task task = taskMap.get(id);
            ScheduledFuture<?> future = null;
            try {
                future = threadPoolTaskScheduler.schedule(task.getRunnable(),
                        new Trigger() {
                            public Date nextExecutionTime(TriggerContext triggerContext) {
                                return new CronTrigger(cron).nextExecutionTime(triggerContext);
                            }
                        }
                );
            } catch (Exception e) {
                return "error";
            }
            task.getScheduledFuture().cancel(true);
            task.setScheduledFuture(future);
        }
        return "success";
    }

    /**
     * 删除定时任务
     */
    @GetMapping("/stopTask/{id}")
    public String stopTask(@PathVariable("id") String id) {
        if (taskMap.containsKey(id)) {
            Task task = taskMap.get(id);
            task.getScheduledFuture().cancel(true);
            taskMap.remove(id);
        }
        return "success";
    }

    @Slf4j
    @Data
    static class Task {
        private String taskId;
        private Runnable runnable;
        private ScheduledFuture scheduledFuture;
        private String cron;

        public Task(String taskId) {
            this.taskId = taskId;
            runnable = () -> {
                log.info("动态定时任务, taskId:" + taskId);
            };
            cron = "0/5 * * * * ?";
        }
    }
}