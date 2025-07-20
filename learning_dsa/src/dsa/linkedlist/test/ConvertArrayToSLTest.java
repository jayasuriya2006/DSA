package dsa.linkedlist.test;

import dsa.linkedlist.main.SinglyLinkedList;

import static dsa.linkedlist.main.ConvertArrayToSL.convertArrayToSinglyLinkedList;
import static dsa.linkedlist.test.IterateSL.iterateSL;

public class ConvertArrayToSLTest {
    public static void main(String[] args) {
        int[] arr = {10, 2, 4, 9, 5, 90};
        SinglyLinkedList singlyLinkedList = convertArrayToSinglyLinkedList(arr);

        singlyLinkedList.reverse();   // test all scenarios here
        //iteration
        iterateSL(singlyLinkedList.getHead());

    }
}
