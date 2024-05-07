package com.demo.springcloud.controller;

import com.demo.springcloud.remote.kafka.KafkaAdminService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * kafka admin controller
 * @author liuxilin
 * @date 2022/2/19 21:26
 */
@Slf4j
@RestController
public class KafkaAdminController {

    @Autowired
    private KafkaAdminService kafkaAdminService;

    @ApiOperation(value = "创建topic")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topicName", value = "topic名称",
                    defaultValue = "first_top", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "partitions", value = "分区数", defaultValue = "4",
                    required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "replicationFactor", value = "副本数", defaultValue = "1",
                    required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("/createTopic")
    public String createTopic(String topicName,int partitions,int replicationFactor){
        return kafkaAdminService.createTopic(topicName, partitions, replicationFactor);
    }

    @ApiOperation(value = "查看所有的topic")
    @GetMapping("/findAllTopic")
    public String findAllTopic() throws ExecutionException, InterruptedException {

        return kafkaAdminService.findAllTopic();
    }

    @ApiOperation(value = "查看topic详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topicName", value = "topic名称",defaultValue = "first_top",
                    required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/info")
    public String topicInfo(String topicName) throws ExecutionException, InterruptedException {

        return kafkaAdminService.topicInfo(topicName);
    }

    @ApiOperation(value = "删除topic")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "topicName", value = "topic名称",defaultValue = "first_top",
                    required = true, dataType = "string", paramType = "query")
    })
    @GetMapping("/delete")
    public String deleteTopic(String topicName){
        return kafkaAdminService.deleteTopic(topicName);
    }

}
