package com.algorithm.linearlist;

import dsa.exception.OutOfBoundaryException;

public interface List {
	//�������Ա�Ĵ�С��������Ԫ�صĸ�����
	public int getSize();
	
	//������Ա�Ϊ�շ���true�����򷵻�false��
	public boolean isEmpty();
	
	//�ж����Ա��Ƿ��������Ԫ��e
	public boolean contains(Object e);
	
	//��������Ԫ��e�����Ա��е����
	public int indexOf(Object e);
	
	//������Ԫ��e���뵽���Ա���i��λ��
	public void insert(int i, Object e) throws OutOfBoundaryException;
	
	//������Ԫ��e���뵽Ԫ��obj֮ǰ
	public boolean insertBefore(Object obj, Object e);
	
	//������Ԫ��e���뵽Ԫ��obj֮��
	public boolean insertAfter(Object obj, Object e);
	
	//ɾ�����Ա������Ϊi��Ԫ��,������֮
	public Object remove(int i) throws OutOfBoundaryException;
	
	//ɾ�����Ա��е�һ����e��ͬ��Ԫ��
	public boolean remove(Object e);
	
	//�滻���Ա������Ϊi������Ԫ��Ϊe������ԭ����Ԫ��
	public Object replace(int i, Object e) throws OutOfBoundaryException;
	
	//�������Ա������Ϊi������Ԫ��
	public Object get(int i) throws OutOfBoundaryException;
}
