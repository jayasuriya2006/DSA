package dsa.binarysearch.main;

public class FirstAndLastOccurrences {

    //TC - O(2 (N LogN))
    //SC - O(1)
    public static int[] getFirstAndLastOccurrence(int[] arr, int num) {
        int[] res = new int[2];
        res[0] = getTheFirstOccurrence(arr, num);
        //if not present
        if (res[0] == -1) {
            res[1] = -1;
            return res;
        }

        res[1] = getTheLastOccurrence(arr, num);
        return res;
    }

    private static int getTheFirstOccurrence(int[] arr, int num) {
        int firstOcc = -1;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == num) {
                firstOcc = mid;
                high = mid - 1;
            } else if (arr[mid] > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return firstOcc;
    }

    private static int getTheLastOccurrence(int[] arr, int num) {
        int lastOcc = -1;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == num) {
                lastOcc = mid;
                low = mid + 1;
            } else if (arr[mid] > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lastOcc;
    }
}
