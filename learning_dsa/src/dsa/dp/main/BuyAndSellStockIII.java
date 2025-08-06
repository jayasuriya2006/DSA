package dsa.dp.main;

public class BuyAndSellStockIII {

    //TC - Exponential
    //SC - O(N)
    public static int getMaxProfitOfTwoTransaction_Recursion(int[] prices) {
        return getMaxProfitOfTwoTransaction_Recursion(0, 1, 2, prices);
    }

    public static int getMaxProfitOfTwoTransaction_Recursion(int day, int canBuy, int maxT, int[] prices) {
        if (day == prices.length) {
            return 0;
        }
        if (maxT == 0) {
            return 0;
        }

        int profit = 0;
        if (canBuy == 1) {
            profit = Math.max(
                    -prices[day] + getMaxProfitOfTwoTransaction_Recursion(day + 1, 0, maxT, prices),
                    getMaxProfitOfTwoTransaction_Recursion(day + 1, 1, maxT, prices)
            );
        } else {
            profit = Math.max(
                    prices[day] + getMaxProfitOfTwoTransaction_Recursion(day + 1, 1, maxT - 1, prices),
                    getMaxProfitOfTwoTransaction_Recursion(day + 1, 0, maxT, prices)
            );
        }
        return profit;
    }

    //TC - O( N * 2 * 2)
    //SC - O( N * 2 * 2) + O(N)
    public static int getMaxProfitOfTwoTransaction_Memo(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int z = 0; z < 3; z++) {
                    dp[i][j][z] = -1;
                }
            }
        }
        return getMaxProfitOfTwoTransaction_Memo(0, 1, 2, prices, dp);
    }

    public static int getMaxProfitOfTwoTransaction_Memo(int day, int canBuy, int maxT, int[] prices, int[][][] dp) {
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
                    -prices[day] + getMaxProfitOfTwoTransaction_Memo(day + 1, 0, maxT, prices, dp),
                    getMaxProfitOfTwoTransaction_Memo(day + 1, 1, maxT, prices, dp)
            );
        } else {
            profit = Math.max(
                    prices[day] + getMaxProfitOfTwoTransaction_Memo(day + 1, 1, maxT - 1, prices, dp),
                    getMaxProfitOfTwoTransaction_Memo(day + 1, 0, maxT, prices, dp)
            );
        }
        dp[day][canBuy][maxT] = profit;
        return profit;
    }

    //TC - O( N * 2 * 2)
    //SC - O( N * 2 * 3)
    public static int getMaxProfitOfTwoTransaction_Tabulation(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        for (int day = n - 1; day >= 0; day--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int maxT = 1; maxT <= 2; maxT++) {
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
        return dp[0][1][2];
    }

    //TC - O( N * 2 * 2)
    //SC - O( 2 * 3)
    public static int getMaxProfitOfTwoTransaction_SpaceOptimized(int[] prices) {
        int n = prices.length;
        int[][] lastDay = new int[2][3];
        for (int day = n - 1; day >= 0; day--) {
            int[][] curDay = new int[2][3];
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int maxT = 1; maxT <= 2; maxT++) {
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
        return lastDay[1][2];
    }
}
