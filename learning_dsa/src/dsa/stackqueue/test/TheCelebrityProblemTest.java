package dsa.stackqueue.test;

import static dsa.stackqueue.main.TheCelebrityProblem.findCelebrity_Brut;
import static dsa.stackqueue.main.TheCelebrityProblem.findCelebrity_Optimal;

public class TheCelebrityProblemTest {
    public static void main(String[] args) {

        int[][][] testMatrices = {
                {
                        {0, 1, 0},
                        {0, 0, 0},
                        {0, 1, 0}
                },
                {
                        {0, 1},
                        {1, 0}
                },
                {
                        {0, 1, 1},
                        {0, 0, 0},
                        {0, 1, 0}
                },
                {
                        {0, 0, 0},
                        {0, 0, 0},
                        {0, 0, 0}
                },
                {
                        {0, 1, 0, 0},
                        {0, 0, 0, 0},
                        {1, 1, 0, 1},
                        {0, 1, 0, 0}
                }
        };

        int[] expected = {1, -1, 1, -1, 1};

        for (int i = 0; i < testMatrices.length; i++) {
            int result = findCelebrity_Optimal(testMatrices[i]);

            System.out.println("Test case " + (i + 1));
            System.out.println("Input matrix:");
            printMatrix(testMatrices[i]);
            System.out.println("Expected: " + expected[i]);
            System.out.println("Actual:   " + result);
            System.out.println(result == expected[i] ? "✅ Passed" : "❌ Failed");
            System.out.println("-----------");
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("[");
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j]);
                if (j < row.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}
