package com.juc.synchoronize;

/**
 * 死锁测试
 */
public class ClassB {
    public ClassA classA;

    public void setClassA(ClassA classA) {
        this.classA = classA;
    }

    synchronized public void methodB(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        classA.methodA();
        System.out.println("b");
    }

    public static void main(String[] args) {
        ClassA a = new ClassA();
        ClassB b = new ClassB();
        a.setClassb(b);
        b.setClassA(a);

        Thread t1 = new Thread(new RunnableA(a));
        t1.setName("Thread-ClassA");
        Thread t2 = new Thread(new RunnableB(b));
        t2.setName("Thread-ClassB");
        t1.start();
        t2.start();

    }

    public static class RunnableA implements Runnable{
        public ClassA a;

        public RunnableA(ClassA a) {
            this.a = a;
        }

        public void run() {
            a.methodA();
        }
    }

    public static class RunnableB implements Runnable{
        ClassB b;

        public RunnableB(ClassB b) {
            this.b = b;
        }

        public void run() {
            b.methodB();
        }
    }
}
