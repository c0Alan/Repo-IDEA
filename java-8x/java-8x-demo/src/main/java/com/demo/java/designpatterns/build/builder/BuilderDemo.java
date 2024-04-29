package com.demo.java.designpatterns.build.builder;

/**
 * Builder 建造者模式
 *
 * @author liuxl
 * @date 2024/4/29
 */
public class BuilderDemo {

	public static void main(String[] args) {
        Builder builder = new Builder();
		builder.produceMailSender(10);
	}
}