package dsa.array.test;

import dsa.array.main.LongestConsecutiveSequence;

public class LongestConsecutiveSequenceTest {
    /*
    * Input: nums = [100, 4, 200, 1, 3, 2]
      Output: 4
      Explanation: The longest sequence of consecutive elements in the array is [1, 2, 3, 4], which has a length of 4.
      This sequence can be formed regardless of the initial order of the elements in the array.
      *
      *
      Input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
      Output: 9
      Explanation: The longest sequence of consecutive elements in the array is [0, 1, 2, 3, 4, 5, 6, 7, 8], which has a length of 9.
    * */

    public static void main(String[] args) {
        int[] arr_brut = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] arr_better = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] arr_optimal = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int expected = 9;

        int longConsSeq_Brut = LongestConsecutiveSequence.getLongestConsecutiveSequence_Brut(arr_brut);
        int longConsSeq_Better = LongestConsecutiveSequence.getLongestConsecutiveSequence_Better(arr_better);
        int longConsSeq_Optimal = LongestConsecutiveSequence.getLongestConsecutiveSequence_Optimal(arr_optimal);

        if (expected == longConsSeq_Brut) {
            System.out.println(".........BRUT - TEST PASSED.......");
        } else {
            System.out.println(".........BRUT - TEST FAILED.......");
        }
        if (expected == longConsSeq_Better) {
            System.out.println(".........BETTER - TEST PASSED.......");
        } else {
            System.out.println(".........BETTER - TEST FAILED.......");
        }
        if (expected == longConsSeq_Optimal) {
            System.out.println(".........OPTIMAL - TEST PASSED.......");
        } else {
            System.out.println(".........OPTIMAL - TEST FAILED.......");
        }

    }
}
