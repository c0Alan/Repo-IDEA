package com.demo.java.designpatterns.structure.flyweight;

import org.junit.Test;

import java.sql.Connection;

/**
 * Flyweight 享元模式，主要目的是实现对象的共享，即共享池
 * 常用场景为各种池化技术，如数据库连接池，线程池，缓存池等
 *
 * @author liuxl
 * @date 2024/4/29
 */
public class FlyweightDemo {
    public static void main(String[] args) {

    }

    @Test
    public void test01() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        pool.release(connection);
    }
}
