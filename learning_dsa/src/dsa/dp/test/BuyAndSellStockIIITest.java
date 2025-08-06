package dsa.dp.test;

import dsa.dp.main.BuyAndSellStockIII;

public class BuyAndSellStockIIITest {
    public static void main(String[] args) {
        int[][] testCases = {
                {3, 3, 5, 0, 0, 3, 1, 4},     // Expected: 6
                {1, 2, 3, 4, 5},               // Expected: 4
                {7, 6, 4, 3, 1},               // Expected: 0
                {1, 2, 4, 2, 5, 7, 2, 4, 9, 0},// Expected: 13
                {2, 1, 2, 0, 1}                // Expected: 2
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] prices = testCases[i];
            System.out.println("Test Case " + (i + 1) + ":");
            System.out.println("Prices: " + arrayToString(prices));

            int result1 = BuyAndSellStockIII.getMaxProfitOfTwoTransaction_Recursion(prices);
            int result2 = BuyAndSellStockIII.getMaxProfitOfTwoTransaction_Memo(prices);
            int result3 = BuyAndSellStockIII.getMaxProfitOfTwoTransaction_Tabulation(prices);
            int result4 = BuyAndSellStockIII.getMaxProfitOfTwoTransaction_SpaceOptimized(prices);

            System.out.println("Recursive:          " + result1);
            System.out.println("Memoization:        " + result2);
            System.out.println("Tabulation:         " + result3);
            System.out.println("Space Optimized:    " + result4);
            System.out.println("-----------------------------");
        }
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
