package com.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@AutoConfigureMockRestServiceServer
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceApplicationTest {

	@Test
	public void contextLoads() {
	}

}
