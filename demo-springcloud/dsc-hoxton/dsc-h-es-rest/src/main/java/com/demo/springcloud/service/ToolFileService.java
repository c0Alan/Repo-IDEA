package com.demo.springcloud.service;

import cn.hutool.json.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "${app.remote-service.dsc-h-tool.file-service}")
public interface ToolFileService {
    @GetMapping("/getJsonFile")
    JSONObject getJsonFile(@RequestParam String filename);
}
