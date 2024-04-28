package com.demo.java.designpatterns.build.prototype.demo01;

public class Prototype implements Cloneable {

	public Object clone() throws CloneNotSupportedException {
        Prototype proto = (Prototype) super.clone();
		return proto;
	}
}