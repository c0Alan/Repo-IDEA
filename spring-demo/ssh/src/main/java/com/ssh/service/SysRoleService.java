package com.ssh.service;

import com.ssh.entity.TSysRole;
import com.ssh.repository.SysRoleReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRoleService {
    @Autowired
    SysRoleReposity sysRoleReposity;

    public TSysRole getRole(Integer id) {
        return sysRoleReposity.get(id);
    }
}
