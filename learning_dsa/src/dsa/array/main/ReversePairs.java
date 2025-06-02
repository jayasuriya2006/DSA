package dsa.array.main;

public class ReversePairs {
    //TC - O (n ^ 2)
    //SC - O(1)
    //normal method, take one element, compare with right elements
    public static int getReversePairsCount_Brut(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > (arr[j] * 2)) {
                    count++;
                }
            }
        }
        return count;
    }

    //use merge sort - approach if we have two sorted arrays we can easily compute the inversion count while merging
    //TC - O(2 * N logN)
    public static int getReversePairsCount_Optimal(int[] arr) {
        int count = 0;
        count = mergeSort(arr, 0, arr.length - 1);
        return count;
    }

    private static int mergeSort(int arr[], int l, int r) {
        int count = 0;
        if (l < r) {
            int mid = (l + r) / 2;
            count += mergeSort(arr, l, mid);
            count += mergeSort(arr, mid + 1, r);
            count += countReversePairs(arr, l, r, mid);
            merge(arr, mid, l, r);
            return count;
        }
        return count;
    }

    //function which is counting the pairs
    private static int countReversePairs(int[] arr, int low, int high, int mid) {
        int count = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            //if left is greater, then next left elements also greater than the current right since array is sorted
            while (right <= high && arr[i] > (2 * arr[right])) {
                right++;
            }
            count = count + (right - (mid + 1));
        }

        return count;
    }

    private static void merge(int arr[], int mid, int l, int r) {
        int[] arr1 = new int[mid - l + 1];
        int[] arr2 = new int[r - mid];

        // Copy data to temporary arrays
        for (int x = 0; x < arr1.length; x++) {
            arr1[x] = arr[l + x];
        }
        for (int x = 0; x < arr2.length; x++) {
            arr2[x] = arr[mid + 1 + x];
        }

        int i = 0, j = 0, k = l;

        // Merge the temporary arrays back into the original array
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
            }
        }

        // Copy remaining elements of arr1 (if any)
        while (i < arr1.length) {
            arr[k++] = arr1[i++];
        }

        // Copy remaining elements of arr2 (if any)
        while (j < arr2.length) {
            arr[k++] = arr2[j++];
        }
    }
}
