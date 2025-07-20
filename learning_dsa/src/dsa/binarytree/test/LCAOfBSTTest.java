package dsa.binarytree.test;

import dsa.binarytree.main.BinaryTreeNode;
import dsa.binarytree.main.LCAOfBST;

public class LCAOfBSTTest {
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

        // Test 1: LCA of 5 and 15 => 10
        BinaryTreeNode<Integer> lca = LCAOfBST.getLCAOfBST(root, 5, 15);
        System.out.println("LCA of 5 and 15: " + (lca != null ? lca.data : "null")); // Expected: 10

        // Test 2: LCA of 5 and 30 => 20
        lca = LCAOfBST.getLCAOfBST(root, 5, 30);
        System.out.println("LCA of 5 and 30: " + (lca != null ? lca.data : "null")); // Expected: 20

        // Test 3: LCA of 25 and 35 => 30
        lca = LCAOfBST.getLCAOfBST(root, 25, 35);
        System.out.println("LCA of 25 and 35: " + (lca != null ? lca.data : "null")); // Expected: 30

        // Test 4: LCA of 10 and 15 => 10
        lca = LCAOfBST.getLCAOfBST(root, 10, 15);
        System.out.println("LCA of 10 and 15: " + (lca != null ? lca.data : "null")); // Expected: 10

        // Test 5: LCA of 25 and 40 => null (40 not in tree, but 25 is)
        lca = LCAOfBST.getLCAOfBST(root, 25, 40);
        System.out.println("LCA of 25 and 40: " + (lca != null ? lca.data : "null")); // Expected: 30 (BST doesn't check existence)

        // Test 6: LCA of nodes not in tree => null
        lca = LCAOfBST.getLCAOfBST(root, 100, 200);
        System.out.println("LCA of 100 and 200: " + (lca != null ? lca.data : "null")); // Expected: null (out of range)
    }
}
