package com.jd.java8.juc.exercise.demo02;

public class State {
    private volatile boolean[] state;
    public State() {
       state = new boolean[3];
       state[0] = false;
       state[1] = false;
       state[2] = true;
    }

    public boolean isOk(int ii){
        return state[(ii-1+3)%3];
    }

    public void ok(int ii){
        state[ii] = true;
        state[(ii-1+3)%3] = false;
    }
}