package com.demo.springcloud.servicefeign.clients.fallback;

import com.demo.springcloud.servicefeign.clients.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * Email miles02@163.com
 *
 * @author fangzhipeng
 * create 2018-07-09
 **/
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry, you are fail," + name;
    }

    @Override
    public String slowHiFromClientOne(String name, Integer delayTime) {
        return "sorry, you are fail," + name + ",delayTime:" + delayTime;
    }

    @Override
    public String notExistHiFromClientOne(String name) {
        return "sorry, you are fail," + name;
    }
}