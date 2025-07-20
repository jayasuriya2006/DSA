package dsa.binarytree.main;

public class LowestCommonAncestor {

    public static BinaryTreeNode<Integer> findLCA(BinaryTreeNode<Integer> node, int t1, int t2) {
        if (node == null) {
            return null;
        }
        if (node.data == t1 || node.data == t2) {
            return node;
        }
        BinaryTreeNode<Integer> left = findLCA(node.left, t1, t2);
        BinaryTreeNode<Integer> right = findLCA(node.right, t1, t2);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return node;
    }
}
