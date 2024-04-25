package com.demo.java.java8.jvm.jvmstack;

/**
 * 方法动态分派演示
 * @author zzm
 */
public class DynamicDispatch {

	static abstract class Human {
        protected abstract void sayHello();
	}

	static class Man extends Human {
		@Override
		protected void sayHello() {
			System.out.println("man say hello");
		}
	}

	static class Woman extends Human {
		@Override
		protected void sayHello() {
			System.out.println("woman say hello");
		}
	}

	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new Woman();
		man.sayHello(); // man say hello
		woman.sayHello(); // woman say hello
		man = new Woman(); // woman say hello
		man.sayHello();
	}
}