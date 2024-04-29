package com.demo.java.designpatterns.build.builder;

import com.demo.java.designpatterns.build.factorymethod.MailSender;
import com.demo.java.designpatterns.build.factorymethod.Sender;
import com.demo.java.designpatterns.build.factorymethod.SmsSender;

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