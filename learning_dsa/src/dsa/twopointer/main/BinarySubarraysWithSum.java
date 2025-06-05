package dsa.twopointer.main;
import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    public static int optimal(int[] nums, int goal) {
        int count = 0; // Total number of subarrays with sum equal to goal
        int sum = 0;   // Current prefix sum
        HashMap<Integer, Integer> map = new HashMap<>(); // To store frequency of prefix sums

        map.put(0, 1); // Base case: prefix sum 0 occurs once

        for (int num : nums) {
            sum += num; // Update the current prefix sum

            // Check how many times (sum - goal) has occurred before.
            // If it has, that many subarrays end at current index with sum = goal
            count += map.getOrDefault(sum - goal, 0);

            // Record this prefix sum in the map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count; // Return total count of subarrays with sum equal to goal
    }
}
