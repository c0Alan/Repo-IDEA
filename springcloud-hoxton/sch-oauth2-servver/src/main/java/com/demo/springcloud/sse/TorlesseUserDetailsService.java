package com.demo.springcloud.sse;

import com.demo.springcloud.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: torlesse-liang
 * @Date: 2022/04/11/22:32
 * @Description: 自定义UserDetailsService实现类
 */
@Component
public class TorlesseUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserSerivce sysUserSerivce;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //登录校验
        if (sysUserSerivce.queryByUserName(username) == null) {
            throw new UsernameNotFoundException("the user is not found");
        } else {
            SysUser userInfo = sysUserSerivce.queryByUserName(username);

            //授权
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authorities.add(new SimpleGrantedAuthority("XXX_DELETE"));

            User user = new User(userInfo.getUsername(), userInfo.getPassword(), authorities);
            return user;
        }
    }
}
