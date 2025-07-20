package dsa.linkedlist.test;

import dsa.linkedlist.main.SinglyLinkedList;

import static dsa.linkedlist.main.ConvertArrayToSL.convertArrayToSinglyLinkedList;
import static dsa.linkedlist.main.LengthOfTheLoop.findLengthOfTheLoop;

public class LengthOfTheLoopTest {
    public static void main(String[] args){
        int[] arr = {1, 2, 5, 3, 5};
        SinglyLinkedList singlyLinkedList = convertArrayToSinglyLinkedList(arr);
        singlyLinkedList.getTail().next = singlyLinkedList.getHead().next;    //making cycle
        System.out.println(findLengthOfTheLoop(singlyLinkedList.getHead()));
    }
}
