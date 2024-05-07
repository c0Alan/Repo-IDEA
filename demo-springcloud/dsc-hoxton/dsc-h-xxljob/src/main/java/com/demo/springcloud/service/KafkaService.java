package com.demo.springcloud.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${app.remote-service.dsc-h-kafka.service-name}",
url = "${app.remote-service.dsc-h-kafka.url:}")
public interface KafkaService {

    /**
     * 推送kafka消息
     * @return
     */
    @GetMapping(value = "/kafka/send")
    void send(@RequestParam String topic, @RequestParam String msg);

}
