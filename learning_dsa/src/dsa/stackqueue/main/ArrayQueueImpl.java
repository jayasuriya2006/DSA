package dsa.stackqueue.main;

public class ArrayQueueImpl<T> implements Queue<T> {

    int size;
    int front;              //front pointer
    int rear;               //last pointer
    int capacity;
    T[] queueElements;


    public ArrayQueueImpl(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.front = -1;
        this.rear = -1;

        @SuppressWarnings("unchecked")
        T[] tempArray = (T[]) new Object[capacity];
        this.queueElements = tempArray;

    }

    //TC - O(1)
    @Override
    public void enqueue(T data) {
        if (isFull()) {
            System.out.println(">>>>>>> Queue is FULL >>>>>>>>");
            return;
        }
        if (this.rear == -1 && this.front == -1) {
            this.rear = 0;
            this.front = 0;
            this.queueElements[this.rear] = data;
            this.size++;
            return;
        }
        this.rear = (this.rear + 1) % this.capacity;        //circular queue
        this.queueElements[this.rear] = data;
        this.size++;
    }

    //TC - O(1)
    @Override
    public T dequeue() {
        if (isEmpty()) {
            System.out.println(">>>>>>> Queue is EMPTY >>>>>>>>");
            return null;
        }
        if (this.rear == this.front) {
            T temp = this.queueElements[this.front];
            this.rear = -1;
            this.front = -1;
            this.size = 0;
            return temp;
        }
        T temp = this.queueElements[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        return temp;
    }

    //TC - O(1)
    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println(">>>>>>> Queue is EMPTY >>>>>>>>");
            return null;
        }
        return this.queueElements[this.front];
    }

    //TC - O(1)
    @Override
    public int size() {
        return this.size;
    }

    //TC - O(1)
    @Override
    public boolean isFull() {
        return this.size == this.capacity;
    }

    //TC - O(1)
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
