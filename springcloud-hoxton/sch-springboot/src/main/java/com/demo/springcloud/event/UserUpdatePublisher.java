package com.demo.springcloud.event;

import com.demo.springcloud.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * 用户更新事件发布
 *
 * @author liuxl
 * @date 2024/8/28
 */
@Slf4j
@Component
public class UserUpdatePublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishEvent(SysUser user) {
        log.info("发布用户更新事件");
        UserUpdateEvent userUpdateEvent = new UserUpdateEvent(user);
        applicationEventPublisher.publishEvent(userUpdateEvent);
    }
}
