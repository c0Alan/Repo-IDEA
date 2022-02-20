package com.demo.springcloud.service.kafka;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutionException;

/**
 * kafka admin service
 *
 * @author liuxilin
 * @date 2022/2/19 21:26
 */
@Slf4j
@Service
public class KafkaAdminService {

    @Autowired
    private AdminClient adminClient;


    public String createTopic(String topicName, int partitions, int replicationFactor) {
        adminClient.createTopics(Arrays.asList(new NewTopic(topicName, partitions, (short) replicationFactor)));
        return "create success";
    }


    public String findAllTopic() throws ExecutionException, InterruptedException {
        ListTopicsResult result = adminClient.listTopics();
        Collection<TopicListing> list = result.listings().get();
        List<String> resultList = new ArrayList<>();
        for (TopicListing topicListing : list) {
            resultList.add(topicListing.name());
        }
        return JSON.toJSONString(resultList);
    }


    public String topicInfo(String topicName) throws ExecutionException, InterruptedException {
        DescribeTopicsResult result = adminClient.describeTopics(Arrays.asList(topicName));
        Map<String, String> resultMap = new HashMap<>();
        result.all().get().forEach((k, v) -> {
            log.info("k: " + k + " ,v: " + v.toString());
            resultMap.put(k, v.toString());
        });

        //  result.all().get().forEach((k,v)->System.out.println("k: "+k+" ,v: "+v.toString()+"\n\r"));
        return JSON.toJSONString(resultMap);
    }


    public String deleteTopic(String topicName) {
        DeleteTopicsResult result = adminClient.deleteTopics(Arrays.asList(topicName));
        return JSON.toJSONString(result.values());
    }

}
