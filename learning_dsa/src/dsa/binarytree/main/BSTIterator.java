package dsa.binarytree.main;

import java.util.Stack;

/*
     Brut force - do in-order traversal and store it in list, then do the action
 */

//TC - O(1)
//SC - (H)
public class BSTIterator {

    Stack<BinaryTreeNode<Integer>> stack;

    public BSTIterator(BinaryTreeNode<Integer> root) {
        this.stack = new Stack<>();
        pushAll(root);
    }

    public void pushAll(BinaryTreeNode<Integer> node) {
        while (node != null) {
            this.stack.push(node);
            node = node.left;
        }
    }

    public BinaryTreeNode<Integer> next() {
        BinaryTreeNode<Integer> curNode = this.stack.pop();
        pushAll(curNode.right);
        return curNode;
    }

    public boolean hasNext() {
        return !this.stack.isEmpty();
    }
}
