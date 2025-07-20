package dsa.linkedlist.main;

public class StartOfCycle {

    //use set , if set already contains the node, that is the start point - brut

    public static NodeSL<Integer> findStartOfCycle(NodeSL<Integer> head) {
        if (head == null) return head;

        //step 1 - detect a loop
        NodeSL<Integer> fp = head;
        NodeSL<Integer> sp = head;
        while (fp != null || fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
            if (fp == sp) {
                //step 2 - find start node
                sp = head;
                while (sp != fp) {
                    sp = sp.next;
                    fp = fp.next;
                }
                return fp;
            }

        }

        return null;   //if no loop

    }


}
