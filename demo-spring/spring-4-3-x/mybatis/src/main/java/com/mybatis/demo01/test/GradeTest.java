package com.mybatis.demo01.test;

import com.mybatis.demo01.mapper.GradeMapper;
import com.mybatis.model.Grade;
import com.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeTest {

    private static Logger logger = Logger.getLogger(GradeTest.class);
    private SqlSession sqlSession = null;
    private GradeMapper gradeMapper = null;

    /**
     * 测试方法前调用
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        sqlSession = SqlSessionFactoryUtil.openSession("demo01");
        gradeMapper = sqlSession.getMapper(GradeMapper.class);
    }

    /**
     * 测试方法后调用
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        sqlSession.close();
    }

    @Test
    public void testFindGradeWithStudents() {
        logger.info("查询年级(带学生)");
        Grade grade = gradeMapper.findById(1);
//        logger.info(grade);
        System.out.println(grade);
    }

}