package com.demo.java.java8.juc.exercise.demo03;

public class Person implements Runnable {
    private String name;
    private Chopsticks chopsticks1;
    private Chopsticks chopsticks2;

    public Person(String name, Chopsticks chopsticks1, Chopsticks chopsticks2) {
        this.name = name;
        this.chopsticks1 = chopsticks1;
        this.chopsticks2 = chopsticks2;
    }

    public void eat() {
        synchronized (chopsticks1) {
            synchronized (chopsticks2) {
                System.out.println(name + " use " + chopsticks1.getNumber()
                        + ", " + chopsticks2.getNumber() + " to eat!");
            }
        }
    }

    @Override
    public void run() {
        eat();
    }
}
