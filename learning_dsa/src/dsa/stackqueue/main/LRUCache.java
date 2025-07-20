package dsa.stackqueue.main;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, NodeDLLRU> cache;
    NodeDLLRU head;
    NodeDLLRU tail;
    int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.head = new NodeDLLRU(-1, -1);
        this.tail = new NodeDLLRU(-1, -1);
        this.capacity = capacity;

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (!this.cache.containsKey(key)) {
            return -1;
        }
        NodeDLLRU curNode = this.cache.get(key);
        deleteNode(curNode);
        insertAfterHead(curNode);
        return curNode.val;

    }

    public void put(int key, int val) {
        if (this.cache.containsKey(key)) {
            NodeDLLRU curNode = this.cache.get(key);
            curNode.val = val;
            deleteNode(curNode);
            insertAfterHead(curNode);
        } else {
            NodeDLLRU newNode = new NodeDLLRU(key, val);
            if (this.cache.size() == this.capacity) {
                NodeDLLRU temp = this.tail.prev;
                deleteNode(temp);
                this.cache.remove(temp.val);
            }
            insertAfterHead(newNode);
            this.cache.put(key, newNode);
        }
    }

    private void deleteNode(NodeDLLRU node) {
        NodeDLLRU prevNode = node.prev;
        NodeDLLRU nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insertAfterHead(NodeDLLRU node) {
        NodeDLLRU curHeadNext = this.head.next;
        this.head.next = node;
        node.next = curHeadNext;
        node.prev = this.head;
        curHeadNext.prev = node;
    }

}

class NodeDLLRU {
    NodeDLLRU prev;
    NodeDLLRU next;
    int key;
    int val;

    NodeDLLRU(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
