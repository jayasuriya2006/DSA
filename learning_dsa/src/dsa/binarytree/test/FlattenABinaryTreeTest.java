package dsa.binarytree.test;

import dsa.binarytree.main.BinaryTreeNode;

import static dsa.binarytree.main.FlattenABinaryTree.*;

public class FlattenABinaryTreeTest {
    public static void main(String[] args) {

        BinaryTreeNode<Integer> root1 = generateTree();
        flattenATreeUsingRecursion(root1);

        BinaryTreeNode<Integer> temp1 = root1;
        while (temp1 != null) {
            System.out.print(temp1.data + ", ");
            temp1 = temp1.right;
        }
        System.out.println();

        BinaryTreeNode<Integer> root2 = generateTree();
        flattenATreeUsingMorris(root2);

        BinaryTreeNode<Integer> temp2 = root2;
        while (temp2 != null) {
            System.out.print(temp2.data + ", ");
            temp2 = temp2.right;
        }


    }

    private static BinaryTreeNode<Integer> generateTree() {
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

        return root;
    }
}
