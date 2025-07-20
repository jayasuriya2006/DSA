package dsa.linkedlist.main;

public class MiddleElement {

    // 1 2 3 4 5
    public static NodeSL<Integer> getMiddle(NodeSL<Integer> head){
        if(head == null || head.next == null) return head;

        NodeSL<Integer> sp = head;
        NodeSL<Integer> fp = head;

        while(fp != null && fp.next != null){
            sp = sp.next;
            fp = fp.next.next;
        }
        return sp;
    }
}
