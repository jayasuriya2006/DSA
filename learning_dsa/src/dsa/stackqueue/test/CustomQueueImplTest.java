package dsa.stackqueue.test;

import dsa.stackqueue.main.ArrayQueueImpl;
import dsa.stackqueue.main.Queue;

public class CustomQueueImplTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueueImpl<>(5);

        System.out.println(queue.isFull());
        System.out.println(queue.isEmpty());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        queue.enqueue(41);
        queue.enqueue(51);
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

}
