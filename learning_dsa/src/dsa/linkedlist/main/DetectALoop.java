package dsa.linkedlist.main;

public class DetectALoop {

    /*
    Brut force -
       maintain set
       iterate list and add it to set
       if the set already has the node then cycle detected
     */

    public static boolean isHasCycle(NodeSL<Integer> head) {
        if (head == null || head.next == null) return false;

        NodeSL<Integer> sp = head;
        NodeSL<Integer> fp = head.next;

        while (fp != null && fp.next != null) {
            if (sp == fp) return true;           //meeting the same node again
                                                 // this will happen surely if list has loop, since each iteration
                                                         // reducing the distance between fast and slow by 1

            sp = sp.next;
            fp = fp.next.next;

        }
        return false;
    }
}
