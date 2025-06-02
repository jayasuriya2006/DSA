package dsa.array.test;

import dsa.array.main.MaxSumSubArray;

public class MaxSumSubArray_Test {

    public static void main(String[] args) {
        //Input: nums = [2, 3, 5, -2, 7, -4]
        // Output: 15
        //Explanation: The subarray from index 0 to index 4 has the largest sum = 15

        int[] arr = {2, 3, 5, -2, 7, -4};
        int expected = 15;

        int res_brut = MaxSumSubArray.getMaxSubArraySum_Brut(arr);
        int res_better = MaxSumSubArray.getMaxSubArraySum_Better(arr);
        int res_optimal = MaxSumSubArray.getMaxSubArraySum_Optimal(arr);

        if (expected == res_brut) {
            System.out.println("..........BRUT - TEST PASSED.........");
        } else {
            System.out.println("..........BRUT - TEST FAILED.........");
        }
        if (expected == res_better) {
            System.out.println("..........BETTER - TEST PASSED.........");
        } else {
            System.out.println("..........BETTER - TEST FAILED.........");
        }
        if (expected == res_optimal) {
            System.out.println("..........OPTIMAL - TEST PASSED.........");
        } else {
            System.out.println("..........OPTIMAL - TEST FAILED.........");
        }
    }
}
