package dsa.linkedlist.main;

public class AddTwoNumbers {

    //brut force
    // we can create two list
    // iterate those
    // create new linked list

    public static NodeSL<Integer> addTwoNumbers(NodeSL<Integer> head1, NodeSL<Integer> head2){
        NodeSL<Integer> dummy = new NodeSL<>(-1);
        NodeSL<Integer> curRes = dummy;
        NodeSL<Integer> temp1 = head1;
        NodeSL<Integer> temp2 = head2;
        int carry = 0;
        while(temp1 != null || temp2 != null){
            int sum = 0;
            if(temp1 != null) sum += temp1.data;
            if(temp2 != null) sum += temp2.data;
            sum += carry;

            carry = sum / 10;
            curRes.next = new NodeSL<>(sum >= 10 ? sum % 10 : sum);
            curRes = curRes.next;

            if(temp1 != null) temp1 = temp1.next;
            if(temp2 != null) temp2 = temp2.next;
        }
        if(carry > 0){
            curRes.next = new NodeSL<>(carry);
        }

        return dummy.next;
    }
}
