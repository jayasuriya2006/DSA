package dsa.binarysearch.main;

public class FindPeakElement {

    //return index
    public static int findPeakElement(int[] arr) {
        if (arr.length == 0) return -1;
        if (arr.length == 1) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[arr.length - 1] > arr[arr.length - 2]) return arr.length - 1;

        int low = 1;
        int high = arr.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {             //increasing curve
                low = mid + 1;
            } else {                                                           //decreasing curve
                high = mid - 1;
            }
        }
        return -1;
    }

}
