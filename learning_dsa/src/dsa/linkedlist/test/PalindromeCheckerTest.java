package dsa.linkedlist.test;

/*
https://leetcode.com/problems/palindrome-linked-list/
 */
import dsa.linkedlist.main.SinglyLinkedList;

import static dsa.linkedlist.main.ConvertArrayToSL.convertArrayToSinglyLinkedList;
import static dsa.linkedlist.main.PalindromeChecker.isPalindrome;
import static dsa.linkedlist.test.IterateSL.iterateSL;

public class PalindromeCheckerTest {

    public static void main(String[] args){
        int[] arr = {1, 2, 1};
        SinglyLinkedList singlyLinkedList = convertArrayToSinglyLinkedList(arr);
        System.out.println(isPalindrome(singlyLinkedList.getHead()));

        iterateSL(singlyLinkedList.getHead());
    }
}
