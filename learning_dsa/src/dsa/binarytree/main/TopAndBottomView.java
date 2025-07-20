package dsa.binarytree.main;

import java.util.*;

public class TopAndBottomView {

    //TC - O(N)
    //SC - O(N)
    public static List<Integer> topViewOfBinaryTree(BinaryTreeNode<Integer> root) {
        List<Integer> topView = new ArrayList<>();

        if (root == null) return topView;

        Queue<TreeNodeWithXAxis> queue = new LinkedList<>();
        Map<Integer, Integer> topViewMap = new HashMap<>();
        queue.offer(new TreeNodeWithXAxis(root, 0));
        while (!queue.isEmpty()) {
            TreeNodeWithXAxis curNodeInfo = queue.poll();
            BinaryTreeNode<Integer> curNode = curNodeInfo.node;
            int curRow = curNodeInfo.row;
            if (!topViewMap.containsKey(curRow)) {
                topViewMap.put(curRow, curNode.data);
            }
            if (curNode.left != null) {
                queue.offer(new TreeNodeWithXAxis(curNode.left, curRow - 1));
            }
            if (curNode.right != null) {
                queue.offer(new TreeNodeWithXAxis(curNode.right, curRow + 1));
            }
        }

        topView = topViewMap.values().stream().toList();
        return topView;
    }

    //TC - O(N)
    //SC - O(N)
    public static List<Integer> bottomViewOfBinaryTree(BinaryTreeNode<Integer> root) {
        List<Integer> bottomView = new ArrayList<>();

        if (root == null) return bottomView;

        Queue<TreeNodeWithXAxis> queue = new LinkedList<>();
        Map<Integer, Integer> bottomViewMap = new HashMap<>();
        queue.offer(new TreeNodeWithXAxis(root, 0));
        while (!queue.isEmpty()) {
            TreeNodeWithXAxis curNodeInfo = queue.poll();
            BinaryTreeNode<Integer> curNode = curNodeInfo.node;
            int curRow = curNodeInfo.row;

            bottomViewMap.put(curRow, curNode.data);

            if (curNode.left != null) {
                queue.offer(new TreeNodeWithXAxis(curNode.left, curRow - 1));
            }
            if (curNode.right != null) {
                queue.offer(new TreeNodeWithXAxis(curNode.right, curRow + 1));
            }
        }

        bottomView = bottomViewMap.values().stream().toList();
        return bottomView;
    }
}


class TreeNodeWithXAxis {
    int row;
    BinaryTreeNode<Integer> node;

    TreeNodeWithXAxis(BinaryTreeNode<Integer> node, int row) {
        this.node = node;
        this.row = row;
    }
}
