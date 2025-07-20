package dsa.stackqueue.test;

import static dsa.stackqueue.main.SumOfSubArrayMin.sumOfSubArraysMin_Brut;
import static dsa.stackqueue.main.SumOfSubArrayMin.sumOfSubArraysMin_Optimal;

public class SumOfSubArrayMinTest {

    public static void main(String[] args) {

        int[][] testInputs = {
                {3, 1, 2, 4},
                {11, 81, 94, 43, 3},
                {1, 2, 3},
                {3, 2, 1},
                {5},
                {}
        };

        int[] expectedOutputs = {
                17, // Example explanation: subarrays like [3], [1], [2], [4], [1,2], [2,4], etc.
                444,
                10,
                10,
                5,
                0
        };

        for (int i = 0; i < testInputs.length; i++) {
            int result = sumOfSubArraysMin_Optimal(testInputs[i]);
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
