package dsa.recursion.main;

public class MergeSort {

    public static void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int low, int high) {

        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
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
