package com.demo.java.entity;

import com.demo.java.enums.Currency;

import java.util.Arrays;
import java.util.List;

public class Transaction02 {
        private final Currency currency;
        private final double value;

    public static List<Transaction02> transactions = Arrays.asList(new Transaction02(Currency.EUR, 1500.0),
            new Transaction02(Currency.USD, 2300.0),
            new Transaction02(Currency.GBP, 9900.0),
            new Transaction02(Currency.EUR, 1100.0),
            new Transaction02(Currency.JPY, 7800.0),
            new Transaction02(Currency.CHF, 6700.0),
            new Transaction02(Currency.EUR, 5600.0),
            new Transaction02(Currency.USD, 4500.0),
            new Transaction02(Currency.CHF, 3400.0),
            new Transaction02(Currency.GBP, 3200.0),
            new Transaction02(Currency.USD, 4600.0),
            new Transaction02(Currency.JPY, 5700.0),
            new Transaction02(Currency.EUR, 6800.0));

        public Transaction02(Currency currency, double value) {
            this.currency = currency;
            this.value = value;
        }

        public Currency getCurrency() {
            return currency;
        }

        public double getValue() {
            return value;
        }

        @Override
        public String toString() {
            return currency + " " + value;
        }
    }