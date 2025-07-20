package dsa.linkedlist.test;

import dsa.linkedlist.main.DoublyLinkedList;

import java.util.List;

import static dsa.linkedlist.main.AllPairsWithSumK.findAllPairsWithSumAsK_Brut;
import static dsa.linkedlist.main.AllPairsWithSumK.findAllPairsWithSumAsK_Optimal;
import static dsa.linkedlist.main.ConvertArrayToDL.convertArrayToDoublyLinkedList;

public class AllPairsWithSumKTest {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        DoublyLinkedList doublyLinkedList = convertArrayToDoublyLinkedList(arr);
        List<List<Integer>> ans = findAllPairsWithSumAsK_Optimal(doublyLinkedList.getHead(), 10); //brut also coded

        for(List<Integer> pair : ans){
            System.out.println(pair);
        }
    }
}
