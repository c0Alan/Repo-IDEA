package com.demo.java.build.builder.demo01;

import com.demo.java.build.factorymethod.demo01.MailSender;
import com.demo.java.build.factorymethod.demo01.Sender;
import com.demo.java.build.factorymethod.demo01.SmsSender;

import java.util.ArrayList;
import java.util.List;

public class Builder {

	private List<Sender> list = new ArrayList<Sender>();

	public void produceMailSender(int count) {
        for(int i=0; i<count; i++) {
			list.add(new MailSender());
		}
	}

	public void produceSmsSender(int count) {
		for(int i=0; i<count; i++) {
			list.add(new SmsSender());
		}
	}
}