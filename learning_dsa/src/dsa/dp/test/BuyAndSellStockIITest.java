package dsa.dp.test;

import dsa.dp.main.BuyAndSellStockII;

public class BuyAndSellStockIITest {
    public static void main(String[] args) {
        BuyAndSellStockII stockSolver = new BuyAndSellStockII();

        int[][] testCases = {
                {7, 1, 5, 3, 6, 4},            // Expected: 7 (buy @1 sell @5, buy @3 sell @6)
                {1, 2, 3, 4, 5},                // Expected: 4 (buy @1 sell @5)
                {7, 6, 4, 3, 1},                // Expected: 0 (no profitable transactions)
                {1},                            // Expected: 0 (single day)
                {},                             // Expected: 0 (empty input)
                {3, 2, 6, 5, 0, 3},             // Expected: 7 (buy @2 sell @6, buy @0 sell @3)
                {2, 1, 2, 1, 2, 1, 2},          // Expected: 3 (buy and sell multiple times with +1)
                {1, 7, 5, 3, 6, 4, 8},          // Expected: 13 (buy @1 sell @7, buy @3 sell @6, buy @4 sell @8)
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] prices = testCases[i];

            System.out.println("Test Case " + (i + 1) + ": " + arrayToString(prices));

            int result1 = stockSolver.getMaxProfitForMultipleTransaction_Recursion(prices);
            int result2 = stockSolver.getMaxProfitForMultipleTransaction_Memo(prices);
            int result3 = stockSolver.getMaxProfitForMultipleTransaction_Tabulation(prices);
            int result4 = stockSolver.getMaxProfitForMultipleTransaction_SpaceOptimized(prices);

            System.out.println("  Recursion:        " + result1);
            System.out.println("  Memoization:      " + result2);
            System.out.println("  Tabulation:       " + result3);
            System.out.println("  Space Optimized:  " + result4);
            System.out.println("-------------------------------------------");
        }
    }

    private static String arrayToString(int[] arr) {
        if (arr == null || arr.length == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int num : arr) {
            sb.append(num).append(", ");
        }
        sb.setLength(sb.length() - 2); // remove trailing comma
        sb.append("]");
        return sb.toString();
    }
}
