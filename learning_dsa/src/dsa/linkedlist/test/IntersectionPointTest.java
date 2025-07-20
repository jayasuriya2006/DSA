package dsa.linkedlist.test;

import dsa.linkedlist.main.NodeSL;
import dsa.linkedlist.main.SinglyLinkedList;

import static dsa.linkedlist.main.ConvertArrayToSL.convertArrayToSinglyLinkedList;
import static dsa.linkedlist.main.IntersectionPoint.getIntersectionPoint;

/*
https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 */
public class IntersectionPointTest {
    public static void main(String[] args) {
        /*
           1 -> 2 -> 3 ->
                                     4 -> 5
           9 -> 8 -> 7 -> 6 -> 10 ->

           intersection is node with 4

         */
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {9, 8, 7, 6, 10};

        SinglyLinkedList singlyLinkedList1 = convertArrayToSinglyLinkedList(arr1);
        SinglyLinkedList singlyLinkedList2 = convertArrayToSinglyLinkedList(arr2);


        //make a link
        NodeSL<Integer> temp = singlyLinkedList2.getHead();
        while (temp.data != 6) {
            temp = temp.next;
        }
        singlyLinkedList1.getTail().next = temp;


        NodeSL<Integer> intersection = getIntersectionPoint(singlyLinkedList1.getHead(), singlyLinkedList2.getHead());
        System.out.println(intersection != null ? intersection.data : null);
    }
}
