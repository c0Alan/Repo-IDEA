package com.demo.java.designpatterns.structure.adapter.demo01;

public class AdapterTest {

	public static void main(String[] args) {
        Targetable target = new Adapter();
		target.method1();
		target.method2();
	}
}