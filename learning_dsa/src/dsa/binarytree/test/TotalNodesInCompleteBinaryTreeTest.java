package dsa.binarytree.test;

import dsa.binarytree.main.BinaryTreeNode;
import dsa.binarytree.main.TotalNodesInCompleteBinaryTree;

public class TotalNodesInCompleteBinaryTreeTest {

    public static void main(String[] args) {
// Create a complete binary tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);

        // Call the method to calculate total nodes
        int totalNodes = TotalNodesInCompleteBinaryTree.countTotalNodes(root);
        System.out.println(totalNodes);
    }
}
