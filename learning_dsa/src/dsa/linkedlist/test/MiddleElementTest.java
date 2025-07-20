package dsa.linkedlist.test;

import dsa.linkedlist.main.NodeSL;
import dsa.linkedlist.main.SinglyLinkedList;

import static dsa.linkedlist.main.ConvertArrayToSL.convertArrayToSinglyLinkedList;
import static dsa.linkedlist.main.MiddleElement.getMiddle;

/*
https://leetcode.com/problems/middle-of-the-linked-list/description/
 */
public class MiddleElementTest {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5};
        SinglyLinkedList singlyLinkedList1 = convertArrayToSinglyLinkedList(arr1);
        NodeSL<Integer> middle = getMiddle(singlyLinkedList1.getHead());

        System.out.println(middle.data);
    }
}
