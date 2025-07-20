package dsa.stackqueue.test;

import dsa.stackqueue.main.Queue;
import dsa.stackqueue.main.QueueUsingStackDequeueCostly;

public class QueueUsingStackDequeueCostlyTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new QueueUsingStackDequeueCostly<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue.peek());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println(queue.peek());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.peek());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println(queue.peek());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
}
