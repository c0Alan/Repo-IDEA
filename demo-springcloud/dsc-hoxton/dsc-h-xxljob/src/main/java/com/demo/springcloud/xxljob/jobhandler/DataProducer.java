package com.demo.springcloud.xxljob.jobhandler;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.demo.springcloud.service.KafkaService;
import com.demo.springcloud.service.ToolService;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 数据生成者
 *
 * @author liuxilin
 * @date 2022/2/21 22:17
 */
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
        JSONObject userJsonObject = JSONUtil.parseObj(userData);
        String topic = userJsonObject.getJSONObject("kafka").getStr("topic");
        JSONArray userList = userJsonObject.getJSONArray("data");
        userList.forEach(user -> {
            kafkaService.send(topic, user.toString());
        });
        log.info("result:{}", userData);
        log.info("xxljob-userProducer finish");
    }


}
