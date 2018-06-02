package com.juc.exercise.demo02;

public class T implements  Runnable{

    protected State state;
    protected int ii ;
    protected String tag;

    public T(State state, int ii, String tag) {
        this.state = state;
        this.ii = ii;
        this.tag = tag;
    }

    public void doPrint(int j){
        synchronized (state){
            while (!state.isOk(ii)){
                try {
                    state.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(j+":"+tag);
            state.ok(ii);
            state.notifyAll();
        }
    }

    @Override
    public void run() {
        for(int j = 0; j < 10; j++){
            doPrint(j);
        }
    }
}