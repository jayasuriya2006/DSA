package dsa.dp.main;

import java.util.*;

public class LongestInCreasingSubSequence {

    //TC - O(2 ^ N)
    //SC - O(N)
    public static int lenOfLIS_Recursion(int[] numbers) {
        return lenOfLIS_Recursion(0, -1, numbers);
    }

    public static int lenOfLIS_Recursion(int ind, int prevInd, int[] numbers) {
        if (ind == numbers.length) {
            return 0;
        }

        int len_notTake = lenOfLIS_Recursion(ind + 1, prevInd, numbers);
        int len_take = 0;
        if (prevInd == -1 || numbers[prevInd] < numbers[ind]) {
            len_take = 1 + lenOfLIS_Recursion(ind + 1, ind, numbers);
        }
        return Math.max(len_take, len_notTake);
    }

    //TC - O(N * N)
    //SC - O(N * N) + O(N)
    public static int lenOfLIS_Memo(int[] numbers) {
        int n = numbers.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return lenOfLIS_Memo(0, -1, numbers, dp);
    }

    public static int lenOfLIS_Memo(int ind, int prevInd, int[] numbers, int[][] dp) {
        if (ind == numbers.length) {
            return 0;
        }
        if (dp[ind][prevInd + 1] != -1) return dp[ind][prevInd + 1];
        int len_notTake = lenOfLIS_Memo(ind + 1, prevInd, numbers, dp);
        int len_take = 0;
        if (prevInd == -1 || numbers[prevInd] < numbers[ind]) {
            len_take = 1 + lenOfLIS_Memo(ind + 1, ind, numbers, dp);
        }
        dp[ind][prevInd + 1] = Math.max(len_take, len_notTake);
        return dp[ind][prevInd + 1];
    }

    //TC - O(N * N)
    //SC - O(N * N)
    public static int lenOfLIS_Tabulation(int[] numbers) {
        int n = numbers.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prevInd = ind - 1; prevInd >= -1; prevInd--) {
                int len_notTake = dp[ind + 1][prevInd + 1];
                int len_take = 0;
                if (prevInd == -1 || numbers[prevInd] < numbers[ind]) {
                    len_take = 1 + dp[ind + 1][ind + 1];
                }
                dp[ind][prevInd + 1] = Math.max(len_take, len_notTake);
            }
        }
        return dp[0][0];
    }

    //TC - O(N * N)
    //SC - O(N * N)
    public static int lenOfLIS_OptimalWay(int[] numbers) {
        int n = numbers.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int lis = 1;
        for (int ind = 0; ind < n; ind++) {
            for (int prevInd = 0; prevInd < ind; prevInd++) {
                if (numbers[ind] > numbers[prevInd]) {
                    if (dp[ind] < dp[prevInd] + 1) {
                        dp[ind] = dp[prevInd] + 1;
                        lis = Math.max(lis, dp[ind]);
                    }
                }
            }

        }
        return lis;
    }

    //TC - O(N * N) + O(N)
    //SC - O(N * N)
    public static List<Integer> getLIS_OptimalWay(int[] numbers) {
        int n = numbers.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        int lis = 1;
        int lisEndInd = 0;
        for (int ind = 0; ind < n; ind++) {
            hash[ind] = ind;
            for (int prevInd = 0; prevInd < ind; prevInd++) {
                if (numbers[ind] > numbers[prevInd]) {
                    if (dp[ind] < dp[prevInd] + 1) {
                        dp[ind] = dp[prevInd] + 1;
                        hash[ind] = prevInd;
                        if (lis < dp[ind]) {
                            lis = dp[ind];
                            lisEndInd = ind;
                        }
                    }
                }
            }

        }
        List<Integer> lisList = new ArrayList<>();
        while (hash[lisEndInd] != lisEndInd) {
            lisList.add(numbers[lisEndInd]);
            lisEndInd = hash[lisEndInd];
        }
        lisList.add(numbers[lisEndInd]);
        Collections.reverse(lisList);
        return lisList;
    }

    //TC - O(N) * O(Log N)
    //SC - O(N)
    public static int lenOfLIS_OptimalWayBinarySearch(int[] numbers) {
        int n = numbers.length;
        List<Integer> lis = new ArrayList<>();
        lis.add(numbers[0]);
        int curSize = 1;
        for (int i = 1; i < n; i++) {
            if (numbers[i] > lis.get(curSize - 1)) {
                lis.add(numbers[i]);
                curSize++;
            } else {
                int index = Collections.binarySearch(lis, numbers[i]);
                if (index < 0) index = -index - 1;
                lis.set(index, numbers[i]);
            }
        }
        return curSize;
    }

}
