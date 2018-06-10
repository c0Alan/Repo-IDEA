package com.wisely.ch9_1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.wisely.ch9_1.dao.SysUserRepository;
import com.wisely.ch9_1.domain.SysUser;

public class CustomUserService implements UserDetailsService { //1
    @Autowired
    SysUserRepository userRepository;

    /**
     * 重写loadUserByUsemame 方法获得用户。
     * 我们当前的用户实现了UserDetails 接口，可直接返回给Spring Security 使用。
     *
     * @param username
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String username) { //2

        SysUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        return user; //3
    }

}
