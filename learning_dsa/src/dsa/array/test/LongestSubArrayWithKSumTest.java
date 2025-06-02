package dsa.array.test;

import dsa.array.main.LongestSubArrayWithKSum;

public class LongestSubArrayWithKSumTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 7, 5};
        int target = 12;
        int expected = 3;

        int actualRes_Brut = LongestSubArrayWithKSum.getLongestLengthWithSumK_Brut(arr, target);
        int actualRes_Better = LongestSubArrayWithKSum.getLongestLengthWithSumK_Better(arr, target);

        //if array contains negatives this will fail. This will works for only positives
        int actualRes_Optimal = LongestSubArrayWithKSum.getLongestLengthWithSumK_Optimal(arr, target);

        if (actualRes_Brut == expected) {
            System.out.println(".......BRUT - TEST PASSED.......");
        } else {
            System.out.println(".......BRUT - TEST FAILED.......");
        }

        if (actualRes_Better == expected) {
            System.out.println(".......BETTER - TEST PASSED.......");
        } else {
            System.out.println(".......BETTER - TEST FAILED.......");
        }

        if (actualRes_Optimal == expected) {
            System.out.println(".......Optimal - TEST PASSED.......");
        } else {
            System.out.println(".......Optimal - TEST FAILED.......");
        }
    }
}
