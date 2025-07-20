package dsa.binarysearch.main;

import static dsa.binarysearch.main.LowerBound.getLowerBound;
import static dsa.binarysearch.main.UpperBound.getUpperBound;

public class FloorAndCeil {

    //The greatest element less than or equal to the target.
    //TC - O(N logN)
    //SC - O(1)
    public static int getFloor(int[] arr, int num) {
        int ceil = -1;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > num) {
                high = mid - 1;
            } else {
                ceil = mid;
                low = mid + 1;
            }
        }

        return ceil;
    }

    //The smallest element greater than or equal to the target.
    public static int getCeil(int[] arr, int num) {
        int upperBound = getLowerBound(arr, num);
        if (upperBound == arr.length) {
            return -1;
        }
        return upperBound;
    }
}
