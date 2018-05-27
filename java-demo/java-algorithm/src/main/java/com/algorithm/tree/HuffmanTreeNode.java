package com.algorithm.tree;

public class HuffmanTreeNode extends BinTreeNode {
	private int weight;			//Ȩֵ
	private String coding = "";	//����
	
	public HuffmanTreeNode(int weight){
		this(weight,null);
	}
	public HuffmanTreeNode(int weight, Object e){
		super(e);
		this.weight = weight;
	}
	
	//��д���෽��
	public HuffmanTreeNode getParent() {
		return (HuffmanTreeNode)super.getParent();
	}
	public HuffmanTreeNode getLChild() {
		return (HuffmanTreeNode)super.getLChild();
	}
	public HuffmanTreeNode getRChild() {
		return (HuffmanTreeNode)super.getRChild();
	}
	//get&set����
	public int getWeight(){ return weight;}
	public String getCoding(){ return coding;}
	public void setCoding(String coding){ this.coding = coding;}	
}
