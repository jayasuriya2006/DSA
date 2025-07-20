package dsa.binarytree.main;

import java.util.*;

public class MinimumTimeToBurn {

    public static int getMinTimeToBurn(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> startNode) {
        if (startNode == null || root == null) return 0;

        Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap = new HashMap<>();
        assignParents(root, parentMap);
        Set<BinaryTreeNode<Integer>> visited = new HashSet<>();
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();

        visited.add(startNode);
        queue.offer(startNode);

        int timeReqToBurn = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isBurned = false;
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> curNode = queue.poll();
                if (curNode.left != null && !visited.contains(curNode.left)) {
                    isBurned = true;
                    visited.add(curNode.left);
                    queue.offer(curNode.left);
                }
                if (curNode.right != null && !visited.contains(curNode.right)) {
                    isBurned = true;
                    visited.add(curNode.right);
                    queue.offer(curNode.right);
                }
                if (parentMap.get(curNode) != null && !visited.contains(parentMap.get(curNode))) {
                    isBurned = true;
                    visited.add(parentMap.get(curNode));
                    queue.offer(parentMap.get(curNode));
                }
            }

            if (isBurned) timeReqToBurn++;
        }

        return timeReqToBurn;
    }

    private static void assignParents(BinaryTreeNode<Integer> root, Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> curNode = queue.poll();
                if (curNode.left != null) {
                    parentMap.put(curNode.left, curNode);
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    parentMap.put(curNode.right, curNode);
                    queue.offer(curNode.right);
                }
            }
        }

    }
}
