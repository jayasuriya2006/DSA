package dsa.linkedlist.main;

public class DeleteAllOccurrencesDL {

    public static NodeDL<Integer> removeAllOccurrencesOfK(NodeDL<Integer> head, int k){
        if(head == null){
            return null;
        }

        NodeDL<Integer> dummy = new NodeDL<>(-1);
        NodeDL<Integer> tracker = dummy;
        NodeDL<Integer> temp = head;
        while(temp != null){
            if(temp.data != k){
                tracker.next = temp;
                temp.prev = tracker;
                tracker = tracker.next;
                temp = temp.next;
                tracker.next = null;
            } else {
                NodeDL<Integer> t = temp;
                temp = temp.next;
                t.next = null;
                t.prev = null;
            }
        }
        return dummy.next;
    }
}
