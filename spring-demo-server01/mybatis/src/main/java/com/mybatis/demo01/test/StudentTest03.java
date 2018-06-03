package com.mybatis.demo01.test;

import com.mybatis.demo01.mapper.StudentMapper;
import com.mybatis.model.Student;
import com.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 大对象测试
 * 
 * @author liuxilin
 * @date 2018/5/13 23:18
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
        sqlSession = SqlSessionFactoryUtil.openSession("demo01");
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


    /**
     * 测试写入 postgresql text 和 bytea 对象
     */
    @Test
    public void testInsertStudent() {
        logger.info("添加学生");
        Student student = new Student();
        student.setName("张三4");
        student.setAge(14);
        student.setRemark("很长的本文...");
        byte[] pic = null;
        try {
            InputStream inputStream =  ClassLoader.getSystemResourceAsStream("picture" + File.separator + "pic.jpeg");
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

    /**
     * 读取 postgresql bytea 对象
     */
    @Test
    public void testGetStudentById() {
        logger.info("通过ID查找学生");
        Student student = studentMapper.getStudentById(9);
        System.out.println(student);
        byte[] pic = student.getPic();
        try {
            File file = new File("d://pic.jpg");
            OutputStream outputStream = new FileOutputStream(file);
            outputStream.write(pic);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
