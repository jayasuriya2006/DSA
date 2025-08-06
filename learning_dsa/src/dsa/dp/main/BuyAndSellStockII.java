package dsa.dp.main;

import java.util.Arrays;

public class BuyAndSellStockII {

    //TC - O(2 ^ N)
    //SC - O(N)
    public int getMaxProfitForMultipleTransaction_Recursion(int[] prices) {
        return getMaxProfitForMultipleTransaction_Recursion(0, 1, prices);        //canBuy 1 - buy allowed, 0 - not allowed
    }

    public int getMaxProfitForMultipleTransaction_Recursion(int day, int canBuy, int[] prices) {
        if (day == prices.length) {
            return 0;
        }

        int profit = 0;
        if (canBuy == 1) {
            profit = Math.max(
                    -prices[day] + getMaxProfitForMultipleTransaction_Recursion(day + 1, 0, prices),   //decided to buy
                    getMaxProfitForMultipleTransaction_Recursion(day + 1, 1, prices)                   //decided to not buy
            );
        } else {
            profit = Math.max(
                    prices[day] + getMaxProfitForMultipleTransaction_Recursion(day + 1, 1, prices),
                    getMaxProfitForMultipleTransaction_Recursion(day + 1, 0, prices)
            );

        }
        return profit;
    }

    //TC - O(N * 2)
    //SC - O(N * 2) + O(N)
    public int getMaxProfitForMultipleTransaction_Memo(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return getMaxProfitForMultipleTransaction_Memo(0, 1, prices, dp);        //canBuy 1 - buy allowed, 0 - not allowed
    }

    public int getMaxProfitForMultipleTransaction_Memo(int day, int canBuy, int[] prices, int[][] dp) {
        if (day == prices.length) {
            return 0;
        }

        if (dp[day][canBuy] != -1) {
            return dp[day][canBuy];
        }
        int profit = 0;
        if (canBuy == 1) {
            profit = Math.max(
                    -prices[day] + getMaxProfitForMultipleTransaction_Memo(day + 1, 0, prices, dp),   //decided to buy
                    getMaxProfitForMultipleTransaction_Memo(day + 1, 1, prices, dp)                   //decided to not buy
            );
        } else {
            profit = Math.max(
                    prices[day] + getMaxProfitForMultipleTransaction_Memo(day + 1, 1, prices, dp),
                    getMaxProfitForMultipleTransaction_Memo(day + 1, 0, prices, dp)
            );

        }
        dp[day][canBuy] = profit;
        return profit;
    }

    //TC - O(N * 2)
    //SC - O(N * 2)
    public int getMaxProfitForMultipleTransaction_Tabulation(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

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
                            prices[day] + dp[day + 1][1],
                            dp[day + 1][0]
                    );

                }
                dp[day][canBuy] = profit;
            }
        }
        return dp[0][1];
    }

    //TC - O(N * 2)
    //SC - O(2)
    public int getMaxProfitForMultipleTransaction_SpaceOptimized(int[] prices) {
        int n = prices.length;

        int aheadBuy = 0;     // dp[day + 1][1] — when we can buy
        int aheadNotBuy = 0;  // dp[day + 1][0] — when we have stock (can sell)

        for (int day = n - 1; day >= 0; day--) {
            int currBuy = Math.max(-prices[day] + aheadNotBuy, aheadBuy);
            int currNotBuy = Math.max(prices[day] + aheadBuy, aheadNotBuy);

            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }

        return aheadBuy;  // starting at day 0, canBuy = 1
    }
}
