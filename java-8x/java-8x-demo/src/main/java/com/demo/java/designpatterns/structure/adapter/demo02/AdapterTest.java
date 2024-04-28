package com.demo.java.designpatterns.structure.adapter.demo02;

import com.demo.java.designpatterns.structure.adapter.demo01.Source;
import com.demo.java.designpatterns.structure.adapter.demo01.Targetable;

public class AdapterTest {

	public static void main(String[] args) {
        Source source = new Source();
		Targetable target = new Wrapper(source);
		target.method1();
		target.method2();
	}
}