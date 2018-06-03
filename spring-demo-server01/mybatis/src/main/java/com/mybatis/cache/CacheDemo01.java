package com.mybatis.cache;

import com.mybatis.cache.mapper.StudentMapper;
import com.mybatis.model.Student;
import com.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 一级缓存跟二级缓存的实验
 * 
 * @author liuxilin
 * @date 2018/6/3 12:32
 */
public class CacheDemo01 extends Demo04Test {
    private static Logger logger = Logger.getLogger(CacheDemo01.class);

    @Test
    public void findById() {
        super.findStudentById(2);
    }

    /**
     * 一级缓存测试
     * 1. 不同 session, 不使用缓存
     * 2. 同一session, 执行过session.clearCache()清理缓存, 不使用缓存
     * 3. 同一session, 执行过增删改的操作(这些操作都会清理缓存), 不使用缓存
     */
    @Test
    public void cacheLevel1(){
        String statement = "com.mybatis.cache.mapper.StudentMapper.findById";

        /** 使用缓存的情况 */
        logger.info("使用缓存的情况");
        Student student = sqlSession.selectOne(statement, 1);
        logger.info(student);

        student = sqlSession.selectOne(statement, 1);
        logger.info(student);

        /** 第 1 种情况 */
        logger.info("第 1 种情况");
        resetSqlSession();
        student = sqlSession.selectOne(statement, 1);
        logger.info(student);

        /** 第 2 种情况 */
        logger.info("第 2 种情况");
        student = sqlSession.selectOne(statement, 2);
        logger.info(student);
        sqlSession.clearCache();
        student = sqlSession.selectOne(statement, 2);
        logger.info(student);

        /** 第 3 种情况 */
        logger.info("第 3 种情况");
        sqlSession.update("com.mybatis.cache.mapper.StudentMapper.updateById",
                new Student(2, "李富贵", 23));

        student = sqlSession.selectOne(statement, 2);
        logger.info(student);
    }

    /**
     * 一级缓存测试, Mapper 方式
     */
    @Test
    public void cacheLevel1Mapper(){

        /** 使用缓存的情况 */
        logger.info("使用缓存的情况");
        Student student = studentMapper.findById(1);
        logger.info(student);

        student = studentMapper.findById(1);
        logger.info(student);

        /** 第 1 种情况 */
        logger.info("第 1 种情况");
        sqlSession.close();
        resetSqlSession();
        resetStudentMapper(); // session 关闭之后 mapper 也不能再用了, 这里重置mapper
        student = studentMapper.findById(1);
        logger.info(student);

        /** 第 2 种情况 */
        logger.info("第 2 种情况");
        student = studentMapper.findById(2);
        logger.info(student);
        sqlSession.clearCache();
        student = studentMapper.findById(2);
        logger.info(student);

        /** 第 3 种情况 */
        logger.info("第 3 种情况");
        studentMapper.update(new Student(2, "李富贵", 23));

        student = studentMapper.findById(2);
        logger.info(student);
    }

    /**
     * 二级缓存测试
     * 使用二级缓存时，实体类必须是可序列化的类, (Student 类必须实现一个Serializable)
     * commit 之后才更新缓存, 一定要提交事务之后二级缓存才会起作用
     */
    @Test
    public void cacheLevel2() {
        String statement = "com.mybatis.cache.mapper.StudentMapper.findById";
        SqlSession session1 = SqlSessionFactoryUtil.openSession(DEMO);
        SqlSession session2 = SqlSessionFactoryUtil.openSession(DEMO);
        Student student = session1.selectOne(statement, 1);
        session1.commit(); // 这里提交之后才会把对象提交到缓存
//        session1.close(); // 自动提交的情况下 close 也可以提交到缓存
        logger.info(student);

        student = session2.selectOne(statement, 1);
        logger.info(student);
    }

    /**
     * 二级缓存测试, Mapper 方式
     */
    @Test
    public void cacheLevel2Mapper() {
        SqlSession session1 = SqlSessionFactoryUtil.openSession(DEMO);
        StudentMapper mapper1 = session1.getMapper(StudentMapper.class);
        SqlSession session2 = SqlSessionFactoryUtil.openSession(DEMO);
        StudentMapper mapper2 = session2.getMapper(StudentMapper.class);
        Student student = mapper1.findById(1);
        session1.commit(); // 这里提交之后才会把对象提交到缓存
        studentMapper.update(new Student(2, "李富贵", 23));
        sqlSession.commit();
        logger.info(student);

        student = mapper2.findById(1);
        logger.info(student);

        student = studentMapper.findById(1);
        logger.info(student);
    }
}
