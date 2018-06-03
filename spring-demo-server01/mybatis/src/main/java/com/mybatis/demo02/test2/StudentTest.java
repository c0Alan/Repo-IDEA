package com.mybatis.demo02.test2;

import com.mybatis.demo02.mapper.StudentMapper;
import com.mybatis.model.Student;
import com.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * 使用注解的方式实现增删改查
 * 
 * @author liuxl
 * @date 2018/5/15 13:27
 */
public class StudentTest {

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
        sqlSession = SqlSessionFactoryUtil.openSession("demo02");
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
    public void testInsert() {
        logger.info("添加学生");
        Student student = new Student("琪琪", 11);
        studentMapper.insertStudent(student);
        sqlSession.commit();
    }

    @Test
    public void testUpdate() {
        logger.info("更新学生");
        Student student = new Student(3, "琪琪2", 12);
        studentMapper.updateStudent(student);
        sqlSession.commit();
    }

    @Test
    public void testDelete() {
        logger.info("删除学生");
        studentMapper.deleteStudent(3);
        sqlSession.commit();
    }

    @Test
    public void testGetById() {
        logger.info("通过ID查找学生");
        Student student = studentMapper.getStudentById(1);
        System.out.println(student);
    }

    @Test
    public void testFindStudents() {
        logger.info("查找所有学生");
        List<Student> studentList = studentMapper.findStudents();
        logger.info(studentList);
    }

}