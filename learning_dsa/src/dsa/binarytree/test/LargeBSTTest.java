package dsa.binarytree.test;

import dsa.binarytree.main.BinaryTreeNode;
import dsa.binarytree.main.LargeBST;

public class LargeBSTTest {
    public static void main(String[] args) {
        /*
                   50
                 /    \
               30      60
              /  \    /  \
            5    20  45   70
                          / \
                        65   80

        Here, the largest BST is:
                 60
               /    \
             45     70
                   /  \
                 65    80
        Node count = 5
        */

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(50);
        root.left = new BinaryTreeNode<>(30);
        root.right = new BinaryTreeNode<>(60);

        root.left.left = new BinaryTreeNode<>(5);
        root.left.right = new BinaryTreeNode<>(20);

        root.right.left = new BinaryTreeNode<>(45);
        root.right.right = new BinaryTreeNode<>(70);

        root.right.right.left = new BinaryTreeNode<>(65);
        root.right.right.right = new BinaryTreeNode<>(80);

        LargeBST solver = new LargeBST();
        int result = solver.largeBSTNodesCount(root);
        System.out.println("Size of largest BST subtree: " + result); // Expected: 5
    }
}
