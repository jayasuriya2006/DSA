package dsa.binarytree.test;

import dsa.binarytree.main.BSTIterator;
import dsa.binarytree.main.BinaryTreeNode;

public class BSTIteratorTest {
    public static void main(String[] args) {
        /*
                      20
                    /    \
                   10     30
                  /  \   /  \
                 5   15 25  35
        */

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(20);
        root.left = new BinaryTreeNode<>(10);
        root.right = new BinaryTreeNode<>(30);
        root.left.left = new BinaryTreeNode<>(5);
        root.left.right = new BinaryTreeNode<>(15);
        root.right.left = new BinaryTreeNode<>(25);
        root.right.right = new BinaryTreeNode<>(35);

        System.out.println("Inorder traversal using BSTIterator:");
        BSTIterator iterator = new BSTIterator(root);

        while (iterator.hasNext()) {
            BinaryTreeNode<Integer> node = iterator.next();
            System.out.print(node.data + " ");
        }
        // Expected output: 5 10 15 20 25 30 35
    }
}
