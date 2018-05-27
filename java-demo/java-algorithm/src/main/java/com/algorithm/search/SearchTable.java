package com.algorithm.search;


public interface SearchTable {
	//��ѯ���ұ�ǰ�Ĺ�ģ
	public int getSize();
	//�жϲ��ұ��Ƿ�Ϊ��
	public boolean isEmpty();
	//���ز��ұ�����Ԫ��ele�ؼ�����ͬ��Ԫ��λ�ã����򣬷���null
	public Node search(Object ele);
	//�������йؼ�����Ԫ��ele��ͬ��Ԫ��λ��
	public Iterator searchAll(Object ele);
	//���ؼ��ֲ���Ԫ��ele
	public void insert(Object ele);
	//�����ұ��д�����Ԫ��ele�ؼ�����ͬԪ�أ���ɾ��һ�������أ����򣬷���null
	public Object remove(Object ele);
}
