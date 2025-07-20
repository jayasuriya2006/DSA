package dsa.binarytree.main;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversalPreAndInOrder {

    //TC - O(N)
    //SC - O(1)
    public static List<Integer> inOrderMorris(BinaryTreeNode<Integer> root) {
        List<Integer> inOrder = new ArrayList<>();
        if (root == null) return inOrder;

        BinaryTreeNode<Integer> curNode = root;

        while (curNode != null) {
            if (curNode.left == null) {
                inOrder.add(curNode.data);
                curNode = curNode.right;
            } else {
                BinaryTreeNode<Integer> prev = curNode.left;
                while (prev.right != null && prev.right != curNode) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curNode;
                    curNode = curNode.left;
                } else {
                    prev.right = null;
                    inOrder.add(curNode.data);
                    curNode = curNode.right;
                }
            }
        }
        return inOrder;
    }

    //TC - O(N)
    //SC - O(1)
    public static List<Integer> preOrderMorris(BinaryTreeNode<Integer> root) {
        List<Integer> preOrder = new ArrayList<>();
        if (root == null) return preOrder;

        BinaryTreeNode<Integer> curNode = root;

        while (curNode != null) {
            if (curNode.left == null) {
                preOrder.add(curNode.data);
                curNode = curNode.right;
            } else {
                BinaryTreeNode<Integer> prev = curNode.left;
                while (prev.right != null && prev.right != curNode) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curNode;
                    preOrder.add(curNode.data);       // add before moving
                    curNode = curNode.left;
                } else {
                    prev.right = null;
                    curNode = curNode.right;
                }
            }
        }
        return preOrder;
    }
}
