package dsa.dp.main;

public class BuyAndSellStockIV {
    //TC - Exponential
    //SC - O(N)
    public static int getMaxProfitOfKTransaction_Recursion(int[] prices, int k) {
        return getMaxProfitOfKTransaction_Recursion(0, 1, k, prices);
    }

    public static int getMaxProfitOfKTransaction_Recursion(int day, int canBuy, int maxT, int[] prices) {
        if (day == prices.length) {
            return 0;
        }
        if (maxT == 0) {
            return 0;
        }

        int profit = 0;
        if (canBuy == 1) {
            profit = Math.max(
                    -prices[day] + getMaxProfitOfKTransaction_Recursion(day + 1, 0, maxT, prices),
                    getMaxProfitOfKTransaction_Recursion(day + 1, 1, maxT, prices)
            );
        } else {
            profit = Math.max(
                    prices[day] + getMaxProfitOfKTransaction_Recursion(day + 1, 1, maxT - 1, prices),
                    getMaxProfitOfKTransaction_Recursion(day + 1, 0, maxT, prices)
            );
        }
        return profit;
    }

    //TC - O( N * 2 * K)
    //SC - O( N * 2 * K) + O(N)
    public static int getMaxProfitOfKTransaction_Memo(int[] prices, int k) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int z = 0; z <= k; z++) {
                    dp[i][j][z] = -1;
                }
            }
        }
        return getMaxProfitOfKTransaction_Memo(0, 1, k, prices, dp);
    }

    public static int getMaxProfitOfKTransaction_Memo(int day, int canBuy, int maxT, int[] prices, int[][][] dp) {
        if (day == prices.length) {
            return 0;
        }
        if (maxT == 0) {
            return 0;
        }

        if (dp[day][canBuy][maxT] != -1) return dp[day][canBuy][maxT];

        int profit = 0;
        if (canBuy == 1) {
            profit = Math.max(
                    -prices[day] + getMaxProfitOfKTransaction_Memo(day + 1, 0, maxT, prices, dp),
                    getMaxProfitOfKTransaction_Memo(day + 1, 1, maxT, prices, dp)
            );
        } else {
            profit = Math.max(
                    prices[day] + getMaxProfitOfKTransaction_Memo(day + 1, 1, maxT - 1, prices, dp),
                    getMaxProfitOfKTransaction_Memo(day + 1, 0, maxT, prices, dp)
            );
        }
        dp[day][canBuy][maxT] = profit;
        return profit;
    }

    //TC - O( N * 2 * K)
    //SC - O( N * 2 * K)
    public static int getMaxProfitOfKTransaction_Tabulation(int[] prices, int k) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k + 1];
        for (int day = n - 1; day >= 0; day--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int maxT = 1; maxT <= k; maxT++) {
                    int profit = 0;
                    if (canBuy == 1) {
                        profit = Math.max(
                                -prices[day] + dp[day + 1][0][maxT],
                                dp[day + 1][1][maxT]
                        );
                    } else {
                        profit = Math.max(
                                prices[day] + dp[day + 1][1][maxT - 1],
                                dp[day + 1][0][maxT]
                        );
                    }
                    dp[day][canBuy][maxT] = profit;
                }
            }
        }
        return dp[0][1][k];
    }

    //TC - O( N * 2 * K)
    //SC - O( 2 * K)
    public static int getMaxProfitOfKTransaction_SpaceOptimized(int[] prices, int k) {
        int n = prices.length;
        int[][] lastDay = new int[2][k + 1];
        for (int day = n - 1; day >= 0; day--) {
            int[][] curDay = new int[2][ k + 1];
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int maxT = 1; maxT <= k; maxT++) {
                    int profit = 0;
                    if (canBuy == 1) {
                        profit = Math.max(
                                -prices[day] + lastDay[0][maxT],
                                lastDay[1][maxT]
                        );
                    } else {
                        profit = Math.max(
                                prices[day] + lastDay[1][maxT - 1],
                                lastDay[0][maxT]
                        );
                    }
                    curDay[canBuy][maxT] = profit;
                }
            }
            lastDay = curDay;
        }
        return lastDay[1][k];
    }
}
