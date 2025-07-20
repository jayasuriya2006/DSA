package dsa.linkedlist.main;

public class IntersectionPoint {

    /* Brut force - use set and add all nodes from list 1
                    iterate list 2 if set already has list2 node , return that node
     */

    public static NodeSL<Integer> getIntersectionPoint(NodeSL<Integer> head1, NodeSL<Integer> head2){


        NodeSL<Integer> pointer1 = head1;
        NodeSL<Integer> pointer2 = head2;

        while(pointer1 != pointer2){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;

            if(pointer1 == pointer2){
                return pointer1;
            }
            pointer2 = pointer2 == null ? head1 : pointer2;
            pointer1 = pointer1 == null ? head2 : pointer1;

        }

        return pointer1;
    }
}
