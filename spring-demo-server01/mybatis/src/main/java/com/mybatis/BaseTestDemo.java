package com.mybatis;

import com.mybatis.cache.mapper.StudentMapper;
import com.mybatis.model.Student;
import com.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;

public abstract class BaseTestDemo {
    public static String DEMO = "demo01";
    protected SqlSession sqlSession = null;
    protected StudentMapper studentMapper = null;

    private static Logger logger = Logger.getLogger(BaseTestDemo.class);

    /**
     * 测试方法前调用
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        System.out.println("current demo: " + DEMO);
        sqlSession = SqlSessionFactoryUtil.openSession(DEMO);
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    /**
     * 测试方法后调用
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 关闭重开 sqlSession
     */
    public void resetSqlSession(){
        sqlSession.close();
        sqlSession = SqlSessionFactoryUtil.openSession(DEMO);
    }

    /**
     * sqlSession 关闭之后 studentMapper 不能再用
     */
    public void resetStudentMapper(){
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    public void findStudentById(int id) {
        Student student = studentMapper.findById(id);
        logger.info(student);
    }
}
