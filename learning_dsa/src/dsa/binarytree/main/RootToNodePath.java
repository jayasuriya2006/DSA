package dsa.binarytree.main;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {

    public static List<Integer> getPath(int target, BinaryTreeNode<Integer> root) {
        List<Integer> path = new ArrayList<>();
        if (root != null) {
            findPath(target, root, path);
        }
        return path;
    }

    public static boolean findPath(int target, BinaryTreeNode<Integer> node, List<Integer> curPath) {
        if (node == null) {
            return false;
        }
        curPath.add(node.data);
        if (node.data == target) {
            return true;
        } else {
            if (findPath(target, node.left, curPath) ||
                    findPath(target, node.right, curPath)) {
                return true;
            } else {
                curPath.removeLast();
                return false;
            }
        }
    }
}
