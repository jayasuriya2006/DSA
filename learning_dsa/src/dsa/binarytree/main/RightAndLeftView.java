package dsa.binarytree.main;

import java.util.ArrayList;
import java.util.List;

public class RightAndLeftView {

    //TC - O(N)
    //SC - O(N)
    public static List<Integer> rightView(BinaryTreeNode<Integer> root) {
        List<Integer> rightView = new ArrayList<>();
        rightView(root, rightView, 0);
        return rightView;
    }

    private static void rightView(BinaryTreeNode<Integer> node, List<Integer> rightView, int curLevel) {
        if (node == null) {
            return;
        }

        if (curLevel == rightView.size()) {
            rightView.add(node.data);
        }
        rightView(node.right, rightView, curLevel + 1);
        rightView(node.left, rightView, curLevel + 1);
    }

    //TC - O(N)
    //SC - O(N)
    public static List<Integer> leftView(BinaryTreeNode<Integer> root) {
        List<Integer> leftView = new ArrayList<>();
        leftView(root, leftView, 0);
        return leftView;
    }

    private static void leftView(BinaryTreeNode<Integer> node, List<Integer> leftView, int curLevel) {
        if (node == null) {
            return;
        }

        if (curLevel == leftView.size()) {
            leftView.add(node.data);
        }
        leftView(node.left, leftView, curLevel + 1);
        leftView(node.right, leftView, curLevel + 1);
    }
}
