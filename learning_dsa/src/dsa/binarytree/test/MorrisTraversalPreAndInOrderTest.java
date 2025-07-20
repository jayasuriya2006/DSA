package dsa.binarytree.test;

import dsa.binarytree.main.BinaryTreeNode;

import java.util.List;

import static dsa.binarytree.main.MorrisTraversalPreAndInOrder.inOrderMorris;
import static dsa.binarytree.main.MorrisTraversalPreAndInOrder.preOrderMorris;
import static dsa.binarytree.test.BinaryTreeTraversalTest.printRes;

public class MorrisTraversalPreAndInOrderTest {
    public static void main(String[] args) {
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

        printRes(preOrder, preOrderMorris(root), "Pre-Order");
        printRes(inOrder, inOrderMorris(root), "In-Order");
    }
}
