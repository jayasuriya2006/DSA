package dsa.linkedlist.main;


public class SinglyLinkedList {
    NodeSL<Integer> head;      //first node
    NodeSL<Integer> tail;      //last node
    int size;

    SinglyLinkedList(){
        this.tail = null;
        this.head = null;
        this.size = 0;
    }

    public void removeHead() {
        if (this.head == null) return;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
            this.size = 0;
            return;
        }
        NodeSL<Integer> temp = head;
        this.head = head.next;
        temp.next = null;
        this.size--;
    }

    public void removeTail() {
        if (head == null) return;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
            this.size = 0;
            return;
        }
        NodeSL<Integer> temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        this.tail = temp;
        this.size--;
    }

    public void addElementAtLast(int data) {
        if (head == null) {
            addElementAtFirst(data);
            return;
        }
        NodeSL<Integer> newNode = new NodeSL<>(data);
        this.tail.next = newNode;
        this.tail = newNode;
        this.size++;
    }

    public void addElementAtFirst(int data) {
        if (this.head == null) {
            NodeSL<Integer> newNode = new NodeSL<>(data);
            this.head = newNode;
            this.tail = newNode;
            this.size++;
            return;
        }
        NodeSL<Integer> newNode = new NodeSL<>(data);
        newNode.next = head;
        this.head = newNode;
        this.size++;
    }

    public void removeKthNode(int k) {
        if (this.head == null) return;

        if (k == 1) {
            removeHead();
            return;
        }

        NodeSL<Integer> temp = this.head;
        NodeSL<Integer> prev = null;
        int count = 0;

        while (temp != null) {
            count++;
            if (count == k) {
                prev.next = temp.next;
                temp.next = null;
                this.size--;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        if (prev.next == null) {
            this.tail = prev;
        }
    }

    public void removeNodeWithVal(int val) {
        if (this.head == null) return;

        if (this.head.data == val) {
            removeHead();
            return;
        }

        NodeSL<Integer> temp = this.head;
        NodeSL<Integer> prev = null;

        while (temp != null) {
            if (temp.data == val) {
                prev.next = temp.next;
                temp.next = null;
                this.size--;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        if (prev.next == null) {
            this.tail = prev;
        }
    }


    public void addBeforeKthNode(int val, int k) {
        if (this.head == null) {
            if (k == 1) {
                addElementAtFirst(val);
                return;
            }
        }
        if (k == 1) {
            addElementAtFirst(val);
            return;
        }
        int count = 0;
        NodeSL<Integer> temp = head;
        while (temp != null) {
            count++;
            if (count == k - 1) {
                NodeSL<Integer> newNode = new NodeSL<>(val);
                newNode.next = temp.next;
                temp.next = newNode;
                this.size++;
                break;
            }
            temp = temp.next;
        }

    }

    public void addBeforeGivenVal(int val, int newVal) {
        if (this.head == null) {
            return;
        }
        if (this.head.data == val) {
            addElementAtFirst(newVal);
            return;
        }
        NodeSL<Integer> temp = this.head;
        while (temp.next != null) {
            if (temp.next.data == val) {
                NodeSL<Integer> newNode = new NodeSL<>(newVal);
                newNode.next = temp.next;
                temp.next = newNode;
                this.size++;
                break;
            }
            temp = temp.next;
        }
    }

    public void reverse(){
        if(this.head == null){
            return;
        }
        NodeSL<Integer> prev = null;
        NodeSL<Integer> temp = this.head;
        while(temp != null){
            NodeSL<Integer> front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        this.tail = this.head;
        this.head = prev;
    }

    public NodeSL<Integer> getHead(){
        return this.head;
    }
    public NodeSL<Integer> getTail(){
        return this.tail;
    }

    public int getSize(){
        return this.size;
    }

}
