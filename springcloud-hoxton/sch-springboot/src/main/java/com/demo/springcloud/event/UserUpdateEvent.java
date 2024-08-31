package com.demo.springcloud.event;

import com.demo.springcloud.entity.SysUser;

/**
 * 用户更新事件
 *
 * @author liuxl
 * @date 2024/8/28
 */
public class UserUpdateEvent {

    private SysUser user;

    public UserUpdateEvent(SysUser user) {
        this.user = user;
    }

    public SysUser getUser() {
        return user;
    }
}
