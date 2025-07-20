package dsa.binarytree.main;

import java.util.*;

public class VerticalOrderTraversal {

    //TC - O(2N)
    //SC - O(N)
    public static List<List<Integer>> verticalOrderElements(BinaryTreeNode<Integer> root) {
        List<List<Integer>> verticalOrder = new ArrayList<>();

        if (root == null) {
            return verticalOrder;
        }

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> verticalMap = new TreeMap<>();

        Queue<TreeNodePosition> queue = new LinkedList<>();
        queue.offer(new TreeNodePosition(root, 0, 0));

        while (!queue.isEmpty()) {
            TreeNodePosition curNodePos = queue.poll();

            int curNodeRow = curNodePos.row;
            int curNodeCol = curNodePos.col;
            BinaryTreeNode<Integer> curNode = curNodePos.node;
            if (!verticalMap.containsKey(curNodeCol)) {
                verticalMap.put(curNodeCol, new TreeMap<>());
            }

            if (!verticalMap.get(curNodeCol).containsKey(curNodeRow)) {
                verticalMap.get(curNodeCol).put(curNodeRow, new PriorityQueue<>());
            }

            verticalMap.get(curNodeCol).get(curNodeRow).add(curNode.data);

            if (curNode.left != null) {
                queue.offer(new TreeNodePosition(curNode.left, curNodeRow + 1, curNodeCol - 1));
            }
            if (curNode.right != null) {
                queue.offer(new TreeNodePosition(curNode.right, curNodeRow + 1, curNodeCol + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> curColElements : verticalMap.values()) {
            List<Integer> curCol = new ArrayList<>();
            for (PriorityQueue<Integer> curPosElements : curColElements.values()) {
                while (!curPosElements.isEmpty()) {
                    curCol.add(curPosElements.poll());
                }
            }
            verticalOrder.add(curCol);
        }
        return verticalOrder;
    }
}

class TreeNodePosition {
    BinaryTreeNode<Integer> node;
    int row;
    int col;

    TreeNodePosition(BinaryTreeNode<Integer> node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
