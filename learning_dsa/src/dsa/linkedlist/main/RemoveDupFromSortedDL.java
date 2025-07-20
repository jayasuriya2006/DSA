package dsa.linkedlist.main;

public class RemoveDupFromSortedDL {

    public static NodeDL<Integer> removeDuplicates(NodeDL<Integer> head){

        NodeDL<Integer> temp = head;
        NodeDL<Integer> lastNonDupNode = head;

        //1, 1, 2, 6, 6
        while(temp != null){
            if(lastNonDupNode.data != temp.data){
                lastNonDupNode.next = temp;
                temp.prev = lastNonDupNode;
                lastNonDupNode = lastNonDupNode.next;
                temp = temp.next;
                lastNonDupNode.next = null;
            } else {
                NodeDL<Integer> t = temp;
                temp = temp.next;
                t.next = null;
                t.prev = null;
            }
        }
        return head;
    }
}
