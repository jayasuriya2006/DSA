package dsa.stackqueue.main;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingQueue<T> implements Stack<T> {

    Deque<T> stack1 = new ArrayDeque<>();

    //TC - O(N)
    @Override
    public void push(T data) {
        int size = stack1.size();
        stack1.push(data);

        for (int i = 0; i < size; i++) {
            stack1.push(stack1.pop());
        }
    }

    //TC - O(1)
    @Override
    public T top() {
        return stack1.isEmpty() ? null : stack1.peek();
    }

    //TC - O(1)
    @Override
    public T pop() {
        return stack1.isEmpty() ? null : stack1.pop();
    }

    //TC - O(1)
    @Override
    public int size() {
        return stack1.size();
    }

    //TC - O(1)
    @Override
    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    //TC - O(1)
    @Override
    public boolean isFUll() {
        return false;
    }
}
