package com.mybatis.demo03.test3;

import com.mybatis.demo03.mapper.StudentMapper;
import com.mybatis.model.Student;
import com.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用注解的方式实现动态sql
 * 
 * @author liuxilin
 * @date 2018/5/15 20:36
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
        sqlSession = SqlSessionFactoryUtil.openSession("demo03");
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
        Student student = new Student(10, "琪琪2", 12);
        studentMapper.updateStudent(student);
        sqlSession.commit();
    }

    @Test
    public void testDelete() {
        logger.info("删除学生");
        studentMapper.deleteStudent(10);
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
        Map<String, Object> map = new HashMap<String, Object>();
         map.put("name", "%张%");
         map.put("age", 12);
        List<Student> studentList = studentMapper.findStudents(map);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

}