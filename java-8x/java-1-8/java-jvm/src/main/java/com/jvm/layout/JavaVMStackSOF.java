package com.jvm.layout;

/**
 * 虚拟机栈和本地方法栈溢出 // StackOverflowError
 * 一般由于方法中递归导致
 * VM Args：-Xss128k
 *
 * @author liuxilin
 * @date 2018/5/26 10:55
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
