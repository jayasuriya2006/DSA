package dsa.binarysearch.main;

public class SearchInATwoDMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = getRowIndex(matrix, target);
        if(row == -1) return false;
        return checkPresence(matrix[row], target);
    }
    private static boolean checkPresence(int[] mat, int target){
        int start = 0;
        int end = mat.length -1;
        while(start <= end){
            int mid = (start + end)/2;
            if(mat[mid] == target) return true;
            if(mat[mid] < target) start = mid + 1;
            else end = mid -1;
        }
        return false;
    }

    private static int getRowIndex(int[][] mat, int target){
        if(mat.length == 0) return -1;
        int start = 0; int end = mat.length -1;
        if(end == 0) return 0;
        int m = mat[0].length;
        while(start <= end){
            int mid = (start + end) / 2;
            if((target >= mat[mid][0]) && target <= mat[mid][m - 1]){
                return mid;
            } else if((target > mat[mid][0]) && mat[mid][m - 1] < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;

    }

    public static boolean searchMatrix_matrixTrans(int[][] matrix, int target){
        if(matrix.length == 0) return false;
        int n = matrix.length; int m = matrix[0].length;
        int low = 0;
        int high = (n * m) - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            int row = mid / m; int col = mid % m;
            if(matrix[row][col] == target){
                return true;
            } else if(matrix[row][col] > target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
