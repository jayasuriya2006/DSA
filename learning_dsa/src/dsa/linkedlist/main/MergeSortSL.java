package dsa.linkedlist.main;

public class MergeSortSL {

    public static NodeSL<Integer> sortSL(NodeSL<Integer> head) {
        return mergeSortSL(head);
    }

    private static NodeSL<Integer> mergeSortSL(NodeSL<Integer> head) {
        if (head == null || head.next == null) return head;

        NodeSL<Integer> mid = findMid(head);
        NodeSL<Integer> right = head;
        NodeSL<Integer> left = mid.next;
        mid.next = null;

        NodeSL<Integer> leftH = mergeSortSL(right);
        NodeSL<Integer> rightH = mergeSortSL(left);
        return merge(leftH, rightH);
    }

    private static NodeSL<Integer> merge(NodeSL<Integer> head1, NodeSL<Integer> head2) {

        NodeSL<Integer> dummy = new NodeSL<>(-1);
        NodeSL<Integer> prev = dummy;
        NodeSL<Integer> temp1 = head1;
        NodeSL<Integer> temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                prev.next = temp1;
                prev = temp1;
                temp1 = temp1.next;
            } else {
                prev.next = temp2;
                prev = temp2;
                temp2 = temp2.next;
            }
        }

        if (temp1 != null) {
            prev.next = temp1;
        }
        if (temp2 != null) {
            prev.next = temp2;
        }

        return dummy.next;
    }

    private static NodeSL<Integer> findMid(NodeSL<Integer> head) {
        NodeSL<Integer> sp = head;
        NodeSL<Integer> fp = head.next;

        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }
        return sp;
    }
}
