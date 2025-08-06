package dsa.dp.test;

import dsa.dp.main.CountSubsetsWithSumK;

public class CountSubsetsWithSumKTest {

    public static void main(String[] args) {
        CountSubsetsWithSumK solver = new CountSubsetsWithSumK();

        System.out.println("=== Test 1: Simple Input ===");
        int[] arr1 = {1, 2, 3};
        int k1 = 3;
        System.out.println("Recursion: " + solver.countSubsetWithSumAsK_Recursion(arr1, k1));         // 2 ([1,2], [3])
        System.out.println("Memoization: " + solver.countSubsetWithSumAsK_Memo(arr1, k1));           // 2
        System.out.println("Tabulation: " + solver.countSubsetWithSumAsK_Tabulation(arr1, k1));      // 2
        System.out.println("Space Optimized: " + solver.countSubsetWithSumAsK_SpaceOptimized(arr1, k1)); // 2

        System.out.println("\n=== Test 2: Array with Zero ===");
        int[] arr2 = {0, 0, 1};
        int k2 = 1;
        System.out.println("Recursion: " + solver.countSubsetWithSumAsK_Recursion(arr2, k2));         // 4
        System.out.println("Memoization: " + solver.countSubsetWithSumAsK_Memo(arr2, k2));           // 4
        System.out.println("Tabulation: " + solver.countSubsetWithSumAsK_Tabulation(arr2, k2));      // 4
        System.out.println("Space Optimized: " + solver.countSubsetWithSumAsK_SpaceOptimized(arr2, k2)); // 4

        System.out.println("\n=== Test 3: Edge Case - All Zeros ===");
        int[] arr3 = {0, 0, 0};
        int k3 = 0;
        System.out.println("Recursion: " + solver.countSubsetWithSumAsK_Recursion(arr3, k3));         // 8 (2^3 subsets)
        System.out.println("Memoization: " + solver.countSubsetWithSumAsK_Memo(arr3, k3));           // 8
        System.out.println("Tabulation: " + solver.countSubsetWithSumAsK_Tabulation(arr3, k3));      // 8
        System.out.println("Space Optimized: " + solver.countSubsetWithSumAsK_SpaceOptimized(arr3, k3)); // 8

        System.out.println("\n=== Test 4: No Valid Subsets ===");
        int[] arr4 = {5, 6, 7};
        int k4 = 3;
        System.out.println("Recursion: " + solver.countSubsetWithSumAsK_Recursion(arr4, k4));         // 0
        System.out.println("Memoization: " + solver.countSubsetWithSumAsK_Memo(arr4, k4));           // 0
        System.out.println("Tabulation: " + solver.countSubsetWithSumAsK_Tabulation(arr4, k4));      // 0
        System.out.println("Space Optimized: " + solver.countSubsetWithSumAsK_SpaceOptimized(arr4, k4)); // 0
    }


}
