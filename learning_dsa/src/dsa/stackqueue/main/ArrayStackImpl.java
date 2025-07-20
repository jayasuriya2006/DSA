package dsa.stackqueue.main;

public class ArrayStackImpl<T> implements Stack<T> {

    private int size;
    private int top;
    private int capacity;
    private T[] stackElements;

    public ArrayStackImpl(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.size = 0;

        @SuppressWarnings("unchecked")
        T[] tempArray = (T[]) new Object[capacity];
        this.stackElements = tempArray;
    }

    //TC - O(1)
    @Override
    public void push(T data) {
        if (isFUll()) {
            System.out.println(">>>>>> Stack is FULL >>>>>>");
            return;
        }
        this.top++;
        stackElements[this.top] = data;
        this.size++;
    }

    //TC - O(1)
    @Override
    public T top() {
        if (isEmpty()) {
            System.out.println(">>>>>> Stack is EMPTY >>>>>>");
            return null;
        }
        return stackElements[this.top];
    }

    //TC - O(1)
    @Override
    public T pop() {
        if (isEmpty()) {
            System.out.println(">>>>>> Stack is EMPTY >>>>>>");
            return null;
        }
        T temp = stackElements[this.top];
        this.top--;
        this.size--;
        return temp;
    }

    //TC - O(1)
    @Override
    public int size() {
        return this.size;
    }

    //TC - O(1)
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    //TC - O(1)
    @Override
    public boolean isFUll() {
        return this.size == capacity;
    }
}
