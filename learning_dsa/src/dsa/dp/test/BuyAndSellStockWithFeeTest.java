package dsa.dp.test;

import dsa.dp.main.BuyAndSellStockWithFee;

public class BuyAndSellStockWithFeeTest {
    public static void main(String[] args) {
        BuyAndSellStockWithFee solver = new BuyAndSellStockWithFee();

        runTest(solver, new int[]{1, 3, 2, 8, 4, 9}, 2, 8);
        runTest(solver, new int[]{1, 3, 7, 5, 10, 3}, 3, 6);
        runTest(solver, new int[]{1, 2, 3, 4, 5}, 1, 3);
        runTest(solver, new int[]{5, 4, 3, 2, 1}, 2, 0); // decreasing prices
        runTest(solver, new int[]{1}, 2, 0); // one day
        runTest(solver, new int[]{1, 3}, 1, 1); // one transaction with fee
        runTest(solver, new int[]{2, 1, 4, 5, 2, 9, 7}, 2, 7); // multiple buy/sell opportunities
        runTest(solver, new int[]{1, 5, 3, 8, 4, 9}, 1, 11); // smaller fee

    }

    private static void runTest(BuyAndSellStockWithFee solver, int[] prices, int fee, int expected) {
        System.out.println("Prices: " + arrayToString(prices) + ", Fee: " + fee);

        int result1 = solver.getMaxProfitForMultipleTransactionWithFee_Recursion(prices, fee);
        int result2 = solver.getMaxProfitForMultipleTransactionWithFee_Memo(prices, fee);
        int result3 = solver.getMaxProfitForMultipleTransactionWithFee_Tabulation(prices, fee);
        int result4 = solver.getMaxProfitForMultipleTransactionWithFee_SpaceOptimized(prices, fee);

        System.out.println("Expected:           " + expected);
        System.out.println("Recursive:          " + result1);
        System.out.println("Memoization:        " + result2);
        System.out.println("Tabulation:         " + result3);
        System.out.println("Space Optimized:    " + result4);
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
