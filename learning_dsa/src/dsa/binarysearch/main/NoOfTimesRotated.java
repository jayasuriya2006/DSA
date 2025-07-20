package dsa.binarysearch.main;

public class NoOfTimesRotated {

    public static int findRotationCount(int[] arr) {
        int minIndex = 0;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            //search space is sorted
            if (arr[low] <= arr[high]) {
                if (arr[low] < arr[minIndex]) {
                    minIndex = low;
                }
                break;
            }

            if (arr[low] <= arr[mid]) {
                if (arr[low] < arr[minIndex]) {
                    minIndex = low;
                }
                low = mid + 1;
            } else {
                if (arr[mid] < arr[minIndex]) {
                    minIndex = mid;
                }
                high = mid - 1;
            }
        }
        return minIndex;
    }
}
