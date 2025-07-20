package dsa.linkedlist.test;

import dsa.linkedlist.main.NodeSL;
import dsa.linkedlist.main.SinglyLinkedList;

import static dsa.linkedlist.main.ConvertArrayToSL.convertArrayToSinglyLinkedList;
import static dsa.linkedlist.main.MergeSortSL.sortSL;
import static dsa.linkedlist.test.IterateSL.iterateSL;

public class MergeSortSLTest {

    public static void main(String[] args) {
        int[] arr1 = {90, 1, 5, 3, 900, 500, 200, 4};
        SinglyLinkedList singlyLinkedList1 = convertArrayToSinglyLinkedList(arr1);
        NodeSL<Integer> head = sortSL(singlyLinkedList1.getHead());
        iterateSL(head);
    }
}
