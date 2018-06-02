package com.sh.demo01;

import com.sh.demo01.service.BookShopService;
import com.sh.demo01.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;


public class SpringHibernateTest {

    private ApplicationContext ctx = null;
    private BookShopService bookShopService = null;
    private Cashier cashier = null;

    {
        ctx = new ClassPathXmlApplicationContext("/demo01/applicationContext.xml");
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);
    }

    @Test
    public void testCashier() {
        cashier.checkout("AA", Arrays.asList("1001", "1002"));
    }

    @Test
    public void testBookShopService() {
        bookShopService.purchase("AA", "1001");
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }

}
