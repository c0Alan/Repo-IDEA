package com.ssh.repository;

import com.ssh.entity.TSysRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SysRoleReposity {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    /**
     * session 的方式获取
     * @param id
     * @return
     */
    public TSysRole get(Integer id) {
        return (TSysRole) getCurrentSession().get(TSysRole.class, id);
    }
}
