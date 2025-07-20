package dsa.stackqueue.main;

import java.util.HashMap;
import java.util.Map;

class DLNode {

    int key;
    int val;
    int freq;
    DLNode prev;
    DLNode next;

    public DLNode(int k, int v) {
        this.key = k;
        this.val = v;
        this.freq = 1;
    }

}

class DLList {
    DLNode head;
    DLNode tail;
    int curSize;

    public DLList() {
        this.head = new DLNode(0, 0);
        this.tail = new DLNode(0, 0);
        this.curSize = 0;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void add(DLNode node) {
        node.next = this.head.next;
        node.next.prev = node;
        node.prev = this.head;
        this.head.next = node;
        this.curSize++;
    }

    public void remove(DLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        this.curSize--;
    }
}

public class LFUCache {

    int capacity;
    int curSize;
    Map<Integer, DLNode> cache;
    Map<Integer, DLList> freqList;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.cache = new HashMap<>();
        this.freqList = new HashMap<>();
        this.minFreq = 0;

    }

    public int get(int key) {
        DLNode node = cache.get(key);
        if (node == null) return -1;
        updateNode(node);
        return node.val;

    }

    public void put(int key, int value) {
        if (this.capacity == 0) return;
        if (this.cache.containsKey(key)) {
            DLNode node = this.cache.get(key);
            node.val = value;
            updateNode(node);
        } else {
            this.curSize++;
            if (this.curSize > this.capacity) {
                DLList curList = this.freqList.get(this.minFreq);
                this.cache.remove(curList.tail.prev.key);
                curList.remove(curList.tail.prev);
                curSize--;
            }
            DLNode newNode = new DLNode(key, value);
            this.minFreq = 1;
            DLList freList_1 = this.freqList.getOrDefault(1, new DLList());
            freList_1.add(newNode);
            this.freqList.put(1, freList_1);
            this.cache.put(key, newNode);

        }

    }

    private void updateNode(DLNode node) {
        int freq = node.freq;
        DLList curList = this.freqList.get(freq);
        this.cache.remove(node.key);
        curList.remove(node);

        if (freq == this.minFreq && curList.curSize == 0) {
            this.minFreq++;
        }
        node.freq++;
        DLList uList = this.freqList.getOrDefault(node.freq, new DLList());
        uList.add(node);
        this.cache.put(node.key, node);
        this.freqList.put(node.freq, uList);

    }
}
