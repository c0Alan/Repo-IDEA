package com.demo.springcloud.sse;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * Server-Sent Events <BR>
 * https://blog.csdn.net/hhl18730252820/article/details/126244274
 */
@Slf4j
public class SSEServer {
    /**
     * 当前连接数
     */
    private static AtomicInteger count = new AtomicInteger(0);

    private static Map<String, SseEmitter> sseEmitterMap = new ConcurrentHashMap<>();

    public static SseEmitter connect() {
        String userId = RandomStringUtils.randomAlphanumeric(10);
        SseEmitter sseEmitter = new SseEmitter(0L); // 设置超时时间，0表示不过期，默认是30秒，超过时间未完成会抛出异常

        // 注册回调
        sseEmitter.onCompletion(completionCallBack(userId));
        sseEmitter.onError(errorCallBack(userId));
        sseEmitter.onTimeout(timeOutCallBack(userId));
        sseEmitterMap.put(userId, sseEmitter);
        log.info("create new sse connect ,current user:{}, count: {}", userId, count.incrementAndGet());
        return sseEmitter;
    }

    public static void batchSendMessage(String message) {
        sseEmitterMap.forEach((k, v) -> {
            try {
                v.send(message, MediaType.APPLICATION_JSON);
            } catch (IOException e) {
                log.error("user id:{}, send message error:{}", k, e.getMessage());
                removeUser(k);
            }
        });
    }

    public static void removeUser(String userId) {
        sseEmitterMap.remove(userId);
        log.info("remove user id:{}, count: {}", userId, count.decrementAndGet());
    }

    private static Runnable completionCallBack(String userId) {
        return () -> {
            log.info("结束连接,{}", userId);
            removeUser(userId);
        };
    }

    private static Runnable timeOutCallBack(String userId) {
        return () -> {
            log.info("连接超时,{}", userId);
            removeUser(userId);
        };
    }

    private static Consumer<Throwable> errorCallBack(String userId) {
        return throwable -> {
            log.error("连接异常，{}", userId);
            removeUser(userId);
        };
    }
}
