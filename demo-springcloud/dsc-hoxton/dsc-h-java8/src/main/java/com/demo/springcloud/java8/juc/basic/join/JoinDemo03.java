package com.demo.springcloud.java8.juc.basic.join;

/**
 * 测试 join 子线程运行完后, 哪个线程会获得锁资源
 * 1. jion 时会将 调用join 方法的线程(子线程)作为锁
 * 2. 子线程会在join里面调用 wait 方法, 也就是父线程会释放锁资源, 进入阻塞状态
 * 3. 实验证明 join 子线程执行完不一定马上执行父线程, 也可能是其他线程先获得锁资源
 * 
 * @author liuxilin
 * @date 2018/5/20 13:33
 */
public class JoinDemo03 {
    private static ThreadB tb = new ThreadB("tb1");

    public static void main(String[] args) {
        ThreadA ta = new ThreadA("ta1");
        ta.start();
        for (int i=0; i<10; i++){
            ThreadC tc = new ThreadC("tc" + i);
            tc.start();
        }
    }


    private static class ThreadA extends Thread{
        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.printf("%s waiting for resource.\n", Thread.currentThread().getName());

            synchronized (tb){
                System.out.printf("%s got the resource.\n", Thread.currentThread().getName());
                tb.start();
                try {
                    tb.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("%s finished.", Thread.currentThread().getName());
            }
        }
    }

    private static class ThreadB extends Thread{
        public ThreadB(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.printf("%s waiting for resource.\n", Thread.currentThread().getName());
            synchronized (tb){
                System.out.printf("%s got the resource.\n", Thread.currentThread().getName());
            }
        }
    }

    private static class ThreadC extends Thread{
        public ThreadC(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.printf("%s waiting for resource.\n", Thread.currentThread().getName());
            // 加了wait 之后会报错, 且 ta1 每次都能被唤醒,
            // 说明 Join 之后应该调用的是 notify, 而且notify 的对象一定是 父线程
            // 其他线程由于无法被唤醒而报错
/*            try {
                tb.wait(); // 试验 join 之后调用的是 notify 还是 notifyAll
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            synchronized (tb){
                System.out.printf("%s got the resource.\n", Thread.currentThread().getName());
            }
        }
    }
}
