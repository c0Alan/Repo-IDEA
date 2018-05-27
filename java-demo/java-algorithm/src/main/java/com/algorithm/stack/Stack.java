package com.algorithm.stack;

import dsa.exception.StackEmptyException;

public interface Stack {
	//���ض�ջ�Ĵ�С
	public int getSize();
	
	//�ж϶�ջ�Ƿ�Ϊ��
	public boolean isEmpty();
	
	//����Ԫ��e��ջ
	public void push(Object e);
	
	//ջ��Ԫ�س�ջ
	public Object pop() throws StackEmptyException;
	
	//ȡջ��Ԫ��
	public Object peek() throws StackEmptyException;
}
