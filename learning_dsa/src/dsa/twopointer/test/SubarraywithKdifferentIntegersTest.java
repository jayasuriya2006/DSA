package dsa.twopointer.test;

import dsa.twopointer.main.SubarraywithKdifferentIntegers;

public class SubarraywithKdifferentIntegersTest {

    public static void main(String[] args) {
        /*
        Given an integer array nums and an integer k, return the number of good subarrays of nums.
        A good array is an array where the number of different integers in that array is exactly k.

       (*)For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
       A subarray is a contiguous part of an array.



      Example:
      Input: nums = [1,2,1,2,3], k = 2
      Output: 7
      Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
         */


        int[] nums1 = {1, 2, 1, 2, 3};
        int k1 = 2;
        System.out.println("Brute: " + SubarraywithKdifferentIntegers.burte(nums1, k1));   // Expected: 7
        System.out.println("Better: " + SubarraywithKdifferentIntegers.better(nums1, k1)); // Expected: 7

        int[] nums2 = {1, 2, 1, 3, 4};
        int k2 = 3;
        System.out.println("Brute: " + SubarraywithKdifferentIntegers.burte(nums2, k2));   // Expected: 6
        System.out.println("Better: " + SubarraywithKdifferentIntegers.better(nums2, k2)); // Expected: 6

        int[] nums3 = {1, 2, 1, 3, 4};
        int k3 = 2;
        System.out.println("Brute: " + SubarraywithKdifferentIntegers.burte(nums3, k3));   // Expected: 5
        System.out.println("Better: " + SubarraywithKdifferentIntegers.better(nums3, k3)); // Expected: 5

        int[] nums4 = {1, 2, 1, 2, 1};
        int k4 = 1;
        System.out.println("Brute: " + SubarraywithKdifferentIntegers.burte(nums4, k4));   // Expected: 5
        System.out.println("Better: " + SubarraywithKdifferentIntegers.better(nums4, k4)); // Expected: 5

        int[] nums5 = {1, 2, 1, 3, 4};
        int k5 = 4;
        System.out.println("Brute: " + SubarraywithKdifferentIntegers.burte(nums5, k5));   // Expected: 0
        System.out.println("Better: " + SubarraywithKdifferentIntegers.better(nums5, k5)); // Expected: 0
    }
}
