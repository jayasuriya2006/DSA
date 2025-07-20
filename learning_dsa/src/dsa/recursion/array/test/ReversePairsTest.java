package dsa.array.test;

import dsa.array.main.CountInversionsInAnArray;
import dsa.array.main.ReversePairs;

public class ReversePairsTest {
    /*
    Given an integer array nums. Return the number of reverse pairs in the array.
    An index pair (i, j) is called a reverse pair if:
    0 <= i < j < nums.length
    nums[i] > 2 * nums[j].

    Examples:
      Input: nums = [6, 4, 1, 2, 7]
      Output: 3
      Explanation: The reverse pairs are:
         (0, 2) : nums[0] = 6, nums[2] = 1, 6 > 2 * 1
         (0, 3) : nums[0] = 6, nums[3] = 2, 6 > 2 * 2
         (1, 2) : nums[1] = 4, nums[2] = 1, 4 > 2 * 1

      Input: nums = [5, 4, 4, 3, 3]
      Output: 0
      Explanation: No pairs satisfy both the conditons.
     */

    public static void main(String[] args) {

        int[] arr1 = {5, 4, 4, 3, 3};
        int[] arr2 = {5, 4, 4, 3, 3};
        int expected = 0;

        int actualResult_brut = ReversePairs.getReversePairsCount_Brut(arr1);
        int actualResult_optimal = ReversePairs.getReversePairsCount_Optimal(arr2);

        if (actualResult_brut == expected) {
            System.out.println("...........BRUT - TEST PASSED............");
        } else {
            System.out.println("...........BRUT - TEST FAILED............");
        }

        if (actualResult_optimal == expected) {
            System.out.println("...........OPTIMAL - TEST PASSED............");
        } else {
            System.out.println("...........OPTIMAL - TEST FAILED............");
        }

    }
}
