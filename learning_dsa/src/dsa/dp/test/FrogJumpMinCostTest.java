package dsa.dp.test;

import dsa.dp.main.FrogJumpMinCost;

public class FrogJumpMinCostTest {
    public static void main(String[] args) {
        int[][] testCases = {
                {10},
                {10, 20},
                {10, 20, 10},
                {30, 10, 60, 10, 60, 50},
                {40, 30, 20, 10, 50, 70, 10},
                {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] cost = testCases[i];

            int memo = FrogJumpMinCost.getMinCostToReachEndMemo(cost);
            int tab = FrogJumpMinCost.getMinCostToReachEndTabulation(cost);
            int opt = FrogJumpMinCost.getMinCostToReachEndSpaceOptimization(cost);

            System.out.println("Test Case " + (i + 1));
            System.out.println("Cost Array: " + arrayToString(cost));
            System.out.println("  Memoization       : " + memo);
            System.out.println("  Tabulation        : " + tab);
            System.out.println("  Space Optimized   : " + opt);
            System.out.println("  Match: " + (memo == tab && tab == opt));
            System.out.println("--------------------------------------------");
        }

        int[] cost = {10, 30, 40, 50, 20};
        int k = 3;

        int result = FrogJumpMinCost.getMinCostToReachEndTabulationForKSteps(cost, k);
        System.out.println("Minimum cost to reach end with k = " + k + " steps: " + result);
    }

    private static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
