package dsa.linkedlist.main;

public class RemoveMiddleNode {

    /*
      Brut force -
            find the length - n
            delete n/2 node
     */

    //1, 2, 3, 4, 5, 6
    //1, 2, 3, 4, 5
    public static NodeSL<Integer> removeMiddleNode(NodeSL<Integer> head) {
        if (head == null || head.next == null) return null;

        NodeSL<Integer> sp = head;
        NodeSL<Integer> fp = head.next.next;    //skipping one step
        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
        }
        NodeSL<Integer> midNode = sp.next;
        sp.next = midNode.next;
        midNode.next = null;
        return head;

    }
}
