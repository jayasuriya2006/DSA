package dsa.trie.test;

import dsa.trie.main.MaxXORQueries;

import java.util.Arrays;

public class MaxXORQueriesTest {

    public static void main(String[] args) {
        MaxXORQueries solution = new MaxXORQueries();

        int[] arr = {0, 1, 2, 3, 4};

        int[][] queries = {
                {5, 6},    // max(5^0,1,2,3,4) = 5^2 = 7
                {1, 3},   // max(1^0, 1^1, 1^2, 1^3) = 1^2 = 3
                {3, 1}   // max(3^0, 3^1) = 3^0 = 3
        };

        int[] expected = {7, 3, 3};

        int[] actual = solution.maxXorQueries(queries, arr);

        System.out.println("Input arr: " + Arrays.toString(arr));
        System.out.println("Queries:");
        for (int[] q : queries) {
            System.out.println(Arrays.toString(q));
        }

        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual  : " + Arrays.toString(actual));

        if (Arrays.equals(expected, actual)) {
            System.out.println("Test passed ✅");
        } else {
            System.out.println("Test failed ❌");
        }

        // Additional case: no number satisfies the condition
        int[] arr2 = {5, 10, 15};
        int[][] queries2 = {
                {7, 4},  // no number <= 4 → -1
                {2, 5}   // 5 is allowed → 2 ^ 5 = 7
        };
        int[] expected2 = {-1, 7};
        int[] actual2 = solution.maxXorQueries(queries2, arr2);

        System.out.println("\nAdditional Test:");
        System.out.println("Expected: " + Arrays.toString(expected2));
        System.out.println("Actual  : " + Arrays.toString(actual2));
        if (Arrays.equals(expected2, actual2)) {
            System.out.println("Test passed ✅");
        } else {
            System.out.println("Test failed ❌");
        }
    }
}
