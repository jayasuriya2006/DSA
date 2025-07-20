package dsa.linkedlist.test;

import dsa.linkedlist.main.NodeSL;
import dsa.linkedlist.main.SinglyLinkedList;

import static dsa.linkedlist.main.ConvertArrayToSL.convertArrayToSinglyLinkedList;
import static dsa.linkedlist.main.RemoveKthNodeFromBack.removeKthNodeFromBack;
import static dsa.linkedlist.test.IterateSL.iterateSL;

public class RemoveKthNodeFromBackTest {

    public static void main(String[] args){
        int[] arr = {10, 2, 4, 9, 5, 90};
        SinglyLinkedList singlyLinkedList = convertArrayToSinglyLinkedList(arr);
        NodeSL<Integer> newHead = removeKthNodeFromBack(1, singlyLinkedList.getHead());
        iterateSL(newHead);
    }
}
