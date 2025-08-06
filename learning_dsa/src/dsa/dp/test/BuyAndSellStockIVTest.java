package dsa.dp.test;

import dsa.dp.main.BuyAndSellStockIV;

public class BuyAndSellStockIVTest {
    public static void main(String[] args) {
        runTest(new int[]{2, 4, 1}, 2, 2); // Best: Buy at 2, sell at 4 => profit = 2
        runTest(new int[]{3, 2, 6, 5, 0, 3}, 2, 7); // Two best transactions
        runTest(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}, 3, 15); // More allowed transactions
        runTest(new int[]{1, 2, 3, 4, 5}, 1, 4); // Single increasing trend
        runTest(new int[]{7, 6, 4, 3, 1}, 3, 0); // No profit
        runTest(new int[]{2, 1, 2, 0, 1}, 2, 2); // Small profit with multiple chances
        runTest(new int[]{5, 11, 3, 50, 60, 90}, 2, 93); // High peak
        runTest(new int[]{3, 2, 6, 5, 0, 3}, 0, 0); // k=0, no transactions allowed
        runTest(new int[]{1}, 1, 0); // Only one price, no transaction possible
    }

    private static void runTest(int[] prices, int k, int expected) {
        System.out.println("Prices: " + arrayToString(prices) + " | k = " + k);
        int result1 = BuyAndSellStockIV.getMaxProfitOfKTransaction_Recursion(prices, k);
        int result2 = BuyAndSellStockIV.getMaxProfitOfKTransaction_Memo(prices, k);
        int result3 = BuyAndSellStockIV.getMaxProfitOfKTransaction_Tabulation(prices, k);
        int result4 = BuyAndSellStockIV.getMaxProfitOfKTransaction_SpaceOptimized(prices, k);

        System.out.println("Expected:           " + expected);
        System.out.println("Recursive:          " + result1);
        System.out.println("Memoization:        " + result2);
        System.out.println("Tabulation:         " + result3);
        System.out.println("Space Optimized:    " + result4);
        System.out.println("-----------------------------");
    }

    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
