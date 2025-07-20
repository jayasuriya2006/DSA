package dsa.binarytree.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static dsa.binarytree.main.BinarySearchTree.insertAValInBST;
import static dsa.binarytree.main.BinaryTreeFromInOrderAndPreOrder.buildTreeFromInAndPreOrder;

public class BSTFromPreOrder {

    //TC - O(N) * O(H)
    //SC - O(H)
    public static BinaryTreeNode<Integer> constructBST_Brut(List<Integer> preOrder) {
        if (preOrder.isEmpty()) return null;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preOrder.get(0));

        for (int i = 1; i < preOrder.size(); i++) {
            root = insertAValInBST(root, preOrder.get(i));
        }

        return root;
    }

    //TC - O(NlogN) + O(N)
    //SC - O(N)
    public static BinaryTreeNode<Integer> constructBST_Better(List<Integer> preOrder) {
        if (preOrder.isEmpty()) return null;

        // we know inOrder is sorted
        List<Integer> inOrder = new ArrayList<>(preOrder);
        Collections.sort(inOrder);

        return buildTreeFromInAndPreOrder(inOrder, preOrder);
    }

    //TC - O(N)
    //SC - O(H)
    public static BinaryTreeNode<Integer> constructBST_Optimal(List<Integer> preOrder) {
        if (preOrder.isEmpty()) return null;

        int[] index = new int[1];
        return buildBSTFromInAndPreOrder(preOrder, Integer.MAX_VALUE, index);
    }

    public static BinaryTreeNode<Integer> buildBSTFromInAndPreOrder(List<Integer> preOrder, int upperLimit, int[] index) {
        if (index[0] >= preOrder.size() || preOrder.get(index[0]) >= upperLimit) {
            return null;
        }

        int curIndex = index[0];
        BinaryTreeNode<Integer> curRoot = new BinaryTreeNode<>(preOrder.get(curIndex));
        index[0]++;
        curRoot.left = buildBSTFromInAndPreOrder(preOrder, preOrder.get(curIndex), index);
        curRoot.right = buildBSTFromInAndPreOrder(preOrder, upperLimit, index);

        return curRoot;
    }


}
