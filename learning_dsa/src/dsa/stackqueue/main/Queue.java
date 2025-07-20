package dsa.stackqueue.main;

public interface Queue<T> {

    void enqueue(T data);

    T dequeue();

    T peek();

    int size();

    boolean isFull();

    boolean isEmpty();
}
