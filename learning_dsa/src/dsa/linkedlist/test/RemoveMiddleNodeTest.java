package dsa.linkedlist.test;

import dsa.linkedlist.main.NodeSL;
import dsa.linkedlist.main.SinglyLinkedList;

import static dsa.linkedlist.main.ConvertArrayToSL.convertArrayToSinglyLinkedList;
import static dsa.linkedlist.main.RemoveMiddleNode.removeMiddleNode;
import static dsa.linkedlist.test.IterateSL.iterateSL;

public class RemoveMiddleNodeTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        SinglyLinkedList singlyLinkedList = convertArrayToSinglyLinkedList(arr);
        NodeSL<Integer> newHead = removeMiddleNode(singlyLinkedList.getHead());
        iterateSL(newHead);
    }
}
