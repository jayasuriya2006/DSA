package dsa.stackqueue.test;

import dsa.stackqueue.main.LRUCache;

public class LRUCacheTest {
    public static void main(String[] args) {
        System.out.println("Test Case 1: Basic put/get");
        LRUCache cache1 = new LRUCache(2);
        cache1.put(1, 1);
        cache1.put(2, 2);
        System.out.println("Get 1: Expected 1, Actual: " + cache1.get(1)); // 1

        System.out.println("\nTest Case 2: Eviction");
        cache1.put(3, 3); // Evicts key 2
        System.out.println("Get 2: Expected -1, Actual: " + cache1.get(2)); // -1

        System.out.println("\nTest Case 3: Recent use update");
        cache1.put(4, 4); // Evicts key 1
        System.out.println("Get 1: Expected -1, Actual: " + cache1.get(1)); // -1
        System.out.println("Get 3: Expected 3, Actual: " + cache1.get(3)); // 3
        System.out.println("Get 4: Expected 4, Actual: " + cache1.get(4)); // 4

        System.out.println("\nTest Case 4: Update existing key");
        cache1.put(4, 40); // Update key 4
        System.out.println("Get 4: Expected 40, Actual: " + cache1.get(4)); // 40

        System.out.println("\nTest Case 5: Access makes key most recently used");
        cache1.put(5, 5); // Evicts key 3 (least recently used)
        System.out.println("Get 3: Expected -1, Actual: " + cache1.get(3)); // -1
        System.out.println("Get 4: Expected 40, Actual: " + cache1.get(4)); // 40
        System.out.println("Get 5: Expected 5, Actual: " + cache1.get(5)); // 5
    }
}
