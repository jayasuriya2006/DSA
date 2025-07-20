package dsa.linkedlist.main;

public class MergeTwoSortedSL {

    /*
     Brut force - copy all node data into array
                - sort array
                - create a new list copy data from array
     */


    public static NodeSL<Integer> merge(NodeSL<Integer> head1, NodeSL<Integer> head2) {

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
}
