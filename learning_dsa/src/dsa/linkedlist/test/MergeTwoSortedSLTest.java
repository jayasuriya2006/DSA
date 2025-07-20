package dsa.linkedlist.test;

import dsa.linkedlist.main.NodeSL;
import dsa.linkedlist.main.SinglyLinkedList;

import static dsa.linkedlist.main.ConvertArrayToSL.convertArrayToSinglyLinkedList;
import static dsa.linkedlist.main.MergeTwoSortedSL.merge;
import static dsa.linkedlist.test.IterateSL.iterateSL;

public class MergeTwoSortedSLTest {

    public static void main(String[] args) {
        int[] arr1 = {10, 50, 60, 90, 101, 900};
        SinglyLinkedList singlyLinkedList1 = convertArrayToSinglyLinkedList(arr1);

        int[] arr2 = {20, 70};
        SinglyLinkedList singlyLinkedList2 = convertArrayToSinglyLinkedList(arr2);

        NodeSL<Integer> mergedHead = merge(singlyLinkedList1.getHead(), singlyLinkedList2.getHead());

        iterateSL(mergedHead);
    }
}
