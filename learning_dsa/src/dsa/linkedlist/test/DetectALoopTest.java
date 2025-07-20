package dsa.linkedlist.test;

import dsa.linkedlist.main.SinglyLinkedList;

import static dsa.linkedlist.main.ConvertArrayToSL.convertArrayToSinglyLinkedList;
import static dsa.linkedlist.main.DetectALoop.isHasCycle;

/*
https://leetcode.com/problems/linked-list-cycle/description/
 */
public class DetectALoopTest {

    public static void main(String[] args){
        int[] arr = {1, 2, 1};
        SinglyLinkedList singlyLinkedList = convertArrayToSinglyLinkedList(arr);
        singlyLinkedList.getTail().next = singlyLinkedList.getHead().next;    //making cycle
        System.out.println(isHasCycle(singlyLinkedList.getHead()));
    }
}
