package com.mybatis.test;

import com.mybatis.mapper.StudentMapper;
import com.mybatis.model.Student;
import com.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentTest3 {

    private static Logger logger = Logger.getLogger(StudentTest.class);
    private SqlSession sqlSession = null;
    private StudentMapper studentMapper = null;

    /**
     * 测试方法前调用
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        sqlSession = SqlSessionFactoryUtil.openSession();
        studentMapper = sqlSession.getMapper(StudentMapper.class);
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
    public void testFindStudentWithAddress() {
        logger.info("查询学生(带地址)");
        Student student = studentMapper.findStudentWithAddress(3);
        System.out.println(student);
    }

    @Test
    public void testFindStudentWithGrade() {
        logger.info("查询学生(带年级)");
        Student student = studentMapper.findStudentWithAddress(1);
        System.out.println(student);
    }

}