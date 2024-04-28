package com.demo.java.designpatterns.structure.adapter.demo01;

public class Adapter extends Source implements Targetable {

	@Override
    public void method2() {
		System.out.println("this is the targetable method!");
	}
}