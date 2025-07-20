package dsa.binarytree.test;

import dsa.binarytree.main.BinaryTreeNode;
import dsa.binarytree.main.TwoSumInBST;

import java.util.List;

public class TwoSumInBSTTest {
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

        TwoSumInBST solver = new TwoSumInBST();

        // Test 1: Target = 40 (5 + 35)
        List<Integer> result = solver.getTwoSumFromBST(root, 40);
        System.out.println("Two Sum for 40: " + result); // Expected: [5, 35] or [35, 5]

        // Test 2: Target = 50 (15 + 35)
        result = solver.getTwoSumFromBST(root, 50);
        System.out.println("Two Sum for 50: " + result); // Expected: [15, 35]

        // Test 3: Target = 45 (10 + 35)
        result = solver.getTwoSumFromBST(root, 45);
        System.out.println("Two Sum for 45: " + result); // Expected: [10, 35]

        // Test 4: Target = 100 (no such pair)
        result = solver.getTwoSumFromBST(root, 100);
        System.out.println("Two Sum for 100: " + result); // Expected: []

        // Test 5: Target = 20 (edge case: 10 + 10 not allowed)
        result = solver.getTwoSumFromBST(root, 20);
        System.out.println("Two Sum for 20: " + result); // Expected: [5, 15] unless two 10s exist
    }
}
