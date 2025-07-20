package dsa.stackqueue.main;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueUsingStackDequeueCostly<T> implements Queue<T> {

    //will be using Java collection stack
    Deque<T> stack1 = new ArrayDeque<>();
    Deque<T> stack2 = new ArrayDeque<>();

    // this is also correct
    //Stack<T> stack = new Stack<>();

    //TC - O(1)
    public void enqueue(T data) {
        stack1.push(data);
    }

    //TC - O(2N)
    public T dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? null : stack2.pop();
    }

    //TC - O(N)
    @Override
    public T peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? null : stack2.peek();
    }

    //TC - O(1)
    @Override
    public int size() {
        return stack1.size() + stack2.size();
    }

    //TC - O(1)
    @Override
    public boolean isFull() {
        return false;
    }

    //TC - O(1)
    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
