package com.multiple.datasource.controller2;

import com.multiple.datasource.dao2.entity.Role;
import com.multiple.datasource.dao2.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxilin
 * @version 2019-04-02
 * @since
 */
@RestController
public class RoleController {
    @Autowired
    RoleMapper roleMapper;

    @GetMapping("getRole")
    public Role getApp() {
        return roleMapper.selectByPrimaryKey(1);
    }
}
