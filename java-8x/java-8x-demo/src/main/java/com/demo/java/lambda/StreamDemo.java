package com.demo.java.lambda;

import com.demo.java.entity.Dish;
import com.demo.java.entity.ForkJoinSumCalculator;
import com.demo.java.entity.ParallelStreams;
import com.demo.java.entity.WordCount;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.demo.java.entity.Dish.menu;
import static com.demo.java.entity.WordCount.SENTENCE;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

/**
 * Stream 流示例
 *
 * @author liuxl
 * @date 2024/5/3
 */
public class StreamDemo {


    /**
     * Optional 示例
     */
    @Test
    public void test10() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("alice30.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));

        Optional<String> optionalValue = wordList.stream()
                .filter(s -> s.contains("fred"))
                .findFirst();
        System.out.println(optionalValue.orElse("No word") + " contains fred");

        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("N/A");
        System.out.println("result: " + result);
        result = optionalString.orElseGet(() -> Locale.getDefault().getDisplayName());
        System.out.println("result: " + result);
        try {
            result = optionalString.orElseThrow(IllegalStateException::new);
            System.out.println("result: " + result);
        } catch (Throwable t) {
            t.printStackTrace();
        }

        optionalValue = wordList.stream()
                .filter(s -> s.contains("red"))
                .findFirst();
        optionalValue.ifPresent(s -> System.out.println(s + " contains red"));

        Set<String> results = new HashSet<>();
        optionalValue.ifPresent(results::add);
        Optional<Boolean> added = optionalValue.map(results::add);
        System.out.println(added);

        System.out.println(inverse(4.0).flatMap(StreamDemo::squareRoot));
        System.out.println(inverse(-1.0).flatMap(StreamDemo::squareRoot));
        System.out.println(inverse(0.0).flatMap(StreamDemo::squareRoot));
        Optional<Double> result2 = Optional.of(-4.0).flatMap(StreamDemo::inverse).flatMap(StreamDemo::squareRoot);
        System.out.println(result2);
    }

    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }


    /**
     * 自定义Spliterator接口实现单词统计功能
     */
    @Test
    public void test09() {
        WordCount wc = new WordCount();
        System.out.println("Found " + wc.countWordsIteratively(SENTENCE) + " words");
        System.out.println("Found " + wc.countWords(SENTENCE) + " words");
    }

    /**
     * parallel() 并行流，装拆箱操作耗时
     */
    @Test
    public void test08() {
        System.out.println("iterativeSum: " + measurePerf(ParallelStreams::iterativeSum, 10_000_000L) + " msecs");
        System.out.println("sequentialSum: " + measurePerf(ParallelStreams::sequentialSum, 10_000_000L) + " msecs");
        System.out.println("parallelSum: " + measurePerf(ParallelStreams::parallelSum, 10_000_000L) + " msecs");
        System.out.println("rangedSum: " + measurePerf(ParallelStreams::rangedSum, 10_000_000L) + " msecs");
        System.out.println("parallelRangedSum: " + measurePerf(ParallelStreams::parallelRangedSum, 10_000_000L) + " msecs");
        System.out.println("forkJoinSum: " + measurePerf(ForkJoinSumCalculator::forkJoinSum, 10_000_000L) + " msecs");
        System.out.println("sideEffectSum: " + measurePerf(ParallelStreams::sideEffectSum, 10_000_000L) + " msecs");
        System.out.println("sideEffectParallelSum: " + measurePerf(ParallelStreams::sideEffectParallelSum, 10_000_000L) + " msecs");
    }

    public static <T, R> long measurePerf(Function<T, R> f, T input) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            R result = f.apply(input);
            long duration = (System.nanoTime() - start) / 1_000_000;
//            System.out.println("Result: " + result);
            if (duration < fastest) fastest = duration;
        }
        return fastest;
    }

    /**
     * 并行流，线程不安全的示例
     */
    @Test
    public void test081() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("alice30.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+")); // 非字母分隔符

        // 结果错误,线程不安全 Very bad code ahead
        int[] shortWords = new int[10];
        wordList.parallelStream().forEach(s -> {
            if (s.length() < 10) {
                shortWords[s.length()]++;
            }
        });
        System.out.println(Arrays.toString(shortWords));
        System.out.println("===========================================================");

        // 结果错误 Try again--the result will likely be different (and also wrong)
        Arrays.fill(shortWords, 0);
        wordList.parallelStream().forEach(s -> {
            if (s.length() < 10) {
                shortWords[s.length()]++;
            }
        });
        System.out.println(Arrays.toString(shortWords));
        System.out.println("===========================================================");

        // Remedy: Group and count
        Map<Integer, Long> shortWordCounts = wordList.parallelStream()
                .filter(s -> s.length() < 10)
                .collect(groupingBy(String::length, counting()));
        System.out.println(shortWordCounts);
        System.out.println("===========================================================");

        // Downstream order not deterministic
        Map<Integer, List<String>> result = wordList.parallelStream().collect(
                Collectors.groupingByConcurrent(String::length));
        System.out.println(result.get(14));
        System.out.println("===========================================================");

        result = wordList.parallelStream().collect(
                Collectors.groupingByConcurrent(String::length));
        System.out.println(result.get(14));
        System.out.println("===========================================================");

        Map<Integer, Long> wordCounts = wordList.parallelStream().collect(
                groupingByConcurrent(String::length, counting()));
        System.out.println(wordCounts);
    }


    /**
     * 构建流
     * Stream.of
     * Stream.iterate
     * Stream.generate
     */
    @Test
    public void test07() throws Exception {

        // Stream.of
        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);
        System.out.println("===========================================================");

        // Stream.empty
        Stream<String> emptyStream = Stream.empty();

        // Arrays.stream
        int[] numbers = {2, 3, 5, 7, 11, 13};
        System.out.println(Arrays.stream(numbers).sum());
        System.out.println("===========================================================");

        // Stream.iterate 无限流
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
        System.out.println("===========================================================");

        // fibonnaci with iterate
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));
        System.out.println("===========================================================");

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);
        System.out.println("===========================================================");

        // random stream of doubles with Stream.generate
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);
        System.out.println("===========================================================");

        // stream of 1s with Stream.generate
        IntStream.generate(() -> 1)
                .limit(5)
                .forEach(System.out::println);
        System.out.println("===========================================================");

        IntStream.generate(new IntSupplier() {
                    public int getAsInt() {
                        return 2;
                    }
                }).limit(5)
                .forEach(System.out::println);
        System.out.println("===========================================================");


        IntSupplier fib = new IntSupplier() {
            private int previous = 0;
            private int current = 1;

            public int getAsInt() {
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return this.previous;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);
        System.out.println("===========================================================");

        long uniqueWords = Files.lines(Paths.get("data2.txt"), Charset.defaultCharset())
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .count();

        System.out.println("There are " + uniqueWords + " unique words in data.txt");


    }


    /**
     * mapToInt 数值流
     * IntStream
     */
    @Test
    public void test06() {

        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);

        Arrays.stream(numbers.toArray()).forEach(System.out::println);
        System.out.println("===========================================================");

        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("Number of calories:" + calories);
        System.out.println("===========================================================");


        // max and OptionalInt
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();

        int max;
        if (maxCalories.isPresent()) {
            max = maxCalories.getAsInt();
        } else {
            // we can choose a default value
            max = 1;
        }
        System.out.println(max);
        System.out.println("===========================================================");

        // numeric ranges
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);

        System.out.println(evenNumbers.count());
        System.out.println("===========================================================");

        // 计算勾股数，a^2 + b^2 = c^2
        Stream<int[]> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 100)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed()
                                .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));

        pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

    }


    /**
     * reduce 归约、简化为、
     */
    @Test
    public void test05() {

        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        // 0 是初始值，a是当前值，b是下一个值，即 sum=0, sum=sum+x
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        int max = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        System.out.println(max);

        // reduce还有一个重载的变体，它不接受初始值，但是会返回一个Optional对象
        // 为什么它返回一个Optional<Integer>呢？考虑流中没有任何元素的情况。reduce操作无法返回其和，
        // 因为它没有初始值。这就是为什么结果被包裹在一个Optional对象里，以表明和可能不存在。
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        min.ifPresent(System.out::println);

        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("Number of calories:" + calories);
    }


    /**
     * 查找和匹配
     * anyMatch 返回 boolean
     * allMatch 返回 boolean
     * noneMatch 返回 boolean
     * findAny 返回 Optional 返回当前流中的任意元素
     * findFirst 返回 Optional 返回当前流中的第一个元素，与 findAny 的区别在于findAny并行运行效率比较高，findFirst是串行
     */
    @Test
    public void test04() {
        if (isVegetarianFriendlyMenu()) {
            System.out.println("Vegetarian friendly");
        }

        System.out.println(isHealthyMenu());
        System.out.println(isHealthyMenu2());

        // 可能无返回值，所以返回 Optional 类型
        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent(d -> System.out.println(d.getName()));
    }

    private static boolean isVegetarianFriendlyMenu() {
        return menu.stream().anyMatch(Dish::isVegetarian);
    }

    private static boolean isHealthyMenu() {
        return menu.stream().allMatch(d -> d.getCalories() < 1000);
    }

    private static boolean isHealthyMenu2() {
        return menu.stream().noneMatch(d -> d.getCalories() >= 1000);
    }

    private static Optional<Dish> findVegetarianDish() {
        return menu.stream().filter(Dish::isVegetarian).findAny();
    }


    /**
     * 映射
     * map 这个函数会被应用到每个元素上，并将其映射成一个新的元素
     * flatMap ，flatmap方法让你把一个流中的每个值都换成另一个流，然后把所有的流连接起来成为一个流。
     */
    @Test
    public void test03() {

        // map
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(dishNames);
        System.out.println("===========================================================");

        // map
        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);
        System.out.println("===========================================================");

        // flatMap
        words.stream()
                .flatMap((String line) -> Arrays.stream(line.split("")))
                .distinct()
                .forEach(System.out::println);
        System.out.println("===========================================================");

        // flatMap
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbers2 = Arrays.asList(6, 7, 8);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap((Integer i) -> numbers2.stream()
                                .map((Integer j) -> new int[]{i, j})
                        )
                        .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                        .collect(toList());
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    }


    /**
     * 筛选和切片
     * filter 过滤
     * distinct 去重
     * limit 返回limit数量的流
     * skip 跳过
     */
    @Test
    public void test02() {

        // Filtering with predicate
        List<Dish> vegetarianMenu =
                menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(toList());

        vegetarianMenu.forEach(System.out::println);
        System.out.println("===========================================================");


        // Filtering unique elements
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
        System.out.println("===========================================================");

        // Truncating a stream
        List<Dish> dishesLimit3 =
                menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .limit(3)
                        .collect(toList());

        dishesLimit3.forEach(System.out::println);
        System.out.println("===========================================================");

        // Skipping elements
        List<Dish> dishesSkip2 =
                menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .skip(2)
                        .collect(toList());

        dishesSkip2.forEach(System.out::println);

    }

    /**
     * 获取低卡路里的菜式
     */
    @Test
    public void test01() {
        // Java 7
        getLowCaloricDishes01(Dish.menu).forEach(System.out::println);

        System.out.println("===========================================================");

        // Java 8
        getLowCaloricDishes02(Dish.menu).forEach(System.out::println);

    }

    /**
     * Comparator 方式实现
     */
    public static List<String> getLowCaloricDishes01(List<Dish> dishes) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : dishes) {
            if (d.getCalories() > 400) {
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    /**
     * stream 方式实现
     */
    public static List<String> getLowCaloricDishes02(List<Dish> dishes) {
        return dishes.stream()
                .filter(d -> d.getCalories() > 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }
}
