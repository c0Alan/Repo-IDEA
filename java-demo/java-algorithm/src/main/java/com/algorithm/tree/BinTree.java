package com.algorithm.tree;

public interface BinTree {
	//�������Ĺ�ģ
	public int getSize();
	//�ж����Ƿ�Ϊ��
	public boolean isEmpty();
	//���ظ��������
	public BinTreeNode getRoot();
	//��ȡ���ĸ߶�
	public int getHeight();
	//�����в���Ԫ��e�����������ڽ��
	public BinTreeNode find(Object e);
	//�������������
	public Iterator preOrder();
	//�������������
	public Iterator inOrder();
	//�������������
	public Iterator postOrder();
	//�������������
	public Iterator levelOrder();
}
