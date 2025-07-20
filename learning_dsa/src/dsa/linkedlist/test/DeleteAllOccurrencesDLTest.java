package dsa.linkedlist.test;

import dsa.linkedlist.main.DoublyLinkedList;
import dsa.linkedlist.main.NodeDL;

import static dsa.linkedlist.main.ConvertArrayToDL.convertArrayToDoublyLinkedList;
import static dsa.linkedlist.main.DeleteAllOccurrencesDL.removeAllOccurrencesOfK;
import static dsa.linkedlist.test.IterateDL.iterateDLFromHead;

public class DeleteAllOccurrencesDLTest {
    public static void main(String[] args) {
        int[] arr = {1, 6,6};
        DoublyLinkedList doublyLinkedList = convertArrayToDoublyLinkedList(arr);
        NodeDL<Integer> newHead = removeAllOccurrencesOfK(doublyLinkedList.getHead(), 6);

        iterateDLFromHead(newHead);
    }
}
