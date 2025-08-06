package dsa.dp.test;

import dsa.dp.main.MaxSumWithoutAdjacent;

public class MaxSumWithoutAdjacentTest {

    public static void main(String[] args) {
        int[][] testCases = {
                {},
                {5},
                {2, 1},
                {3, 2, 7, 10},
                {3, 2, 5, 10, 7},
                {5, 5, 10, 100, 10, 5},
                {1, 2, 3, 1},
                {20, 30, 50, 10, 5, 70, 10}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] arr = testCases[i];

            int memo = MaxSumWithoutAdjacent.getMaxSumWithoutAdjacentMemo(arr);
            int tab = MaxSumWithoutAdjacent.getMaxSumWithoutAdjacentTabulation(arr);
            int opt = MaxSumWithoutAdjacent.getMaxSumWithoutAdjacentSpaceOptimization(arr);

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input Array: " + arrayToString(arr));
            System.out.println("  Memoization       : " + memo);
            System.out.println("  Tabulation        : " + tab);
            System.out.println("  Space Optimized   : " + opt);
            System.out.println("  Match: " + (memo == tab && tab == opt));
            System.out.println("--------------------------------------------");
        }
        int[][] testCases1 = {
                {},
                {5},
                {5, 10},
                {5, 1, 1, 5},
                {2, 3, 2},
                {1, 2, 3, 1},
                {200, 3, 140, 20, 10},
                {1, 3, 1, 3, 100},
                {2, 7, 9, 3, 1}
        };

        int[] expected = {
                0,      // empty
                5,      // only one element
                10,     // pick max of two
                6,      // can't take both 5s (first & last)
                3,      // pick 3
                4,      // pick 2 + 1 (first 1 + last 1 are adjacent)
                340,    // pick 200 + 140
                103,     // pick 3 + 100 (can't pick first and last 1s)
                12
        };

        for (int i = 0; i < testCases1.length; i++) {
            int result = MaxSumWithoutAdjacent.getMaxSumWithoutAdjacentCircular(testCases1[i]);
            System.out.println("Test Case " + (i + 1));
            System.out.println("Input        : " + arrayToString(testCases1[i]));
            System.out.println("Expected     : " + expected[i]);
            System.out.println("Your Output  : " + result);
            System.out.println("Match        : " + (expected[i] == result));
            System.out.println("-----------------------------------------");
        }
    }


    private static String arrayToString(int[] arr) {
        if (arr.length == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

}
