package dsa.binarytree.test;

import dsa.binarytree.main.BinaryTreeNode;

import static dsa.binarytree.main.RightAndLeftView.leftView;
import static dsa.binarytree.main.RightAndLeftView.rightView;

public class RightAndLeftViewTest {
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
        root.left.left.left.right = new BinaryTreeNode<>(100);

        System.out.println(rightView(root));
        System.out.println(leftView(root));
    }
}
