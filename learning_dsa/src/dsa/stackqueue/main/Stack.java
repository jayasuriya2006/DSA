package dsa.stackqueue.main;

public interface Stack<T> {

    void push(T data);

    T top();

    T pop();

    int size();

    boolean isEmpty();

    boolean isFUll();
}
