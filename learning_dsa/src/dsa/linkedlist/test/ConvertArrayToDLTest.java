package dsa.linkedlist.test;

import dsa.linkedlist.main.DoublyLinkedList;

import static dsa.linkedlist.main.ConvertArrayToDL.convertArrayToDoublyLinkedList;
import static dsa.linkedlist.test.IterateDL.iterateDLFromHead;
import static dsa.linkedlist.test.IterateDL.iterateDLFromTail;

public class ConvertArrayToDLTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 6};
        DoublyLinkedList doublyLinkedList = convertArrayToDoublyLinkedList(arr);

        doublyLinkedList.reverse();                  //test all scenarios here
        iterateDLFromHead(doublyLinkedList.getHead());
        iterateDLFromTail(doublyLinkedList.getTail());
    }
}
