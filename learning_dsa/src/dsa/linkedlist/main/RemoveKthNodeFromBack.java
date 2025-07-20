package dsa.linkedlist.main;

public class RemoveKthNodeFromBack {

    //Brut force
    //find the size of linked list - n  (iterate from head to last, increase the count)   -O(n)
    //then you need to delete (n - k)th node       - O(n-k)
    //Note - if k == n then delete the head... -> return head.next

    public static NodeSL<Integer> removeKthNodeFromBack(int k, NodeSL<Integer> head){
        if(head == null || k == 0) return head;

        NodeSL<Integer> fastPointer = head;
        for(int i = 1; i <= k; i++){
            fastPointer = fastPointer.next;
            if(fastPointer == null){
                if(i == k){                      // remove head
                    return head.next;
                } else {                         // k is greater than size
                    return head;
                }
            }
        }
        //1 , 2, 3, 4, 5, 6
        NodeSL<Integer> slowPointer = head;
        while(fastPointer.next != null){
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        NodeSL<Integer> deleteNode = slowPointer.next;
        slowPointer.next = deleteNode.next;
        deleteNode.next = null;
        return head;
    }


}
