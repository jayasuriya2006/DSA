package dsa.binarytree.main;

import java.util.*;

public class ZigZagTraversal {

    //TC - O(N) + O(N/2)
    //SC - O(N)
    public static List<List<Integer>> zigZagTraversalOfTree(BinaryTreeNode<Integer> root) {
        List<List<Integer>> zigZag = new ArrayList<>();

        if (root == null) return zigZag;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        boolean isFromRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevelElements = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<Integer> curNode = queue.poll();
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }

                curLevelElements.add(curNode.data);
            }
            if(isFromRight) {
                zigZag.add(curLevelElements);
            } else {
                Collections.reverse(curLevelElements);
                zigZag.add(curLevelElements);
            }
            isFromRight = !isFromRight;

        }

        return zigZag;
    }
}
