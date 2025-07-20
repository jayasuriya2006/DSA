package dsa.array.test;

import dsa.array.main.LeadersInAnArray;

import java.util.Arrays;
import java.util.List;

public class LeadersInAnArrayTest {
    public static void main(String[] args) {

        /*
        * Input: nums = [1, 2, 5, 3, 1, 2]
          Output: [5, 3, 2]
          Explanation: 2 is the rightmost element, 3 is the largest element in the index range [3, 5], 5 is the largest element in the index range [2, 5]
        * */
        int[] nums = {1, 2, 5, 3, 1, 2};
        List<Integer> expected = List.of(5, 3, 2);

        List<Integer> output_brut = LeadersInAnArray.getLeaders_Brut(nums);
        List<Integer> output_optimal = LeadersInAnArray.getLeaders_Optimal(nums);

        if (output_brut.equals(expected)) {
            System.out.println("....... BRUT - TEST PASSED..........");
        } else {
            System.out.println("....... BRUT - TEST FAILED..........");
        }

        if (output_optimal.equals(expected)) {
            System.out.println("....... OPTIMAL - TEST PASSED..........");
        } else {
            System.out.println("....... OPTIMAL - TEST FAILED..........");
        }
    }
}
