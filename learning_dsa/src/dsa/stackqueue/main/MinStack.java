package dsa.stackqueue.main;

import java.util.Stack;

/*
  we can store a pair in stack <data, curMin>  - this will give SC - O(2n)
 */

//TC - O(1) for all operation
//SC - O(n) - stack
public class MinStack {

    int min;
    Stack<Integer> stack;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.stack = new Stack<>();
    }

    public int getMin() {
        if (this.stack.isEmpty()) return Integer.MAX_VALUE;
        return this.min;
    }

    public void push(int data) {
        if (this.stack.isEmpty()) {
            this.min = data;
            this.stack.push(data);
        } else {
            if (this.min >= data) {
                this.stack.push(2 * data - this.min);
                this.min = data;
            } else {
                this.stack.push(data);
            }
        }
    }


    public int pop() {
        if (this.stack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            int top = this.stack.pop();
            if (this.min > top) {
                int original = this.min;
                this.min = 2 * this.min - top;
                return original;
            } else {
                return top;
            }
        }

    }

    public int peek() {
        if (this.stack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            int top = this.stack.peek();
            if (this.min > top) {
                return this.min;
            } else {
                return top;
            }
        }
    }

}
