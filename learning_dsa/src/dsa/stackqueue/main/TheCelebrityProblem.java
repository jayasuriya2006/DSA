package dsa.stackqueue.main;

public class TheCelebrityProblem {

    //TC - O(N * N) + O(N)
    //SC - O(2N)
    public static int findCelebrity_Brut(int[][] matrix) {
        int n = matrix.length;

        int[] knowsMe = new int[n];
        int[] iKnow = new int[n];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 1) {
                    knowsMe[col]++;
                    iKnow[row]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (iKnow[i] == 0 && knowsMe[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

    //TC - O(n/2) + O(n)
    //SC - O(1)
    public static int findCelebrity_Optimal(int[][] matrix) {
        int n = matrix.length;
        int top = 0;
        int down = n - 1;

        while (top < down) {
            if (matrix[top][down] == 1) {
                top++;
            } else {
                down--;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[top][i] != 0) return -1;
            if (matrix[i][top] != 1) {
                if (i != top) return -1;
            }
        }
        return top;
    }
}
