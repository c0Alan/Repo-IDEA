package com.spring.demo01;

import com.spring.demo01.action.Action;
import com.spring.demo01.dao.Dao;
import com.spring.domain.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

public class Demo04 {

    public static void main(String[] args) throws SQLException {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/demo01/beans-auto.xml");
        Action action = ctx.getBean(Action.class);

        action.execute();

        //测试 bean 的作用域
        Dao dao1 = (Dao) ctx.getBean("dao2");
        Dao dao2 = (Dao) ctx.getBean("dao2");

        System.out.println(dao1 == dao2);

        //测试使用外部属性文件
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        System.out.println(dataSource.getConnection());

        //测试 spEL
        User boy = (User) ctx.getBean("boy");
        System.out.println(boy.getUserName() + ":" + boy.getWifeName());

//		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL);
        DateFormat dateFormat = (DateFormat) ctx.getBean("dateFormat");
        System.out.println(dateFormat.format(new Date()));

        Date date = (Date) ctx.getBean("datetime");
        System.out.println(date);

        User user = (User) ctx.getBean("user");
        System.out.println(user);

        ctx.close();
    }
	
}
