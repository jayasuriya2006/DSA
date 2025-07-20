package dsa.stackqueue.test;

import dsa.stackqueue.main.MinStack;

public class MinStackTest {

    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(10);

        System.out.println(stack.getMin());

        stack.push(100);

        System.out.println(stack.getMin());

        stack.push(5);
        System.out.println(stack.getMin());

        System.out.println(stack.peek());
        System.out.println(stack.pop());

        System.out.println(stack.getMin());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.getMin());

        stack.push(2);
        stack.push(10);
        System.out.println(stack.getMin());

    }
}
