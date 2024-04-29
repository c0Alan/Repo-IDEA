package com.demo.java.designpatterns.structure.composite;

import org.junit.Test;

/**
 * Composite 组合模式，组合模式用于表示对象的层次结构，将对象组合成树形结构以表示“整体-部分”的层次结构。
 * 常见如树结构体
 *
 * @author liuxl
 * @date 2024/4/29
 */
public class CompositeDemo {

    public static void main(String[] args) {

    }

    @Test
    public void test01() {
        Tree tree = new Tree("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");

        nodeB.add(nodeC);
        tree.root.add(nodeB);
        System.out.println("build the tree finished!");
    }
}
