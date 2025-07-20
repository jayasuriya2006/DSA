package dsa.linkedlist.test;

import dsa.linkedlist.main.NodeSL;
import dsa.linkedlist.main.SinglyLinkedList;

import static dsa.linkedlist.main.ConvertArrayToSL.convertArrayToSinglyLinkedList;
import static dsa.linkedlist.main.StartOfCycle.findStartOfCycle;

public class StartOfCycleTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        SinglyLinkedList singlyLinkedList = convertArrayToSinglyLinkedList(arr);
        singlyLinkedList.getTail().next = singlyLinkedList.getHead().next.next;    //making cycle
        NodeSL<Integer> startLoop = findStartOfCycle(singlyLinkedList.getHead());
        System.out.println(startLoop.data);
    }
}
