package dsa.linkedlist.main;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSL {

    /*
     Brut force - copy all elements into array or list
                - sort the list
                - create a new list
     */


    //This approach we can follow for all types of merge
    //TC - nk lognk
    //SC - nk
    public static NodeSL<Integer> mergeList(List<NodeSL<Integer>> heads) {
        int k = heads.size();

        PriorityQueue<NodeSL<Integer>> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

        for (int i = 0; i < k; i++) {
            pq.add(heads.get(i));
        }

        NodeSL<Integer> dummy = new NodeSL<>(-1);
        NodeSL<Integer> prev = dummy;
        while (!pq.isEmpty()) {
            NodeSL<Integer> curNode = pq.poll();
            prev.next = curNode;
            prev = prev.next;
            if(curNode.next != null) pq.add(curNode.next);
        }

        return dummy.next;
    }
}
