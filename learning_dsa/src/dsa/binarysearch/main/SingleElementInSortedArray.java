package dsa.binarysearch.main;

public class SingleElementInSortedArray {

    //{1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6}
    //{e, o, e, o, e, o, e, o, e, o, e}
    public static int getSingleElement(int[] arr) {
        if (arr.length == 0) return -1;
        if (arr.length == 1) return arr[0];

        //corner cases
        if (arr[0] != arr[1]) {
            return arr[0];
        }
        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }

        //since we handled corner cases
        int low = 1;
        int high = arr.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }

            if (((mid % 2 == 0) && (arr[mid] == arr[mid - 1]))
                    || ((mid % 2 == 1) && (arr[mid] == arr[mid + 1]))) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
