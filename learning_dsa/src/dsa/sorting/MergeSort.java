package dsa.sorting;

/*
 *
 *  Time complexity N LogN
 *
 * */
public class MergeSort implements Sort {
    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int arr[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] array, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int i = low; // pointer for left subarray
        int j = mid + 1; // pointer for right subarray

        int k = 0; // pointer for temp array
        while (i <= mid && j <= high) {
            temp[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }

        //copy remaining elements from left subarray if any
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        //copy remaining elements from right subarray if any
        while (j <= high) {
            temp[k++] = array[j++];
        }

        // Copy sorted elements back to original array
        for (int z = low; z <= high; z++) {
            array[z] = temp[z - low];
        }

    }
}
