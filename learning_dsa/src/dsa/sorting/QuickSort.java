package dsa.sorting;

/*
 *
 *  Time complexity N LogN
 *
 * */
public class QuickSort implements Sort {
    @Override
    public void sort(int[] arr) {
        quickSort(0, arr.length - 1, arr);

    }

    private void quickSort(int low, int high, int arr[]) {
        if (low < high) {
            //In each iteration we are putting the pivot in to the right position
            int pivot = partition(low, high, arr);
            quickSort(low, pivot - 1, arr);
            quickSort(pivot + 1, high, arr);
        }
    }

    private int partition(int low, int high, int arr[]) {
        // find the right position for the pivot
        int j = low;
        int i = j - 1;
        //put all the values which are less than pivot in the front
        int pivotVal = arr[high];
        for(int x = low; x < high; x++){
            if(arr[x] < pivotVal){
                int temp = arr[i + 1];
                arr[i + 1] = arr[x];
                arr[x] = temp;
                i++;
            }
        }
        //now put the pivot into the right place (i+1),
        // since we know that all the values before i+1 are less than pivot
        // and all the values after i+1 are greater than pivot
        int temp = arr[high];
        arr[high] = arr[i + 1];
        arr[i + 1] = temp;

        //pivot index
       return i + 1;

    }
}
