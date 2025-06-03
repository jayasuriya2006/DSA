package dsa.twopointer.test;

import dsa.twopointer.main.MaxConsecutiveOnes;

public class MaxConsecutiveOnesTest {
//    Given a binary array nums and an integer k, flip at most k 0's.
//    Return the maximum number of consecutive 1's after performing the flipping operation.


    public static void main(String[] args) {
//       int[] nums={1,1,1,0,0,0,1,1,1,1,0};
//       int k = 2;
//       Expected Output:6

//        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
//        int k = 2;
//        Expected Output:6


        int[] nums = {0, 0, 1, 1, 1, 0, 0};
        int k = 0;
//        Expected Output:3


        System.out.println(MaxConsecutiveOnes.brute(nums, k));
        System.out.println(MaxConsecutiveOnes.optimal(nums, k));
    }
}
