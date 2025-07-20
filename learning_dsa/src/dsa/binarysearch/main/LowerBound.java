package dsa.binarysearch.main;

public class LowerBound {

    // Returns the index of the first element >= target
    // If no such element exists, returns n
    //TC - O(N logN)
    //SC - O(1)
    public static int getLowerBound(int[] arr, int num) {
        int lowerBound = arr.length;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= num) {
                lowerBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return lowerBound;
    }
}
