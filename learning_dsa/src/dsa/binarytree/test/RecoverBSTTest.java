package dsa.binarytree.test;

import dsa.binarytree.main.BinaryTreeNode;
import dsa.binarytree.main.RecoverBST;

public class RecoverBSTTest {
    public static void main(String[] args) {
        /*
              6
             / \
            10  2
           / \   \
          1   3   12

        The correct BST should be:
              6
             / \
            2  10
           / \   \
          1   3   12

        Swapped nodes: 10 and 2
        */

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(6);
        root.left = new BinaryTreeNode<>(10);
        root.right = new BinaryTreeNode<>(2);
        root.left.left = new BinaryTreeNode<>(1);
        root.left.right = new BinaryTreeNode<>(3);
        root.right.right = new BinaryTreeNode<>(12);

        System.out.println("Inorder before recovery:");
        printInOrder(root); // Expected (incorrect): 1 10 3 6 2 12

        RecoverBST recoverer = new RecoverBST();
        recoverer.recoverBST(root);

        System.out.println("\nInorder after recovery:");
        printInOrder(root); // Expected (correct): 1 2 3 6 10 12
    }

    private static void printInOrder(BinaryTreeNode<Integer> node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }
}
