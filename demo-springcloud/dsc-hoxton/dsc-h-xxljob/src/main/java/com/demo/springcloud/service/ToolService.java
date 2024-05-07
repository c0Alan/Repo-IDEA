package com.demo.springcloud.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "${app.remote-service.dsc-h-tool.service-name}",
        url = "${app.remote-service.dsc-h-tool.url:}")
public interface ToolService {

    /**
     * 获取随机数据列表
     *
     * @param size
     * @return
     */
    @GetMapping(value = "/baseData/getRandomDataList")
    Map getRandomDataList(@RequestParam String configFile, @RequestParam int size);

}
