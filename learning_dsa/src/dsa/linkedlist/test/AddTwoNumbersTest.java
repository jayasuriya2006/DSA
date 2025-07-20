package dsa.linkedlist.test;

import dsa.linkedlist.main.NodeSL;
import dsa.linkedlist.main.SinglyLinkedList;

import static dsa.linkedlist.main.AddTwoNumbers.addTwoNumbers;
import static dsa.linkedlist.main.ConvertArrayToSL.convertArrayToSinglyLinkedList;
import static dsa.linkedlist.test.IterateSL.iterateSL;

//https://leetcode.com/problems/add-two-numbers/description/
public class AddTwoNumbersTest {
    public static void main(String[] args) {
        int[] num1 = {9, 9, 9, 9, 9, 9, 9};
        int[] num2 = {9, 9, 9, 9};
        SinglyLinkedList sl1 = convertArrayToSinglyLinkedList(num1);
        SinglyLinkedList sl2 = convertArrayToSinglyLinkedList(num2);
        NodeSL<Integer> resHead = addTwoNumbers(sl1.getHead(), sl2.getHead());
        iterateSL(resHead);
    }
}
