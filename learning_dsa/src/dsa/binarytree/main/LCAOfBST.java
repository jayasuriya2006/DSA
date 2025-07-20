package dsa.binarytree.main;

public class LCAOfBST {

    public static BinaryTreeNode<Integer> getLCAOfBST(BinaryTreeNode<Integer> node, int p, int q) {
        if (node == null) return null;

        while (node != null) {
            if (node.data < p && node.data < q) {
                node = node.right;
            } else if (node.data > p && node.data > q) {
                node = node.left;
            } else {
                return node;
            }
        }
        return null;
    }
}
