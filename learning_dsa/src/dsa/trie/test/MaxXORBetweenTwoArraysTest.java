package dsa.trie.test;

import dsa.trie.main.MaxXORBetweenTwoArrays;

public class MaxXORBetweenTwoArraysTest {
    public static void main(String[] args) {
        MaxXORBetweenTwoArrays solution = new MaxXORBetweenTwoArrays();

        int[][] arr1Inputs = {
                {3, 10, 5, 25, 2, 8},
                {0},
                {1, 2, 3},
                {8, 1, 2},
                {15, 5, 1},
                {}
        };

        int[][] arr2Inputs = {
                {5, 2, 8},
                {0},
                {7, 8},
                {6, 7},
                {2, 10},
                {1, 2, 3}
        };

        int[] expectedOutputs = {
                28,  // 5 ^ 25 = 28
                0,   // 0 ^ 0 = 0
                11,
                15,  // 7 ^ 8 = 15
                15,  // 10 ^ 5 = 15
                0    // Empty arr1, so no comparisons possible (could also throw exception if desired)
        };

        for (int i = 0; i < arr1Inputs.length; i++) {
            int[] arr1 = arr1Inputs[i];
            int[] arr2 = arr2Inputs[i];

            int result = solution.getMaxXorBetweenTwoArrays(arr1, arr2);

            System.out.println("Test case " + (i + 1));
            System.out.println("Arr1: " + arrayToString(arr1));
            System.out.println("Arr2: " + arrayToString(arr2));
            System.out.println("Expected: " + expectedOutputs[i]);
            System.out.println("Actual  : " + result);

            if (result == expectedOutputs[i]) {
                System.out.println("Test passed ✅");
            } else {
                System.out.println("Test failed ❌");
            }
            System.out.println("----------------------------");
        }
    }

    private static String arrayToString(int[] arr) {
        if (arr == null || arr.length == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int num : arr) {
            sb.append(num).append(", ");
        }
        sb.setLength(sb.length() - 2); // remove last comma
        sb.append("]");
        return sb.toString();
    }
}
