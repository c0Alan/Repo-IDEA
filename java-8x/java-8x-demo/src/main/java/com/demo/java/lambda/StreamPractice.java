package com.demo.java.lambda;


import com.demo.java.entity.Trader;
import com.demo.java.entity.Transaction;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * 练习
 *
 * @author liuxl
 * @date 2024/5/4
 */
public class StreamPractice {
    public static void main(String ...args){    
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
        
        
        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        // 找出2011年发生的所有交易，并按交易额排序（从低到高）。
        List<Transaction> tr2011 = transactions.stream()
                                               .filter(transaction -> transaction.getYear() == 2011)
                                               .sorted(comparing(Transaction::getValue))
                                               .collect(toList());
        System.out.println(tr2011);
        System.out.println("===========================================================");
        
        // Query 2: What are all the unique cities where the traders work?
        // 交易员都在哪些不同的城市工作过？
        List<String> cities = 
            transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .distinct()
                        .collect(toList());
        System.out.println(cities);
        System.out.println("===========================================================");

        // Query 3: Find all traders from Cambridge and sort them by name.
        // 查找所有来自于剑桥的交易员，并按姓名排序。
        List<Trader> traders = 
            transactions.stream()
                        .map(Transaction::getTrader)
                        .filter(trader -> trader.getCity().equals("Cambridge"))
                        .distinct()
                        .sorted(comparing(Trader::getName))
                        .collect(toList());
        System.out.println(traders);
        System.out.println("===========================================================");
        
        
        // Query 4: Return a string of all traders’ names sorted alphabetically.
        // 返回所有交易员的姓名字符串，按字母顺序排序。
        String traderStr = 
            transactions.stream()
                        .map(transaction -> transaction.getTrader().getName())
                        .distinct()
                        .sorted()
                        .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(traderStr);
        System.out.println("===========================================================");
        
        // Query 5: Are there any trader based in Milan?
        // 有没有交易员是在米兰工作的？
        boolean milanBased =
            transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader()
                                                            .getCity()
                                                            .equals("Milan")
                                 );
        System.out.println(milanBased);
        System.out.println("===========================================================");
        
        
        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        // 打印生活在剑桥的交易员的所有交易额。
        transactions.stream()
                    .map(Transaction::getTrader)
                    .filter(trader -> trader.getCity().equals("Milan"))
                    .forEach(trader -> trader.setCity("Cambridge"));
        System.out.println(transactions);
        System.out.println("===========================================================");
        
        
        // Query 7: What's the highest value in all the transactions?
        // 所有交易中，最高的交易额是多少？
        int highestValue = 
            transactions.stream()
                        .map(Transaction::getValue)
                        .reduce(0, Integer::max);
        System.out.println(highestValue);      
    }
}