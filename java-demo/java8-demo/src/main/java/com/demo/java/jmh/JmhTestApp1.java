package com.demo.java.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * JMH测试1
 * 参考：https://blog.csdn.net/u014282578/article/details/127952593
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
public class JmhTestApp1 {

    private final static String DATA = "大白有点菜";

    private List<String> arrayList;
    private List<String> linkedList;

    /**
     * 初始化 ArrayList 和 LinkedList
     */
    @Setup(Level.Iteration)
    public void setUp() {
        this.arrayList = new ArrayList<>();
        this.linkedList = new LinkedList<>();
    }

    /**
     * ArrayList的add方法
     *
     * @return
     */
    @Benchmark
    public List<String> arrayListAdd() {
        this.arrayList.add(DATA);
        return arrayList;
    }

    /**
     * LinkedList的add方法
     *
     * @return
     */
    @Benchmark
    public List<String> linkedListAdd() {
        this.linkedList.add(DATA);
        return this.linkedList;
    }

    public static void main(String[] args) throws RunnerException {
        final Options opts = new
                OptionsBuilder().include(JmhTestApp1.class.getSimpleName())
                .forks(1)
                .measurementIterations(10)
                .measurementTime(TimeValue.microseconds(1000000L))
                .warmupIterations(10)
                .warmupTime(TimeValue.microseconds(1000000L))
                .build();
        new Runner(opts).run();
    }
}
