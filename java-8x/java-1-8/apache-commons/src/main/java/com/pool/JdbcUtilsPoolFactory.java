package com.demo.java.apachecommons.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * JdbcUtils工具类对象池工厂
 */
public class JdbcUtilsPoolFactory extends BasePooledObjectFactory<JdbcUtils> {

    static GenericObjectPool<JdbcUtils> pool = null;

    // 取得对象池工厂实例
    public synchronized static GenericObjectPool<JdbcUtils> getInstance() {
        if (pool == null) {
            GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
            poolConfig.setTimeBetweenEvictionRunsMillis(5000);
            /*poolConfig.setMaxIdle(-1);
            poolConfig.setMaxTotal(-1);
            poolConfig.setMinIdle(100);
            poolConfig.setLifo(false);*/
            pool = new GenericObjectPool<JdbcUtils>(new JdbcUtilsPoolFactory(), poolConfig);
        }
        return pool;
    }

    public static JdbcUtils borrowObject() throws Exception {
        return (JdbcUtils) JdbcUtilsPoolFactory.getInstance().borrowObject();
    }

    public static void returnObject(JdbcUtils jdbcUtils) throws Exception {
        JdbcUtilsPoolFactory.getInstance().returnObject(jdbcUtils);
    }

    /*@Override
    public PooledObject<JdbcUtils> makeObject() throws Exception {
        return super.makeObject();
    }*/

    public static void close() throws Exception {
        JdbcUtilsPoolFactory.getInstance().close();
    }

    public static void clear() throws Exception {
        JdbcUtilsPoolFactory.getInstance().clear();
    }

    @Override
    public JdbcUtils create() throws Exception {
        return new JdbcUtils();
    }

    @Override
    public PooledObject<JdbcUtils> wrap(JdbcUtils obj) {
        return new DefaultPooledObject<JdbcUtils>(obj);
    }

    public static void main(String[] args) throws Exception {
        JdbcUtils jdbcUtils = JdbcUtilsPoolFactory.borrowObject();
        jdbcUtils.domestring();
        JdbcUtils jdbcUtils2 = JdbcUtilsPoolFactory.borrowObject();
        jdbcUtils2.domestring();
        JdbcUtilsPoolFactory.returnObject(jdbcUtils);
        JdbcUtilsPoolFactory.returnObject(jdbcUtils2);
        Thread.sleep(10000);
        System.out.println("finished");
    }




}  