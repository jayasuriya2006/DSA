package dsa.linkedlist.main;
/*
  Node for Singly Linked List
 */
public class NodeSL<T> {
    public T data;
    public NodeSL<T> next;

    public NodeSL(T data){
        this.data = data;
        this.next = null;
    }

    NodeSL(T data, NodeSL<T> nextNode){
        this.data = data;
        this.next = nextNode;
    }
}
