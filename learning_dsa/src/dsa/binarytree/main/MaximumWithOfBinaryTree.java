package dsa.binarytree.main;

import java.util.Queue;

import java.util.LinkedList;

public class MaximumWithOfBinaryTree {

    public static int getMaxWidth(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;

        Queue<TreeNodeWithRow> queue = new LinkedList<>();
        queue.offer(new TreeNodeWithRow(root, 0));

        int maxWidth = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int mmin = queue.peek().no;
            int first = 0;
            int last = 0;
            for (int i = 0; i < size; i++) {
                TreeNodeWithRow curNodeInfo = queue.poll();
                int cur_id = curNodeInfo.no - mmin;
                BinaryTreeNode<Integer> curNode = curNodeInfo.node;
                if (curNode.left != null) {
                    queue.offer(new TreeNodeWithRow(curNode.left, 2 * cur_id + 1));
                }
                if (curNode.right != null) {
                    queue.offer(new TreeNodeWithRow(curNode.right, 2 * cur_id + 2));
                }
                if (i == 0) first = cur_id;
                if (i == size - 1) last = cur_id;
                maxWidth = Math.max(maxWidth, last - first + 1);
            }
        }
        return maxWidth;
    }
}

class TreeNodeWithRow {
    int no;
    BinaryTreeNode<Integer> node;

    TreeNodeWithRow(BinaryTreeNode<Integer> node, int no) {
        this.node = node;
        this.no = no;
    }
}
