package dsa.binarytree.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeFromInOrderAndPreOrder {

    //TC - O(N)
    //SC - O(H)
    public static BinaryTreeNode<Integer> buildTreeFromInAndPreOrder(List<Integer> inOrder, List<Integer> preOrder) {
        if (inOrder.size() == 0) return null;

        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.size(); i++) {
            inOrderIndexMap.put(inOrder.get(i), i);
        }

        return buildTreeFromInAndPreOrder(inOrder, 0, inOrder.size() - 1, preOrder, 0, preOrder.size() - 1, inOrderIndexMap);
    }

    private static BinaryTreeNode<Integer> buildTreeFromInAndPreOrder(List<Integer> inOrder, int inStart, int inEnd,
                                                                       List<Integer> preOrder, int preStart, int preEnd,
                                                                       Map<Integer, Integer> inOrderIndexMap) {

        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }

        BinaryTreeNode<Integer> curRoot = new BinaryTreeNode<>(preOrder.get(preStart));

        int inOrderIndex = inOrderIndexMap.get(preOrder.get(preStart));
        int leftElements = inOrderIndex - inStart;

        curRoot.left = buildTreeFromInAndPreOrder(inOrder, inStart, inStart + leftElements - 1,
                preOrder, preStart + 1, preStart + leftElements, inOrderIndexMap);

        curRoot.right = buildTreeFromInAndPreOrder(inOrder, inOrderIndex + 1, inEnd,
                preOrder, preStart + leftElements + 1, preEnd, inOrderIndexMap);

        return curRoot;

    }
}
