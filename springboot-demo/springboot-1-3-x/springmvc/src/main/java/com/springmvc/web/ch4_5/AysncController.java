package com.springmvc.web.ch4_5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.springmvc.service.PushService;

/**
 * 服务器踹推送技术
 * 基于Servlet 3.0+ 的异步方法特性
 * 需要在MyMvcConfig 上开始计划任务的支持，使用@EnableScheduling:
 *
 * @author liuxilin
 * @date 2018/6/11 22:37
 */
@Controller
public class AysncController {
    @Autowired
    PushService pushService; //1

    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredCall() { //2
        return pushService.getAsyncUpdate();
    }

}

