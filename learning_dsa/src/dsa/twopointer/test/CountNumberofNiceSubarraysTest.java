package dsa.twopointer.test;

import dsa.twopointer.main.CountNumberofNiceSubarrays;

public class CountNumberofNiceSubarraysTest {
    /*
    Given an array of integers nums and an integer k. A continuous subarray is called nice if
    there are k odd numbers on it.    Return the number of nice sub-arrays.


    Example
    Input: nums = [1,1,2,1,1], k = 3
    Output: 2
    Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
     */
    public static void main(String[] args) {
//        int []nums = {2, 4, 6, 8};
//        int k = 1;
//        Expected Output: 0

//        int []nums = {1, 3, 5};
//        int k = 1;
////        Expected Output: 3
//

//        int []nums = {2, 4, 1, 6};
//        int k = 0:
////        Expected Output: 3
//

//       int[] nums = {2, 2, 1, 2, 2, 1, 2, 2, 1};
//       int k = 1:
////        Expected Output: 15
//

        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
//        Expected Output: 2

        System.out.println(CountNumberofNiceSubarrays.burt(nums, k));
    }


}
