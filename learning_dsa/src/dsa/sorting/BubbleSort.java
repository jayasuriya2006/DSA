package dsa.sorting;

/*
 *
 *  Time complexity N^2
 * Compare i and i + 1 -> if(( i + 1 ) > i)   -> swap(i, i + 1)
 * It will make sure that in every iteration the last element will be placed in the right position
 *
 * */

public class BubbleSort implements Sort {

    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}

