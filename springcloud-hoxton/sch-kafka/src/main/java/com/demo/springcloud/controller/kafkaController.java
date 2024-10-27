package com.demo.springcloud.controller;

import cn.hutool.json.JSONUtil;
import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.response.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * kafka 消息发送
 *
 * @author liuxl
 * @date 2024/10/21
 */
@Api("kafka消息发送")
@RestController
@RequestMapping("/kafka")
public class kafkaController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/send/{message}")
    public ResponseResult sendNormalMessage(@PathVariable("message") String message) {
        kafkaTemplate.send("Q_TEST", message);
        return ResponseResult.success();
    }

    @PostMapping
    public ResponseResult sendMessage(@RequestBody SysUser user) {
        kafkaTemplate.send("Q_TEST", JSONUtil.toJsonStr(user));
        return ResponseResult.success();
    }

}
 