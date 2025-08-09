package dsa.dp.test;

import dsa.dp.main.MatrixChainMultiplication;

public class MatrixChainMultiplicationTest {
    public static void main(String[] args) {
        // Basic test cases
        runTest(new int[]{40, 20, 30, 10, 30}, 26000);
        runTest(new int[]{10, 20, 30, 40, 30}, 30000);
        runTest(new int[]{10, 20, 30}, 6000);
        runTest(new int[]{10, 100, 5}, 5000);
        runTest(new int[]{20, 20, 20, 20}, 16000);

        // Edge case: only two matrices
        runTest(new int[]{5, 10, 3}, 150);

        // Edge case: all ones
        runTest(new int[]{1, 1, 1, 1}, 2);

        // Edge case: large values but few matrices
        runTest(new int[]{1000, 1000, 1000}, 1000000000);

        // Increasing sizes
        runTest(new int[]{5, 10, 20, 40, 80}, 21000);
        runTest(new int[]{80, 40, 20, 10, 5}, 21000);

        // Random case
        runTest(new int[]{30, 35, 15, 5, 10, 20, 25}, 15125);
    }

    private static void runTest(int[] dimensions, int expected) {
        System.out.println("Testing dimensions: " + arrayToString(dimensions));

        int recResult = MatrixChainMultiplication.getMinNoOfOperationForMCM_Recursion(dimensions);
        System.out.println("Recursion Result     : " + recResult);

        int memoResult = MatrixChainMultiplication.getMinNoOfOperationForMCM_Memo(dimensions);
        System.out.println("Memoization Result   : " + memoResult);

        int tabResult = MatrixChainMultiplication.getMinNoOfOperationForMCM_Tabulation(dimensions);
        System.out.println("Tabulation Result    : " + tabResult);

        System.out.println("Expected Result      : " + expected);
        boolean passed = (recResult == expected) && (memoResult == expected) && (tabResult == expected);
        System.out.println(passed ? "✅ Test Passed" : "❌ Test Failed");
        System.out.println("--------------------------------------------------");
    }

    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
