package dsa.bitmanupulations.main;

import java.util.Arrays;

/**
 * This class finds the element that appears exactly once in an array where
 * every other element appears exactly three times.
 *
 * Approach (Better - Sorting Based):
 * 1. Sort the array
 * 2. Traverse in chunks of 3. The first element in a chunk will differ
 *    from the next if it's the unique one.
 * 3. If all triplets are fine, the unique element must be the last one.
 *
 * Time Complexity: O(n log n) due to sorting
 * Space Complexity: O(1) extra space
 */
public class SingleNumberII {

    /**
     * Returns the number that appears only once.
     * All other numbers appear exactly three times.
     *
     * @param arr Input array
     * @return The unique element
     *
     * Example:
     * Input: [5, 5, 5, 2, 3, 3, 3]
     * Sorted: [2, 3, 3, 3, 5, 5, 5]
     * Check:
     *   i = 1 → arr[0] = 2, arr[1] = 3 ⇒ 2 is the unique one.
     * Output: 2
     */
    public static int getSingleNumber(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr); // Sorting ensures that triplets are grouped together

        // Traverse the sorted array in steps of 3
        for (int i = 1; i < n; i = i + 3) {
            // If a triplet breaks, the previous number is the unique one
            if (arr[i - 1] != arr[i]) {
                return arr[i - 1];
            }
        }

        // If no mismatches found, the unique number is the last element
        return arr[n - 1];
    }
}
