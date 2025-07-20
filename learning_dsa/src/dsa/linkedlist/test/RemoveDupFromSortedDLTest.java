package dsa.linkedlist.test;

import dsa.linkedlist.main.DoublyLinkedList;
import dsa.linkedlist.main.NodeDL;

import static dsa.linkedlist.main.ConvertArrayToDL.convertArrayToDoublyLinkedList;
import static dsa.linkedlist.main.RemoveDupFromSortedDL.removeDuplicates;
import static dsa.linkedlist.test.IterateDL.iterateDLFromHead;

public class RemoveDupFromSortedDLTest {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0};
        DoublyLinkedList doublyLinkedList = convertArrayToDoublyLinkedList(arr);
        NodeDL<Integer> newHead =  removeDuplicates(doublyLinkedList.getHead());

        iterateDLFromHead(newHead);
    }
}
