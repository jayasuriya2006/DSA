package dsa.dp.main;

import java.util.Arrays;

public class BuyAndSellStockWithCoolDown {
    //TC - O(2 ^ N)
    //SC - O(N)
    public int getMaxProfitForMultipleTransactionWithCoolDown_Recursion(int[] prices) {
        return getMaxProfitForMultipleTransactionWithCoolDown_Recursion(0, 1, prices);        //canBuy 1 - buy allowed, 0 - not allowed
    }

    public int getMaxProfitForMultipleTransactionWithCoolDown_Recursion(int day, int canBuy, int[] prices) {
        if (day >= prices.length) {
            return 0;
        }

        int profit = 0;
        if (canBuy == 1) {
            profit = Math.max(
                    -prices[day] + getMaxProfitForMultipleTransactionWithCoolDown_Recursion(day + 1, 0, prices),   //decided to buy
                    getMaxProfitForMultipleTransactionWithCoolDown_Recursion(day + 1, 1, prices)                   //decided to not buy
            );
        } else {
            profit = Math.max(
                    prices[day] + getMaxProfitForMultipleTransactionWithCoolDown_Recursion(day + 2, 1, prices),
                    getMaxProfitForMultipleTransactionWithCoolDown_Recursion(day + 1, 0, prices)
            );

        }
        return profit;
    }

    //TC - O(N * 2)
    //SC - O(N * 2) + O(N)
    public int getMaxProfitForMultipleTransactionWithCoolDown_Memo(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getMaxProfitForMultipleTransactionWithCoolDown_Memo(0, 1, prices, dp);        //canBuy 1 - buy allowed, 0 - not allowed
    }

    public int getMaxProfitForMultipleTransactionWithCoolDown_Memo(int day, int canBuy, int[] prices, int[][] dp) {
        if (day >= prices.length) {
            return 0;
        }

        if (dp[day][canBuy] != -1) {
            return dp[day][canBuy];
        }
        int profit = 0;
        if (canBuy == 1) {
            profit = Math.max(
                    -prices[day] + getMaxProfitForMultipleTransactionWithCoolDown_Memo(day + 1, 0, prices, dp),   //decided to buy
                    getMaxProfitForMultipleTransactionWithCoolDown_Memo(day + 1, 1, prices, dp)                   //decided to not buy
            );
        } else {
            profit = Math.max(
                    prices[day] + getMaxProfitForMultipleTransactionWithCoolDown_Memo(day + 2, 1, prices, dp),
                    getMaxProfitForMultipleTransactionWithCoolDown_Memo(day + 1, 0, prices, dp)
            );

        }
        dp[day][canBuy] = profit;
        return profit;
    }

    //TC - O(N * 2)
    //SC - O(N * 2)
    public int getMaxProfitForMultipleTransactionWithCoolDown_Tabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];

        for (int day = n - 1; day >= 0; day--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                int profit = 0;
                if (canBuy == 1) {
                    profit = Math.max(
                            -prices[day] + dp[day + 1][0],   //decided to buy
                            dp[day + 1][1]                   //decided to not buy
                    );
                } else {
                    profit = Math.max(
                            prices[day] + dp[day + 2][1],
                            dp[day + 1][0]
                    );

                }
                dp[day][canBuy] = profit;
            }
        }
        return dp[0][1];
    }
}
