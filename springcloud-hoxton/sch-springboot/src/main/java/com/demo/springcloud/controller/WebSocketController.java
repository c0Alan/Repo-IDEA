package com.demo.springcloud.controller;

import com.demo.springcloud.websocket.WebSocketServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Api(tags = "websocket")
@RestController
@RequestMapping("/websocket")
public class WebSocketController {

    /**
     * 推送数据接口
     */
    @ApiOperation(value = "推送数据接口")
    @GetMapping("/socket/push/{cid}")
    public String pushToWeb(@PathVariable String cid, @RequestParam String message) {
        try {
            WebSocketServer.sendInfo(message, cid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }
}