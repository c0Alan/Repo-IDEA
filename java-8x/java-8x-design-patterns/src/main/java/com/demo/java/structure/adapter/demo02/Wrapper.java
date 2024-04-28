package com.demo.java.structure.adapter.demo02;

import com.demo.java.structure.adapter.demo01.Source;
import com.demo.java.structure.adapter.demo01.Targetable;

public class Wrapper implements Targetable {

	private Source source;

	public Wrapper(Source source) {
        super();
		this.source = source;
	}
	@Override
	public void method2() {
		System.out.println("this is the targetable method!");
	}

	@Override
	public void method1() {
		source.method1();
	}
}