package com.demo.java;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 层序遍历二叉树
 *
 * @author liuxl
 * @date 2024/5/25
 */
@Slf4j
public class Helloworld2 {
    public static void main(String[] args) {
        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeE = new TreeNode("E");
        TreeNode nodeF = new TreeNode("F");
        TreeNode nodeG = new TreeNode("G");
        TreeNode nodeH = new TreeNode("H");
        TreeNode nodeI = new TreeNode("I");

        nodeA.setLChild(nodeB);
        nodeA.setRChild(nodeC);

        nodeB.setLChild(nodeD);
        nodeB.setRChild(nodeE);
        nodeC.setLChild(nodeF);
        nodeC.setRChild(nodeG);

        nodeE.setLChild(nodeH);
        nodeF.setRChild(nodeI);

        Map<Integer, ArrayList> map = new HashMap<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        int curLevel = 1;
        list.add(nodeA);
        map.put(curLevel, list);

        while (true) {
            System.out.println(curLevel);
            ArrayList<TreeNode> list2 = map.get(curLevel);
            System.out.println(list2);

            curLevel++;
            ArrayList<TreeNode> list3 = new ArrayList<>();
            for (TreeNode node : list2){
                if (node.hasLChild()){
                    list3.add(node.getLChild());
                }
                if (node.hasRChild()){
                    list3.add(node.getRChild());
                }
            }

            if (list3.size() == 0)
            {
                break;
            }

            map.put(curLevel, list3);
        }

    }

    public static class TreeNode {
        private TreeNode lChild;    //左孩子
        private TreeNode rChild;    //右孩子
        private String val; // 值


        public TreeNode(String val) {
            this.val = val;
        }


        /******与lChild相关的方法******/
        //取左孩子
        public TreeNode getLChild() {
            return lChild;
        }

        //设置当前结点的左孩子,返回原左孩子
        public TreeNode setLChild(TreeNode lc) {
            this.lChild = lc;
            return lChild;                //返回原左孩子
        }

        public boolean hasLChild() {
            if (lChild != null)
                return true;
            return false;
        }

        /******与rChild相关的方法******/
        //取右孩子
        public TreeNode getRChild() {
            return rChild;
        }

        //设置当前结点的右孩子,返回原右孩子
        public TreeNode setRChild(TreeNode rc) {
            this.rChild = rc;
            return rChild;                //返回原左孩子
        }

        public boolean hasRChild() {
            if (rChild != null) {
                return true;
            }
            return false;
        }

        public String toString() {
            return val;
        }

    }
}
