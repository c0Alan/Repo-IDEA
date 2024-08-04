package com.demo.springcloud.sse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
@Component
public class SseEmitters {

    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    public SseEmitter add(SseEmitter emitter) {
        this.emitters.add(emitter);
        emitter.onCompletion(() -> this.emitters.remove(emitter));
        emitter.onTimeout(() -> {
            emitter.complete();
            this.emitters.remove(emitter);
        });
        return emitter;
    }


    public void send(Object obj) {
        log.info("当前emitters连接数:{}", this.emitters.size());
        List<SseEmitter> failedEmitters = Collections.emptyList();
        this.emitters.forEach(emitter -> {
            try {
                emitter.send(obj);
            } catch (Exception e) {
                emitter.completeWithError(e);
                failedEmitters.add(emitter);
            }
        });
        this.emitters.removeAll(failedEmitters);
    }

}
