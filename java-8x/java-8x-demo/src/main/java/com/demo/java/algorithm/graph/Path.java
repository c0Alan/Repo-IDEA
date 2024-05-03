package com.demo.java.algorithm.graph;


import com.demo.java.algorithm.linearlist.*;

/**
 * Path �ඨ��
 * 
 * @author liuxilin
 * @date 2018/5/30 22:24
 */
public class Path {
    private int distance;    //������յ�ľ���
    private Vertex start;    //�����Ϣ
    private Vertex end;        //�յ���Ϣ
    private LinkedList pathInfo;//��㵽�յ������·��

    public Path() {
        this(Integer.MAX_VALUE, null, null);
    }

    public Path(int distance, Vertex start, Vertex end) {
        this.distance = distance;
        this.start = start;
        this.end = end;
        pathInfo = new LinkedListDLNode();
    }

    //�ж�������յ�֮���Ƿ����·��
    public boolean hasPath() {
        return distance != Integer.MAX_VALUE && start != null && end != null;
    }

    //��·������
    public int pathLength() {
        if (!hasPath()) return -1;
        else if (start == end) return 0;
        else return pathInfo.getSize() + 1;
    }

    //get&set methods
    public void setDistance(int dis) {
        distance = dis;
    }

    public void setStart(Vertex v) {
        start = v;
    }

    public void setEnd(Vertex v) {
        end = v;
    }

    public int getDistance() {
        return distance;
    }

    public Vertex getStart() {
        return start;
    }

    public Vertex getEnd() {
        return end;
    }

    public Iterator getPathInfo() {
        return pathInfo.elements();
    }

    //���·����Ϣ
    public void clearPathInfo() {
        pathInfo = new LinkedListDLNode();
    }

    //���·����Ϣ
    public void addPathInfo(Object info) {
        pathInfo.insertLast(info);
    }

}
