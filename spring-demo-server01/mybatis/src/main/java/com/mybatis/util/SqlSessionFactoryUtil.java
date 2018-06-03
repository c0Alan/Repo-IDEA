package com.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionFactoryUtil {

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory getSqlSessionFactory(String demo) {
        if (sqlSessionFactory == null) {
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream(demo + "/mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession openSession(String demo) {
        return getSqlSessionFactory(demo).openSession();
    }
}