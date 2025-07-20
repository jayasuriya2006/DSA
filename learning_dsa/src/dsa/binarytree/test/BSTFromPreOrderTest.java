package dsa.binarytree.test;

import dsa.binarytree.main.BSTFromPreOrder;
import dsa.binarytree.main.BinaryTreeNode;

import java.util.Arrays;
import java.util.List;

public class BSTFromPreOrderTest {
    public static void main(String[] args) {
        List<Integer> preOrder = Arrays.asList(10, 5, 1, 7, 15, 12, 20);

        // Test 1: Brute force construction
        BinaryTreeNode<Integer> root1 = BSTFromPreOrder.constructBST_Brut(preOrder);
        System.out.print("Inorder (Brute): ");
        printInOrder(root1);
        System.out.println();

        // Test 2: Better construction (Pre + Sorted Inorder)
        BinaryTreeNode<Integer> root2 = BSTFromPreOrder.constructBST_Better(preOrder);
        System.out.print("Inorder (Better): ");
        printInOrder(root2);
        System.out.println();

        // Test 3: Optimal construction (using upper bound)
        BinaryTreeNode<Integer> root3 = BSTFromPreOrder.constructBST_Optimal(preOrder);
        System.out.print("Inorder (Optimal): ");
        printInOrder(root3);
        System.out.println();

        // Validate that all three BSTs produce same inorder (should be sorted)
        // Optional: Compare inorder traversals if needed
    }

    // Helper to print inorder traversal
    private static void printInOrder(BinaryTreeNode<Integer> node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }
}
