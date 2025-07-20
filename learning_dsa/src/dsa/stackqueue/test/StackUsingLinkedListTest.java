package dsa.stackqueue.test;

import dsa.stackqueue.main.Stack;
import dsa.stackqueue.main.StackUsingLinkedList;

public class StackUsingLinkedListTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new StackUsingLinkedList<>();

        System.out.println(stack.pop());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


        stack.push(4);
        stack.push(5);
        System.out.println(stack.top());
        System.out.println(stack.pop());

    }
}
