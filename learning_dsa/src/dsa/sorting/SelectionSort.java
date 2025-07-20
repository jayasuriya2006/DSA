package dsa.sorting;

/*
 *
 *  Time complexity N ^ 2
 *
 * */
public class SelectionSort implements Sort {

    /*
     * in each iteration find the largest or min element and put it in the last
     * */
    public void sort(int arr[]) {

        //outer loop - in each iteration updating the max element in sorted array
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            //inner loop - iterate over unsorted array
            for (int j = 0; j < arr.length - i; j++) {
                //find the max element
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            //update the sorted array
            int temp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[max];
            arr[max] = temp;
        }
    }
}
