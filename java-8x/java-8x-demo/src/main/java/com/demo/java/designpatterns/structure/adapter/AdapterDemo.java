package com.demo.java.designpatterns.structure.adapter;

import org.junit.Test;

/**
 * Adapter 适配器模式，将一个类的接口转换成客户希望的另一个接口，使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 *
 * @author liuxl
 * @date 2024/4/29
 */
public class AdapterDemo {

	public static void main(String[] args) {

	}


	/**
	 * 接口适配
	 */
	@Test
	public void test03() {
		Sourceable source1 = new SourceSub1();
		Sourceable source2 = new SourceSub2();

		source1.method1();
		source1.method2();
		source2.method1();
		source2.method2();
	}

	/**
	 * 对象适配
	 */
	@Test
	public void test02() {
		Source source = new Source();
		Targetable target = new Wrapper(source);
		target.method1();
		target.method2();
	}

	/**
	 * 类适配
	 */
	@Test
	public void test01() {
		Targetable target = new Adapter();
		target.method1();
		target.method2();
	}
}