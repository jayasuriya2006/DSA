package dsa.linkedlist.test;

import dsa.linkedlist.main.NodeSL;
import dsa.linkedlist.main.SinglyLinkedList;

import static dsa.linkedlist.main.ConvertArrayToSL.convertArrayToSinglyLinkedList;
import static dsa.linkedlist.main.PlusOneToList.plusOneToLinkedList;
import static dsa.linkedlist.test.IterateSL.iterateSL;

public class PlusOneToListTest {

    public static void main(String[] args){
        int[] arr = {9, 9, 9, 9};
        SinglyLinkedList singlyLinkedList = convertArrayToSinglyLinkedList(arr);
        NodeSL<Integer> newHead = plusOneToLinkedList(singlyLinkedList.getHead());
        iterateSL(newHead);
    }
}
