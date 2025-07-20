package dsa.binarysearch.main;

public class BinarySearchInArray {

    //TC - O(N logN)
    //SC - O(1)
    public static int binarySearch(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            //target found
            if (arr[mid] == target) {
                return mid;
            }

            //eliminate half search space
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int binarySearchRecursion(int arr[], int target) {
        return binarySearchUsingRecursion(arr, target, 0, arr.length - 1);
    }

    private static int binarySearchUsingRecursion(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return binarySearchUsingRecursion(arr, target, mid + 1, high);
        } else {
            return binarySearchUsingRecursion(arr, target, low, mid - 1);
        }
    }
}
