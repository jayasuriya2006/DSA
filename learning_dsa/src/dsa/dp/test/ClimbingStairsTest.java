package dsa.dp.test;

import dsa.dp.main.ClimbingStairs;

public class ClimbingStairsTest {
    public static void main(String[] args) {
        int[] testCases = {1, 2, 3, 5, 10, 20, 30};

        for (int n : testCases) {
            int memo = ClimbingStairs.getTotalWaysClimMemo(n);
            int tab = ClimbingStairs.getTotalWaysClimTabulation(n);
            int opt = ClimbingStairs.getTotalWaysClimSpaceOptimized(n);

            System.out.println("n = " + n);
            System.out.println("  Memoization       : " + memo);
            System.out.println("  Tabulation        : " + tab);
            System.out.println("  Space Optimized   : " + opt);
            System.out.println("  Match: " + (memo == tab && tab == opt));
            System.out.println("---------------------------------------");
        }
    }
}
