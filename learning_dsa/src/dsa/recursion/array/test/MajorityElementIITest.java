package dsa.array.test;

import dsa.array.main.MajorityElementII;

import java.util.List;

public class MajorityElementIITest {

    /*
     Given an integer array nums of size n.
     Return all elements which appear more than n/3 times in the array. The output can be returned in any order.

     Input: nums = [1, 2, 1, 1, 3, 2, 2]
     Output: [1, 2]
     Explanation: Here, n / 3 = 7 / 3 = 2.
                  Therefore the elements appearing 3 or more times is : [1, 2]
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1, 3, 2};
        List<Integer> expected = List.of(1);

        List<Integer> output_brut = MajorityElementII.getMajorityElement_Brut(nums);
        List<Integer> output_better = MajorityElementII.getMajorityElement_Better(nums);
        List<Integer> output_optimal = MajorityElementII.getMajorityElement_Optimal(nums);

        if (output_brut.equals(expected)) {
            System.out.println("......... BRUT - TEST PASSED.............");
        } else {
            System.out.println("......... BRUT - TEST FAILED.............");
        }
        if (output_better.equals(expected)) {
            System.out.println("......... BETTER - TEST PASSED.............");
        } else {
            System.out.println("......... BETTER - TEST FAILED.............");
        }
        if (output_optimal.equals(expected)) {
            System.out.println("......... OPTIMAL - TEST PASSED.............");
        } else {
            System.out.println("......... OPTIMAL - TEST FAILED.............");
        }
    }
}
