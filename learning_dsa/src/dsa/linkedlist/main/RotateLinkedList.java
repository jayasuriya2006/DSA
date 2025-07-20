package dsa.linkedlist.main;

public class RotateLinkedList {

    public static NodeSL<Integer> rotateByK(NodeSL<Integer> head, int k) {
        if (head == null) {
            return null;
        }

        int size = 0;
        NodeSL<Integer> temp = head;
        NodeSL<Integer> lastNode = head;
        while (temp != null) {
            size++;
            temp = temp.next;
            if (temp != null) lastNode = temp;
        }

        int requiredRotation = k % size;
        if (requiredRotation == 0) return head;

        lastNode.next = head;
        temp = head;
        int iterator = size - requiredRotation;
        while (iterator > 1) {
            temp = temp.next;
            iterator--;
        }
        NodeSL<Integer> newHead = temp.next;
        temp.next = null;
        return newHead;

    }
}
