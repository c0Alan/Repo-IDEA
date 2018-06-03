package com.mybatis.cache;

import com.mybatis.model.Student;
import com.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 自定义缓存实验
 * 
 * @author liuxilin
 * @date 2018/6/3 12:32
 */
public class CacheDemo02 extends Demo04Test {
    private static Logger logger = Logger.getLogger(CacheDemo02.class);

    @Test
    public void customCache() {
        SqlSession session1 = SqlSessionFactoryUtil.openSession(DEMO);
        com.mybatis.cache.mapper.StudentMapper mapper1 = session1.getMapper(com.mybatis.cache.mapper.StudentMapper.class);
        SqlSession session2 = SqlSessionFactoryUtil.openSession(DEMO);
        com.mybatis.cache.mapper.StudentMapper mapper2 = session2.getMapper(com.mybatis.cache.mapper.StudentMapper.class);
        Student student = mapper1.findById(1);
        session1.commit(); // 这里提交之后才会把对象提交到缓存
//        studentMapper.update(new Student(2, "李富贵", 23));
//        sqlSession.commit();
        logger.info(student);

        student = mapper2.findById(1);
        logger.info(student);

        student = studentMapper.findById(1);
        logger.info(student);
    }
}
