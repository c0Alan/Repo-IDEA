package com.algorithm.linearlist;

import dsa.exception.OutOfBoundaryException;
import dsa.strategy.Strategy;
import dsa.strategy.DefaultStrategy;

public class ListArray implements List {
	
	private final int LEN = 8;	//�����Ĭ�ϴ�С
	private Strategy strategy;	//����Ԫ�رȽϲ���
	private int size;			//���Ա�������Ԫ�صĸ���
	private Object[] elements;	//����Ԫ������

	public ListArray() {
		this(new DefaultStrategy());
	}
	
	public ListArray(Strategy strategy){
		this.strategy = strategy;
		size = 0;
		elements = new Object[LEN];
	}
	
	//�������Ա�Ĵ�С��������Ԫ�صĸ�����
	public int getSize() {
		return size;
	}

	//������Ա�Ϊ�շ���true�����򷵻�false��
	public boolean isEmpty() {
		return size==0;
	}

	//�ж����Ա��Ƿ��������Ԫ��e
	public boolean contains(Object e) {
		for (int i=0; i<size; i++)
			if (strategy.equal(e,elements[i])) return true;
		return false;
	}

	//��������Ԫ��e�����Ա��е����
	public int indexOf(Object e) {
		for (int i=0; i<size; i++)
			if (strategy.equal(e,elements[i])) return i;
		return -1;
	}

	//������Ԫ��e���뵽���Ա���i��λ��
	public void insert(int i, Object e) throws OutOfBoundaryException {
		if (i<0||i>size)
			throw new OutOfBoundaryException("����ָ���Ĳ������Խ�硣");
		if (size >= elements.length)
			expandSpace();
		for (int j=size; j>i; j--)
			elements[j] = elements[j-1];
		elements[i] = e;
		size++;
		return;
	}
	
	private void expandSpace(){
		Object[] a = new Object[elements.length*2];
		for (int i=0; i<elements.length; i++)
			a[i] = elements[i];
		elements = a;
	}

	//������Ԫ��e���뵽Ԫ��obj֮ǰ
	public boolean insertBefore(Object obj, Object e) {
		int i = indexOf(obj);
		if (i<0) return false;
		insert(i,e);
		return true;
	}

	//������Ԫ��e���뵽Ԫ��obj֮��
	public boolean insertAfter(Object obj, Object e) {
		int i = indexOf(obj);
		if (i<0) return false;
		insert(i+1,e);
		return true;
	}

	//ɾ�����Ա������Ϊi��Ԫ��,������֮
	public Object remove(int i) throws OutOfBoundaryException {
		if (i<0||i>=size)
			throw new OutOfBoundaryException("����ָ����ɾ�����Խ�硣");
		Object obj = elements[i];
		for (int j=i; j<size-1; j++)
			elements[j] = elements[j+1];
		elements[--size] = null;
		return obj;
	}

	//ɾ�����Ա��е�һ����e��ͬ��Ԫ��
	public boolean remove(Object e) {
		int i = indexOf(e);
		if (i<0) return false;
		remove(i);
		return true;
	}

	//�滻���Ա������Ϊi������Ԫ��Ϊe������ԭ����Ԫ��
	public Object replace(int i, Object e) throws OutOfBoundaryException {
		if (i<0||i>=size)
			throw new OutOfBoundaryException("����ָ�������Խ�硣");
		Object obj = elements[i];
		elements[i] = e;
		return obj;
	}

	//�������Ա������Ϊi������Ԫ��
	public Object get(int i) throws OutOfBoundaryException {
		if (i<0||i>=size)
			throw new OutOfBoundaryException("����ָ�������Խ�硣");
		return elements[i];
	}
}
