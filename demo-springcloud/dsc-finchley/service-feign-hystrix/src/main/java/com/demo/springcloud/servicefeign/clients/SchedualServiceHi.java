package com.demo.springcloud.servicefeign.clients;

import com.demo.springcloud.servicefeign.clients.fallback.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Email miles02@163.com
 *
 * @author fangzhipeng
 * create 2018-07-09
 **/
@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/slowHi", method = RequestMethod.GET)
    String slowHiFromClientOne(@RequestParam(value = "name") String name,
                               @RequestParam(value = "delayTime") Integer delayTime);

    @RequestMapping(value = "/notExistHi", method = RequestMethod.GET)
    String notExistHiFromClientOne(@RequestParam(value = "name") String name);
}

