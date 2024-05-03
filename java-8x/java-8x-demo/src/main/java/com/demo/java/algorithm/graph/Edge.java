package com.demo.java.algorithm.graph;


import com.demo.java.algorithm.linearlist.Node;

/**
 * ˫��ʽ�洢�ṹ�ı߶���
 * 
 * @author liuxilin
 * @date 2018/5/30 22:16
 */
public class Edge {
    public static final int NORMAL = 0;
    public static final int MST = 1;    //MST��
    public static final int CRITICAL = 2;//�ؼ�·���еı�
    private int weight;        //Ȩֵ
    private Object info;    //�ߵ���Ϣ
    private Node edgePosition;        //���ڱ߱��е�λ��
    private Node firstVexPosition;    //�ߵĵ�һ������ڶ�����
    private Node secondVexPosition;    //�ڶ�����е�λ��
    private Node edgeFirstPosition;    //���ڵ�һ������������ڽӣ����ڽӣ��߱��е�λ��
    private Node egdeSecondPosition;//������ͼ�о���������������ڽӱ��е�λ��
    private int type;        //�ߵ�����
    private int graphType;    //����ͼ������

    //���췽��:��ͼG������һ���±�,�䶥��Ϊu��v
    public Edge(Graph g, Vertex u, Vertex v, Object info) {
        this(g, u, v, info, 1);
    }

    public Edge(Graph g, Vertex u, Vertex v, Object info, int weight) {
        this.info = info;
        this.weight = weight;
        edgePosition = g.insert(this);
        firstVexPosition = u.getVexPosition();
        secondVexPosition = v.getVexPosition();
        type = Edge.NORMAL;
        graphType = g.getType();
        if (graphType == Graph.UndirectedGraph) {
            //���������ͼ,��Ӧ������������������ڽӱ߱�
            edgeFirstPosition = u.getAdjacentEdges().insertLast(this);
            egdeSecondPosition = v.getAdjacentEdges().insertLast(this);
        } else {
            //���������ͼ,�߼�����ʼ����ڽӱ߱�,��ֹ������ڽӱ߱�
            edgeFirstPosition = u.getAdjacentEdges().insertLast(this);
            egdeSecondPosition = v.getReAdjacentEdges().insertLast(this);
        }
    }

    //get&set methods
    public Object getInfo() {
        return info;
    }

    public void setInfo(Object obj) {
        this.info = info;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getFirstVex() {
        return (Vertex) firstVexPosition.getData();
    }

    public Vertex getSecondVex() {
        return (Vertex) secondVexPosition.getData();
    }

    public Node getFirstVexPosition() {
        return firstVexPosition;
    }

    public Node getSecondVexPosition() {
        return secondVexPosition;
    }

    public Node getEdgeFirstPosition() {
        return edgeFirstPosition;
    }

    public Node getEdgeSecondPosition() {
        return egdeSecondPosition;
    }

    public Node getEdgePosition() {
        return edgePosition;
    }

    //��ߵ�������صķ���
    public void setToMST() {
        type = Edge.MST;
    }

    public void setToCritical() {
        type = Edge.CRITICAL;
    }

    public void resetType() {
        type = Edge.NORMAL;
    }

    public boolean isMSTEdge() {
        return type == Edge.MST;
    }

    public boolean isCritical() {
        return type == Edge.CRITICAL;
    }
}
