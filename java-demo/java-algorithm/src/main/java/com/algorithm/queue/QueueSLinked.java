package com.algorithm.queue;

import dsa.exception.QueueEmptyException;

public class QueueSLinked implements Queue {
	private dsa.adt.SLNode front;
	private dsa.adt.SLNode rear;
	private int size;
	public QueueSLinked() {
		front = new dsa.adt.SLNode();
		rear = front;
		size = 0;
	}

	//���ض��еĴ�С
	public int getSize() {
		return size;
	}

	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return size==0;
	}

	//����Ԫ��e���
	public void enqueue(Object e) {
		dsa.adt.SLNode p = new dsa.adt.SLNode(e,null);
		rear.setNext(p);
		rear = p;
		size++;
	}

	//����Ԫ�س���
	public Object dequeue() throws QueueEmptyException {
		if (size<1)
			throw new QueueEmptyException("���󣺶���Ϊ��");
		dsa.adt.SLNode p = front.getNext();
		front.setNext(p.getNext());
		size--;
		if (size<1) rear = front;	//�������Ϊ��,rearָ��ͷ���
		return p.getData();
	}

	//ȡ����Ԫ��
	public Object peek() throws QueueEmptyException {
		if (size<1)
			throw new QueueEmptyException("���󣺶���Ϊ��");
		return front.getNext().getData();
	}	
}
