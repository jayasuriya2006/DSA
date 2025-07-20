package dsa.binarytree.main;

public class InorderSuccessorAndPredecessor {

    //TC - O(H)
    //SC - O(1)
    public static BinaryTreeNode<Integer> getBSTInOrderSuccessor(BinaryTreeNode<Integer> root, int target) {
        if (root == null) return null;

        BinaryTreeNode<Integer> curNode = root;
        BinaryTreeNode<Integer> successor = null;

        while (curNode != null) {
            if (curNode.data <= target) {
                curNode = curNode.right;
            } else {
                successor = curNode;
                curNode = curNode.left;
            }
        }
        return successor;
    }

    //TC - O(H)
    //SC - O(1)
    public static BinaryTreeNode<Integer> getBSTInOrderPredecessor(BinaryTreeNode<Integer> root, int target) {
        if (root == null) return null;

        BinaryTreeNode<Integer> curNode = root;
        BinaryTreeNode<Integer> predecessor = null;

        while (curNode != null) {
            if (curNode.data < target) {
                predecessor = curNode;
                curNode = curNode.right;
            } else {
                curNode = curNode.left;
            }
        }
        return predecessor;
    }
}
