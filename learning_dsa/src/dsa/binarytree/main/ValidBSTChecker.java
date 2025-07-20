package dsa.binarytree.main;

public class ValidBSTChecker {

    //TC - O(N)
    //SC - O(H)
    public static boolean isValidBST(BinaryTreeNode<Integer> root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValidBST(BinaryTreeNode<Integer> node, int minLimit, int maxLimit) {
        if (node == null) return true;

        if (node.data >= maxLimit || node.data <= minLimit) {
            return false;
        }

        return isValidBST(node.left, minLimit, node.data) && isValidBST(node.right, node.data, maxLimit);
    }
}
