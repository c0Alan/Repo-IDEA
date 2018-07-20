package com.kafka.test;

import com.kafka.utils.KafkaUtils;

public class Test {
    public Test() {
    }

    @org.junit.Test
    public void produce(){
        KafkaUtils.sendMsgToKafka("666");
    }

    @org.junit.Test
    public void consume(){
        KafkaUtils.getMsgFromKafka();
    }
}
