package com.demo.springcloud;

import com.demo.springcloud.constant.KafkaConsts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaApplicationTests {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	/**
	 * 测试发送消息
	 */
	@Test
	public void testSend() {
		kafkaTemplate.send(KafkaConsts.TOPIC_TEST, "hello,kafka...");
	}


}
