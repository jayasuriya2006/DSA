package dsa.stackqueue.main;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class QueueUsingStackEnqueueCostly<T> implements Queue<T> {

    //will be using Java collection stack
    Deque<T> stack1 = new ArrayDeque<>();

    // this is also correct
    //Stack<T> stack = new Stack<>();

    //TC - O(2N)
    @Override
    public void enqueue(T data) {
        int size = stack1.size();
        Stack<T> tempStack = new Stack<>();

        //move to temp stack
        for (int i = 0; i < size; i++) {
            tempStack.push(stack1.pop());
        }

        //insert data
        stack1.push(data);

        //move back to original stack
        while (!tempStack.isEmpty()) {
            stack1.push(tempStack.pop());
        }

    }

    //TC - O(1)
    @Override
    public T dequeue() {
        return stack1.isEmpty() ? null : stack1.pop();
    }

    //TC - O(1)
    @Override
    public T peek() {
        return stack1.isEmpty() ? null : stack1.peek();
    }

    //TC - O(1)
    @Override
    public int size() {
        return stack1.size();
    }

    //TC - O(1)
    @Override
    public boolean isFull() {
        return false;
    }

    //TC - O(1)
    @Override
    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}
