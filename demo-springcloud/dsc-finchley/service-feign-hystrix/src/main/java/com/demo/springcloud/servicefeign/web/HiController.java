package com.demo.springcloud.servicefeign.web;

import com.demo.springcloud.servicefeign.clients.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Email miles02@163.com
 *
 * @author fangzhipeng
 * create 2018-07-09
 **/
@RestController
public class HiController {


    /** 编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。 */
    @Autowired
    SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return schedualServiceHi.sayHiFromClientOne( name );
    }

    @GetMapping(value = "/slowHi")
    public String slowHi(@RequestParam(value = "name") String name,
                         @RequestParam(value = "delayTime") Integer delayTime) {

        return schedualServiceHi.slowHiFromClientOne(name, delayTime);
    }

    @GetMapping(value = "/notExistHi")
    public String notExistHi(@RequestParam String name) {
        return schedualServiceHi.notExistHiFromClientOne(name);
    }

}