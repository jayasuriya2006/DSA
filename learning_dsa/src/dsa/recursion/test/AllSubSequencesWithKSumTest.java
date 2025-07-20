package dsa.recursion.test;

import java.util.ArrayList;
import java.util.List;

public class AllSubSequencesWithKSumTest {

    /**
     * Test for All SubSequences with K Sum
     * This test checks if the function correctly generates all subsequences of a given array that sum to a specific value.
     * <p>
     * Example: [1, 2, 3, 4, 5]    k = 5
     * All Subsequences: [ [1, 4], [2, 3], [5] ]
     */

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        List<List<Integer>> expectedAns = new ArrayList<>();
        //expectedAns.add(new ArrayList<>()); // empty subsequence
        expectedAns.add(List.of(1, 4));
        expectedAns.add(List.of(2, 3));
        expectedAns.add(List.of(5));

        List<List<Integer>> actualAns = dsa.recursion.main.AllSubSequencesWithKSum.getAllSubSequencesWithSumK(input, 5);
        if (actualAns.size() == expectedAns.size() && actualAns.containsAll(expectedAns)) {
            System.out.println("..........TEST PASSED.............");
        } else {
            System.out.println("..........TEST FAILED.............");
            System.out.println("Expected: " + expectedAns);
            System.out.println("Actual: " + actualAns);
        }
    }

}
