package dsa.binarytree.main;

import org.w3c.dom.Node;

public class LargeBST {

    /*Brut -
         Stand on each node and call is valid BST,
         If valid then count the nodes, then compare and update the max count
     */

    public int largeBSTNodesCount(BinaryTreeNode<Integer> root) {
        if (root == null) return 0;

        return largeBSTNodesCountHelper(root).validBSTCount;
    }

    private NodeWithMaxMinInfo largeBSTNodesCountHelper(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return new NodeWithMaxMinInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeWithMaxMinInfo left = largeBSTNodesCountHelper(node.left);
        NodeWithMaxMinInfo right = largeBSTNodesCountHelper(node.right);

        if (node.data > left.maxLimit && node.data < right.minLimit) {
            return new NodeWithMaxMinInfo(Math.min(node.data, left.minLimit),
                    Math.max(node.data, right.maxLimit), left.validBSTCount + right.validBSTCount + 1);
        }

        return new NodeWithMaxMinInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.validBSTCount, right.validBSTCount));
    }
}

class NodeWithMaxMinInfo {
    int maxLimit;
    int minLimit;
    int validBSTCount;

    NodeWithMaxMinInfo(int minLimit, int maxLimit, int validBSTCount) {
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
        this.validBSTCount = validBSTCount;
    }
}
