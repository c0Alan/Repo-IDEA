package com.demo.springcloud.controller;

import com.demo.springcloud.xxljob.jobhandler.DataProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author liuxilin
 * @date 2022年02月21日 22:33
 */
@RestController
@RequestMapping("/DataProducer")
public class DataProducerController {
    @Autowired
    DataProducer dataProducer;

    @GetMapping("/produceUser")
    public void produceUser() throws Exception {
        dataProducer.userProducer();
    }
}
