package dsa.linkedlist.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllPairsWithSumK {

    /*
    brut force
     */

    public static List<List<Integer>> findAllPairsWithSumAsK_Brut(NodeDL<Integer> head, int k) {
        if (head == null) return null;
        List<List<Integer>> answer = new ArrayList<>();
        NodeDL<Integer> temp1 = head;
        while (temp1 != null) {
            NodeDL<Integer> temp2 = temp1.next;
            while (temp2 != null) {
                if (temp1.data + temp2.data == k) {
                    answer.add(List.of(temp1.data, temp2.data));
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return answer;
    }

    public static List<List<Integer>> findAllPairsWithSumAsK_Optimal(NodeDL<Integer> head, int k) {
        if (head == null) return null;

        List<List<Integer>> answer = new ArrayList<>();

        //first node
        NodeDL<Integer> temp1 = head;

        //last node
        NodeDL<Integer> temp2 = head;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }


        while (temp1 != temp2) {
            if (temp1.data + temp2.data == k) {
                answer.add(List.of(temp1.data, temp2.data));
                temp1 = temp1.next;
                temp2 = temp2.prev;
            } else if (temp1.data + temp2.data > k) {
                temp2 = temp2.prev;
            } else {
                temp1 = temp1.next;
            }

        }
        return answer;
    }


}
