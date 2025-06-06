package dsa.twopointer.main;

import java.util.HashMap;
import java.util.Map;

public class SubarraywithKdifferentIntegers {

    // Brute-force approach: Count subarrays with exactly k different integers
    public static int burte(int[] nums, int k) {
        int count = 0;
        int n = nums.length;

        // Iterate over all possible subarray start points
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();

            // Extend the subarray from i to j
            for (int j = i; j < n; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

                int distinct = map.size(); // Get number of distinct elements so far

                if (distinct == k) count++;     // If exactly k distinct, count this subarray
                else if (distinct > k) break;   // Stop if more than k distinct elements
            }
        }

        return count;
    }

    // Optimized approach: Subarrays with exactly K distinct = atMost(K) - atMost(K - 1)
    public static int better(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    // Helper method to count subarrays with at most K distinct elements
    private static int atMostK(int[] nums, int k) {
        int l = 0, r = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < nums.length) {
            // Add current element to the map
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            // Shrink window if we have more than k distinct elements
            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++; // Move left pointer forward
            }

            // Add the number of subarrays ending at r
            count += r - l + 1;
            r++; // Move right pointer forward
        }

        return count;
    }
}
