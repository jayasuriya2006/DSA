package dsa.linkedlist.test;

import dsa.linkedlist.main.NodeSL;
import dsa.linkedlist.main.SinglyLinkedList;

import static dsa.linkedlist.main.ConvertArrayToSL.convertArrayToSinglyLinkedList;
import static dsa.linkedlist.main.SortZeroOneTwo.sortZeroOneTwo;
import static dsa.linkedlist.test.IterateSL.iterateSL;

public class SortZeroOneTwoTest {

    public static void main(String[] args){
        int[] arr = {2,2,2,1,1,1,1,0,0, 2, 0, 1};
        SinglyLinkedList sl = convertArrayToSinglyLinkedList(arr);
        NodeSL<Integer> newHead = sortZeroOneTwo(sl.getHead());

        iterateSL(newHead);
    }
}
