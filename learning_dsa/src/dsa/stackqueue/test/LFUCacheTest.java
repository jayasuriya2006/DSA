package dsa.stackqueue.test;

import dsa.stackqueue.main.LFUCache;

public class LFUCacheTest {
    public static void main(String[] args) {
        System.out.println("Test Case 1: Basic put/get");
        LFUCache lfu1 = new LFUCache(2);
        lfu1.put(1, 1);  // {1=1}
        lfu1.put(2, 2);  // {1=1, 2=2}
        System.out.println("Get 1: Expected 1, Actual: " + lfu1.get(1)); // 1 -> freq 2
        lfu1.put(3, 3);  // Evicts key 2 (least freq)
        System.out.println("Get 2: Expected -1, Actual: " + lfu1.get(2)); // -1
        System.out.println("Get 3: Expected 3, Actual: " + lfu1.get(3)); // 3

        System.out.println("\nTest Case 2: LFU eviction tie-breaker (LRU)");
        LFUCache lfu2 = new LFUCache(2);
        lfu2.put(1, 1); // {1=1}
        lfu2.put(2, 2); // {1=1, 2=2}
        lfu2.get(1);    // freq of 1 -> 2
        lfu2.get(2);    // freq of 2 -> 2
        lfu2.put(3, 3); // Both 1 and 2 have same freq, evict LRU: 1 < 2 => evict 1
        System.out.println("Get 1: Expected -1, Actual: " + lfu2.get(1)); // -1
        System.out.println("Get 2: Expected 2, Actual: " + lfu2.get(2)); // 2
        System.out.println("Get 3: Expected 3, Actual: " + lfu2.get(3)); // 3

        System.out.println("\nTest Case 3: Update value and frequency");
        LFUCache lfu3 = new LFUCache(2);
        lfu3.put(1, 10);
        lfu3.put(2, 20);
        lfu3.put(1, 15); // update value, should not evict
        System.out.println("Get 1: Expected 15, Actual: " + lfu3.get(1));
        System.out.println("Get 2: Expected 20, Actual: " + lfu3.get(2));

        System.out.println("\nTest Case 4: Capacity 0");
        LFUCache lfu4 = new LFUCache(0);
        lfu4.put(1, 100);
        System.out.println("Get 1: Expected -1, Actual: " + lfu4.get(1)); // Should be -1
    }

}
