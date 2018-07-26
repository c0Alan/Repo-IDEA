package com.suntek.vehicle.file.schedule;

import com.suntek.vehicle.file.service.IVehicleFileService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@EnableScheduling
public class SchedulingConfig {

    private static final Logger logger = Logger.getLogger(SchedulingConfig.class);

    @Autowired
    @Qualifier("vehicleFileKafkaService")
    IVehicleFileService vehicleFileKafkaService;

    @Autowired
    @Qualifier("vehicleFileZyfwService")
    IVehicleFileService vehicleFileZyfwService;

    @PostConstruct
    public void triggerKafkaJob(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                vehicleFileKafkaService.process();
            }
        }).start();
    }

    public void triggerZyfwJob(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                vehicleFileZyfwService.process();
            }
        }).start();
    }

    /**
     * 停止消费 kafka 消息服务 定时任务
     * 每天晚上 23:55:00 停止消费
     */
    @Scheduled(cron = "0 49 11 * * ? ")
    public void stopKafkaJob() {
        vehicleFileKafkaService.stop();
    }

    /**
     * 调用资源服务定时任务
     * 每 8 秒请求一次资源服务
     */
    @Scheduled(cron = "${vehicle-file.call.zyfw.rate}")
    public void processZyfwJob(){
        triggerZyfwJob();
    }

    /**
     * 消费 kafka 消息服务 定时任务
     * 每天晚上 00:01:00 开始任务
     */
    @Scheduled(cron = "0 */30 * * * ? ")
    public void processKafkaJob(){
        triggerKafkaJob();
    }
}