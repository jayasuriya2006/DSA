package dsa.recursion.test;

import java.util.ArrayList;
import java.util.List;

public class AllSubSequencesTest {
    /**
     * Test for All SubSequences
     * This test checks if the function correctly generates all subsequences of a given string.
     */
     /* * Example: [1, 2, 3, 4]
     All Subsequences: [[1, 2, 3, 4], [1, 2, 3], [1, 2, 4], [1, 2], [1, 3, 4], [1, 3], [1, 4], [1], [2, 3, 4], [2, 3], [2, 4], [2], [3, 4], [3], [4], []]
      */
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        List<List<Integer>> expectedAns = new ArrayList<>();
        expectedAns.add(new ArrayList<>()); // empty subsequence
        expectedAns.add(List.of(1));
        expectedAns.add(List.of(2));
        expectedAns.add(List.of(3));
        expectedAns.add(List.of(4));
        expectedAns.add(List.of(1, 2));
        expectedAns.add(List.of(1, 3));
        expectedAns.add(List.of(1, 4));
        expectedAns.add(List.of(2, 3));
        expectedAns.add(List.of(2, 4));
        expectedAns.add(List.of(3, 4));
        expectedAns.add(List.of(1, 2, 3));
        expectedAns.add(List.of(2, 3, 4));
        expectedAns.add(List.of(1, 2, 3, 4));
        expectedAns.add(List.of(1, 2, 4));
        expectedAns.add(List.of(1, 3, 4));


        List<List<Integer>> actualAns = dsa.recursion.main.AllSubSequences.getAllSubSequences(input);

        if (actualAns.size() == expectedAns.size() && actualAns.containsAll(expectedAns)) {
            System.out.println("..........TEST PASSED.............");
        } else {
            System.out.println("..........TEST FAILED.............");
            System.out.println("Expected: " + expectedAns);
            System.out.println("Actual: " + actualAns);
        }


    }
}
