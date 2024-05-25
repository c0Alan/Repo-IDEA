package com.demo.java.web.jdbc;

import com.demo.java.web.jdbc.utils.JdbcUtils;
import org.junit.Test;

import java.io.*;
import java.sql.*;

/**
 * jdbc 操作示例
 *
 * @author liuxl
 * @date 2024/5/25
 */
public class JdbcDemo {


    /**
     * 自动生成主键
     */
    @Test
    public void test02() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conn = JdbcUtils.getConnection();
            String sql = "insert into users(name) values(?)";
            st = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, "aaa");
            st.executeUpdate();
            //获取数据库自动生成的主键
            rs = st.getGeneratedKeys();
            if(rs.next()){
                System.out.println(rs.getInt(1));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.release(conn, st, rs);
        }
    }

    /**
     * 使用JDBC操作MySQL的二进制数据(例如图像 、 声音 、 二进制文)
     *
     * @Description:向数据库中插入二进制数据
     */
    @Test
    public void addBlob() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into testblob(image) values(?)";
            st = conn.prepareStatement(sql);
            //这种方式获取的路径，其中的空格会被使用“%20”代替
            String path = JdbcDemo.class.getClassLoader().getResource("img.jpg").getPath();
            //将“%20”替换会空格
            path = path.replaceAll("%20", " ");
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);//生成的流
            st.setBinaryStream(1, fis, (int) file.length());
            int num = st.executeUpdate();
            if (num > 0) {
                System.out.println("插入成功！！");
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }

    /**
     * @Description: 读取数据库中的二进制数据
     */
    @Test
    public void readBlob() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select image from testblob where id=?";
            st = conn.prepareStatement(sql);
            st.setInt(1, 1);
            rs = st.executeQuery();
            if (rs.next()) {
                //InputStream in = rs.getBlob("image").getBinaryStream();//这种方法也可以
                InputStream in = rs.getBinaryStream("image");
                int len = 0;
                byte buffer[] = new byte[1024];

                FileOutputStream out = new FileOutputStream("D:\\1.jpg");
                while ((len = in.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
                in.close();
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }


    /**
     * @Description:向数据库中插入大文本数据
     */
    @Test
    public void addClob() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Reader reader = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into testclob(resume) values(?)";
            st = conn.prepareStatement(sql);
            //这种方式获取的路径，其中的空格会被使用“%20”代替
            String path = JdbcDemo.class.getClassLoader().getResource("alice30.txt").getPath();
            //将“%20”替换回空格
            path = path.replaceAll("%20", " ");
            File file = new File(path);
            reader = new FileReader(file);
            st.setCharacterStream(1, reader, (int) file.length());
            int num = st.executeUpdate();
            if (num > 0) {
                System.out.println("插入成功！！");
            }
            //关闭流
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }

    /**
     * @Description: 读取数据库中的大文本数据
     */
    @Test
    public void readClob() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select resume from testclob where id=1";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            String contentStr = "";
            String content = "";
            if (rs.next()) {
                //使用resultSet.getString("字段名")获取大文本数据的内容
                content = rs.getString("resume");
                //使用resultSet.getCharacterStream("字段名")获取大文本数据的内容
                Reader reader = rs.getCharacterStream("resume");
                char buffer[] = new char[1024];
                int len = 0;
                FileWriter out = new FileWriter("D:\\1.txt");
                while ((len = reader.read(buffer)) > 0) {
                    contentStr += new String(buffer);
                    out.write(buffer, 0, len);
                }
                out.close();
                reader.close();
            }
            System.out.println(content);
            System.out.println("-----------------------------------------------");
            System.out.println(contentStr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn, st, rs);
        }
    }


    /**
     * Driver-> Connection-> Statement-> ResultSet
     */
    @Test
    public void test01() throws Exception {
        //要连接的数据库URL
        String url = "jdbc:mysql://192.168.50.133:3306/db_javaweb";
        //连接的数据库时使用的用户名
        String username = "liuxl";
        //连接的数据库时使用的密码
        String password = "lxl123";

        //1.加载驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());不推荐使用这种方式来加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");//推荐使用这种方式来加载驱动
        //2.获取与数据库的链接
        Connection conn = DriverManager.getConnection(url, username, password);

        //3.获取用于向数据库发送sql语句的statement
        Statement st = conn.createStatement();

        String sql = "select id,name,password,email,birthday from users";
        //4.向数据库发sql,并获取代表结果集的resultset
        ResultSet rs = st.executeQuery(sql);

        //5.取出结果集的数据
        while (rs.next()) {
            System.out.println("id=" + rs.getObject("id"));
            System.out.println("name=" + rs.getObject("name"));
            System.out.println("password=" + rs.getObject("password"));
            System.out.println("email=" + rs.getObject("email"));
            System.out.println("birthday=" + rs.getObject("birthday"));
        }

        //6.关闭链接，释放资源
        rs.close();
        st.close();
        conn.close();
    }
}