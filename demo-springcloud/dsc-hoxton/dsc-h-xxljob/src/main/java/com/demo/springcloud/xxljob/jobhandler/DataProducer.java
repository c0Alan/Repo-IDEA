package com.demo.springcloud.xxljob.jobhandler;

import com.demo.springcloud.service.KafkaService;
import com.demo.springcloud.service.ToolService;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@Slf4j
public class DataProducer {
    @Autowired
    KafkaService kafkaService;

    @Autowired
    ToolService toolService;

    /**
     * user 数据生成任务
     */
    @XxlJob("userProducer")
    public void userProducer() throws Exception {
        log.info("xxljob-userProducer start");

        Map userData = toolService.getRandomDataList("user.json", 5);
        log.info("result:{}", userData);
        log.info("xxljob-userProducer finish");
    }


}
