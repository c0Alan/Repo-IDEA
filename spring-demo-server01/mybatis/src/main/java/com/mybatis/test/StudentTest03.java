package com.mybatis.test;

import com.mybatis.mapper.StudentMapper;
import com.mybatis.model.Student;
import com.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * 大对象测试
 * 
 * @author liuxilin
 * @date 2018/5/13 21:58
 */
public class StudentTest03 {

    private static Logger logger = Logger.getLogger(StudentTest03.class);
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
    public void testInsertStudent() {
        logger.info("添加学生");
        Student student = new Student();
        student.setName("张三4");
        student.setAge(14);
        student.setRemark("很长的本文...");
        byte[] pic = null;
        try {
            File file = new File("c://boy.jpg");
            InputStream inputStream = new FileInputStream(file);
            pic = new byte[inputStream.available()];
            inputStream.read(pic);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        student.setPic(pic);
        studentMapper.insertStudent(student);
        sqlSession.commit();
    }

    @Test
    public void testGetStudentById() {
        logger.info("通过ID查找学生");
        Student student = studentMapper.getStudentById(4);
        System.out.println(student);
        byte[] pic = student.getPic();
        try {
            File file = new File("d://boy2.jpg");
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(pic);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSearchStudents6() {
        logger.info("添加学生(带条件)");
        List<Student> studentList = studentMapper.searchStudents6("%3%", 12);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
