package dsa.linkedlist.main;

/*
  Node for Doubly Linked List
 */
public class NodeDL<T> {

    public T data;
    public NodeDL<T> next;
    public NodeDL<T> prev;

    NodeDL(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    NodeDL(T data, NodeDL<T> next, NodeDL<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }


}
