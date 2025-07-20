package dsa.linkedlist.main;

public class DoublyLinkedList {

    NodeDL<Integer> head;
    NodeDL<Integer> tail;
    int size;

    public void removeHead() {
        if (this.head == null) return;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
            this.size = 0;
            return;
        }
        NodeDL<Integer> temp = head.next;
        temp.prev = null;
        head.next = null;
        this.head = temp;
        this.size--;
    }

    public void removeTail() {
        if (this.head == null) return;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
            this.size = 0;
            return;
        }
        NodeDL<Integer> temp = tail.prev;
        temp.next = null;
        tail.prev = null;
        this.tail = temp;
        this.size--;
    }

    public void removeKthNode(int k) {
        if (this.head == null) return;
        if (k == 1) {
            removeHead();
            return;
        }

        int count = 0;
        NodeDL<Integer> temp = this.head;
        while (temp != null) {
            count++;
            if (count == k) {
                NodeDL<Integer> back = temp.prev;
                NodeDL<Integer> front = temp.next;
                if (back == null) {        //if head
                    removeHead();
                } else if (front == null) {     // if tail
                    removeTail();
                } else {                     //if middle
                    back.next = front;
                    front.prev = back;
                    temp.next = null;
                    temp.prev = null;
                    this.size--;
                }
            }
            temp = temp.next;
        }
    }

    public void removeNodeWithGivenVal(int val) {
        if (this.head == null) return;

        NodeDL<Integer> temp = this.head;
        while (temp != null) {
            if (temp.data == val) {
                NodeDL<Integer> back = temp.prev;
                NodeDL<Integer> front = temp.next;
                if (back == null) {        //if head
                    removeHead();
                } else if (front == null) {     // if tail
                    removeTail();
                } else {                     //if middle
                    back.next = front;
                    front.prev = back;
                    temp.next = null;
                    temp.prev = null;
                    this.size--;
                }
            }
            temp = temp.next;
        }
    }

    public void addElementAtFirst(int val) {
        NodeDL<Integer> temp = new NodeDL<>(val);
        if (this.head == null) {
            this.head = temp;
            this.tail = temp;
            this.size = 1;
            return;
        }
        temp.next = this.head;
        this.head.prev = temp;
        this.head = temp;
        this.size++;
    }

    public void addElementAtLast(int val) {

        if (this.head == null) {
            addElementAtFirst(val);
            return;
        }
        NodeDL<Integer> temp = new NodeDL<>(val);
        this.tail.next = temp;
        temp.prev = this.tail;
        this.tail = temp;
        this.size++;

    }

    public void addBeforeKthNode(int k, int val) {

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
        NodeDL<Integer> temp = this.head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == k) {
                NodeDL<Integer> newNode = new NodeDL<>(val);
                newNode.next = temp;
                newNode.prev = temp.prev;
                temp.prev.next = newNode;
                temp.prev = newNode;
                this.size++;
                break;
            }
            temp = temp.next;
        }

    }

    public void addBeforeGivenNode(int val, int newVal) {

        if (this.head == null) {
            return;
        }
        if (this.head.data == val) {
            addElementAtFirst(newVal);
            return;
        }

        NodeDL<Integer> temp = this.head;
        while (temp != null) {
            if (temp.data == val) {
                NodeDL<Integer> newNode = new NodeDL<>(newVal);
                newNode.next = temp;
                newNode.prev = temp.prev;
                temp.prev.next = newNode;
                temp.prev = newNode;
                this.size++;
                break;
            }
            temp = temp.next;
        }

    }

    // 1 - 2
    public void reverse(){
        if(this.head == null){
            return;
        }
        if(this.head == this.tail){   //only one node
            return;
        }
        NodeDL<Integer> prev = this.head;
        NodeDL<Integer> temp = this.head.next;
        while(temp != null){
            NodeDL<Integer> front = temp.next;
            temp.next = prev;
            prev.prev = temp;
            prev = temp;
            temp = front;
        }
        NodeDL<Integer> newHead = this.tail;
        this.tail = this.head;
        this.head = newHead;
        this.head.prev = null;
        this.tail.next = null;

    }

    public NodeDL<Integer> getHead() {
        return this.head;
    }

    public NodeDL<Integer> getTail() {
        return this.tail;
    }

    public int getSize() {
        return size;
    }
}
