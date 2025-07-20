package dsa.binarytree.main;

import java.util.*;

public class AllNodesWithKDistance {

    public static List<Integer> getAllNodeDataWithKDistance(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> startNode, int k) {
        List<Integer> answer = new ArrayList<>();
        if (startNode == null || root == null) return answer;
        if (k == 0) {
            answer.add(startNode.data);
            return answer;
        }

        Map<BinaryTreeNode<Integer>, BinaryTreeNode<Integer>> parentMap = new HashMap<>();
        assignParents(root, parentMap);
        Set<BinaryTreeNode<Integer>> visited = new HashSet<>();
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();

        visited.add(startNode);
        queue.offer(startNode);
        int curLevel = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (curLevel == k) break;
            curLevel++;
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> curNode = queue.poll();
                if (curNode.left != null && !visited.contains(curNode.left)) {
                    visited.add(curNode.left);
                    queue.offer(curNode.left);
                }
                if (curNode.right != null && !visited.contains(curNode.right)) {
                    visited.add(curNode.right);
                    queue.offer(curNode.right);
                }
                if (parentMap.get(curNode) != null && !visited.contains(parentMap.get(curNode))) {
                    visited.add(parentMap.get(curNode));
                    queue.offer(parentMap.get(curNode));
                }
            }
        }

        while (!queue.isEmpty()) {
            answer.add(queue.poll().data);
        }

        return answer;
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
