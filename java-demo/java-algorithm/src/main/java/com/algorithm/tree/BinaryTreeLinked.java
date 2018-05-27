package com.algorithm.tree;

import dsa.strategy.Strategy;
import dsa.strategy.DefaultStrategy;

public class BinaryTreeLinked implements BinTree {
	protected BinTreeNode root;
	protected Strategy strategy;
	
	public BinaryTreeLinked(){ this(null); }
	public BinaryTreeLinked(BinTreeNode root) { this(root,new DefaultStrategy());}
	public BinaryTreeLinked(BinTreeNode root, Strategy strategy){
		this.root = root; 
		this.strategy = strategy;
	}

	//�������Ĺ�ģ
	public int getSize() {
		return root==null?0:root.getSize();
	}

	//�ж����Ƿ�Ϊ��
	public boolean isEmpty() { return root==null;}

	//���ظ��������
	public BinTreeNode getRoot() { return root;}

	//��ȡ���ĸ߶�
	public int getHeight() { return isEmpty()?-1:root.getHeight();}

	//�����в���Ԫ��e�����������ڽ��
	public BinTreeNode find(Object e) {
		return searchE(root,e);
	}
	//�ݹ����Ԫ��e
	private BinTreeNode searchE(BinTreeNode rt, Object e) {
		if (rt==null) return null;
		if (strategy.equal(rt.getData(),e)) return rt;	//����Ǹ���㣬���ظ�
		BinTreeNode v = searchE(rt.getLChild(),e);	//����������������
		if (v==null) v = searchE(rt.getRChild(),e);	//û�ҵ���������������
		return v;
	}
	
	//�������������
	public Iterator preOrder() {
		LinkedList list = new LinkedListDLNode();
		preOrderRecursion(this.root,list);
		return list.elements();
	}
	//��������ĵݹ��㷨
	private void preOrderRecursion(BinTreeNode rt, LinkedList list){
		if (rt==null) return;					//�ݹ��,����ֱ�ӷ���
		list.insertLast(rt);					//���ʸ����
		preOrderRecursion(rt.getLChild(),list);	//����������
		preOrderRecursion(rt.getRChild(),list);	//����������
	}
	//��������ķǵݹ��㷨
	private void preOrderTraverse(BinTreeNode rt, LinkedList list){
		if (rt==null) return;
		BinTreeNode p = rt;
		Stack s = new StackSLinked();
		while (p!=null){
			while (p!=null){								//�����ߵ���ͷ
				list.insertLast(p);							//���ʸ�
				if (p.hasRChild()) s.push(p.getRChild());	//�������������ջ
				p = p.getLChild();							
			}
			if (!s.isEmpty()) p = (BinTreeNode)s.pop();		//����������ջ����������
		}
	}
	
	//�������������
	public Iterator inOrder(){
		LinkedList list = new LinkedListDLNode();
		inOrderRecursion(this.root,list);
		return list.elements();
	}
	//��������ĵݹ��㷨
	private void inOrderRecursion(BinTreeNode rt, LinkedList list){
		if (rt==null) return;					//�ݹ��,����ֱ�ӷ���
		inOrderRecursion(rt.getLChild(),list);	//����������
		list.insertLast(rt);					//���ʸ����
		inOrderRecursion(rt.getRChild(),list);	//����������
	}
	//��������ķǵݹ��㷨
	private void inOrderTraverse(BinTreeNode rt, LinkedList list){
		if (rt==null) return;
		BinTreeNode p = rt;
		Stack s = new StackSLinked();
		while (p!=null||!s.isEmpty()){
			while (p!=null){		//һֱ������
				s.push(p);			//���������ջ
				p = p.getLChild();
			}
			if (!s.isEmpty()){
				p = (BinTreeNode)s.pop();//ȡ��ջ����������֮
				list.insertLast(p);
				p = p.getRChild();		//ת��������������б���
			}//if 
		}//out while
	}
	
	//�������������
	public Iterator postOrder(){
		LinkedList list = new LinkedListDLNode();
		postOrderRecursion(this.root,list);
		return list.elements();
	}
	//��������ĵݹ��㷨
	private void postOrderRecursion(BinTreeNode rt, LinkedList list){
		if (rt==null) return;					//�ݹ��,����ֱ�ӷ���
		postOrderRecursion(rt.getLChild(),list);//����������
		postOrderRecursion(rt.getRChild(),list);//����������
		list.insertLast(rt);					//���ʸ����
	}
	//��������ķǵݹ��㷨
	private void postOrderTraverse(BinTreeNode rt, LinkedList list){
		if (rt==null) return;
		BinTreeNode p = rt;
		Stack s = new StackSLinked();
		while(p!=null||!s.isEmpty()){
			while (p!=null){		//������Ҳ�������
				s.push(p);			//�����ڵ���ջ
				if (p.hasLChild()) p = p.getLChild();
				else p = p.getRChild();
			}
			if (!s.isEmpty()){
				p = (BinTreeNode)s.pop();		//ȡ��ջ����������֮
				list.insertLast(p);
			}
			//��������ʱ��˵��ջ�����ڵ��������ѷ��ʣ�Ӧ��ջ����֮
			while (!s.isEmpty()&&((BinTreeNode)s.peek()).getRChild()==p){
				p = (BinTreeNode)s.pop();
				list.insertLast(p);
			}
			//ת��ջ�������������������������
			if (!s.isEmpty()) p = ((BinTreeNode)s.peek()).getRChild();
			else p = null;
		}
	}
	
	//�������������
	public Iterator levelOrder(){
		LinkedList list = new LinkedListDLNode();
		levelOrderTraverse(this.root,list);
		return list.elements();
	}
	//ʹ�ö�����ɶ������İ������
	private void levelOrderTraverse(BinTreeNode rt, LinkedList list){
		if (rt==null) return;
		Queue q = new QueueArray();
		q.enqueue(rt);			//��������
		while (!q.isEmpty()){
			BinTreeNode p = (BinTreeNode)q.dequeue();	//ȡ�����׽��p������
			list.insertLast(p);
			if (p.hasLChild()) q.enqueue(p.getLChild());//��p�ķǿ����Һ����������
			if (p.hasRChild()) q.enqueue(p.getRChild());
		}
	}
}
