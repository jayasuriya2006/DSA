package dsa.bitmanupulations.main;

import java.util.ArrayList;
import java.util.List;

import static dsa.bitmanupulations.main.BitwiseUtils.isIthBitSet;

/**
 * This class generates all possible subsequences (also called the power set) of a given integer array
 * using bit manipulation.
 */
public class PowerSet {

    /**
     * Generates all subsequences of the given array using bitwise operations.
     *
     * @param arr Input array for which to generate the power set
     * @return A list of lists, where each list is a possible subsequence of the input array
     *
     * Example:
     * Input: arr = {1, 2}
     * Binary representation for subsequences (n = 2 -> 2^2 = 4 total subsets):
     * i = 0 -> 00 -> []               (no elements picked)
     * i = 1 -> 01 -> [1]              (only first element picked)
     * i = 2 -> 10 -> [2]              (only second element picked)
     * i = 3 -> 11 -> [1, 2]           (both elements picked)
     * Output: [[], [1], [2], [1, 2]]
     */
    public static List<List<Integer>> getAllSubSequences(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        // There are 2^n possible subsequences for an array of length n
        int resultSize = 1 << n;  // Same as (int) Math.pow(2, n)

        // Iterate over all numbers from 0 to 2^n - 1
        for (int i = 0; i < resultSize; i++) {
            List<Integer> curSubSeq = new ArrayList<>();

            // Check each bit position (0 to n - 1)
            for (int j = 0; j < n; j++) {
                // If j-th bit is set in i, include arr[j] in the current subsequence
                if (isIthBitSet(i, j)) {
                    curSubSeq.add(arr[j]);
                }
            }

            // Add the current subsequence to the result list
            result.add(curSubSeq);
        }

        return result;
    }
}
