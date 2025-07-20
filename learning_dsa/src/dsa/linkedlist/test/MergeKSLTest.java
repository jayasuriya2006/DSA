package dsa.linkedlist.test;

import dsa.linkedlist.main.NodeSL;
import dsa.linkedlist.main.SinglyLinkedList;

import java.util.ArrayList;
import java.util.List;

import static dsa.linkedlist.main.ConvertArrayToSL.convertArrayToSinglyLinkedList;
import static dsa.linkedlist.main.MergeKSL.mergeList;
import static dsa.linkedlist.test.IterateSL.iterateSL;

public class MergeKSLTest {
    public static void main(String[] args) {
        int[] arr1 = {10, 50, 60, 90, 101, 900};
        SinglyLinkedList singlyLinkedList1 = convertArrayToSinglyLinkedList(arr1);

        int[] arr2 = {20, 70};
        SinglyLinkedList singlyLinkedList2 = convertArrayToSinglyLinkedList(arr2);

        int[] arr3 = {80, 905, 1000, 1001};
        SinglyLinkedList singlyLinkedList3 = convertArrayToSinglyLinkedList(arr3);

        int[] arr4 = {200, 300, 400, 500};
        SinglyLinkedList singlyLinkedList4 = convertArrayToSinglyLinkedList(arr4);

        List<NodeSL<Integer>> headList = new ArrayList<>();
        headList.add(singlyLinkedList1.getHead());
        headList.add(singlyLinkedList2.getHead());
        headList.add(singlyLinkedList3.getHead());
        headList.add(singlyLinkedList4.getHead());

        NodeSL<Integer> newHead = mergeList(headList);
        iterateSL(newHead);

    }
}
