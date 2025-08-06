package dsa.dp.test;

import dsa.dp.main.ZeroOrOneKnapsack;

public class ZeroOrOneKnapsackTest {
    public static void main(String[] args) {
        int[] weights1 = {1, 2, 3};
        int[] values1 = {6, 10, 12};
        int capacity1 = 5;

        System.out.println("=== Test 1: Basic Case ===");
        System.out.println("Recursion: " + ZeroOrOneKnapsack.getMaxProfit_Recursion(weights1, values1, capacity1));
        System.out.println("Memoization: " + ZeroOrOneKnapsack.getMaxProfit_Memo(weights1, values1, capacity1));
        System.out.println("Tabulation: " + ZeroOrOneKnapsack.getMaxProfit_Tabulation(weights1, values1, capacity1));
        System.out.println("Space Optimized: " + ZeroOrOneKnapsack.getMaxProfit_SpaceOptimized(weights1, values1, capacity1));

        int[] weights2 = {2, 3, 4, 5};
        int[] values2 = {3, 4, 5, 6};
        int capacity2 = 5;

        System.out.println("\n=== Test 2: Medium Case ===");
        System.out.println("Expected: 7");
        System.out.println("Recursion: " + ZeroOrOneKnapsack.getMaxProfit_Recursion(weights2, values2, capacity2));
        System.out.println("Memoization: " + ZeroOrOneKnapsack.getMaxProfit_Memo(weights2, values2, capacity2));
        System.out.println("Tabulation: " + ZeroOrOneKnapsack.getMaxProfit_Tabulation(weights2, values2, capacity2));
        System.out.println("Space Optimized: " + ZeroOrOneKnapsack.getMaxProfit_SpaceOptimized(weights2, values2, capacity2));

        int[] weights3 = {1, 3, 4, 5};
        int[] values3 = {1, 4, 5, 7};
        int capacity3 = 7;

        System.out.println("\n=== Test 3: Larger Capacity ===");
        System.out.println("Expected: 9");
        System.out.println("Recursion: " + ZeroOrOneKnapsack.getMaxProfit_Recursion(weights3, values3, capacity3));
        System.out.println("Memoization: " + ZeroOrOneKnapsack.getMaxProfit_Memo(weights3, values3, capacity3));
        System.out.println("Tabulation: " + ZeroOrOneKnapsack.getMaxProfit_Tabulation(weights3, values3, capacity3));
        System.out.println("Space Optimized: " + ZeroOrOneKnapsack.getMaxProfit_SpaceOptimized(weights3, values3, capacity3));

        int[] weights4 = {5, 6, 7};
        int[] values4 = {10, 20, 30};
        int capacity4 = 4;

        System.out.println("\n=== Test 4: No Items Fit ===");
        System.out.println("Expected: 0");
        System.out.println("Recursion: " + ZeroOrOneKnapsack.getMaxProfit_Recursion(weights4, values4, capacity4));
        System.out.println("Memoization: " + ZeroOrOneKnapsack.getMaxProfit_Memo(weights4, values4, capacity4));
        System.out.println("Tabulation: " + ZeroOrOneKnapsack.getMaxProfit_Tabulation(weights4, values4, capacity4));
        System.out.println("Space Optimized: " + ZeroOrOneKnapsack.getMaxProfit_SpaceOptimized(weights4, values4, capacity4));
    }
}
