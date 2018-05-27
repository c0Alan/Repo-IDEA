package com.algorithm.queue;

import dsa.exception.QueueEmptyException;

public interface Queue {
	//���ض��еĴ�С
	public int getSize();
	
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty();
	
	//����Ԫ��e���
	public void enqueue(Object e);
	
	//����Ԫ�س���
	public Object dequeue() throws QueueEmptyException;
	
	//ȡ����Ԫ��
	public Object peek() throws QueueEmptyException;
}
