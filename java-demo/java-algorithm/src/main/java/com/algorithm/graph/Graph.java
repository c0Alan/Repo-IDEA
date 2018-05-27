package com.algorithm.graph;

import dsa.exception.UnsupportedOperation;

public interface Graph {
	public static final int UndirectedGraph = 0;//����ͼ
	public static final int DirectedGraph   = 1;//����ͼ
	
	//����ͼ������
	public int getType();
	//����ͼ�Ķ�����
	public int getVexNum();
	//����ͼ�ı���
	public int getEdgeNum();
	//����ͼ�����ж���
	public Iterator getVertex();
	//����ͼ�����б�
	public Iterator getEdge();
	//ɾ��һ������v
	public void remove(Vertex v);
	//ɾ��һ����e
	public void remove(Edge e);
	//���һ������v
	public Node insert(Vertex v);
	//���һ����e
	public Node insert(Edge e);
	//�ж϶���u��v�Ƿ��ڽӣ����Ƿ��бߴ�u��v
	public boolean areAdjacent(Vertex u, Vertex v);
	//���ش�uָ��v�ıߣ��������򷵻�null
	public Edge edgeFromTo(Vertex u, Vertex v);
	//���ش�u��������ֱ�ӵ�����ڽӶ���
	public Iterator adjVertexs(Vertex u);
	//��ͼ����������ȱ���
	public Iterator DFSTraverse(Vertex v);
	//��ͼ���й�����ȱ���
	public Iterator BFSTraverse(Vertex v);
	//�󶥵�v��������������·��
	public Iterator shortestPath(Vertex v);
	//������ͼ����С������,���������ͼ��֧�ִ˲���
	public void generateMST() throws UnsupportedOperation;
	//������ͼ����������,����ͼ��֧�ִ˲���
	public Iterator toplogicalSort() throws UnsupportedOperation;
	//�������޻�ͼ�Ĺؼ�·��,����ͼ��֧�ִ˲���
	public void criticalPath() throws UnsupportedOperation;
}
