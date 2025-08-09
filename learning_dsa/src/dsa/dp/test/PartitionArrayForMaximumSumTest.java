package dsa.dp.test;

import dsa.dp.main.PartitionArrayForMaximumSum;

public class PartitionArrayForMaximumSumTest {
    public static void main(String[] args) {
        test(new int[]{1, 15, 7, 9, 2, 5, 10}, 3, 84);
        test(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4, 83);
        test(new int[]{1}, 1, 1);
        test(new int[]{10, 9, 8, 7}, 2, 36);
        test(new int[]{1, 2, 3, 4, 5}, 2, 17);
        test(new int[]{5, 4, 3, 2, 1}, 3, 19);
        test(new int[]{1, 1, 1, 1, 1}, 2, 5);
        test(new int[]{10, 20, 30}, 1, 60);
        test(new int[]{1, 15, 7, 9, 2, 5, 10}, 1, 49);
        test(new int[]{100, 1, 100, 1, 100}, 2, 500);
    }

    private static void test(int[] arr, int k, int expected) {
        int resultMemo = PartitionArrayForMaximumSum.maxSumAfterPartitioning(arr, k);
        int resultTab = PartitionArrayForMaximumSum.maxSumAfterPartitioning_Tabulation(arr, k);
        boolean passMemo = resultMemo == expected;
        boolean passTab = resultTab == expected;

        System.out.println("Test case:");
        System.out.print("Array: ");
        for (int num : arr) System.out.print(num + " ");
        System.out.println("\nk = " + k);
        System.out.println("Expected: " + expected);
        System.out.println("Memoization result: " + resultMemo + " -> " + (passMemo ? "✅ PASS" : "❌ FAIL"));
        System.out.println("Tabulation result:  " + resultTab + " -> " + (passTab ? "✅ PASS" : "❌ FAIL"));
        System.out.println("--------------------------------------");
    }
}
