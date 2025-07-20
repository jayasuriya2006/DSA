package dsa.binarytree.main;

public class ChildrenSumProperty {

    public static void childrenSum(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return;
        }

        int childSum = 0;
        if (node.left != null) childSum += node.left.data;
        if (node.right != null) childSum += node.right.data;

        if (node.data <= childSum) {
            node.data = childSum;
        } else {
            if(node.left != null) node.left.data = node.data;
            if(node.right != null) node.right.data = node.data;
        }

        childrenSum(node.left);
        childrenSum(node.right);

        int sum = 0;
        if (node.left != null) sum += node.left.data;
        if (node.right != null) sum += node.right.data;

        if (node.right != null || node.left != null) node.data = sum;
    }
}
