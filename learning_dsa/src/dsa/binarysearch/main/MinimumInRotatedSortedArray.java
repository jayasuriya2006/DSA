package dsa.binarysearch.main;

public class MinimumInRotatedSortedArray {

    public static int getMinimum(int[] arr) {
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            //search space is sorted
            if (arr[low] <= arr[high]) {
                min = Math.min(arr[low], min);
                break;
            }

            if (arr[low] <= arr[mid]) {                  // if left part sorted
                min = Math.min(min, arr[low]);
                low = mid + 1;
            } else {                                   // if right part sorted
                min = Math.min(min, arr[mid]);
                high = mid - 1;
            }
        }
        return min;
    }
}
