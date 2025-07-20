package dsa.sorting;

/*
 *
 *  Time complexity N^2
 *
 * */
// Class that implements Insertion Sort algorithm
public class InsertionSort implements Sort {

    /**
     * Sorts an array using the Insertion Sort algorithm.
     *
     * @param arr The array to be sorted
     */
    @Override
    public void sort(int[] arr) {

        // Start from the second element (index 1)
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];     // Current element to be inserted
            int j = i - 1;

            // Shift elements of the sorted segment forward if they are greater than the key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // Move element one position ahead
                j--;
            }

            // Insert the key in the correct position
            arr[j + 1] = key;
        }
    }
}

