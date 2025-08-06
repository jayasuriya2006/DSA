package dsa.dp.test;

import dsa.dp.main.LongestInCreasingSubSequence;

import java.util.Arrays;
import java.util.List;

public class LongestInCreasingSubSequenceTest {
    public static void main(String[] args) {
        // Define test inputs
        int[][] testCases = {
                {1},
                {10, 9, 2, 5, 3, 7, 101, 18},
                {3, 10, 2, 1, 20},
                {50, 3, 10, 7, 40, 80},
                {5, 4, 3, 2, 1}
        };

        // Expected LIS lengths for each test case
        int[] expectedLengths = {1, 4, 3, 4, 1};

        // Expected one valid LIS sequence for each non-empty test case
        List<List<Integer>> expectedSequences = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2, 5, 7, 101),
                Arrays.asList(3, 10, 20),
                Arrays.asList(3, 10, 40, 80),
                Arrays.asList(5)  // any single element is fine for a strictly decreasing array
        );

        // Run through all test cases
        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            int expLen = expectedLengths[i];
            List<Integer> expSeq = expectedSequences.get(i);

            // Test pure recursion
            int rec = LongestInCreasingSubSequence.lenOfLIS_Recursion(nums);
            printResult("Recursion", nums, rec, expLen);

            // Test memoized recursion
            int memo = LongestInCreasingSubSequence.lenOfLIS_Memo(nums);
            printResult("Memoization", nums, memo, expLen);

            // Test tabulation
            int tab = LongestInCreasingSubSequence.lenOfLIS_Tabulation(nums);
            printResult("Tabulation", nums, tab, expLen);

            // Test O(N^2) DP
            int optDP = LongestInCreasingSubSequence.lenOfLIS_OptimalWay(nums);
            printResult("Optimal DP", nums, optDP, expLen);

            // Test O(N log N) using binary search
            int optBS = LongestInCreasingSubSequence.lenOfLIS_OptimalWayBinarySearch(nums);
            printResult("BinarySearch DP", nums, optBS, expLen);

            // Test actual sequence reconstruction
            // Note: getLIS_OptimalWay returns a List<Integer>
            List<Integer> actualSeq = LongestInCreasingSubSequence.getLIS_OptimalWay(nums);
            boolean seqPass = actualSeq.equals(expSeq);
            System.out.printf(
                    "getLIS_OptimalWay: array=%s expected=%s actual=%s => %s%n",
                    Arrays.toString(nums),
                    expSeq,
                    actualSeq,
                    (seqPass ? "PASS" : "FAIL")
            );

            System.out.println("--------------------------------------------------");
        }
    }

    private static void printResult(String method, int[] arr, int actual, int expected) {
        System.out.printf(
                "%-16s array=%-30s expected=%2d actual=%2d => %s%n",
                method,
                Arrays.toString(arr),
                expected,
                actual,
                (actual == expected ? "PASS" : "FAIL")
        );
    }

}
