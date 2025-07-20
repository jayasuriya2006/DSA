package dsa.stackqueue.main;

import dsa.linkedlist.main.NodeSL;

public class StackUsingLinkedList<T> implements Stack<T> {

    private int size;
    private NodeSL<T> top;

    /*
       no argument constructor, we can add constructor with capacity
       and add check for overflow(isFull) and underFloe(isEmpty)
     */
    public StackUsingLinkedList() {
        this.size = 0;
        this.top = null;
    }

    //TC - O(1)
    @Override
    public void push(T data) {
        //if want we can add capacity check here

        NodeSL<T> newNode = new NodeSL<>(data);
        newNode.next = this.top;
        this.top = newNode;
        this.size++;
    }

    //TC - O(1)
    @Override
    public T top() {
        if (this.top != null) return this.top.data;     //not empty
        return null;        //empty
    }

    //TC - O(1)
    @Override
    public T pop() {
        if (this.top != null) {
            NodeSL<T> topNode = this.top;
            this.top = this.top.next;
            this.size--;
            topNode.next = null;
            return topNode.data;
        }

        return null;          //empty
    }

    //TC - O(1)
    @Override
    public int size() {
        return this.size;
    }

    //TC - O(1)
    @Override
    public boolean isEmpty() {
        return this.top == null;
    }

    //TC - O(1)
    @Override
    public boolean isFUll() {
        //we can add capacity check here
        return false;
    }
}
