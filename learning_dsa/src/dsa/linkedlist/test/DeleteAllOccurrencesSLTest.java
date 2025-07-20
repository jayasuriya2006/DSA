package dsa.linkedlist.test;

import dsa.linkedlist.main.NodeSL;
import dsa.linkedlist.main.SinglyLinkedList;

import static dsa.linkedlist.main.ConvertArrayToSL.convertArrayToSinglyLinkedList;
import static dsa.linkedlist.main.DeleteAllOccurrencesSL.removeAllOccurrencesOfK;
import static dsa.linkedlist.test.IterateSL.iterateSL;

public class DeleteAllOccurrencesSLTest {

    public static void main(String[] args) {
        int[] arr = {90, 10, 2, 4, 9, 5, 90, 90};
        SinglyLinkedList singlyLinkedList = convertArrayToSinglyLinkedList(arr);
        NodeSL<Integer> newHead = removeAllOccurrencesOfK(singlyLinkedList.getHead(), 90);

        iterateSL(newHead);
    }
}
