package dsa.binarytree.main;

import java.util.List;
import java.util.Stack;

public class PreInPostOrderInSingleFunction<T> {

    public void preInPostOrderTraversal(BinaryTreeNode<T> root, List<T> preOrder, List<T> inOrder, List<T> postOrder) {
        if (root == null) return;

        Stack<Pair<T>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));

        while (!stack.isEmpty()) {
            Pair<T> temp = stack.pop();
            if (temp.visitCount == 1) {
                BinaryTreeNode<T> curNode = temp.treeNode;
                preOrder.add(curNode.data);
                temp.visitCount++;
                stack.push(temp);
                if (curNode.left != null) {
                    stack.push(new Pair<>(curNode.left, 1));
                }

            } else if (temp.visitCount == 2) {
                BinaryTreeNode<T> curNode = temp.treeNode;
                inOrder.add(curNode.data);
                temp.visitCount++;
                stack.push(temp);
                if (curNode.right != null) {
                    stack.push(new Pair<>(curNode.right, 1));
                }

            } else {
                BinaryTreeNode<T> curNode = temp.treeNode;
                postOrder.add(curNode.data);
            }

        }

    }
}

class Pair<T> {
    BinaryTreeNode<T> treeNode;
    int visitCount;

    Pair(BinaryTreeNode<T> treeNode, int visitCount) {
        this.treeNode = treeNode;
        this.visitCount = visitCount;
    }
}
