package dsa.stackqueue.main;

import dsa.linkedlist.main.NodeSL;

public class QueueUsingLinkedList<T> implements Queue<T> {

    private int size;
    private NodeSL<T> front;
    private NodeSL<T> rear;

    //we can add capacity
    public QueueUsingLinkedList() {
        this.size = 0;
        this.front = null;
        this.rear = null;
    }

    //TC - O(1)
    @Override
    public void enqueue(T data) {
        //we can add capacity check for overflow

        if (this.front == null && this.rear == null) {
            NodeSL<T> newNode = new NodeSL<>(data);
            this.front = newNode;
            this.rear = newNode;
            this.size++;
            return;
        }
        NodeSL<T> newNode = new NodeSL<>(data);
        this.rear.next = newNode;
        this.rear = newNode;
        this.size++;

    }

    //TC - O(1)
    @Override
    public T dequeue() {
        if (this.front == null) {
            return null;
        }

        if (this.rear == this.front) {
            NodeSL<T> temp = this.front;
            this.front = null;
            this.rear = null;
            return temp.data;
        }
        NodeSL<T> temp = this.front;
        this.front = this.front.next;
        temp.next = null;
        return temp.data;
    }

    //TC - O(1)
    @Override
    public T peek() {
        if (this.front == null) {
            return null;
        }
        return this.front.data;
    }

    //TC - O(1)
    @Override
    public int size() {
        return this.size;
    }

    //TC - O(1)
    @Override
    public boolean isFull() {
        //we can add capacity check here

        return false;
    }

    //TC - O(1)
    @Override
    public boolean isEmpty() {
        return this.front == null || this.rear == null;
    }
}
