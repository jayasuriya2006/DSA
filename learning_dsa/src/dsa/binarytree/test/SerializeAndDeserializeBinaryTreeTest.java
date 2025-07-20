package dsa.binarytree.test;

import dsa.binarytree.main.BinaryTreeNode;
import dsa.binarytree.main.BinaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;

import static dsa.binarytree.main.BinaryTreeFromInOrderAndPreOrder.buildTreeFromInAndPreOrder;
import static dsa.binarytree.main.SerializeAndDeserializeBinaryTree.deSerializeTree;
import static dsa.binarytree.main.SerializeAndDeserializeBinaryTree.serializeTree;
import static dsa.binarytree.test.BinaryTreeTraversalTest.printRes;

public class SerializeAndDeserializeBinaryTreeTest {
    public static void main(String[] args) {
        List<Integer> preOrder = List.of(10, 6, 3, 1, 4, 8, 15, 12, 17, 16, 20);
        List<Integer> inOrder = List.of(1, 3, 4, 6, 8, 10, 12, 15, 16, 17, 20);
        List<Integer> postOrder = List.of(1, 4, 3, 8, 6, 12, 16, 20, 17, 15, 10);

        BinaryTreeNode<Integer> root = buildTreeFromInAndPreOrder(inOrder, preOrder);

        String serialized = serializeTree(root);

        System.out.println(serialized);

        BinaryTreeNode<Integer> deSerializedRoot = deSerializeTree(serialized);

        List<Integer> levelOrder = List.of(10, 6, 15, 3, 8, 12, 17, 1, 4, 16, 20);

        BinaryTreeTraversal<Integer> treeTraversal = new BinaryTreeTraversal<>();
        List<Integer> preOrderRes = new ArrayList<>();
        treeTraversal.preOrderTraversal(deSerializedRoot, preOrderRes);
        printRes(preOrder, preOrderRes, "Pre-Order");

        List<Integer> inOrderRes = new ArrayList<>();
        treeTraversal.inOrderTraversal(deSerializedRoot, inOrderRes);
        printRes(inOrder, inOrderRes, "In-Order");

        List<Integer> postOrderRes = new ArrayList<>();
        treeTraversal.postOrderTraversal(deSerializedRoot, postOrderRes);
        printRes(postOrder, postOrderRes, "Post-Order");

        List<Integer> levelOrderRes = treeTraversal.levelOrderTraversal(deSerializedRoot);
        printRes(levelOrder, levelOrderRes, "Level-Order");
    }
}
