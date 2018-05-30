package com.algorithm.tree;

import com.algorithm.linearlist.Node;

/**
 * 二叉查找树
 * 
 * @author liuxilin
 * @date 2018/5/30 23:49
 */
public class BinarySearchTree extends BinaryTreeLinked {
    private BinTreeNode startBN;

    /**
     * 实现了在二叉查找树中查找数据元素的算法
     *
     * @param ele 待查元素ele
     * @return 对应元素在二叉查找树中的结点位置
     */
    public Node search(Object ele) {
        return binTSearchRe(root, ele);
    }

    private Node binTSearchRe(BinTreeNode rt, Object ele) {
        if (rt == null) return null;
        switch (strategy.compare(ele, rt.getData())) {
            case 0:
                return rt; //等于
            case -1:
                return binTSearchRe(rt.getLChild(), ele); //小于
            default:
                return binTSearchRe(rt.getRChild(), ele); //大于
        }
    }

    /**
     * @param rt  根结点rt
     * @param ele 待查元素ele
     * @return 对应元素在rt 为根的二叉查找树中的结点位置
     */
    private Node binTSearch(BinTreeNode rt, Object ele) {
        while (rt != null) {
            switch (strategy.compare(ele, rt.getData())) {
                case 0:
                    return rt; //等于
                case -1:
                    rt = rt.getLChild();
                    break; //小于
                default:
                    rt = rt.getRChild(); //大于
            }
        }
        return null;
    }

    /**
     * 在v 为根的二叉查找树中最小元素的位置
     *
     * @param v
     * @return
     */
    public Node min(BinTreeNode v) {
        if (v != null)
            while (v.hasLChild()) v = v.getLChild();
        return v;
    }

    /**
     * 在v 为根的二叉查找树中最大元素的位置
     *
     * @param v 根结点v
     * @return
     */
    public Node max(BinTreeNode v) {
        if (v != null)
            while (v.hasRChild()) v = v.getRChild();
        return v;
    }

    /**
     * 返回v 在中序遍历序列中的后续结点
     *
     * @param v 根结点v
     * @return
     */
    private BinTreeNode getSuccessor(BinTreeNode v) {
        if (v == null) return null;
        if (v.hasRChild()) return (BinTreeNode) min(v.getRChild());
        while (v.isRChild()) v = v.getParent();
        return v.getParent();
    }

    /**
     * 返回v 在中序遍历序列中的前驱结点
     *
     * @param v 根结点v
     * @return
     */
    private BinTreeNode getPredecessor(BinTreeNode v) {
        if (v == null) return null;
        if (v.hasLChild()) return (BinTreeNode) max(v.getLChild());
        while (v.isLChild()) v = v.getParent();
        return v.getParent();
    }

    /**
     * 在二叉查找树中插入ele
     *
     * @param ele
     */
    public void insert(Object ele) {
        BinTreeNode p = null;
        BinTreeNode current = root;
        while (current != null) { //找到待插入位置
            p = current;
            if (strategy.compare(ele, current.getData()) < 0)
                current = current.getLChild();
            else
                current = current.getRChild();
        }
        startBN = p; //待平衡出发点 ＊
        if (p == null)
            root = new BinTreeNode(ele); //树为空
        else if (strategy.compare(ele, p.getData()) < 0)
            p.setLChild(new BinTreeNode(ele));
        else
            p.setRChild(new BinTreeNode(ele));
    }

    /**
     * 在二叉查找树中删除ele
     *
     * @param ele
     * @return
     */
    public Object remove(Object ele) {
        BinTreeNode v = (BinTreeNode) binTSearch(root, ele);
        if (v == null) return null; //查找失败
        BinTreeNode del = null; //待删结点
        BinTreeNode subT = null; //待删结点的子树
        if (!v.hasLChild() || !v.hasRChild()) //确定待删结点
            del = v;
        else {
            del = getPredecessor(v);
            Object old = v.getData();
            v.setData(del.getData());
            del.setData(old);
        }
        startBN = del.getParent(); //待平衡出发点 ＊
        //此时待删结点只有左子树或右子树
        if (del.hasLChild())
            subT = del.getLChild();
        else
            subT = del.getRChild();
        if (del == root) { //若待删结点为根
            if (subT != null) subT.sever();
            root = subT;
        } else if (subT != null) {
            //del为非叶子结点
            if (del.isLChild()) del.getParent().setLChild(subT);
            else del.getParent().setRChild(subT);
        } else//del为叶子结点
            del.sever();
        return del.getData();
    }
}
