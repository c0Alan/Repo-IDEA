package com.algorithm.tree;

import dsa.strategy.Strategy;

public class AVLTree extends BSTree {
	
	public AVLTree() { super();}
	public AVLTree(Strategy strategy) { super(strategy); }
	
	private boolean isBalance(dsa.adt.BinTreeNode v){
		if (v==null)	return true;
		int lH = (v.hasLChild()) ? v.getLChild().getHeight():-1;
		int rH = (v.hasRChild()) ? v.getRChild().getHeight():-1;
		return (Math.abs(lH - rH)<=1);
	}
	
	private dsa.adt.BinTreeNode higherSubT(dsa.adt.BinTreeNode v){
		if (v==null) return null;
		int lH = (v.hasLChild()) ? v.getLChild().getHeight():-1;
		int rH = (v.hasRChild()) ? v.getRChild().getHeight():-1;
		if (lH>rH) return v.getLChild();
		if (lH<rH) return v.getRChild();
		if (v.isLChild()) return v.getLChild();
		else return v.getRChild();
	}
	
	private dsa.adt.BinTreeNode rotate(dsa.adt.BinTreeNode z){
		dsa.adt.BinTreeNode y = higherSubT(z);		//ȡyΪz���ߵĺ���
		dsa.adt.BinTreeNode x = higherSubT(y);		//ȡxΪy���ߵĺ���
		boolean isLeft = z.isLChild();		//��¼��z�Ƿ�����
		dsa.adt.BinTreeNode p = z.getParent();		//pΪz�ĸ���
		dsa.adt.BinTreeNode a, b, c;				//�������ң������ڵ�
		dsa.adt.BinTreeNode t0, t1, t2, t3;			//�������ң��Ŀ�����
		// ���·��������
		if (y.isLChild()) {					//��y�����ӣ���
			c = z;	t3 = z.getRChild();
			if (x.isLChild()) {				//��x������(����ʧ��)
				b = y;	t2 = y.getRChild();
				a = x;	t1 = x.getRChild();	t0 = x.getLChild();
			} else {						//��x���Һ���(����ʧ��)
				a = y;	t0 = y.getLChild();
				b = x;	t1 = x.getLChild();	t2 = x.getRChild();
			}
		} else {							//��y���Һ��ӣ���
			a = z;	t0 = z.getLChild();
			if (x.isRChild()) {				//��x���Һ���(����ʧ��)
				b = y;	t1 = y.getLChild();
				c = x;	t2 = x.getLChild();	t3 = x.getRChild();
			} else {						//��x������(����ʧ��)
				c = y;	t3 = y.getRChild();
				b = x;	t1 = x.getLChild();	t2 = x.getRChild();
			}
		}

		//ժ�������ڵ�
		z.sever();
		y.sever();
		x.sever();

		//ժ���Ŀ�����
		if (t0!=null) t0.sever();
		if (t1!=null) t1.sever();
		if (t2!=null) t2.sever();
		if (t3!=null) t3.sever();

		//��������
		a.setLChild(t0);	a.setRChild(t1);
		c.setLChild(t2);	c.setRChild(t3);
		b.setLChild(a);		b.setRChild(c);

		//�������½���ԭ��
		if (p!=null)
			if (isLeft)	p.setLChild(b);
			else		p.setRChild(b);

		return b;//�����µ�������
	}
	
	private dsa.adt.BinTreeNode reBalance(dsa.adt.BinTreeNode v){
		if (v==null)	return root;
		dsa.adt.BinTreeNode c = v;
		while (v!=null) {						//��v��ʼ��������һ���z������
			if (!isBalance(v))	v = rotate(v);	//��vʧ�⣬����תʹ֮����ƽ��
			c = v;
			v = v.getParent();					//��������丸��
		}//while
		return c;
	}
	
	//���ؼ��ֲ���Ԫ��ele
	public void insert(Object ele){
		super.insert(ele);
		root = reBalance(startBN);
	}
	
	//�����ұ��д�����Ԫ��ele�ؼ�����ͬԪ�أ���ɾ��һ�������أ����򣬷���null
	public Object remove(Object ele){
		Object obj = super.remove(ele);
		root = reBalance(startBN);
		return obj;
	}
}
