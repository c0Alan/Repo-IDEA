package com.design.pattern.build.builder.demo01;

public class Test {

	public static void main(String[] args) {
        Builder builder = new Builder();
		builder.produceMailSender(10);
	}
}