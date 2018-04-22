package com.collections;

import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import org.apache.commons.collections4.queue.PredicatedQueue;
import org.apache.commons.collections4.queue.UnmodifiableQueue;
import org.junit.Test;

import java.util.Queue;

/**
 * Queue 队列
 * 1、循环队列:CircularFifoQueue
 * 2、只读队列:不可改变队列  UnmodifiableQueue
 * 3、断言队列:PredicatedQueue.predicatedQueue()
 *
 * @author Administrator
 */
public class QueueDemo {

    /**
     * 断言队列
     */
    @Test
    public void predicate() {
        //循环队列
        CircularFifoQueue<String> que = new CircularFifoQueue<String>(2);
        que.add("a");
        que.add("b");
        que.add("c");
        Predicate notNull = NotNullPredicate.INSTANCE;
        //包装成对应的队列
        Queue<String> que2 = PredicatedQueue.predicatedQueue(que, notNull);
        que2.add(null); // 此处报错
    }

    /**
     * 只读队列
     */
    @Test
    public void readOnly() {
        //循环队列
        CircularFifoQueue<String> que = new CircularFifoQueue<String>(2);
        que.add("a");
        que.add("b");
        que.add("c");
        Queue<String> readOnlyQue = UnmodifiableQueue.unmodifiableQueue(que);
        readOnlyQue.add("d"); // 此处报错
    }

    /**
     * 循环队列
     */
    @Test
    public void circular() {
        //循环队列, 这里设置了大小
        CircularFifoQueue<String> que = new CircularFifoQueue<String>(2);
        que.add("a");
        que.add("b");
        que.add("c");
        que.add("d");

        //查看
        for (int i = 0; i < que.size(); i++) {
            System.out.println(que.get(i));
        }

    }

}