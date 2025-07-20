package dsa.linkedlist.test;

import dsa.linkedlist.main.NodeSL;

public class IterateSL {

    public static void iterateSL(NodeSL<Integer> head){
        //iteration of linked list
        NodeSL<Integer> temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
