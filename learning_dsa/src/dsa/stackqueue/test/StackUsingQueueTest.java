package dsa.stackqueue.test;

import dsa.stackqueue.main.Stack;
import dsa.stackqueue.main.StackUsingQueue;

public class StackUsingQueueTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new StackUsingQueue<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.top());

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.top());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.top());

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.top());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
