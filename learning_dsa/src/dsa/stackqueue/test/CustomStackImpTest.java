package dsa.stackqueue.test;

import dsa.stackqueue.main.ArrayStackImpl;
import dsa.stackqueue.main.Stack;

public class CustomStackImpTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStackImpl<>(5);

        System.out.println(stack.isFUll());
        System.out.println(stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.top());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
