package dsa.binarytree.main;

import java.util.Objects;

public class ProblemsOnHeight {

    //TC - O(N)
    //SC - O(N)
    public static int findTheHeightOfTheTree(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = findTheHeightOfTheTree(node.left);
        int rightHeight = findTheHeightOfTheTree(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    //TC - O(N)
    //SC - O(N)
    public static int checkForBalancedTree_Height(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkForBalancedTree_Height(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = checkForBalancedTree_Height(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        int diff = Math.abs(leftHeight - rightHeight);
        if (diff > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);

    }

    //TC - O(N)
    //SC - O(N)
    public static int checkForBalancedTree_NoOfNodes(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        int leftNodes = checkForBalancedTree_NoOfNodes(node.left);
        if (leftNodes == -1) {
            return -1;
        }
        int rightNodes = checkForBalancedTree_NoOfNodes(node.right);
        if (rightNodes == -1) {
            return -1;
        }

        int diff = Math.abs(leftNodes - rightNodes);
        if (diff > 1) {
            return -1;
        }

        return 1 + leftNodes + rightNodes;

    }

    //TC - O(N)
    //SC - O(N)
    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root) {
        int[] res = new int[1];
        diameterOfBinaryTree(root, res);
        return res[0];
    }

    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> node, int[] res) {
        if (node == null) {
            return 0;
        }

        int left = diameterOfBinaryTree(node.left, res);
        int right = diameterOfBinaryTree(node.right, res);

        res[0] = Math.max(res[0], left + right + 1);

        return 1 + Math.max(left, right);
    }

    public static int maximumPathSum(BinaryTreeNode<Integer> root) {
        int[] res = new int[1];
        maximumPathSum(root, res);
        return res[0];
    }

    public static int maximumPathSum(BinaryTreeNode<Integer> node, int[] res) {
        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(0, maximumPathSum(node.left, res));
        int rightSum = Math.max(0, maximumPathSum(node.right, res));

        res[0] = Math.max(res[0], node.data + leftSum + rightSum);

        return node.data + Math.max(leftSum, rightSum);
    }

    public static boolean isTwoTreeIdentical(BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2) {
        if (node1 == null || node2 == null) {
            return node1 == node2;
        }
        return Objects.equals(node1.data, node2.data)
                && isTwoTreeIdentical(node1.left, node2.left)
                && isTwoTreeIdentical(node1.right, node2.right);
    }
}
