package com.demo.java.juc.pool;

import org.junit.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author liuxl
 * @date 2024/4/27
 * @description CompletableFuture
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*CompletableFutureDemo demo = new CompletableFutureDemo();
        demo.test12();*/

        test05();
    }

    /**
     * CompletableFuture.allOf, 并行执行，多任务结果合并。
     */
    @Test
    public void test12() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        // 创建一个CompletableFuture列表
        List<CompletableFuture<String>> futureList = Arrays.asList(
                CompletableFuture.supplyAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    return "Result1";
                }),
                CompletableFuture.supplyAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    return "Result2";
                }),
                CompletableFuture.supplyAsync(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    return "Result3";
                })
        );

        // 使用allOf合并所有CompletableFuture，然后获取最终的结果列表
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]));
        combinedFuture.get(); // 等待所有CompletableFuture完成

        // 使用流将CompletableFuture的结果收集到列表中
        List<String> results = futureList.stream()
                .map(CompletableFuture::join) // 获取CompletableFuture的结果
                .collect(Collectors.toList());

        // 输出结果
        results.forEach(System.out::println);
        System.out.println("cost time: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * CompletableFuture.runAfterBothAsync,
     * 跟runAfterBoth不同的是，这个方法会使用指定的线程池来执行操作，可以使操作在另外一个线程上异步执行，避免当前线程阻塞等待操作完成。
     */
    public static void test11() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello";
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 123;
        });

        CompletableFuture<Void> future3 = future1.runAfterBothAsync(future2, () -> {
            System.out.println("Both completed.");
        }, Executors.newFixedThreadPool(1));

        future3.get(); // 阻塞等待任务完成

        System.out.println("cost time: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * CompletableFuture.runAfterBoth ,
     * 在当前 CompletableFuture 和另一个 CompletableFuture 都完成后执行一个特定的操作，无需合并结果，并返回一个新的 CompletableFuture<Void> 对象（因为该方法没有返回值）。
     */
    public static void test10() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello";
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 123;
        });

        CompletableFuture<Void> future3 = future1.runAfterBoth(future2, () -> {
            System.out.println("Both completed.");
        });

        future3.get(); // 阻塞等待任务完成

        System.out.println("cost time: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * CompletableFuture.thenAcceptBothAsync,跟thenAcceptBoth不同的是，这个方法会使用指定的线程池来执行操作，可以使操作在另外一个线程上异步执行，避免当前线程阻塞等待操作完成。
     */
    public static void test09() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello";
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 123;
        });

        CompletableFuture<Void> future3 = future1.thenAcceptBothAsync(future2, (s, i) -> {
            System.out.println(s + " " + i); // 输出：Hello 123
        }, Executors.newFixedThreadPool(1));

        future3.get(); // 阻塞等待任务完成

        System.out.println("cost time: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * CompletableFuture.thenAcceptBoth,
     * 并行执行，将两个 CompletableFuture 的结果合并，然后执行特定的操作（使用传入的 BiConsumer 对象对合并结果进行处理），并返回一个新的 CompletableFuture<Void> 对象（因为该方法没有返回值）。
     */
    public static void test08() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello";
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 123;
        });

        CompletableFuture<Void> future3 = future1.thenAcceptBoth(future2, (s, i) -> {
            System.out.println(s + " " + i); // 输出：Hello 123
        });

        future3.get(); // 阻塞等待任务完成

        System.out.println("cost time: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * CompletableFuture.thenCombineAsync,
     * 并行执行有返回，对当前 CompletableFuture 对象和另一个 CompletableFuture 对象的结果进行转换，并返回一个新的 CompletableFuture 对象，使用默认的 ForkJoinPool 执行异步任务。
     * 与 thenComposeAsync 方法不同的是，thenCombineAsync 方法返回的 CompletableFuture 对象只包含两个异步任务的结果中的一个。
     */
    public static void test07() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "World";
        });

        CompletableFuture<String> combinedFuture = future1.thenCombineAsync(future2, (result1, result2) -> {
            return result1 + " " + result2;
        });

        System.out.println("Combined future result: " + combinedFuture.join());

        System.out.println("cost time: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * CompletableFuture.thenCompose ,
     * 串行执行有返回，将上一个 CompletableFuture 的结果转换为另一个 CompletableFuture输入
     */
    @Test
    public void test06() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hello";
        });
        CompletableFuture<String> future2 = future1.thenCompose(s -> CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return s + "World";
        }));
        CompletableFuture<String> future3 = future2.thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " I'm robot."));
        String result = future3.get(); // 阻塞等待任务完成并获取结果
        System.out.println(result); // 输出：Hello, world! I'm robot.
        System.out.println("cost time: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * CompletableFuture.thenApplyAsync,
     * 串行执行有返回 ,对已有 CompletableFuture 对象的结果进行异步转换。
     * 串行执行，任务B需等任务A执行完再执行
     */
    public static void test05() {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });

        CompletableFuture<Integer> transformedFuture = future.thenApplyAsync(result -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return result.length();
        });

        System.out.println("Transformed future result: " + transformedFuture.join());
        System.out.println("cost time: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * CompletableFuture.thenApply,
     * 串行执行有返回 ,对已有 CompletableFuture 对象的结果进行异步转换。
     * 串行执行，任务B需等任务A执行完再执行
     */
    @Test
    public void test051() {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> taskA = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1010);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String id = UUID.randomUUID().toString();
            System.out.println("执行任务A：" + id);
            return id;
        });
        CompletableFuture<String> taskB = taskA.thenApply(result -> {
            try {
                Thread.sleep(1010);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务B获取到任务A结果：" + result);
            result = result.replace("-", "");
            return result;
        });

        System.out.println("main线程拿到结果：" + taskB.join());
        System.out.println("cost time: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * CompletableFuture.thenAccept,
     * 串行执行有返回 , 套路和thenApply一样，都是任务A和任务B的拼接。
     * 前置任务需要有返回结果，后置任务会接收前置任务的结果，返回后置任务，没有返回值
     */
    @Test
    public void test052() {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> taskA = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1010);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String id = UUID.randomUUID().toString();
            System.out.println("执行任务A：" + id);
            return id;
        });
        CompletableFuture<Void> taskB = taskA.thenAccept(result -> {
            try {
                Thread.sleep(1010);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务B获取到任务A结果：" + result);
        });

        // 加入主线程
        taskB.join();

        System.out.println("cost time: " + (System.currentTimeMillis() - startTime) + "ms");
    }


    /**
     * CompletableFuture.anyOf,
     * 并行执行，返回值为第一个结束线程的返回值，根据多个 CompletableFuture 对象生成一个新的 CompletableFuture 对象，等待任意一个异步任务执行完毕后，返回该异步任务的结果。
     * 使用 CompletableFuture.anyOf 方法等待多个 CompletableFuture 对象中的任意一个执行完毕
     * anyOf 方法返回第一个 CompletableFuture 对象结果值
     */
    public static void test04() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1010);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "World";
        });

        CompletableFuture<Object> anyFuture = CompletableFuture.anyOf(future1, future2);

        // 调用 thenAccept 方法处理 CompletableFuture 对象的结果
        anyFuture.thenAccept(result -> System.out.println("Result: " + result));

        String joinResult = (String) anyFuture.join();
        System.out.println("Join result: " + joinResult);
        System.out.println("cost time: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * CompletableFuture.allOf,
     * 并行执行无返回值，根据多个 CompletableFuture 对象生成一个新的 CompletableFuture 对象，等待所有异步任务执行完毕后，把所有的异步任务结果封装到一个数组对象中并返回。
     * allOf 方法返回的 CompletableFuture 对象并不包含任何结果值
     */
    public static void test03() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "World";
        });

        CompletableFuture<Void> allFuture = CompletableFuture.allOf(future1, future2);

        allFuture.join();

//        System.out.println("allFuture result: " + allFuture.join());
        System.out.println("Future1 result: " + future1.get());
        System.out.println("Future2 result: " + future2.get());
        System.out.println("cost time: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * CompletableFuture.runAsync
     * 并行执行无返回值,根据指定的 Runnable 函数生成一个新的 CompletableFuture 对象，使用默认的 ForkJoinPool 执行异步任务。
     * 实现对一个任务进行异步处理，并在任务完成后输出一条日志
     */
    @Test
    public void test02() throws ExecutionException, InterruptedException {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor(); //定义线程池
        executor.setCorePoolSize(5); //核心线程数
        executor.setMaxPoolSize(10); //最大线程数
        executor.setQueueCapacity(1000); //等待队列大小
        executor.initialize(); //初始化线程池

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            //模拟异步任务
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Async task executed.");
        }, executor); //指定线程池

        future.thenRun(() -> System.out.println("Async task completed."));

        //等待异步任务执行完毕
        future.join();

        //关闭线程池
        executor.shutdown();
    }

    /**
     * CompletableFuture.supplyAsync,
     * 并行执行有返回值，根据指定的 Supplier 函数生成一个新的 CompletableFuture 对象，使用默认的 ForkJoinPool 执行异步任务。
     * 实现对两个字符串进行异步处理，并将它们合并起来
     */
    @Test
    public void test01() throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            //模拟异步任务
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            //模拟异步任务
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "World";
        });

//        future2.thenRun(() -> System.out.println("World returned."));

        CompletableFuture<String> result = future1.thenCombine(future2, (str1, str2) -> str1 + " " + str2);

        //当异步任务完成后，获取结果并输出到控制台
//        result.thenAccept(System.out::println);
        System.out.println(result.get());
        System.out.println("cost time: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    @Test
    public void test(){
        CompletableFuture.runAsync(() -> {
            System.out.println("Hello");
        });
    }
}
