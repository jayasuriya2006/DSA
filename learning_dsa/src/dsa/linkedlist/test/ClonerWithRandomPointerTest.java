package dsa.linkedlist.test;

import dsa.linkedlist.main.NodeSL;
import dsa.linkedlist.main.NodeSLWithRandom;

import static dsa.linkedlist.main.ClonerWithRandomPointer.clone_optimal;
import static dsa.linkedlist.main.ClonerWithRandomPointer.clone_usingHashMap;

public class ClonerWithRandomPointerTest {

    public static void main(String[] args) {
        int[] arr = {90, 1, 5, 3};

        NodeSLWithRandom head = new NodeSLWithRandom(arr[0]);
        NodeSLWithRandom first = new NodeSLWithRandom(arr[1]);
        NodeSLWithRandom second = new NodeSLWithRandom(arr[2]);
        NodeSLWithRandom third = new NodeSLWithRandom(arr[3]);

        head.next = first;
        first.next = second;
        second.next = third;

        head.random = third;
        third.random = first;
        first.random = second;

        NodeSLWithRandom clonedHead = clone_usingHashMap(head);
        iterateWithRandom(clonedHead);
        iterateWithRandom(head);
        iterateWithNext(clonedHead);
        iterateWithNext(head);


    }

    private static void iterateWithRandom(NodeSLWithRandom head) {
        System.out.println("Iteration with random: ");
        NodeSLWithRandom temp = head;
        while (temp != null) {
            System.out.println(temp + " - " + temp.data);
            temp = temp.random;
        }
    }

    private static void iterateWithNext(NodeSLWithRandom head) {
        System.out.println("Iteration with next: ");
        NodeSLWithRandom temp = head;
        while (temp != null) {
            System.out.println(temp + " - " + temp.data);
            temp = temp.next;
        }
    }
}
