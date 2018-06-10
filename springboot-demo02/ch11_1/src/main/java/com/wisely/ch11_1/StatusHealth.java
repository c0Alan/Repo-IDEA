package com.wisely.ch11_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 实现Healthlndicator 接口并重写health()方法。
 */
@Component
public class StatusHealth implements HealthIndicator {//1
    @Autowired
    StatusService statusService;

    /**
     * 1. 当status 的值为非running 时构造失败。
     * 2. 其余情况运行成功。
     *
     * @return
     */
    @Override
    public Health health() {
        String status = statusService.getStatus();
        if (status == null || !status.equals("running")) {
            return Health.down().withDetail("Error", "Not Running").build(); //2
        }
        return Health.up().build(); //3
    }

}
