package dsa.stackqueue.test;

import dsa.stackqueue.main.StockSpanProblem;

public class StockSpanProblemTest {
    public static void main(String[] args) {
        int[][] testInputs = {
                {100, 80, 60, 70, 60, 75, 85},
                {10, 20, 30, 40, 50},
                {50, 40, 30, 20, 10},
                {100},
                {},
                {60, 70, 80, 100, 90, 95, 85},
                {90, 80, 70, 60, 50, 60, 70, 80}
        };

        int[][] expectedOutputs = {
                {1, 1, 1, 2, 1, 4, 6},
                {1, 2, 3, 4, 5},
                {1, 1, 1, 1, 1},
                {1},
                {},
                {1, 2, 3, 4, 1, 2, 1},
                {1,  1,  1,  1,  1,  3,  5,  7}
        };

        for (int i = 0; i < testInputs.length; i++) {
            StockSpanProblem solver = new StockSpanProblem();
            int[] input = testInputs[i];
            int[] expected = expectedOutputs[i];
            int[] result = new int[input.length];

            for (int j = 0; j < input.length; j++) {
                result[j] = solver.getStockSpan(input[j]);
            }

            System.out.println("Test case " + (i + 1));
            System.out.print("Input:    ");
            printArray(input);
            System.out.print("Expected: ");
            printArray(expected);
            System.out.print("Actual:   ");
            printArray(result);
            System.out.println(arraysEqual(result, expected) ? "✅ Passed" : "❌ Failed");
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
