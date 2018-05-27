package com.algorithm.stack;

import com.algorithm.stack.Stack;
import dsa.exception.StackEmptyException;

public class StackArray implements Stack {
	
	private final int LEN = 4;	//�����Ĭ�ϴ�С
	private Object[] elements;	//����Ԫ������
	private int top;			//ջ��ָ��
	
	public StackArray() {
		top = -1;
		elements = new Object[LEN];
	}

	//���ض�ջ�Ĵ�С
	public int getSize() {
		return top+1;
	}

	//�ж϶�ջ�Ƿ�Ϊ��
	public boolean isEmpty() {
		return top<0;
	}

	//����Ԫ��e��ջ
	public void push(Object e) {
		if (getSize()>=elements.length) expandSpace();
		elements[++top] = e;
	}
	
	private void expandSpace(){
		Object[] a = new Object[elements.length*2];
		for (int i=0; i<elements.length; i++)
			a[i] = elements[i];
		elements = a;
	}

	//ջ��Ԫ�س�ջ
	public Object pop() throws StackEmptyException {
		if (getSize()<1)
			throw new StackEmptyException("���󣬶�ջΪ�ա�");
		Object obj = elements[top];
		elements[top--] = null;
		return obj;
	}

	//ȡջ��Ԫ��
	public Object peek() throws StackEmptyException {
		if (getSize()<1)
			throw new StackEmptyException("���󣬶�ջΪ�ա�");
		return elements[top];
	}	
}
