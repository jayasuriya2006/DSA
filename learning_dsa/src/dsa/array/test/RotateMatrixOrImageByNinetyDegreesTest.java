package dsa.array.test;

import dsa.array.main.RotateMatrixOrImageByNinetyDegrees;

import java.util.Arrays;

public class RotateMatrixOrImageByNinetyDegreesTest {
    /*
     Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise.
     The rotation must be done in place, meaning the input 2D matrix must be modified directly.

     Input: matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
     Output: matrix = [[7, 4, 1], [8, 5, 2], [9, 6, 3]]

     Input: matrix = [[0, 1, 1, 2], [2, 0, 3, 1], [4, 5, 0, 5], [5, 6, 7, 0]]
     Output: matrix = [[5, 4, 2, 0], [6, 5, 0, 1], [7, 0, 3, 1], [0, 5, 1, 2]]
     */

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] expected = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };

        int[][] out_brut = RotateMatrixOrImageByNinetyDegrees.rotateMatrix_Brut(matrix);
        if (Arrays.deepEquals(out_brut, expected)) {
            System.out.println(".........BRUT - TEST PASSED........");
        } else {
            System.out.println(".........BRUT - TEST FAILED........");
        }

        RotateMatrixOrImageByNinetyDegrees.rotateMatrix_Optimal(matrix);
        if (Arrays.deepEquals(matrix, expected)) {
            System.out.println(".........OPTIMAL - TEST PASSED........");
        } else {
            System.out.println(".........OPTIMAL - TEST FAILED........");
        }
    }

}
