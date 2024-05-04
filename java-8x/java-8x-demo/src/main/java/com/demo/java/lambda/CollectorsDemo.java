package com.demo.java.lambda;

import com.demo.java.entity.*;
import com.demo.java.entity.Currency;
import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.demo.java.entity.Dish.menu;
import static com.demo.java.entity.Transaction02.transactions;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toSet;

/**
 * stream.collect(Collectors) 统计 分组 多级分组 分区 收集
 *
 * @author liuxl
 * @date 2024/5/4
 */
public class CollectorsDemo {
    public static void main(String[] args) {
    }


    /**
     * Collectors.toMap
     */
    @Test
    public void test08() throws IOException {
        Map<Integer, String> idToName = people().collect(
                Collectors.toMap(Person03::getId, Person03::getName));
        System.out.println("idToName: " + idToName);
        System.out.println("===========================================================");

        Map<Integer, Person03> idToPerson = people().collect(
                Collectors.toMap(Person03::getId, Function.identity()));
        System.out.println("idToPerson: " + idToPerson.getClass().getName() + idToPerson);
        System.out.println("===========================================================");

        idToPerson = people().collect(
                Collectors.toMap(Person03::getId, Function.identity(), (
                        existingValue, newValue) -> {
                    throw new IllegalStateException();
                }, TreeMap::new));
        System.out.println("idToPerson: " + idToPerson.getClass().getName() + idToPerson);
        System.out.println("===========================================================");

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, String> languageNames = locales.collect(
                Collectors.toMap(
                        Locale::getDisplayLanguage,
                        l -> l.getDisplayLanguage(l),
                        (existingValue, newValue) -> existingValue));
        System.out.println("languageNames: " + languageNames);
        System.out.println("===========================================================");

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryLanguageSets = locales.collect(
                Collectors.toMap(
                        Locale::getDisplayCountry,
                        l -> Collections.singleton(l.getDisplayLanguage()),
                        // union of a and b
                        (a, b) -> {
                            Set<String> union = new HashSet<>(a);
                            union.addAll(b);
                            return union;
                        }));
        System.out.println("countryLanguageSets: " + countryLanguageSets);
    }

    public static Stream<Person03> people() {
        return Stream.of(new Person03(1001, "Peter"), new Person03(1002, "Paul"), new Person03(1003, "Mary"));
    }


    /**
     * test06中自定义 Collector 的性能测试
     */
    @Test
    public void test07() {
        System.out.println("Partitioning done in: " + execute(PartitionPrimeNumbers::partitionPrimes) + " msecs");
        System.out.println("Partitioning done in: " + execute(PartitionPrimeNumbers::partitionPrimesWithCustomCollector) + " msecs");
    }

    private static long execute(Consumer<Integer> primePartitioner) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            primePartitioner.accept(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) fastest = duration;
            System.out.println("done in " + duration);
        }
        return fastest;
    }

    /**
     * 自定义Collector，将前n个自然数划分为质数和非质数
     */
    @Test
    public void test06() {
        PartitionPrimeNumbers demo = new PartitionPrimeNumbers();
        System.out.println("partitionPrimes                   : " + demo.partitionPrimes(100));
        System.out.println("partitionPrimesWithCustomCollector: " + demo.partitionPrimesWithCustomCollector(100));

    }


    /**
     * 统计, 计算最大值,最小值,总和,平均值
     */
    @Test
    public void test05() {
        System.out.println("howManyDishes: " + howManyDishes());
        System.out.println("findMostCaloricDish: " + findMostCaloricDish());
        System.out.println("findMostCaloricDishUsingComparator: " + findMostCaloricDishUsingComparator());
        System.out.println("calculateTotalCalories: " + calculateTotalCalories2());
        System.out.println("calculateAverageCalories: " + calculateAverageCalories());
        System.out.println("calculateMenuStatistics: " + calculateMenuStatistics());
        System.out.println("getShortMenu: " + getShortMenu());
        System.out.println("getShortMenuCommaSeparated: " + getShortMenuCommaSeparated());
    }


    private static long howManyDishes() {
        return Dish.menu.stream().collect(counting());
    }

    private static Dish findMostCaloricDish() {
        return Dish.menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)).get();
    }

    private static Dish findMostCaloricDishUsingComparator() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        BinaryOperator<Dish> moreCaloricOf = BinaryOperator.maxBy(dishCaloriesComparator);
        return Dish.menu.stream().collect(reducing(moreCaloricOf)).get();
    }

    private static int calculateTotalCalories2() {
        return Dish.menu.stream().collect(summingInt(Dish::getCalories));
    }

    private static Double calculateAverageCalories() {
        return Dish.menu.stream().collect(averagingInt(Dish::getCalories));
    }

    // 统计, 计算最大值,最小值,总和,平均值,返回 IntSummaryStatistics{count=9, sum=4300, min=120, average=477.777778, max=800}
    private static IntSummaryStatistics calculateMenuStatistics() {
        return Dish.menu.stream().collect(summarizingInt(Dish::getCalories));
    }

    // 合并
    private static String getShortMenu() {
        return Dish.menu.stream().map(Dish::getName).collect(joining());
    }

    // 合并,指定分隔符
    private static String getShortMenuCommaSeparated() {
        return Dish.menu.stream().map(Dish::getName).collect(joining(", "));
    }

    /**
     * reducing 归约、简化为
     */
    @Test
    public void test04() {
        System.out.println("calculateTotalCalories: " + calculateTotalCalories());
        System.out.println("calculateTotalCaloriesWithMethodReference: " + calculateTotalCaloriesWithMethodReference());
        System.out.println("calculateTotalCaloriesWithoutCollectors: " + calculateTotalCaloriesWithoutCollectors());
        System.out.println("calculateTotalCaloriesUsingSum: " + calculateTotalCaloriesUsingSum());
    }

    private static int calculateTotalCalories() {
        return Dish.menu.stream().collect(reducing(0, Dish::getCalories, (Integer i, Integer j) -> i + j));
    }

    private static int calculateTotalCaloriesWithMethodReference() {
        return Dish.menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
    }

    private static int calculateTotalCaloriesWithoutCollectors() {
        return Dish.menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
    }

    private static int calculateTotalCaloriesUsingSum() {
        return Dish.menu.stream().mapToInt(Dish::getCalories).sum();
    }


    /**
     * partitioningBy 分区
     */
    @Test
    public void test03() {
        System.out.println("partitionByVegeterian: " + partitionByVegeterian());
        System.out.println("vegetarianDishesByType: " + vegetarianDishesByType());
        System.out.println("mostCaloricPartitionedByVegetarian: " + mostCaloricPartitionedByVegetarian());
    }

    private static Map<Boolean, List<Dish>> partitionByVegeterian() {
        return Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian));
    }

    private static Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType() {
        return Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
    }

    private static Object mostCaloricPartitionedByVegetarian() {
        return Dish.menu.stream().collect(
                partitioningBy(Dish::isVegetarian,
                        collectingAndThen(
                                maxBy(comparingInt(Dish::getCalories)),
                                Optional::get)));
    }


    /**
     * groupingBy 分组
     */
    @Test
    public void test02() {
        System.out.println("groupDishesByType: " + groupDishesByType());
        System.out.println("groupDishesByCaloricLevel: " + groupDishesByCaloricLevel());
        System.out.println("groupDishedByTypeAndCaloricLevel: " + groupDishedByTypeAndCaloricLevel());
        System.out.println("countDishesInGroups: " + countDishesInGroups());
        System.out.println("mostCaloricDishesByType: " + mostCaloricDishesByType());
        System.out.println("mostCaloricDishesByTypeWithoutOprionals: " + mostCaloricDishesByTypeWithoutOprionals());
        System.out.println("sumCaloriesByType: " + sumCaloriesByType());
        System.out.println("caloricLevelsByType: " + caloricLevelsByType());
    }

    private static Map<Dish.Type, List<Dish>> groupDishesByType() {
        return menu.stream().collect(groupingBy(Dish::getType));
    }

    private static Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevel() {
        return menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }));
    }

    // 多级分组
    private static Map<Dish.Type, Map<CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel() {
        return menu.stream().collect(
                groupingBy(Dish::getType,
                        groupingBy((Dish dish) -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        })
                )
        );
    }

    // 按子组收集数据
    private static Map<Dish.Type, Long> countDishesInGroups() {
        return menu.stream().collect(groupingBy(Dish::getType, counting()));
    }

    private static Map<Dish.Type, Optional<Dish>> mostCaloricDishesByType() {
        return menu.stream().collect(
                groupingBy(Dish::getType,
                        reducing((Dish d1, Dish d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)));
    }

    private static Map<Dish.Type, Dish> mostCaloricDishesByTypeWithoutOprionals() {
        return menu.stream().collect(
                groupingBy(Dish::getType,
                        collectingAndThen(
                                reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2),
                                Optional::get)));
    }

    private static Map<Dish.Type, Integer> sumCaloriesByType() {
        return menu.stream().collect(groupingBy(Dish::getType,
                summingInt(Dish::getCalories)));
    }

    private static Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType() {
        return menu.stream().collect(
                groupingBy(Dish::getType, mapping(
                        dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        },
                        toSet())));
    }

    /**
     * Collectors.groupingBy 分组
     */
    @Test
    public void test01() {
        groupImperatively();
        System.out.println("===========================================================");
        groupFunctionally();

    }

    private static void groupImperatively() {
        Map<Currency, List<Transaction02>> transactionsByCurrencies = new HashMap<>();
        for (Transaction02 transaction : transactions) {
            com.demo.java.entity.Currency currency = transaction.getCurrency();
            List<Transaction02> transactionsForCurrency = transactionsByCurrencies.get(currency);
            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrencies.put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }

        System.out.println(transactionsByCurrencies);
    }

    private static void groupFunctionally() {
        Map<Currency, List<Transaction02>> transactionsByCurrencies = transactions.stream().collect(groupingBy(Transaction02::getCurrency));
        System.out.println(transactionsByCurrencies);
    }
}
