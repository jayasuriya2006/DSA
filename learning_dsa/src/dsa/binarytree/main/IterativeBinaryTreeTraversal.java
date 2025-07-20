package dsa.binarytree.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeBinaryTreeTraversal<T> {

    //TC - O(2N)
    //SC - O(N)
    public List<T> inOrderIterativeTraversal(BinaryTreeNode<T> node) {
        List<T> inOrder = new ArrayList<>();
        if (node == null) return inOrder;
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> curNode = node;
        while (curNode != null || !stack.isEmpty()) {
            if (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            } else {
                BinaryTreeNode<T> temp = stack.pop();
                inOrder.add(temp.data);
                curNode = temp.right;
            }
        }
        return inOrder;
    }

    //TC - O(N)
    //SC - O(N)
    public List<T> preOrderIterativeTraversal(BinaryTreeNode<T> node) {
        List<T> preOrder = new ArrayList<>();
        if (node == null) return preOrder;
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            BinaryTreeNode<T> curNode = stack.pop();
            preOrder.add(curNode.data);
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
        return preOrder;
    }

    //TC - O(2N)
    //SC - O(N)
    public List<T> postOrderIterativeTraversal_usingTwoStack(BinaryTreeNode<T> node) {
        List<T> postOrder = new ArrayList<>();
        if (node == null) return postOrder;
        Stack<BinaryTreeNode<T>> stack1 = new Stack<>();
        Stack<BinaryTreeNode<T>> stack2 = new Stack<>();

        stack1.push(node);
        while (!stack1.isEmpty()) {
            BinaryTreeNode<T> temp = stack1.pop();
            stack2.push(temp);
            if (temp.left != null) {
                stack1.push(temp.left);
            }
            if (temp.right != null) {
                stack1.push(temp.right);
            }
        }

        while (!stack2.isEmpty()) {
            postOrder.add(stack2.pop().data);
        }

        return postOrder;
    }

    //TC - O(2N)
    //SC - O(N)
    public List<T> postOrderIterativeTraversal_usingOneStack(BinaryTreeNode<T> node) {
        List<T> postOrder = new ArrayList<>();
        if (node == null) return postOrder;
        Stack<BinaryTreeNode<T>> stack1 = new Stack<>();

        BinaryTreeNode<T> curNode = node;
        while (curNode != null || !stack1.isEmpty()) {
            if (curNode != null) {
                stack1.push(curNode);
                curNode = curNode.left;
            } else {
                BinaryTreeNode<T> temp = stack1.peek().right;
                if (temp == null) {
                    temp = stack1.pop();
                    postOrder.add(temp.data);
                    while (!stack1.isEmpty() && stack1.peek().right == temp) {
                        temp = stack1.pop();
                        postOrder.add(temp.data);
                    }
                } else {
                    curNode = temp;
                }
            }

        }


        return postOrder;
    }


}
