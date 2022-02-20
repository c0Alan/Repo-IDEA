package com.demo.springcloud.controller;

import com.demo.springcloud.service.kafka.KafkaProducerTestService;
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
@Api(tags = "kafka生产者测试服务")
@Slf4j
@RestController
@RequestMapping("/kafka/test")
public class KafkaProducerTestController {

    @Autowired
    private KafkaProducerTestService kafkaProducerTestService;

    @ApiOperation(value = "三种方式发消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topic", value = "topic", defaultValue = "q_dsc_test", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "msg", value = "发送的消息", defaultValue = "message", required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/send")
    public String send(@RequestParam String topic, @RequestParam String msg) {
        return kafkaProducerTestService.send(topic, msg);
    }

    @ApiOperation(value = "批量发消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topic", value = "topic", defaultValue = "q_dsc_test", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "count", value = "发送多少遍", defaultValue = "10", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "msg", value = "发送的消息", defaultValue = "message", required = true, dataType = "string", paramType = "query")
    })
    @GetMapping(value = "/batchSendMsg")
    public String batchSendMsg(@RequestParam String topic, @RequestParam int count, @RequestParam String msg) {

        return kafkaProducerTestService.batchSendMsg(topic, count, msg);
    }

    @ApiOperation(value = "消息结果回调")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topic", value = "topic", defaultValue = "q_dsc_test", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "msg", value = "发送的消息", defaultValue = "message", required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/producerListen")
    public String producerListen(@RequestParam String topic, @RequestParam String msg) throws InterruptedException {
        return kafkaProducerTestService.producerListen(topic, msg);
    }

    @ApiOperation(value = "发送同步消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topic", value = "topic", defaultValue = "q_dsc_test", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "msg", value = "发送的消息", defaultValue = "message", required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/syncMsg")
    public String syncMsg(@RequestParam String topic, @RequestParam String msg) {

        return kafkaProducerTestService.syncMsg(topic, msg);
    }


}
