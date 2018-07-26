package com.suntek.vehicle.file.kafka.consumer;

import org.apache.log4j.Logger;

public class Listener {
    protected final Logger logger = Logger.getLogger(this.getClass());

/*    @KafkaListener(topics = {"test"})
    public void listen(String record) {
        System.out.println(record);
//        logger.info("kafka的key: " + record);
    }*/
}