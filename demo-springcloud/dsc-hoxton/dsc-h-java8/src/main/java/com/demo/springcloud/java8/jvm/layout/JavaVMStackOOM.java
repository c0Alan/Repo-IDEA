package com.demo.springcloud.java8.jvm.layout;

/**
 * 虚拟机栈和本地方法栈溢出
 * 线程开太多导致CPU 100% 电脑卡死
 * 通过不断创建线程导致 OOM 异常
 * VM Args：-Xms20m -Xmx20m -Xss2M
 * 
 * @author liuxilin
 * @date 2018/5/26 11:08
 */
public class JavaVMStackOOM {

    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.setPriority(1); // 设置低优先级, 电脑卡死就容易关闭程序了
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}