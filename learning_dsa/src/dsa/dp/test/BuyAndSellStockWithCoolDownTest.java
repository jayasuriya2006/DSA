package dsa.dp.test;

import dsa.dp.main.BuyAndSellStockWithCoolDown;

public class BuyAndSellStockWithCoolDownTest {
    public static void main(String[] args) {
        BuyAndSellStockWithCoolDown solver = new BuyAndSellStockWithCoolDown();

        runTest(solver, new int[]{1, 2, 3, 0, 2}, 3); // Expected 3
        runTest(solver, new int[]{1}, 0);             // Only one day, no transaction
        runTest(solver, new int[]{2, 1, 2, 1, 2}, 1);  // Small peaks
        runTest(solver, new int[]{1, 2, 4}, 3);        // Buy on day 0, sell on 2
        runTest(solver, new int[]{6, 1, 3, 2, 4, 7}, 6); // Multiple peaks
        runTest(solver, new int[]{1, 2, 3, 0, 2, 1, 4}, 5); // With cooldown logic
        runTest(solver, new int[]{7, 6, 4, 3, 1}, 0);   // Prices only drop
    }

    private static void runTest(BuyAndSellStockWithCoolDown solver, int[] prices, int expected) {
        System.out.println("Prices: " + arrayToString(prices));

        int result1 = solver.getMaxProfitForMultipleTransactionWithCoolDown_Recursion(prices);
        int result2 = solver.getMaxProfitForMultipleTransactionWithCoolDown_Memo(prices);
        int result3 = solver.getMaxProfitForMultipleTransactionWithCoolDown_Tabulation(prices);

        System.out.println("Expected:           " + expected);
        System.out.println("Recursive:          " + result1);
        System.out.println("Memoization:        " + result2);
        System.out.println("Tabulation:         " + result3);
        System.out.println("--------------------------------------");
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
