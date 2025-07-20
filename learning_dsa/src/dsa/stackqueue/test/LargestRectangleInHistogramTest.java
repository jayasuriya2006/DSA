package dsa.stackqueue.test;

import static dsa.stackqueue.main.LargestRectangleInHistogram.findLargestRectangleArea_Brut;
import static dsa.stackqueue.main.LargestRectangleInHistogram.findLargestRectangleArea_Optimal;

public class LargestRectangleInHistogramTest {
    public static void main(String[] args) {

        int[][] testInputs = {
                {2, 1, 5, 6, 2, 3},   // Expected: 10
                {2, 4},               // Expected: 4
                {6, 2, 5, 4, 5, 1, 6},// Expected: 12
                {1, 1, 1, 1},         // Expected: 4
                {1},                  // Expected: 1
                {},                   // Expected: 0
                {2, 1, 2},            // Expected: 3
                {0, 9},               // Expected: 9
                {2, 3, 4, 5, 6}       // Expected: 12
        };

        int[] expectedOutputs = {
                10,
                4,
                12,
                4,
                1,
                0,
                3,
                9,
                12
        };

        for (int i = 0; i < testInputs.length; i++) {
            int result = findLargestRectangleArea_Optimal(testInputs[i]);
            System.out.println("Test case " + (i + 1));
            System.out.print("Input:    ");
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
