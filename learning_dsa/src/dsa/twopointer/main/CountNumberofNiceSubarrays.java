package dsa.twopointer.main;
import java.util.HashMap;
import java.util.Map;

public class CountNumberofNiceSubarrays {

    // Function to count subarrays with exactly k odd numbers
    public static int burt(int nums[], int k) {
        int count = 0; // Total number of valid subarrays
        int sum = 0;   // This will count the number of odd numbers seen so far
        HashMap<Integer, Integer> map = new HashMap<>();

        // Base case: prefix sum 0 has occurred once
        map.put(0, 1);

        for (int num : nums) {
            // Convert the number to 1 if odd, else 0 (even)
            sum += num % 2;

            // Check if there's a prefix sum that makes (sum - k)
            // If yes, add its frequency to the count
            count += map.getOrDefault(sum - k, 0);

            // Record the current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count; // Return the total number of nice subarrays
    }
}

