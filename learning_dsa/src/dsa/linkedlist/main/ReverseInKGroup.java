package dsa.linkedlist.main;

import static dsa.linkedlist.main.PalindromeChecker.reverseSL;

public class ReverseInKGroup {

    public static NodeSL<Integer> reverseKGroup(NodeSL<Integer> head, int k) {
        if (head == null) return null;

        NodeSL<Integer> temp = head;
        NodeSL<Integer> prevLast = null;

        while (temp != null) {
            NodeSL<Integer> kThNode = getKthNode(temp, k);
            if (kThNode == null) {
                if (prevLast != null) {
                    prevLast.next = temp;
                    break;
                }
            } else {
                NodeSL<Integer> nextNode = kThNode.next;
                kThNode.next = null;
                reverseSL(temp);

                if (temp == head) {
                    head = kThNode;
                } else {
                    prevLast.next = kThNode;
                }
                prevLast = temp;
                temp = nextNode;
            }
        }
        return head;
    }

    private static NodeSL<Integer> getKthNode(NodeSL<Integer> head, int k) {
        NodeSL<Integer> temp = head;
        while (k > 1 && temp != null) {
            temp = temp.next;
            k--;
        }
        return temp;
    }
}
