package dsa.array.test;

import dsa.array.main.MaximumProductSubarray;

public class MaximumProductSubarrayTest {
    /*

    Given an integer array nums. Find the subarray with the largest product, and return the product of the elements present in that subarray.
    A subarray is a contiguous non-empty sequence of elements within an array.

   Examples:
   Input: nums = [4, 5, 3, 7, 1, 2]
   Output: 840
   Explanation: The largest product is given by the whole array itself

   Input: nums = [-5, 0, -2]
   Output: 0
   Explanation: The largest product is achieved with the following subarrays [0], [-5, 0], [0, -2], [-5, 0, -2].
     */

    public static void main(String[] args) {
        int[] arr = {-5, 0, -2};
        long expected = 0;

        long res_brut = MaximumProductSubarray.getMaxSubArrayProduct_Brut(arr);
        long res_better = MaximumProductSubarray.getMaxSubArrayProduct_Better(arr);
        long res_optimal = MaximumProductSubarray.getMaxSubArrayProduct_Optimal(arr);

        if (res_brut == expected) {
            System.out.println(".......... BRUT - TEST PASSED.........");
        } else {
            System.out.println(".......... BRUT - TEST FAILED.........");
        }
        if (res_better == expected) {
            System.out.println(".......... BETTER - TEST PASSED.........");
        } else {
            System.out.println(".......... BETTER - TEST FAILED.........");
        }
        if (res_optimal == expected) {
            System.out.println(".......... OPTIMAL - TEST PASSED.........");
        } else {
            System.out.println(".......... OPTIMAL - TEST FAILED.........");
        }
    }
}
