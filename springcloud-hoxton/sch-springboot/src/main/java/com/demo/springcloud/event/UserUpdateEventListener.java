package com.demo.springcloud.event;

import com.demo.springcloud.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 用户更新事件监听
 *
 * @author liuxl
 * @date 2024/8/28
 */
@Slf4j
@Component
public class UserUpdateEventListener {
    @Async // 开启异步监听
    @EventListener
    public void onUserUpdate(UserUpdateEvent event) {
        SysUser user = event.getUser();
        log.info("用户更新事件监听，用户ID：{}，用户名：{}", user.getId(), user.getUsername());
    }
}
