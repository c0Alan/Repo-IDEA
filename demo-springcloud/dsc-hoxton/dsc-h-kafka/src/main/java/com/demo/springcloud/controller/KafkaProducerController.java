package com.demo.springcloud.controller;

import com.demo.springcloud.remote.kafka.KafkaProducerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * kafka 生产者 controller
 *
 * @author liuxilin
 * @date 2022/2/19 21:19
 */
@Api(tags = "kafka消息生产者服务")
@Slf4j
@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @ApiOperation(value = "发送单条消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topic", value = "topic", defaultValue = "q_dsc_", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "msg", value = "发送的消息", defaultValue = "message", required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/send")
    public void send(@RequestParam String topic, @RequestParam String msg) {
        kafkaProducerService.send(topic, msg);
    }

}
