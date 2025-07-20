package dsa.binarytree.test;

import dsa.binarytree.main.BinaryTreeNode;

import static dsa.binarytree.main.ProblemsOnHeight.*;

public class ProblemsOnHeightTest {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(-1000);
        root.left = new BinaryTreeNode<>(6);
        root.right = new BinaryTreeNode<>(15);

        root.left.left = new BinaryTreeNode<>(3);
        root.left.right = new BinaryTreeNode<>(8);
        root.right.left = new BinaryTreeNode<>(12);
        root.right.right = new BinaryTreeNode<>(17);

        root.left.right.left = new BinaryTreeNode<>(90);
        root.right.left.left = new BinaryTreeNode<>(89);
        root.left.left.left = new BinaryTreeNode<>(1);
        root.left.left.right = new BinaryTreeNode<>(4);
        root.right.right.left = new BinaryTreeNode<>(16);
        root.right.right.right = new BinaryTreeNode<>(20);
        root.left.left.left.left = new BinaryTreeNode<>(97);
        root.left.right.left.left = new BinaryTreeNode<>(20);
        root.right.left.left.left = new BinaryTreeNode<>(15);
        //root.right.left.left.left.right = new BinaryTreeNode<>(8);

        System.out.println(findTheHeightOfTheTree(root)); 
        System.out.println(checkForBalancedTree_Height(root));
        System.out.println(checkForBalancedTree_NoOfNodes(root));
        System.out.println(diameterOfBinaryTree(root));
        System.out.println(maximumPathSum(root));

        System.out.println(isTwoTreeIdentical(root, root));

    }
}
