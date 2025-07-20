package dsa.binarytree.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//TC - O(3N)
//SC - O(2H)
class BSTIteratorWithReverse {

    Stack<BinaryTreeNode<Integer>> stack;
    boolean isReverse;

    public BSTIteratorWithReverse(BinaryTreeNode<Integer> root, boolean isReverse) {
        this.stack = new Stack<>();
        this.isReverse = isReverse;
        pushAll(root);
    }

    public void pushAll(BinaryTreeNode<Integer> node) {
        while (node != null) {
            this.stack.push(node);
            if (this.isReverse) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }

    public BinaryTreeNode<Integer> next() {
        BinaryTreeNode<Integer> curNode = this.stack.pop();
        if (this.isReverse) {
            pushAll(curNode.left);
        } else {
            pushAll(curNode.right);
        }
        return curNode;
    }

    public boolean hasNext() {
        return !this.stack.isEmpty();
    }
}

public class TwoSumInBST {
    public List<Integer> getTwoSumFromBST(BinaryTreeNode<Integer> root, int target) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        BSTIteratorWithReverse iterator = new BSTIteratorWithReverse(root, false);
        BSTIteratorWithReverse revIterator = new BSTIteratorWithReverse(root, true);

        BinaryTreeNode<Integer> left = iterator.next();
        BinaryTreeNode<Integer> right = revIterator.next();

        while (left != right) {
            int sum = left.data + right.data;

            if (sum == target) {
                result.add(left.data);
                result.add(right.data);
                return result;
            } else if (sum < target) {
                if (iterator.hasNext()) left = iterator.next();
                else break;
            } else {
                if (revIterator.hasNext()) right = revIterator.next();
                else break;
            }
        }

        return result;

    }
}
