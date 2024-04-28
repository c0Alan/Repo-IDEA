package com.web.jdbc.dbutils;

import java.sql.Connection;

/**
 * 数据库连接上下文
 *
 * @author liuxilin
 * @date 2018/5/16 22:25
 */
public class ConnectionContext {

    /**
     * 构造方法私有化，将ConnectionContext设计成单例
     */
    private ConnectionContext() {

    }

    //创建ConnectionContext实例对象
    private static ConnectionContext connectionContext = new ConnectionContext();

    /**
     * 获取ConnectionContext实例对象
     *
     * @return
     */
    public static ConnectionContext getInstance() {
        return connectionContext;
    }

    /**
     * 使用ThreadLocal存储数据库连接对象
     */
    private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();

    /**
     * 利用ThreadLocal把获取数据库连接对象Connection和当前线程绑定
     *
     * @param connection
     */
    public void bind(Connection connection) {
        connectionThreadLocal.set(connection);
    }

    /**
     * 从当前线程中取出Connection对象
     *
     * @return
     */
    public Connection getConnection() {
        return connectionThreadLocal.get();
    }

    /**
     * 解除当前线程上绑定Connection
     */
    public void remove() {
        connectionThreadLocal.remove();
    }
}