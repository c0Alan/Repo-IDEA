package com.mybatis.test;

import com.mybatis.mapper.StudentMapper;
import com.mybatis.model.Student;
import com.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StudentTest2 {

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
    public void testAdd() {
        logger.info("添加学生");
        Student student = new Student("王五", 12);
        studentMapper.add(student);
        sqlSession.commit();
    }

    @Test
    public void testUpdate() {
        logger.info("修改学生");
        Student student = new Student(8, "王五2", 13);
        studentMapper.update(student);
        sqlSession.commit();
    }

    @Test
    public void testDelete() {
        logger.info("删除学生");
        studentMapper.delete(8);
        sqlSession.commit();
    }

    @Test
    public void testFindById() {
        logger.info("通过ID查找学生");
        Student student = studentMapper.findById(1);
        System.out.println(student);
    }

    @Test
    public void testFind() {
        logger.info("查找所有学生");
        List<Student> studentList = studentMapper.find();
        for (Student s : studentList) {
            System.out.println(s);
        }
    }
}