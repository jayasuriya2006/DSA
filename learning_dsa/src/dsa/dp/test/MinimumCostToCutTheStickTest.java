package dsa.dp.test;

import dsa.dp.main.MinimumCostToCutTheStick;

import java.util.Arrays;

public class MinimumCostToCutTheStickTest {
    public static void main(String[] args) {
        runTest(7, new int[]{1, 3, 4, 5}, 16);
        runTest(9, new int[]{5, 6, 1, 4, 2}, 22);
        runTest(10, new int[]{2, 4, 7}, 20);
        runTest(100, new int[]{25, 50, 75}, 200);
        runTest(10, new int[]{}, 0); // No cuts
        runTest(1, new int[]{}, 0); // Minimal input
        runTest(20, new int[]{3, 8, 15}, 40);
        runTest(30, new int[]{1, 2, 3, 4, 5}, 42); // Frequent small cuts
        runTest(10, new int[]{5}, 10); // Single cut
    }

    private static void runTest(int n, int[] cuts, int expected) {
        System.out.println("Stick Length: " + n + ", Cuts: " + Arrays.toString(cuts));

        int recResult = MinimumCostToCutTheStick.getMinCostToCutTheStick_Recursion(n, cuts);
        System.out.println("Recursion Result     : " + recResult);

        int memoResult = MinimumCostToCutTheStick.getMinCostToCutTheStick_Memorization(n, cuts);
        System.out.println("Memoization Result   : " + memoResult);

        int tabResult = MinimumCostToCutTheStick.getMinCostToCutTheStick_Tabulation(n, cuts);
        System.out.println("Tabulation Result    : " + tabResult);

        System.out.println("Expected Result      : " + expected);
        boolean passed = (recResult == expected) && (memoResult == expected) && (tabResult == expected);
        System.out.println(passed ? "✅ Test Passed" : "❌ Test Failed");
        System.out.println("--------------------------------------------------");
    }
}
