package com.algorithm.queue;

import dsa.exception.QueueEmptyException;

public class QueueArray implements Queue {
	private static final int CAP = 7;//����Ĭ�ϴ�С
	private Object[] elements;	//����Ԫ������
	private int capacity;		//����Ĵ�Сelements.length
	private int front;			//����ָ��,ָ�����
	private int rear;			//��βָ��,ָ���β��һ��λ��
	public QueueArray() {
		this(CAP);
	}
	public QueueArray(int cap){
		capacity = cap + 1;
		elements = new Object[capacity];
		front = rear = 0;
	}

	//���ض��еĴ�С
	public int getSize() {
		return (capacity-front+rear)%capacity;
	}

	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return front==rear;
	}

	//����Ԫ��e���
	public void enqueue(Object e) {
		if (getSize()==capacity-1) expandSpace();
		elements[rear] = e;
		rear = (rear+1)%capacity;
	}
	private void expandSpace(){
		Object[] a = new Object[elements.length*2];
		int i = front;
		int j = 0;
		while (i!=rear){
			a[j++] = elements[i];
			i = (i+1)%capacity;
		}
		elements = a;
		capacity = elements.length;
		front = 0;
		rear = j;
	}
	
	//����Ԫ�س���
	public Object dequeue() throws QueueEmptyException {
		if (isEmpty())
			throw new QueueEmptyException("���󣺶���Ϊ��");
		Object obj = elements[front];
		elements[front] = null;
		front = (front+1)%capacity;
		return obj;
	}

	//ȡ����Ԫ��
	public Object peek() throws QueueEmptyException {
		if (isEmpty())
			throw new QueueEmptyException("���󣺶���Ϊ��");
		return elements[front];
	}	
}
