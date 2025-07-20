package dsa.stackqueue.test;

import static dsa.stackqueue.main.AestroidCollisions.asteroidCollision;

/*
https://leetcode.com/problems/asteroid-collision/description/
 */
public class AestroidCollisionsTest {
    public static void main(String[] args) {

        int[][] testInputs = {
                {5, 10, -5},          // → [5, 10]
                {8, -8},              // → []
                {10, 2, -5},          // → [10]
                {-2, -1, 1, 2},       // → [-2, -1, 1, 2]
                {1, -2, -2, -2},      // → [-2, -2, -2]
                {1, -1, -2, 2},       // → [-2, 2]
                {10, -10, 10, -10},   // → []
                {},                   // → []
                {-5, -10, 5, 10}      // → [-5, -10, 5, 10]
        };

        int[][] expectedOutputs = {
                {5, 10},
                {},
                {10},
                {-2, -1, 1, 2},
                {-2, -2, -2},
                {-2, 2},
                {},
                {},
                {-5, -10, 5, 10}
        };

        for (int i = 0; i < testInputs.length; i++) {
            int[] result = asteroidCollision(testInputs[i]);
            System.out.println("Test case " + (i + 1));
            System.out.print("Input:    ");
            printArray(testInputs[i]);
            System.out.print("Expected: ");
            printArray(expectedOutputs[i]);
            System.out.print("Actual:   ");
            printArray(result);
            System.out.println(arraysEqual(result, expectedOutputs[i]) ? "✅ Passed" : "❌ Failed");
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

    private static boolean arraysEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
