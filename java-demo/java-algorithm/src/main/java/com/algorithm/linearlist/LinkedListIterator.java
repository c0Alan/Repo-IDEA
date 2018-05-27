package com.algorithm.linearlist;

import com.algorithm.tree.Iterator;
import dsa.exception.OutOfBoundaryException;

public class LinkedListIterator implements Iterator {
	private LinkedList list;//���ӱ�
	private Node current;//��ǰ���

	//���췽��
	public LinkedListIterator(LinkedList list) {
		this.list = list;
		if (list.isEmpty())		//���б�Ϊ��
			current = null;		//��ǰԪ���ÿ�
		else
			current = list.first();//����ӵ�һ��Ԫ�ؿ�ʼ
	}
	
	//�ƶ�����һ��Ԫ��
	public void first(){
		if (list.isEmpty())		//���б�Ϊ��
			current = null;		//��ǰԪ���ÿ�
		else
			current = list.first();//����ӵ�һ��Ԫ�ؿ�ʼ		
	}
	
	//�ƶ�����һ��Ԫ��
	public void next() throws OutOfBoundaryException{
		if (isDone()) 
			throw new OutOfBoundaryException("�����Ѿ�û��Ԫ�ء�");
		if (current==list.last()) current = null;
		else current = list.getNext(current);
	}
	
	//�����������Ƿ���ʣ���Ԫ��
	public boolean isDone() { return current==null; }
	
	//���ص�ǰԪ��
	public Object currentItem() throws OutOfBoundaryException{
		if (isDone()) 
			throw new OutOfBoundaryException("�����Ѿ�û��Ԫ�ء�");
		return current.getData();
	}
}