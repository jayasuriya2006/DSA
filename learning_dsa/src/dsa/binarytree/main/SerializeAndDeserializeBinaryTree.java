package dsa.binarytree.main;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public static String serializeTree(BinaryTreeNode<Integer> root) {
        if (root == null) return "";

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> curNode = queue.poll();
            if (curNode == null) {
                result.append("n ");
                continue;
            } else {
                result.append(curNode.data + " ");
                queue.offer(curNode.left);
                queue.offer(curNode.right);
            }
        }

        return result.toString();
    }

    public static BinaryTreeNode<Integer> deSerializeTree(String serialized) {
        if (serialized.length() == 0) return null;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        String[] values = serialized.split(" ");
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(Integer.parseInt(values[0]));
        queue.offer(root);
        int i = 1;
        while (i < values.length) {
            BinaryTreeNode<Integer> curNode = queue.poll();
            if (!Objects.equals(values[i], "n")) {
                curNode.left = new BinaryTreeNode<>(Integer.parseInt(values[i]));
                queue.offer(curNode.left);
            }
            i++;

            if (!Objects.equals(values[i], "n")) {
                curNode.right = new BinaryTreeNode<>(Integer.parseInt(values[i]));
                queue.offer(curNode.right);
            }
            i++;
        }
        return root;
    }
}
