package com.spring.demo04;

import com.spring.demo04.dao.BookShopDao;
import com.spring.demo04.service.BookShopService;
import com.sh.demo01.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringTransactionTest {

    private ApplicationContext ctx = null;
    private BookShopDao bookShopDao = null;
    private BookShopService bookShopService = null;
    private Cashier cashier = null;

    {
        ctx = new ClassPathXmlApplicationContext("/demo04/applicationContext.xml");
        bookShopDao = ctx.getBean(BookShopDao.class);
        bookShopService = ctx.getBean(BookShopService.class);
        cashier = ctx.getBean(Cashier.class);
    }

    /**
     * 从 AA 的账户买了 "1001", "1002" 两本书,
     * AA 账户余额balance相应减少两本书的价格
     * 相应的书籍库存表book_stock的库存相应减少,
     */
    @Test
    public void testTransactionlPropagation() {
        cashier.checkout("AA", Arrays.asList("1001", "1002"));
    }

    /**
     * 从 AA 的账户买了 "1001" 一本书,
     * AA 账户余额balance相应减少一本书的价格
     * 相应的书籍库存表book_stock的库存相应减少,
     */
    @Test
    public void testBookShopService() {
        bookShopService.purchase("AA", "1001");
    }

    @Test
    public void testBookShopDaoUpdateUserAccount() {
        bookShopDao.updateUserAccount("AA", 200);
    }

    @Test
    public void testBookShopDaoUpdateBookStock() {
        bookShopDao.updateBookStock("1001");
    }

    @Test
    public void testBookShopDaoFindPriceByIsbn() {
        System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
    }

}
