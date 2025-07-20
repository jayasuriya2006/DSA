package dsa.recursion.test;

import dsa.recursion.main.AllSubSeqWithKSumInfinite;

import java.util.ArrayList;
import java.util.List;

public class AllSubSeqWithKSumInfiniteTest {

    /**
     * Test for AllSubSeqWithKSumInfinite
     * Example: [1, 2, 3, 4, 5]    k = 5
     * Possible infinite subsequences: [1,1,1,1,1], [1,1,1,2], [1,4], [2,3], [5], etc.
     * This test checks a few valid sequences.
     */

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int target = 5;

        List<List<Integer>> actualAns = AllSubSeqWithKSumInfinite.getSubSeqWithKSum(input, target);

        // Choose a few expected subsequences for validation
        List<List<Integer>> expectedSubsets = new ArrayList<>();
        expectedSubsets.add(List.of(1, 4));
        expectedSubsets.add(List.of(2, 3));
        expectedSubsets.add(List.of(5));
        expectedSubsets.add(List.of(1, 1, 1, 2));
        expectedSubsets.add(List.of(1, 1, 1, 1, 1)); // example of infinite use

        boolean passed = true;
        for (List<Integer> expected : expectedSubsets) {
            if (!actualAns.contains(expected)) {
                passed = false;
                System.out.println("Missing expected subsequence: " + expected);
            }
        }

        if (passed) {
            System.out.println("..........TEST PASSED.............");
        } else {
            System.out.println("..........TEST FAILED.............");
            System.out.println("Actual: " + actualAns);
        }
    }
}
