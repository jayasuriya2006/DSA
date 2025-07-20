package dsa.linkedlist.main;

public class AlterOddEven {

    public static NodeSL<Integer> oddEvenList(NodeSL<Integer> head){
        if(head == null || head.next == null) return head;

//        NodeSL<Integer> dummyOdd = new NodeSL<>(-1);
//        NodeSL<Integer> dummyEven = new NodeSL<>(-1);
//        NodeSL<Integer> oddTracker = dummyOdd;
//        NodeSL<Integer> evenTracker = dummyEven;

        NodeSL<Integer> newHead = head;
        NodeSL<Integer> odd = head;
        NodeSL<Integer> even = head.next;
        NodeSL<Integer> evenHead = even;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = evenHead.next;
        }
        odd.next = evenHead;
        return newHead;
    }
}
