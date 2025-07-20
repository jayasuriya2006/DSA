package dsa.binarytree.main;

public class SymmetricTree {

    public static boolean isSymmetrical(BinaryTreeNode<Integer> root) {
        if (root == null) return true;
        return isSymmetrical(root.left, root.right);
    }

    public static boolean isSymmetrical(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right) {
        if (left == null || right == null) {
            return left == right;
        }

        return left.data == right.data
                && isSymmetrical(left.left, right.right)
                && isSymmetrical(left.right, right.left);
    }

}
