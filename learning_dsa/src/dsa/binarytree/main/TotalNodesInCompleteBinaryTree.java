package dsa.binarytree.main;

public class TotalNodesInCompleteBinaryTree {

    //TC - O(N Log N)
    //SC - O(N LogN)
    public static int countTotalNodes(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = findLeftHeight(node);
        int rightHeight = findRightHeight(node);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        } else {
            return 1 + countTotalNodes(node.left) + countTotalNodes(node.right);
        }
    }

    private static int findLeftHeight(BinaryTreeNode<Integer> node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.left;
        }
        return count;
    }

    private static int findRightHeight(BinaryTreeNode<Integer> node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.right;
        }
        return count;
    }
}
