package com.algorithm.graph;

import com.algorithm.graph.AbstractGraph;
import com.algorithm.linearlist.LinkedList;
import com.algorithm.linearlist.LinkedListDLNode;
import dsa.exception.UnsupportedOperation;

public class UndirectedGraph extends AbstractGraph {
	
	public UndirectedGraph() {
		super(UndirectedGraph);
	}

	//ɾ��һ������v
	public void remove(Vertex v) {
		while(v.getDeg()>0){
			Edge e = (Edge)v.getAdjacentEdges().first().getData();
			remove(e);
		}
		vertexs.remove(v.getVexPosition());
	}

	//ɾ��һ����e
	public void remove(Edge e) {
		edges.remove(e.getEdgePosition());
		Vertex u = e.getFirstVex();
		Vertex v = e.getSecondVex();
		u.getAdjacentEdges().remove(e.getEdgeFirstPosition());
		v.getAdjacentEdges().remove(e.getEdgeSecondPosition());
	}

	//���ش�uָ��v�ıߣ��������򷵻�null
	public Edge edgeFromTo(Vertex u, Vertex v){
		LinkedList adjEdge = u.getAdjacentEdges();
		Iterator it = adjEdge.elements();
		for(it.first(); !it.isDone(); it.next()){
			Edge e = (Edge)it.currentItem();
			if (e.getSecondVex()==v||e.getFirstVex()==v)
				return e;
		}
		return null;
	}
	
	//���ش�u��������ֱ�ӵ�����ڽӶ���
	public Iterator adjVertexs(Vertex u){
		LinkedList adjVex = new LinkedListDLNode();
		LinkedList adjEdge = u.getAdjacentEdges();
		Iterator it = adjEdge.elements();
		for(it.first(); !it.isDone(); it.next()){
			Edge e = (Edge)it.currentItem();
			Vertex i = e.getFirstVex();
			Vertex j = e.getSecondVex();
			if (i==u) adjVex.insertLast(j);
			else adjVex.insertLast(i);
		}
		return adjVex.elements();
	}

	//������ͼ����С������,���������ͼ��֧�ִ˲���
	//ǰ��������ͼ����ͨͼ,�㷨���ж�ͼ����ͨ��
	public void generateMST(){
		resetVexStatus();	//����ͼ�и������״̬��Ϣ
		resetEdgeType();	//����ͼ�и��ߵ�������Ϣ
		Iterator it = getVertex();
		Vertex v = (Vertex)it.currentItem();//ѡ��һ��������Ϊ���
		v.setToVisited();		//����v���뼯��S,��visited=true��ʾ����S����������S
		//��ʼ�����㼯��S��V-S���������̺��б�
		for(it.first(); !it.isDone(); it.next()){
			Vertex u = (Vertex)it.currentItem();
			Edge e = edgeFromTo(v,u);
			setCrossEdge(u,e);	//���õ���V-S�ж���u����̺��б�
		}
		for (int t=1;t<getVexNum();t++){	//����|V|-1��ѭ���ҵ�|V|-1����
			Vertex k = selectMinVertex(it);//�м䶥��k
			k.setToVisited();				//����k����S
			Edge mst = getCrossEdge(k);		//��(S , V - S) �����
			if (mst!=null) mst.setToMST();	//���߼���MST
			//��kΪ�м䶥���޸�S��V-S�ж������̺��б�
			Iterator adjIt = adjVertexs(k);	//ȡ��k�������ڽӵ�
			for(adjIt.first(); !adjIt.isDone(); adjIt.next()){
				Vertex adjV = (Vertex)adjIt.currentItem();
				Edge e = this.edgeFromTo(k,adjV);
				if (e.getWeight()<getCrossWeight(adjV))//���ֵ���adjV���̵ĺ��б�
					setCrossEdge(adjV,e);
			}//for
		}//for(int t=1...
	}
	//���������V-S�еĶ���
	protected Vertex selectMinVertex(Iterator it){
		Vertex min = null;
		for(it.first(); !it.isDone(); it.next()){
			Vertex v = (Vertex)it.currentItem();
			if(!v.isVisited()){ min = v; break;}
		}
		for(; !it.isDone(); it.next()){
			Vertex v = (Vertex)it.currentItem();
			if(!v.isVisited()&&getCrossWeight(v)<getCrossWeight(min))
				min = v;
		}
		return min;
	} 
	//��MSTʱ����v.application�Ĳ���
	protected int getCrossWeight(Vertex v){ 
		if (getCrossEdge(v)!=null) return getCrossEdge(v).getWeight();
		else return Integer.MAX_VALUE;
	}
	protected Edge getCrossEdge(Vertex v){ return (Edge)v.getAppObj();}
	protected void setCrossEdge(Vertex v, Edge e){ v.setAppObj(e);}
	
	//������ͼ����������,����ͼ��֧�ִ˲���
	public Iterator toplogicalSort() throws UnsupportedOperation{
		throw new UnsupportedOperation("��֧�ִ˲���");
	}

	//�������޻�ͼ�Ĺؼ�·��,����ͼ��֧�ִ˲���
	public void criticalPath() throws UnsupportedOperation{
		throw new UnsupportedOperation("��֧�ִ˲���");
	}
}
