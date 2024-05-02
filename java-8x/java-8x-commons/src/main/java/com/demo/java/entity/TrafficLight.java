package com.demo.java.entity;

/**
 * 用法二：switch
 *
 * @author liuxl
 * @date 2018/4/7 9:20
 */


public class TrafficLight {
    public Signal color = Signal.RED;

    public void change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
        }
    }
} 