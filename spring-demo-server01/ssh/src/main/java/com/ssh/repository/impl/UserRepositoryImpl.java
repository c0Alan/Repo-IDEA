package com.ssh.repository.impl;

import com.ssh.entity.TUser;
import com.ssh.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XRom
 * On 11/16/2017.11:55 PM
 */
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    @Override
    public TUser load(Integer id) {
        return (TUser) getCurrentSession().load(TUser.class, id);
    }

    @Override
    public TUser get(Integer id) {
        return (TUser) getCurrentSession().get(TUser.class, id);
    }

    @Override
    public List<TUser> findAll() {
        return null;
    }

    @Override
    public void persist(TUser entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public Integer save(TUser entity) {
        return (Integer) getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(TUser entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(Integer id) {
        TUser TUser = load(id);
        getCurrentSession().delete(TUser);
    }

    @Override
    public void flush() {
        getCurrentSession().flush();
    }
}
