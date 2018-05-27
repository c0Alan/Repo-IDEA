package com.algorithm.linearlist;

import com.algorithm.tree.DLNode;
import dsa.exception.InvalidNodeException;
import dsa.exception.OutOfBoundaryException;
import com.algorithm.tree.Iterator;

public class LinkedListDLNode implements LinkedList {
	private int size;	//��ģ
	private DLNode head;//ͷ���,��Ԫ���
	private DLNode tail;//β���,��Ԫ���
	public LinkedListDLNode() {
		size = 0;
		head = new DLNode();//����ֻ��ͷβ��������
		tail = new DLNode();
		head.setNext(tail);
		tail.setPre(head);
	}
	//�����������жϽ��p�Ƿ�Ϸ�����Ϸ�ת��ΪDLNode
	private DLNode checkPosition(Node p) throws InvalidNodeException {
		if (p==null)
			throw new InvalidNodeException("����pΪ�ա�");
		if (p==head)
			throw new InvalidNodeException("����pָ��ͷ�ڵ㣬�Ƿ���");
		if (p==tail)
			throw new InvalidNodeException("����pָ��β��㣬�Ƿ���");
		DLNode node = (DLNode)p;
		return node;
	}
	
	//��ѯ���ӱ�ǰ�Ĺ�ģ
	public int getSize() {
		return size;
	}

	//�ж����ӱ��Ƿ�Ϊ��
	public boolean isEmpty() {
		return size==0;
	}

	//���ص�һ�����
	public Node first() throws OutOfBoundaryException{
		if (isEmpty())
			throw new OutOfBoundaryException("�������ӱ�Ϊ�ա�");
		return head.getNext();
	}

	//�������һ���
	public Node last() throws OutOfBoundaryException{
		if (isEmpty())
			throw new OutOfBoundaryException("�������ӱ�Ϊ�ա�");
		return tail.getPre();
	}

	//����p֮��Ľ��
	public Node getNext(Node p) throws InvalidNodeException, OutOfBoundaryException {
		DLNode node = checkPosition(p);
		node = node.getNext();
		if (node==tail)
			throw new OutOfBoundaryException("�����Ѿ������ӱ�β�ˡ�");
		return node;
	}

	//����p֮ǰ�Ľ��
	public Node getPre(Node p) throws InvalidNodeException, OutOfBoundaryException {
		DLNode node = checkPosition(p);
		node = node.getPre();
		if (node==head)
			throw new OutOfBoundaryException("�����Ѿ������ӱ�ǰ�ˡ�");
		return node;
	}

	//��e��Ϊ��һ��Ԫ�ز������ӱ�
	public Node insertFirst(Object e) {
		DLNode node = new DLNode(e,head,head.getNext());
		head.getNext().setPre(node);
		head.setNext(node);
		size++;
		return node;
	}

	//��e��Ϊ���һ��Ԫ�ز����б�,������e���ڽ��
	public Node insertLast(Object e) {
		DLNode node = new DLNode(e,tail.getPre(),tail);
		tail.getPre().setNext(node);
		tail.setPre(node);
		size++;
		return node;
	}

	//��e������p֮���λ��,������e���ڽ��
	public Node insertAfter(Node p, Object e) throws InvalidNodeException {
		DLNode node = checkPosition(p);
		DLNode newNode = new DLNode(e,node,node.getNext());
		node.getNext().setPre(newNode);
		node.setNext(newNode);
		size++;
		return newNode;
	}

	//��e������p֮ǰ��λ��,������e���ڽ��
	public Node insertBefore(Node p, Object e) throws InvalidNodeException {
		DLNode node = checkPosition(p);
		DLNode newNode = new DLNode(e,node.getPre(),node);
		node.getPre().setNext(newNode);
		node.setPre(newNode);
		size++;
		return newNode;
	}

	//ɾ������λ�ô���Ԫ�أ�������֮
	public Object remove(Node p) throws InvalidNodeException {
		DLNode node = checkPosition(p);
		Object obj = node.getData();
		node.getPre().setNext(node.getNext());
		node.getNext().setPre(node.getPre());
		size--;
		return obj;
	}

	//ɾ����Ԫ�أ�������֮
	public Object removeFirst() throws OutOfBoundaryException{
		return remove(head.getNext());
	}

	//ɾ��ĩԪ�أ�������֮
	public Object removeLast() throws OutOfBoundaryException{
		return remove(tail.getPre());
	}

	//�����ڸ���λ�õ�Ԫ���滻Ϊ��Ԫ�أ������ر��滻��Ԫ��
	public Object replace(Node p, Object e) throws InvalidNodeException {
		DLNode node = checkPosition(p);
		Object obj = node.getData();
		node.setData(e);
		return obj;
	}

	//Ԫ�ص�����
	public Iterator elements() {
		return new LinkedListIterator(this);
	}	
}
