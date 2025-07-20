package dsa.linkedlist.main;

public class DeleteAllOccurrencesSL {
    public static NodeSL<Integer> removeAllOccurrencesOfK(NodeSL<Integer> head, int k) {
        NodeSL<Integer> dummy = new NodeSL<>(-1);
        NodeSL<Integer> tracker = dummy;
        NodeSL<Integer> temp = head;

        while (temp != null) {
            if (temp.data != k) {
                tracker.next = temp;
                tracker = tracker.next;
                temp = temp.next;
                tracker.next = null;
            } else {
                temp = temp.next;
            }
        }
        return dummy.next;
    }
}
