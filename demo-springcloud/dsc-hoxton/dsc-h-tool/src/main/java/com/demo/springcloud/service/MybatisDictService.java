package com.demo.springcloud.service;

import com.demo.springcloud.entity.Dict;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "${app.remote-service.dsc-h-mybatis.service-name}",
url = "${app.remote-service.dsc-h-mybatis.url:}")
public interface MybatisDictService {
    @GetMapping(value = "/dict/getCurrentSysDictId")
    int getCurrentSysDictId();

    @PostMapping("/dict/saveDictList")
    int saveDictList(List<Dict> dictList);
}
