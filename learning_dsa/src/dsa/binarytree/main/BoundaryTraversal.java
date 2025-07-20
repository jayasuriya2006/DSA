package dsa.binarytree.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {

    public static List<Integer> boundaryTraversalOfTree(BinaryTreeNode<Integer> root) {
        List<Integer> boundaryElements = new ArrayList<>();
        if (root == null) {
            return boundaryElements;
        }
        boundaryElements.add(root.data);
        getLeftBoundary(root.left, boundaryElements);
        getLeafNodes(root, boundaryElements);
        getRightBoundary(root.right, boundaryElements);

        return boundaryElements;

    }

    public static void getLeftBoundary(BinaryTreeNode<Integer> node, List<Integer> boundaryElements) {
        BinaryTreeNode<Integer> curNode = node;
        while (curNode != null) {
            if (!isLeaf(curNode)) {
                boundaryElements.add(curNode.data);
            }
            if (curNode.left != null) {
                curNode = curNode.left;
            } else {
                curNode = curNode.right;
            }
        }
    }

    public static void getLeafNodes(BinaryTreeNode<Integer> node, List<Integer> boundaryElements) {
        if (node == null) {
            return;
        }

        if (isLeaf(node)) {
            boundaryElements.add(node.data);
        }
        getLeafNodes(node.left, boundaryElements);
        getLeafNodes(node.right, boundaryElements);
    }

    public static void getRightBoundary(BinaryTreeNode<Integer> node, List<Integer> boundaryElements) {
        BinaryTreeNode<Integer> curNode = node;
        Stack<Integer> rightElements = new Stack<>();
        while (curNode != null) {
            if (!isLeaf(curNode)) {
                rightElements.push(curNode.data);
            }
            if (curNode.right != null) {
                curNode = curNode.right;
            } else {
                curNode = curNode.left;
            }
        }
        while (!rightElements.isEmpty()) {
            boundaryElements.add(rightElements.pop());
        }
    }


    private static boolean isLeaf(BinaryTreeNode<Integer> node) {
        return node.left == null && node.right == null;
    }


}
