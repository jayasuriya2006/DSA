package dsa.binarytree.test;

import dsa.binarytree.main.BinaryTreeNode;
import dsa.binarytree.main.BinaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversalTest {

    public static void main(String[] args) {
        /*
           10
         /    \
        6      15
       / \    /  \
      3   8  12   17
     / \          / \
    1   4       16  20

  */

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        root.left = new BinaryTreeNode<>(6);
        root.right = new BinaryTreeNode<>(15);

        root.left.left = new BinaryTreeNode<>(3);
        root.left.right = new BinaryTreeNode<>(8);
        root.right.left = new BinaryTreeNode<>(12);
        root.right.right = new BinaryTreeNode<>(17);

        root.left.left.left = new BinaryTreeNode<>(1);
        root.left.left.right = new BinaryTreeNode<>(4);
        root.right.right.left = new BinaryTreeNode<>(16);
        root.right.right.right = new BinaryTreeNode<>(20);


        List<Integer> preOrder = List.of(10, 6, 3, 1, 4, 8, 15, 12, 17, 16, 20);
        List<Integer> inOrder = List.of(1, 3, 4, 6, 8, 10, 12, 15, 16, 17, 20);
        List<Integer> postOrder = List.of(1, 4, 3, 8, 6, 12, 16, 20, 17, 15, 10);
        List<Integer> levelOrder = List.of(10, 6, 15, 3, 8, 12, 17, 1, 4, 16, 20);

        BinaryTreeTraversal<Integer> treeTraversal = new BinaryTreeTraversal<>();

        List<Integer> preOrderRes = new ArrayList<>();
        treeTraversal.preOrderTraversal(root, preOrderRes);
        printRes(preOrder, preOrderRes, "Pre-Order");

        List<Integer> inOrderRes = new ArrayList<>();
        treeTraversal.inOrderTraversal(root, inOrderRes);
        printRes(inOrder, inOrderRes, "In-Order");

        List<Integer> postOrderRes = new ArrayList<>();
        treeTraversal.postOrderTraversal(root, postOrderRes);
        printRes(postOrder, postOrderRes, "Post-Order");

        List<Integer> levelOrderRes = treeTraversal.levelOrderTraversal(root);
        printRes(levelOrder, levelOrderRes, "Level-Order");

    }

    public static void printRes(List<Integer> expected, List<Integer> actual, String traversal) {
        if (expected.equals(actual)) {
            System.out.println("..... " + traversal + " Passed......");
        } else {
            System.out.println("..... " + traversal + " Failed......");
        }
    }
}
