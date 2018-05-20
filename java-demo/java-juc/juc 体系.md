# (一) 基础篇

01之 基本概念
02之 常用的实现多线程的两种方式
03之 Thread中start()和run()的区别
04之 synchronized关键字

## 05之 线程等待与唤醒

在Object.java中，定义了wait(), notify()和notifyAll()等接口。wait()的作用是让当前线程进入等待状态，同时，wait()也会让当前线程释放它所持有的锁。而notify()和notifyAll()的作用，则是唤醒当前对象上的等待线程；notify()是唤醒单个线程，而notifyAll()是唤醒所有的线程。

Object类中关于等待/唤醒的API详细信息如下：
**notify()**        -- 唤醒在此对象监视器上等待的单个线程。
**notifyAll()**   -- 唤醒在此对象监视器上等待的所有线程。
**wait()**           -- 让当前线程处于“等待(阻塞)状态”，“直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法”，当前线程被唤醒(进入“就绪状态”)。
**wait(long timeout)**  	-- 让当前线程处于“等待(阻塞)状态”，“直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者超过指定的时间量”，当前线程被唤醒(进入“就绪状态”)。
**wait(long timeout, int nanos)**  -- 让当前线程处于“等待(阻塞)状态”，“直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者其他某个线程中断当前线程，或者已超过某个实际时间量”，当前线程被唤醒(进入“就绪状态”)。

## 06之 线程让步

07之 线程休眠 
08之 join()

## 09之 interrupt()和线程终止方式

interrupted() 和 isInterrupted()都能够用于检测对象的“中断标记”。
区别是，interrupted()除了返回中断标记之外，它还会清除中断标记(即将中断标记设为false)；而isInterrupted()仅仅返回中断标记。

10之 线程优先级和守护线程
11之 生产消费者问题

# (二) JUC原子类 

JUC包中的原子操作类可以分为4类。

1. **基本类型**: AtomicInteger, AtomicLong, AtomicBoolean ;
2. **数组类型**: AtomicIntegerArray, AtomicLongArray, AtomicReferenceArray ;
3. **引用类型**: AtomicReference, AtomicStampedRerence, AtomicMarkableReference ;
4. **对象的属性修改类型**: AtomicIntegerFieldUpdater, AtomicLongFieldUpdater, AtomicReferenceFieldUpdater 。

01之 框架 
02之 AtomicLong原子类
03之 AtomicLongArray原子类
04之 AtomicReference原子类
05之 AtomicLongFieldUpdater原子类

# (三) JUC锁

01之 框架
02之 互斥锁ReentrantLock
03之 公平锁(一) 
04之 公平锁(二) 
05之 非公平锁 
06之 Condition条件
07之 LockSupport
08之 共享锁和ReentrantReadWriteLock 
09之 CountDownLatch原理和示例
10之 CyclicBarrier原理和示例
11之 Semaphore信号量的原理和示例 

# (四) JUC集合

01之 框架
02之 CopyOnWriteArrayList
03之 CopyOnWriteArraySet
04之 ConcurrentHashMap
05之 ConcurrentSkipListMap
06之 ConcurrentSkipListSet
07之 ArrayBlockingQueue
08之 LinkedBlockingQueue 
09之 LinkedBlockingDeque
10之 ConcurrentLinkedQueue

# (五) JUC线程池

01之 线程池架构
02之 线程池原理(一)
03之 线程池原理(二)
04之 线程池原理(三)
05之 线程池原理(四)
06之 Callable和Future