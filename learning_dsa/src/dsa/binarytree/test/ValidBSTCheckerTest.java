package dsa.binarytree.test;

import dsa.binarytree.main.BinaryTreeNode;
import dsa.binarytree.main.ValidBSTChecker;

public class ValidBSTCheckerTest {
    public static void main(String[] args) {
        // ✅ Test 1: A valid BST
        /*
                 10
                /  \
               5    15
              / \     \
             3   7     18
        */
        BinaryTreeNode<Integer> validRoot = new BinaryTreeNode<>(10);
        validRoot.left = new BinaryTreeNode<>(5);
        validRoot.right = new BinaryTreeNode<>(15);
        validRoot.left.left = new BinaryTreeNode<>(3);
        validRoot.left.right = new BinaryTreeNode<>(7);
        validRoot.right.right = new BinaryTreeNode<>(18);

        System.out.println("Test 1 - Should be valid: " +
                ValidBSTChecker.isValidBST(validRoot)); // Expected: true

        // ❌ Test 2: Invalid BST (left child > parent)
        /*
                 10
                /  \
              12    15
        */
        BinaryTreeNode<Integer> invalidRoot1 = new BinaryTreeNode<>(10);
        invalidRoot1.left = new BinaryTreeNode<>(12);
        invalidRoot1.right = new BinaryTreeNode<>(15);

        System.out.println("Test 2 - Should be invalid: " +
                ValidBSTChecker.isValidBST(invalidRoot1)); // Expected: false

        // ❌ Test 3: Invalid BST (right child < parent)
        /*
                 10
                /  \
               5     8
        */
        BinaryTreeNode<Integer> invalidRoot2 = new BinaryTreeNode<>(10);
        invalidRoot2.left = new BinaryTreeNode<>(5);
        invalidRoot2.right = new BinaryTreeNode<>(8);

        System.out.println("Test 3 - Should be invalid: " +
                ValidBSTChecker.isValidBST(invalidRoot2)); // Expected: false

        // ✅ Test 4: Single node (valid)
        BinaryTreeNode<Integer> singleNode = new BinaryTreeNode<>(42);
        System.out.println("Test 4 - Should be valid (single node): " +
                ValidBSTChecker.isValidBST(singleNode)); // Expected: true

        // ✅ Test 5: Empty tree (valid)
        BinaryTreeNode<Integer> emptyTree = null;
        System.out.println("Test 5 - Should be valid (empty tree): " +
                ValidBSTChecker.isValidBST(emptyTree)); // Expected: true

        // ❌ Test 6: Duplicate values (invalid if duplicates not allowed)
        /*
                 10
                /  \
               5    10
        */
        BinaryTreeNode<Integer> duplicateRoot = new BinaryTreeNode<>(10);
        duplicateRoot.left = new BinaryTreeNode<>(5);
        duplicateRoot.right = new BinaryTreeNode<>(10);

        System.out.println("Test 6 - Should be invalid (duplicate values): " +
                ValidBSTChecker.isValidBST(duplicateRoot)); // Expected: false
    }
}
