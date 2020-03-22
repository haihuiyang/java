package com.yhh.example;

/**
 * @author happyfeet
 * @since Mar 03, 2020
 */
public class JudgeBinarySearchTree {

    private static int minValue = Integer.MIN_VALUE;
    private static boolean flag = true;

    /*
        假设树中节点的 value 均大于 Integer.MIN_VALUE
        利用二叉查找树中序遍历是升序的特点，通过 minValue 接收遍历的值，在遍历的过程中，如果出现了 node.value < minValue 的情况，则不是二叉查找树
     */
    public static boolean isBinarySearchNode(Node node) {

        if (node.left != null && flag) {
            isBinarySearchNode(node.left);
        }

        if (node.value < minValue) {
            flag = false;
        }

        minValue = node.value;

        if (node.right != null && flag) {
            isBinarySearchNode(node.right);
        }

        return flag;
    }

    private static class Node {
        private int value;
        private Node left;
        private Node right;
    }

}
