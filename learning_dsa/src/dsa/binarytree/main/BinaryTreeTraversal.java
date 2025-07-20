package dsa.binarytree.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTraversal<T> {

    //TC - O(N)
    //SC - O(N)
    //left, root, right
    public void inOrderTraversal(BinaryTreeNode<T> node, List<T> inOrderList) {
        if (node == null) {
            return;
        }
        //visit left
        inOrderTraversal(node.left, inOrderList);
        //process the data
        inOrderList.add(node.data);
        //visit right
        inOrderTraversal(node.right, inOrderList);
    }

    //TC - O(N)
    //SC - O(N)
    //root, left, right
    public void preOrderTraversal(BinaryTreeNode<T> node, List<T> preOrderList) {
        if (node == null) {
            return;
        }

        //process the data
        preOrderList.add(node.data);
        //visit left
        preOrderTraversal(node.left, preOrderList);
        //visit right
        preOrderTraversal(node.right, preOrderList);
    }

    //TC - O(N)
    //SC - O(N)
    //left, right, root
    public void postOrderTraversal(BinaryTreeNode<T> node, List<T> postOrderList) {
        if (node == null) {
            return;
        }

        //visit left
        postOrderTraversal(node.left, postOrderList);
        //visit right
        postOrderTraversal(node.right, postOrderList);
        //process the data
        postOrderList.add(node.data);
    }

    //TC - O(N)
    //SC - O(N)
    //level by level
    public List<T> levelOrderTraversal(BinaryTreeNode<T> node) {
        if (node == null) return null;

        List<T> levelOrderList = new ArrayList<>();
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                BinaryTreeNode<T> curNode = queue.poll();
                levelOrderList.add(curNode.data);
                if (curNode.left != null) queue.add(curNode.left);
                if (curNode.right != null) queue.add(curNode.right);
            }

        }
        return levelOrderList;
    }


}
