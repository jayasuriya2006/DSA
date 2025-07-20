package dsa.binarytree.test;

import dsa.binarytree.main.BinarySearchTree;
import dsa.binarytree.main.BinaryTreeNode;

import static dsa.binarytree.main.BinarySearchTree.*;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        // Build BST
        /*
                      8
                    /   \
                   3    10
                  / \     \
                 1   6     14
                    / \    /
                   4   7  13
        */
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(8);
        root.left = new BinaryTreeNode<>(3);
        root.right = new BinaryTreeNode<>(10);
        root.left.left = new BinaryTreeNode<>(1);
        root.left.right = new BinaryTreeNode<>(6);
        root.left.right.left = new BinaryTreeNode<>(4);
        root.left.right.right = new BinaryTreeNode<>(7);
        root.right.right = new BinaryTreeNode<>(14);
        root.right.right.left = new BinaryTreeNode<>(13);

        // Test searchInBST
        System.out.println("Searching 6 in BST: " +
                (BinarySearchTree.searchInBST(root, 6) != null ? "Found" : "Not Found")); // Expected: Found
        System.out.println("Searching 9 in BST: " +
                (BinarySearchTree.searchInBST(root, 9) != null ? "Found" : "Not Found")); // Expected: Not Found

        // Test ceilOfTargetBST
        BinaryTreeNode<Integer> ceilNode = BinarySearchTree.ceilOfTargetBST(root, 5);
        System.out.println("Ceil of 5: " + (ceilNode != null ? ceilNode.data : "null")); // Expected: 6

        ceilNode = BinarySearchTree.ceilOfTargetBST(root, 15);
        System.out.println("Ceil of 15: " + (ceilNode != null ? ceilNode.data : "null")); // Expected: null

        // Test floorOfTargetBST
        BinaryTreeNode<Integer> floorNode = BinarySearchTree.floorOfTargetBST(root, 5);
        System.out.println("Floor of 5: " + (floorNode != null ? floorNode.data : "null")); // Expected: 4

        floorNode = BinarySearchTree.floorOfTargetBST(root, 0);
        System.out.println("Floor of 0: " + (floorNode != null ? floorNode.data : "null")); // Expected: null

        // Test insertAValInBST
        root = BinarySearchTree.insertAValInBST(root, 9);
        System.out.println("After inserting 9, search 9: " +
                (BinarySearchTree.searchInBST(root, 9) != null ? "Found" : "Not Found")); // Expected: Found

        // Test deleteAValInBST
        root = BinarySearchTree.deleteAValInBST(root, 3); // Node with two children
        System.out.println("After deleting 3, search 3: " +
                (BinarySearchTree.searchInBST(root, 3) != null ? "Found" : "Not Found")); // Expected: Not Found

        root = BinarySearchTree.deleteAValInBST(root, 1); // Leaf node
        System.out.println("After deleting 1, search 1: " +
                (BinarySearchTree.searchInBST(root, 1) != null ? "Found" : "Not Found")); // Expected: Not Found

        root = BinarySearchTree.deleteAValInBST(root, 14); // Node with one child
        System.out.println("After deleting 14, search 14: " +
                (BinarySearchTree.searchInBST(root, 14) != null ? "Found" : "Not Found")); // Expected: Not Found

        System.out.println("After deleting 13, search 13: " +
                (BinarySearchTree.searchInBST(root, 13) != null ? "Found" : "Not Found")); // Expected: Not Found

        System.out.println(findKthSmallestNumberInBST(root, 1).data);
        System.out.println(findKthLargestNumberInBST(root, 1).data);
    }
}
