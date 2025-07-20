package dsa.array.test;

import dsa.array.main.CountSubarraysSumEqualsK;

public class CountSubarraysSumEqualsKTest {

    /*
    Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

    Input: nums = [1, 1, 1], k = 2
    Output: 2
    Explanation: In the given array [1, 1, 1], there are two subarrays that sum up to 2: [1, 1] and [1, 1]. Hence, the output is 2.

    Input: nums = [1, 2, 3], k = 3
    Output: 2
    Explanation: In the given array [1, 2, 3], there are two subarrays that sum up to 3: [1, 2] and [3]. Hence, the output is 2.
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int k = 3;
        int expected = 8;

        int output_brut = CountSubarraysSumEqualsK.getTheSubArrayCountWithSumAsK_Brut(nums, k);
        int output_better = CountSubarraysSumEqualsK.getTheSubArrayCountWithSumAsK_Better(nums, k);
        int output_optimal = CountSubarraysSumEqualsK.getTheSubArrayCountWithSumAsK_Optimal(nums, k);

        if (output_brut == expected) {
            System.out.println(".......BRUT - TEST PASSED.........");
        } else {
            System.out.println(".......BRUT - TEST FAILED.........");
        }
        if (output_better == expected) {
            System.out.println(".......BETTER - TEST PASSED.........");
        } else {
            System.out.println(".......BETTER - TEST FAILED.........");
        }
        if (output_optimal == expected) {
            System.out.println(".......OPTIMAL - TEST PASSED.........");
        } else {
            System.out.println(".......OPTIMAL - TEST FAILED.........");
        }

    }
}
