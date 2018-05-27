package com.algorithm.tree;

import com.algorithm.search.SearchTable;
import dsa.strategy.Strategy;
import dsa.strategy.DefaultStrategy;

public class BSTree extends BinaryTreeLinked implements SearchTable{
	protected dsa.adt.BinTreeNode startBN;			//��AVL��������ƽ�����ʼ���
	//���췽��
	public BSTree() { this(new DefaultStrategy());}
	public BSTree(Strategy strategy){
		this.root = null;
		this.strategy = strategy;
		startBN = null;
	}
	
	//��ѯ���ұ�ǰ�Ĺ�ģ
	public int getSize(){
		return root==null?0:root.getSize();
	}
	
	//�жϲ��ұ��Ƿ�Ϊ��
	public boolean isEmpty(){
		return getSize()==0;
	}
	
	//���ز��ұ�����Ԫ��ele�ؼ�����ͬ��Ԫ��λ�ã����򣬷���null
	public Node search(Object ele){
		return binTSearch(root, ele);
	}
	private Node binTSearchRe(dsa.adt.BinTreeNode rt, Object ele){
		if (rt==null) return null;
		switch(strategy.compare(ele,rt.getData()))
		{
			case  0: return rt;								//����
			case -1: return binTSearchRe(rt.getLChild(),ele);//С��
			default: return binTSearchRe(rt.getRChild(),ele);//����
		}
	}
	private Node binTSearch(dsa.adt.BinTreeNode rt, Object ele){
		while(rt!=null){
			switch(strategy.compare(ele,rt.getData()))
			{
				case  0: return rt;					//����
				case -1: rt = rt.getLChild(); break;//С��
				default: rt = rt.getRChild(); 		//����
			}
		}
		return null;
	}
	
	//�������йؼ�����Ԫ��ele��ͬ��Ԫ��λ��
	public Iterator searchAll(Object ele){
		LinkedList list = new dsa.adt.LinkedListDLNode();
		binTSearchAll(root, ele, list);
		return list.elements();
	}
	public void binTSearchAll(dsa.adt.BinTreeNode rt, Object ele, LinkedList list){
		if (rt==null) return;
		int comp = strategy.compare(ele,rt.getData());
		if (comp<=0) binTSearchAll(rt.getLChild(),ele,list);
		if (comp==0) list.insertLast(rt);
		if (comp>=0) binTSearchAll(rt.getRChild(),ele,list);
	}
	
	//���ؼ��ֲ���Ԫ��ele
	public void insert(Object ele){
		dsa.adt.BinTreeNode p = null;
		dsa.adt.BinTreeNode current = root;
		while (current!=null){				//�ҵ�������λ��
			p = current;
			if (strategy.compare(ele,current.getData())<0)
				current = current.getLChild();
			else
				current = current.getRChild();
		}
		startBN = p;						//��ƽ�������
		if (p==null)
			root = new dsa.adt.BinTreeNode(ele);	//��Ϊ��
		else if (strategy.compare(ele,p.getData())<0)
			p.setLChild(new dsa.adt.BinTreeNode(ele));
		else
			p.setRChild(new dsa.adt.BinTreeNode(ele));
	}
	
	//�����ұ��д�����Ԫ��ele�ؼ�����ͬԪ�أ���ɾ��һ�������أ����򣬷���null
	public Object remove(Object ele){
		dsa.adt.BinTreeNode v = (dsa.adt.BinTreeNode)binTSearch(root,ele);
		if (v==null) return null;			//����ʧ��
		dsa.adt.BinTreeNode del = null;				//��ɾ���
		dsa.adt.BinTreeNode subT = null;			//del������
		if (!v.hasLChild()||!v.hasRChild())	//ȷ����ɾ���
			del = v;
		else{
			del = getPredecessor(v);
			Object old = v.getData();
			v.setData(del.getData());
			del.setData(old);
		}
		startBN = del.getParent();			//��ƽ�������
		//��ʱ��ɾ���ֻ����������������
		if (del.hasLChild())
			subT = del.getLChild();
		else
			subT = del.getRChild();
		if (del==root) {					//����ɾ���Ϊ��
			if (subT!=null) subT.sever();
			root = subT;
		} else
		if (subT!=null){
			//delΪ��Ҷ�ӽ��
			if (del.isLChild()) del.getParent().setLChild(subT);
			else del.getParent().setRChild(subT);
		}
		else//delΪҶ�ӽ��
			del.sever();
		return del.getData();
	}
	
	//������vΪ���Ķ������������С(��)Ԫ�ص�λ��
	public Node min(dsa.adt.BinTreeNode v){
		if (v!=null)
			while (v.hasLChild()) v = v.getLChild();
		return v;
	}
	public Node max(dsa.adt.BinTreeNode v){
		if (v!=null)
			while (v.hasRChild()) v = v.getRChild();
		return v;
	}
	
	//���ؽ��v��������������е�ǰ�����
	private dsa.adt.BinTreeNode getPredecessor(dsa.adt.BinTreeNode v){
		if (v==null) return null;
		if (v.hasLChild()) return (dsa.adt.BinTreeNode)max(v.getLChild());
		while (v.isLChild()) v = v.getParent();
		return v.getParent();
	}
	//���ؽ��v��������������еĺ������
	private dsa.adt.BinTreeNode getSuccessor (dsa.adt.BinTreeNode v){
		if (v==null) return null;
		if (v.hasRChild()) return (dsa.adt.BinTreeNode)min(v.getRChild());
		while (v.isRChild()) v = v.getParent();
		return v.getParent();
	}
}
