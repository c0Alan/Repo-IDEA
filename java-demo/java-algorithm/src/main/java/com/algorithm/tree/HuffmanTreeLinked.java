package com.algorithm.tree;

import com.algorithm.tree.BinaryTreeLinked;
import dsa.strategy.Strategy;
import dsa.strategy.DefaultStrategy;

public class HuffmanTreeLinked extends BinaryTreeLinked {
	public HuffmanTreeLinked(HuffmanTreeNode[] nodes) {
		this(nodes,new DefaultStrategy());
		
	}
	public HuffmanTreeLinked(HuffmanTreeNode[] nodes, Strategy strategy){
		super(buildHuffmanTree(nodes),strategy);
		generateHuffmanCode((HuffmanTreeNode)super.getRoot());
	}
	
	//����Huffman������Ҷ�ӽ��
	public Iterator getAllLeafs(){
		LinkedList list = new LinkedListDLNode();
		getLeafs(getRoot(),list);
		return list.elements();
	}
	private void getLeafs(HuffmanTreeNode root, LinkedList list){
		if (root==null) return;
		if (root.isLeaf()) list.insertLast(root);
		getLeafs(root.getLChild(),list);
		getLeafs(root.getRChild(),list);
	}
	
	//�ݹ�����Huffman����
	private static void generateHuffmanCode(HuffmanTreeNode root){
		if (root==null) return;
		if (root.hasParent()){
			if (root.isLChild()) root.setCoding(root.getParent().getCoding() + "0");
			else				 root.setCoding(root.getParent().getCoding() + "1");
		}
		generateHuffmanCode(root.getLChild());
		generateHuffmanCode(root.getRChild());
	}
	
	//ͨ�������������Huffman��
	private static HuffmanTreeNode buildHuffmanTree(HuffmanTreeNode[] nodes){
		int n = nodes.length;
		if (n<2) return nodes[0];
		List l = new ListArray();	//��������Ա���weight�Ӵ�С����
		for (int i=0; i<n; i++)		//�������һ�������Ա�
			insertToList(l,nodes[i]);
		for (int i=1; i<n; i++){	//ѡ��weight��С���������ϲ���ѭ��n-1��
			HuffmanTreeNode min1 = (HuffmanTreeNode)l.remove(l.getSize()-1);//ѡ��weight��С����
			HuffmanTreeNode min2 = (HuffmanTreeNode)l.remove(l.getSize()-1);//ѡ��weight��С����
			HuffmanTreeNode newRoot = new HuffmanTreeNode(min1.getWeight()+min2.getWeight());//�ϲ�
			newRoot.setLChild(min1);
			newRoot.setRChild(min2);
			insertToList(l,newRoot);//�����������Ա�
		}
		return (HuffmanTreeNode)l.get(0);//����Huffman���ĸ�
	}
	//����㰴��weight�Ӵ�С��˳��������Ա�
	private static void insertToList(List l, HuffmanTreeNode node){
		for (int j=0; j<l.getSize(); j++)
			if (node.getWeight()>((HuffmanTreeNode)l.get(j)).getWeight()){
				l.insert(j,node);
				return;
			}
		l.insert(l.getSize(),node);
	}
	
	public HuffmanTreeNode getRoot(){
		return (HuffmanTreeNode)super.getRoot();
	}
}
