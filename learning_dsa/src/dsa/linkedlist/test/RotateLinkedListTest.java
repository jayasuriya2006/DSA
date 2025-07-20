package dsa.linkedlist.test;

import dsa.linkedlist.main.NodeSL;
import dsa.linkedlist.main.SinglyLinkedList;

import static dsa.linkedlist.main.ConvertArrayToSL.convertArrayToSinglyLinkedList;
import static dsa.linkedlist.main.RotateLinkedList.rotateByK;
import static dsa.linkedlist.test.IterateSL.iterateSL;

public class RotateLinkedListTest {
    public static void main(String[] args) {
        int[] arr = {10, 1, 4, 9, 5, 90, 8, 9};
        SinglyLinkedList singlyLinkedList = convertArrayToSinglyLinkedList(arr);
        NodeSL<Integer> newHead = rotateByK(singlyLinkedList.getHead(), 10);
        iterateSL(newHead);
    }
}
