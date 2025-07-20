package dsa.stackqueue.test;

import dsa.stackqueue.main.Queue;
import dsa.stackqueue.main.QueueUsingLinkedList;

public class QueueUsingLinkedListTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new QueueUsingLinkedList<>();

        System.out.println(queue.peek());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue(11);
        queue.enqueue(12);
        queue.enqueue(33);
        queue.enqueue(14);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());

    }
}
