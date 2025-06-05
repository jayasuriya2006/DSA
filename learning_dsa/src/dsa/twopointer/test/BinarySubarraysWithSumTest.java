package dsa.twopointer.test;

import dsa.twopointer.main.BinarySubarraysWithSum;

public class BinarySubarraysWithSumTest {
/*
    Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
    A subarray is a contiguous part of the array.

Example 1:
Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]

*/
    public static void main(String[] argu) {

//        int[] nums = {1, 0, 1};
//        int goal = 5;
////      Expected Output: 0

//
//        int[] nums = {1, 0, 1};
//        int goal = 2;
////      Expected Output: 2
//
//        int[] nums = {1, 1, 1, 1};
//        int goal = 4;
////      Output: 1

//
//        int[] nums = {0, 0, 1, 0, 0};
//        int goal = 0;
////      Output: 6



        int nums[] = {1, 0, 1, 0, 1};
        int goal = 0;
//        output:2
        System.out.println(BinarySubarraysWithSum.optimal(nums, goal));
    }
}
