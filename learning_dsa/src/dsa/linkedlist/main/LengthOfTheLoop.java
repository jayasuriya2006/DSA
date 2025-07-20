package dsa.linkedlist.main;

public class LengthOfTheLoop {
    /*
    Brut force -
          map = {n1->1 , n2->2, n3->3, n4->4,........}
          when we find the node already exist in the map return curCount - map.get(node)
     */

    public static int findLengthOfTheLoop(NodeSL<Integer> head) {
        if (head == null || head.next == null) return 0;
        if(head.next == head) return 1;

        NodeSL<Integer> sp = head;
        NodeSL<Integer> fp = head;

        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
            if (fp == sp) {
                int count = 0;
                do {
                    count++;
                    sp = sp.next;

                } while (sp != fp);
                return count;
            }

        }

        return 0;
    }
}
