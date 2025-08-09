package dsa.dp.test;

import java.util.ArrayList;
import java.util.*;

import static dsa.dp.main.LargestDivisibleSubset.getDivisibleSubset_OptimalWay;

public class LargestDivisibleSubsetTest {
    // Helper method to compare results and print pass/fail
    private static void runTest(int[] input, List<Integer> expected, int testNum) {
        List<Integer> result = getDivisibleSubset_OptimalWay(input);
        List<Integer> sortedResult = new ArrayList<>(result);
        List<Integer> sortedExpected = new ArrayList<>(expected);
        Collections.sort(sortedResult);
        Collections.sort(sortedExpected);

        if (sortedResult.equals(sortedExpected)) {
            System.out.println("Test " + testNum + " ✅ Passed: " + result);
        } else {
            System.out.println("Test " + testNum + " ❌ Failed");
            System.out.println("  Input:     " + Arrays.toString(input));
            System.out.println("  Expected:  " + expected);
            System.out.println("  Got:       " + result);
        }
    }

    public static void main(String[] args) {
        // Test 1
        runTest(new int[]{1, 2, 4, 8}, Arrays.asList(1, 2, 4, 8), 1);

        // Test 2
        runTest(new int[]{3, 5, 7, 11}, Arrays.asList(3), 2); // Any one-element subset is valid

        // Test 3
        runTest(new int[]{1, 2, 3, 6, 24}, Arrays.asList(1, 2, 6, 24), 3);

        // Test 4
        runTest(new int[]{10}, Arrays.asList(10), 4);

        // Test 5
        runTest(new int[]{1, 2, 2, 4, 8}, Arrays.asList(1, 2, 2, 4, 8), 5);

        // Test 6
        runTest(new int[]{1, 1, 1}, Arrays.asList(1, 1, 1), 6);

        // Test 7
        runTest(new int[]{}, new ArrayList<>(), 7);

        // Test 8
        runTest(new int[]{1, 3, 6, 24, 12, 36}, Arrays.asList(1, 3, 6, 12, 24), 8);

        // Test 9
        runTest(new int[]{2, 4, 8, 16, 32, 64}, Arrays.asList(2, 4, 8, 16, 32, 64), 9);
    }
}
