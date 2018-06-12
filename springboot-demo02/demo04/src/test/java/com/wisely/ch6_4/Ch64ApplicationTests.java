package com.springboot.ch6_4;

import com.springboot.Ch64Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Ch64Application.class)
@WebAppConfiguration
public class Ch64ApplicationTests {

	@Test
	public void contextLoads() {
	}

}
