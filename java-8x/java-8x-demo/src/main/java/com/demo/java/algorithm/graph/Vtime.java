package com.demo.java.algorithm.graph;

/**
 * ����v �����翪ʼʱ������ٿ�ʼʱ��
 * 
 * @author liuxilin
 * @date 2018/5/30 22:26
 */
public class Vtime {
    private int ve;    //���緢��ʱ��
    private int vl;    //��ٷ���ʱ��

    //���췽��
    public Vtime() {
        this(0, Integer.MAX_VALUE);
    }

    public Vtime(int ve, int vl) {
        this.ve = ve;
        this.vl = vl;
    }

    //get&set method
    public int getVE() {
        return ve;
    }

    public int getVL() {
        return vl;
    }

    public void setVE(int t) {
        ve = t;
    }

    public void setVL(int t) {
        vl = t;
    }
}
