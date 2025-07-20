package dsa.binarytree.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeFromInOrderAndPostOrder {

    public static BinaryTreeNode<Integer> buildTreeFromInAndPostOrder(List<Integer> inOrder, List<Integer> postOrder) {
        if (inOrder.size() == 0) return null;

        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.size(); i++) {
            inOrderIndexMap.put(inOrder.get(i), i);
        }

        return buildTreeFromInAndPostOrder(inOrder, 0, inOrder.size() - 1, postOrder, 0, postOrder.size() - 1, inOrderIndexMap);
    }

    private static BinaryTreeNode<Integer> buildTreeFromInAndPostOrder(List<Integer> inOrder, int inStart, int inEnd,
                                                                       List<Integer> poOrder, int poStart, int poEnd,
                                                                       Map<Integer, Integer> inOrderIndexMap) {

        if (inStart > inEnd || poStart > poEnd) {
            return null;
        }

        BinaryTreeNode<Integer> curRoot = new BinaryTreeNode<>(poOrder.get(poEnd));

        int inOrderIndex = inOrderIndexMap.get(poOrder.get(poEnd));
        int leftElements = inOrderIndex - inStart;

        curRoot.left = buildTreeFromInAndPostOrder(inOrder, inStart, inStart + leftElements - 1,
                poOrder, poStart, poStart + leftElements - 1, inOrderIndexMap);

        curRoot.right = buildTreeFromInAndPostOrder(inOrder, inOrderIndex + 1, inEnd,
                poOrder, poStart + leftElements , poEnd - 1, inOrderIndexMap);

        return curRoot;

    }
}
