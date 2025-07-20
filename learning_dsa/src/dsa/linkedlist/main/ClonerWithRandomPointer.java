package dsa.linkedlist.main;

import java.util.HashMap;
import java.util.Map;

public class ClonerWithRandomPointer {

    //TC - O(2N)
    //SC - O(2N)  - N for clone
    public static NodeSLWithRandom clone_usingHashMap(NodeSLWithRandom head) {
        Map<NodeSLWithRandom, NodeSLWithRandom> map = new HashMap<>();

        //create copy and put it in hashmap
        NodeSLWithRandom temp = head;
        while (temp != null) {
            NodeSLWithRandom copy = new NodeSLWithRandom(temp.data);
            map.put(temp, copy);
            temp = temp.next;
        }

        //assign next and random pointer
        temp = head;
        NodeSLWithRandom dummy = new NodeSLWithRandom(-1);
        NodeSLWithRandom prev = dummy;
        while (temp != null) {
            NodeSLWithRandom copy = map.get(temp);
            prev.next = copy;
            copy.next = map.get(temp.next);
            copy.random = map.get(temp.random);
            prev = copy;
            temp = temp.next;

        }
        return dummy.next;
    }

    //TC - O(3N)
    //SC - O(N)  - N for clone
    public static NodeSLWithRandom clone_optimal(NodeSLWithRandom head) {

        //step 1 - create copy nodes and place in between of two nodes
        NodeSLWithRandom temp = head;
        while (temp != null) {
            NodeSLWithRandom copyNode = new NodeSLWithRandom(temp.data);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }

        //step 2 - assign random nodes
        temp = head;
        while (temp != null) {
            NodeSLWithRandom copyNode = temp.next;
            if (temp.random != null) copyNode.random = temp.random.next;
            temp = temp.next.next;
        }

        //step 3 - assign next nodes
        NodeSLWithRandom dummy = new NodeSLWithRandom(-1);
        NodeSLWithRandom prev = dummy;
        temp = head;
        while (temp != null) {
            NodeSLWithRandom copyNode = temp.next;
            prev.next = copyNode;
            temp.next = copyNode.next;
            temp = temp.next;
            prev = copyNode;
        }
        return dummy.next;
    }


}
