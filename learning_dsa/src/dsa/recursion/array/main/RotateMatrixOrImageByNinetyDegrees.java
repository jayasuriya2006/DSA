package dsa.array.main;

import java.util.Arrays;

public class RotateMatrixOrImageByNinetyDegrees {

    //TC - O(N * M)
    //SC - O(N * M)
    public static int[][] rotateMatrix_Brut(int[][] matrix) {
        //observation
        // 1st row last column
        //2nd row 2nd last column.... ad so on

        //output[j][m-i] = mat[i][j]


        int n = matrix.length;
        int m = matrix[0].length;

        int[][] output = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                output[j][m - i - 1] = matrix[i][j];
            }
        }

        return output;
    }


    //TC - O((n * m)/2  + n * (m/2))
    //SC - O(1)
    public static void rotateMatrix_Optimal(int[][] matrix) {
        //pure observation
        //find the transform of an array then reverse each array     -> transform = i th row becomes i th column

        //TC - O((n * m)/2)
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < m; j++) {
                swap(matrix, i, j);
            }
        }

        //TC - n * (m/2)
        for (int[] arr : matrix) {
            ReverseArray.reverseTheArray(arr);
        }

    }

    private static void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

}
