package dsa.linkedlist.main;

public class SortZeroOneTwo {
   //Brut force - count the no of 0, 1, 2 and create new list

    public static NodeSL<Integer> sortZeroOneTwo(NodeSL<Integer> head) {
        NodeSL<Integer> dummyZero = new NodeSL<>(-1);
        NodeSL<Integer> dummyOne = new NodeSL<>(-1);
        NodeSL<Integer> dummyTwo = new NodeSL<>(-1);;

        NodeSL<Integer> zero = dummyZero;
        NodeSL<Integer> one = dummyOne;
        NodeSL<Integer> two = dummyTwo;

        NodeSL<Integer> temp = head;

        while(temp != null){
            if(temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            } else if(temp.data == 1){
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }

        zero.next = dummyOne.next != null ?  dummyOne.next : dummyTwo.next;
        one.next = dummyTwo.next;
        two.next = null;
        return dummyZero.next;
    }
}
