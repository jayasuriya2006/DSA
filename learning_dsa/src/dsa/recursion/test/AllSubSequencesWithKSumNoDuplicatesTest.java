package dsa.recursion.test;

import java.util.*;

public class AllSubSequencesWithKSumNoDuplicatesTest {


    /**
     * Test for All SubSequences with K Sum (no duplicates by value)
     * Input: [1, 2, 3, 4, 5, 1], k = 5
     * Valid subsequences: [1, 4], [2, 3], [5]
     * Even if two 1s exist, [1, 4] should appear only once
     */
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 1};
        List<List<Integer>> rawActualAns = dsa.recursion.main.AllSubSequencesWithKSumNoDuplicates.getAllSubSeqWithKSumNoDuplicates(input, 5);
        System.out.println("Actual: " + rawActualAns);
    }
}


