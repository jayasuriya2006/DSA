package dsa.array.test;

import dsa.array.main.SetMatrixZeroes;

import java.util.Arrays;

public class SetMatrixZeroesTest {
    /*
      arr[row][col] = 0 , then make complete row and col as 0


      Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
      Output: [[1,0,1],[0,0,0],[1,0,1]]

      Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
      Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
    * */

    public static void main(String[] args) {


        int[][] matrix_CloneBrut = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] matrix_CloneBetter = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] matrix_CloneOptimal = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] expected = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        SetMatrixZeroes.setMatrixZeros_Brut(matrix_CloneBrut);
        SetMatrixZeroes.setMatrixZeros_Better(matrix_CloneBetter);
        SetMatrixZeroes.setMatrixZeros_Optimal(matrix_CloneOptimal);

        if (Arrays.deepEquals(expected, matrix_CloneBrut)) {
            System.out.println(".......BRUT - TEST PASSED............");
        } else {
            System.out.println(".......BRUT - TEST FAILED............");
        }

        if (Arrays.deepEquals(expected, matrix_CloneBetter)) {
            System.out.println(".......BETTER - TEST PASSED............");
        } else {
            System.out.println(".......BETTER - TEST FAILED............");
        }

        if (Arrays.deepEquals(expected, matrix_CloneOptimal)) {
            System.out.println(".......OPTIMAL - TEST PASSED............");
        } else {
            System.out.println(".......OPTIMAL - TEST FAILED............");
        }


    }
}
