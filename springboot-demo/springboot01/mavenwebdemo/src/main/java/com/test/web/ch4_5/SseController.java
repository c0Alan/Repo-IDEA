package com.test.web.ch4_5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * SSE : Server Send Event 服务端发送事件
 */
@Controller
public class SseController {

    /**
     * 这里使用输出的媒体类型为text/event-stream ，这是服务器端SSE 的支持
     * @return
     */
	@RequestMapping(value="/push",produces="text/event-stream") //1
	public @ResponseBody
    String push(){
		 Random r = new Random();
        try {
                Thread.sleep(5000);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }   
        return "data:Testing 1,2,3" + r.nextInt() +"\n\n";
	}

}
