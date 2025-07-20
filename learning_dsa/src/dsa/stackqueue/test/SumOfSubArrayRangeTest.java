package dsa.stackqueue.test;

import static dsa.stackqueue.main.SumOfSubArrayRange.sumOfSubArrayRange_Brut;
import static dsa.stackqueue.main.SumOfSubArrayRange.sumOfSubArrayRange_Optimal;

public class SumOfSubArrayRangeTest {
    public static void main(String[] args) {

        int[][] testInputs = {
                {1, 2, 3},
                {1, 3, 3},
                {4, -2, -3, 4, 1},
                {1},
                {},
                {5, 5, 5, 5},
                {1, 3, 2, 4}
        };

        int[] expectedOutputs = {
                4,    // Subarrays: [1], [2], [3], [1,2], [2,3], [1,2,3] -> ranges sum = 4
                4,    // [1], [3], [3], [1,3], [3,3], [1,3,3]
                59,   // More complex case
                0,    // Only one element, max-min = 0
                0,    // Empty input
                0,    // All same elements -> all ranges = 0
                12    // Subarrays and their ranges add up to 12
        };

        for (int i = 0; i < testInputs.length; i++) {
            int result = sumOfSubArrayRange_Optimal(testInputs[i]);
            System.out.println("Test case " + (i + 1));
            System.out.print("Input: ");
            printArray(testInputs[i]);
            System.out.println("Expected: " + expectedOutputs[i]);
            System.out.println("Actual:   " + result);
            System.out.println(result == expectedOutputs[i] ? "✅ Passed" : "❌ Failed");
            System.out.println("-----------");
        }
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
