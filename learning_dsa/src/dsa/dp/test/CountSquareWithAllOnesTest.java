package dsa.dp.test;

import dsa.dp.main.CountSquareWithAllOnes;

public class CountSquareWithAllOnesTest {
    public static void main(String[] args) {
        test(new int[][]{
                {0, 1},
                {1, 0}
        }, 2);

        test(new int[][]{
                {1, 1},
                {1, 1}
        }, 5);

        test(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        }, 7);

        test(new int[][]{
                {0, 0},
                {0, 0}
        }, 0);

        test(new int[][]{
                {1}
        }, 1);

        test(new int[][]{
                {0}
        }, 0);

        test(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        }, 14); // 9 (1x1) + 4 (2x2) + 1 (3x3)

        test(new int[][]{
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        }, 17);

        test(new int[][]{
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1}
        }, 11);

        test(new int[][]{
                {1, 1, 1, 1}
        }, 4); // 4 1x1 squares, no larger square

    }

    private static void test(int[][] matrix, int expected) {
        int result = CountSquareWithAllOnes.countSquares(matrix);
        boolean pass = result == expected;

        System.out.println("Test case:");
        printMatrix(matrix);
        System.out.println("Expected: " + expected);
        System.out.println("Actual:   " + result + " -> " + (pass ? "✅ PASS" : "❌ FAIL"));
        System.out.println("--------------------------------------");
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
