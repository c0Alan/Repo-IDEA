package com.demo.java.designpatterns.structure.adapter;

public class Adapter extends Source implements Targetable {

	@Override
    public void method2() {
		System.out.println("this is the targetable method!");
	}
}