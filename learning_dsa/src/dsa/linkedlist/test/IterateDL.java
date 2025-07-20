package dsa.linkedlist.test;

import dsa.linkedlist.main.NodeDL;
import dsa.linkedlist.main.NodeSL;

public class IterateDL {

    public static void iterateDLFromHead(NodeDL<Integer> head){
        //iteration of linked list
        System.out.println("...... FROM HEAD ........");
        NodeDL<Integer> temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void iterateDLFromTail(NodeDL<Integer> tail){
        //iteration of linked list
        System.out.println("...... FROM TAIL ........");
        NodeDL<Integer> temp = tail;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.prev;
        }
    }
}
