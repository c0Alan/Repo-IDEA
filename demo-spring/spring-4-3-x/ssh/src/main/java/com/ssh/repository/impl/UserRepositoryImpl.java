package com.ssh.repository.impl;

import com.ssh.entity.TUser;
import com.ssh.repository.UserRepository;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author liuxl
 * @date 2018/4/9 21:09
 */
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    /**
     * hibernateTemplate 方式获取 listMap 结果集, 这种用 JdbcTemplate 来就好了
     *
     * @param state
     * @return
     */
    public List<Map<String, Object>> findNameAndAddressByState(Integer state) {
        // 这里的脚本必须是普通脚本, 不能是hsql
        String hql = "select c_name as name, c_address, n_age from springdemo.t_user where n_state = " + state;
        List<Map<String, Object>> resultMap = hibernateTemplate.execute(
                new HibernateCallback<List<Map<String, Object>>>() {
                    @Override
                    public List<Map<String, Object>> doInHibernate(Session session) throws HibernateException {
                        Query query = session.createSQLQuery(hql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
                        return query.list();
                    }
                }
        );
        return resultMap;
    }

    /**
     * jdbcTemplate 方式获取 listMap 结果集, 这种用 JdbcTemplate 来就好了
     *
     * @param state
     * @return
     */
    public List<Map<String, Object>> getNameAndAddressByState(Integer state) {
        String sql = "select c_name as name, c_address address, n_age age from springdemo.t_user where n_state = " + state;
        List<Map<String, Object>> resultMap = jdbcTemplate.queryForList(sql);
        return resultMap;
    }

}
