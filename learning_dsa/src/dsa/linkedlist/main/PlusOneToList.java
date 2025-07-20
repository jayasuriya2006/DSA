package dsa.linkedlist.main;

public class PlusOneToList {

    //9 -> 9 -> 9
    //1 -> 0 -> 0 -> 0

    /*Brut force - reverse a list
                  add one (with carry forward)
                  if no carry - then break
                  again reverse
     */

    public static NodeSL<Integer> plusOneToLinkedList(NodeSL<Integer> head) {
        if (head == null) return head;
        int carry = plusOneToLinkedList_Helper(head);
        if (carry > 0) {
            NodeSL<Integer> newNode = new NodeSL<>(1);
            newNode.next = head;
            return newNode;
        }
        return head;

    }

    public static int plusOneToLinkedList_Helper(NodeSL<Integer> head) {
        if (head == null) return 1;

        int carry = plusOneToLinkedList_Helper(head.next);
        if ((carry + head.data) > 9) {
            head.data = 0;
            return 1;
        } else {
            head.data = carry + head.data;
            return 0;
        }
    }

}
