package dsa.linkedlist.test;

import dsa.linkedlist.main.NodeSLWithDown;

import static dsa.linkedlist.main.FlattenSL.flatSL;

public class FlattenSLTest {

    /*
    1  - 2   - 8  - 0
    |    |
    3    9
    |    |
    7    90
         |
         900

 */
   public static void main(String[] args){
       NodeSLWithDown head1 = new NodeSLWithDown(1);

       head1.down = new NodeSLWithDown(3);
       head1.down.down = new NodeSLWithDown(7);

       head1.next = new NodeSLWithDown(2);
       head1.next.down = new NodeSLWithDown(9);
       head1.next.down.down = new NodeSLWithDown(90);
       head1.next.down.down.down = new NodeSLWithDown(9000);

       head1.next.next = new NodeSLWithDown(8);

       head1.next.next.next = new NodeSLWithDown(0);

       NodeSLWithDown newHead = flatSL(head1);

       printFlatList(newHead);

   }

   private static void printFlatList(NodeSLWithDown head){
       NodeSLWithDown temp = head;
       while(temp != null){
           System.out.println(temp.data);
           temp = temp.down;
       }
   }

}
