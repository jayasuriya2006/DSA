package dsa.array.main;

public class IsArraySorted {
    public static boolean isArraySortedCheck(int[] arr) {
        return isArraySortedCheck(arr, arr.length);
    }

    private static boolean isArraySortedCheck(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
