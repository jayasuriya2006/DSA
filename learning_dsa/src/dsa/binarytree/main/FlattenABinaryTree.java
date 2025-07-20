package dsa.binarytree.main;

import java.util.Stack;

public class FlattenABinaryTree {

    static BinaryTreeNode<Integer> prev = null;


    //TC - O(N)
    //SC - O(N)
    public static void flattenATreeUsingRecursion(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return;
        }

        flattenATreeUsingRecursion(node.right);
        flattenATreeUsingRecursion(node.left);

        node.right = prev;
        node.left = null;
        prev = node;

    }

    //TC - O(N)
    //SC - O(N)
    public static void flattenATreeUsingStack(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return;
        }

        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            BinaryTreeNode<Integer> curNode = stack.pop();
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
            if (!stack.isEmpty()) curNode.right = stack.peek();
            curNode.left = null;
        }
    }

    //TC - O(N)
    //SC - O(1)
    public static void flattenATreeUsingMorris(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return;
        }

        BinaryTreeNode<Integer> curNode = node;
        while (curNode != null) {
            if (curNode.left == null) {
                curNode = curNode.right;
            } else {
                BinaryTreeNode<Integer> temp = curNode.left;
                while (temp.right != null) {
                    temp = temp.right;
                }

                temp.right = curNode.right;
                curNode.right = curNode.left;
                curNode.left = null;
                curNode = curNode.right;
            }
        }
    }
}
