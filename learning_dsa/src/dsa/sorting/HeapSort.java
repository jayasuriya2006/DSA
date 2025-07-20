package dsa.sorting;

/*
 *
 *  Time complexity N LogN
 *
 * */
// Class that implements Heap Sort algorithm
public class HeapSort implements Sort {

    /**
     * Sorts an array using Heap Sort algorithm.
     *
     * @param arr The array to be sorted
     */
    @Override
    public void sort(int arr[]) {
        // Step 1: Build a max-heap from the unsorted array
        // Start from the last non-leaf node and heapify each node
        for (int i = (arr.length / 2) - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        // Step 2: Extract elements from the heap one by one
        // Move the current root (maximum) to the end of the array
        for (int i = arr.length - 1; i >= 0; i--) {
            // Swap root (max element) with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on the reduced heap
            heapify(arr, 0, i);
        }
    }

    /**
     * Heapifies a subtree rooted with element at index 'element'
     * Assumes the subtrees are already heapified
     *
     * @param arr     The array representation of the heap
     * @param element The index of the root of the subtree
     * @param length  The size of the heap
     */
    private static void heapify(int[] arr, int element, int length) {
        int largeIndex = element;
        int leftChild = element * 2 + 1;
        int rightChild = element * 2 + 2;

        // Check if left child exists and is greater than current largest
        if (leftChild < length && arr[leftChild] > arr[largeIndex]) {
            largeIndex = leftChild;
        }

        // Check if right child exists and is greater than current largest
        if (rightChild < length && arr[rightChild] > arr[largeIndex]) {
            largeIndex = rightChild;
        }

        // If largest is not the root, swap and continue heapifying
        if (element != largeIndex) {
            int temp = arr[largeIndex];
            arr[largeIndex] = arr[element];
            arr[element] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, largeIndex, length);
        }
    }
}
