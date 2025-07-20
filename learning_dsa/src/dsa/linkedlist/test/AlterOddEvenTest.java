package dsa.linkedlist.test;

import dsa.linkedlist.main.NodeSL;
import dsa.linkedlist.main.SinglyLinkedList;

import static dsa.linkedlist.main.AlterOddEven.oddEvenList;
import static dsa.linkedlist.main.ConvertArrayToSL.convertArrayToSinglyLinkedList;
import static dsa.linkedlist.test.IterateSL.iterateSL;

//https://leetcode.com/problems/odd-even-linked-list/description/
public class AlterOddEvenTest {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        SinglyLinkedList sl = convertArrayToSinglyLinkedList(arr);
        NodeSL<Integer> newHead = oddEvenList(sl.getHead());

        iterateSL(newHead);
    }
}
