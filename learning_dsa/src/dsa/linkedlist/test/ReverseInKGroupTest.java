package dsa.linkedlist.test;

import dsa.linkedlist.main.NodeSL;
import dsa.linkedlist.main.SinglyLinkedList;

import static dsa.linkedlist.main.ConvertArrayToSL.convertArrayToSinglyLinkedList;
import static dsa.linkedlist.main.ReverseInKGroup.reverseKGroup;
import static dsa.linkedlist.test.IterateSL.iterateSL;

public class ReverseInKGroupTest {
    public static void main(String[] args) {
        int[] arr = {10, 2, 4, 9, 5, 90, 8, 9};
        SinglyLinkedList singlyLinkedList = convertArrayToSinglyLinkedList(arr);
        NodeSL<Integer> newHead = reverseKGroup(singlyLinkedList.getHead(), 4);

        iterateSL(newHead);
    }
}
