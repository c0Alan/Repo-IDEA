package com.demo.springcloud;

import com.demo.springcloud.mapper.SysUserMapper;
import com.demo.springcloud.service.BusinessService;
import com.demo.springcloud.service.TAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeataAtTest {
	@Autowired
    SysUserMapper sysUserMapper;

	@Autowired
	private BusinessService businessService;

	@Autowired
	private TAccountService tAccountService;

	@Test
	public void contextLoads() {
		System.out.println("test run");
	}

	@Test
	public void test() {
		System.out.println(sysUserMapper.selectById(1));
	}

	@Test
	public void seataTest() throws InterruptedException {
		businessService.purchase("U100001", "C100001", 2);
		/*Thread thread = new Thread(() -> businessService.purchase("U100001", "C100001", 2));
		thread.start();

		//keep run
		Thread.currentThread().join();*/

	}

	@Test
	public void test2() {
		tAccountService.addMoney("U100001", 100);
	}

	@Test
	public void test3() {
		tAccountService.addMoney("U100001", 200);
	}

}
