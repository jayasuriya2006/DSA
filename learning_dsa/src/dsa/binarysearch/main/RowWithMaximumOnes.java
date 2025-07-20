package dsa.binarysearch.main;

import static dsa.binarysearch.main.LowerBound.getLowerBound;

public class RowWithMaximumOnes {
    public static int rowWithMaxOnes(int[][] matrix){
        if(matrix.length == 0) return -1;
        int max = 0;
        int maxOnesRow = -1;
        int m = matrix[0].length;
        int i = 0;
        for(int[] row : matrix){
            int onesPos = getLowerBound(row, 1);
            int noOfOnes = m - onesPos;
            if(noOfOnes > max){
                max = noOfOnes;
                maxOnesRow = i;
            }
            i++;
        }
        return maxOnesRow;
    }
}
