package dsa.linkedlist.main;

public class FlattenSL {

    /*
     Brut force - copy all elements into array
           while(temp1 != null){
               temp2 = temp1;
               while(temp2 != null){
                  arrayList.add(temp2.data);
                  temp2 = temp2.down;
               }
               temp1 = temp1.next;
           }

           - Sort the list
           - create a new SL
     */


    public static NodeSLWithDown flatSL(NodeSLWithDown head) {
        //base case
        if (head == null || head.next == null)
            return head;

        NodeSLWithDown newHead = flatSL(head.next);
        return mergeDown(head, newHead);
    }

    private static NodeSLWithDown mergeDown(NodeSLWithDown head1, NodeSLWithDown head2) {

        NodeSLWithDown dummy = new NodeSLWithDown(-1);
        NodeSLWithDown prev = dummy;

        NodeSLWithDown temp1 = head1;
        NodeSLWithDown temp2 = head2;

        while (temp1 != null && temp2 != null) {
            prev.next = null;
            if (temp1.data <= temp2.data) {
                prev.down = temp1;
                prev = temp1;
                temp1 = temp1.down;
            } else {
                prev.down = temp2;
                prev = temp2;
                temp2 = temp2.down;
            }
        }

        if (temp1 != null) {
            prev.down = temp1;
        }
        if (temp2 != null) {
            prev.down = temp2;
        }
        return dummy.down;
    }
}

