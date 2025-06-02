package dsa.array.main;

import java.util.Arrays;

public class MergeSortedArraysWithoutExtraSpace {


    //TC - O(2 * ( n + m))
    //SC - O(n + m)
    public static void mergeArray_Brut(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        //temp array for storing elements in sorted order
        int[] tempArray = new int[n + m];

        int i = 0;
        int j = 0;
        int index = 0;
        while (i < n && j < m) {
            //arr1 value is small
            if (arr1[i] <= arr2[j]) {
                tempArray[index] = arr1[i];
                i++;
                index++;
            } else {
                //arr2 value is small
                tempArray[index] = arr2[j];
                j++;
                index++;
            }
        }

        //copy remaining elements
        while (i < n) {
            tempArray[index] = arr1[i];
            i++;
            index++;
        }
        while (j < m) {
            tempArray[index] = arr2[j];
            j++;
            index++;
        }

        //copy temp array to original array
        for (int x = 0; x < tempArray.length; x++) {
            if (x < n) {
                arr1[x] = tempArray[x];
            } else {
                arr2[x - n] = tempArray[x];
            }
        }
    }

    //TC - O(min(n,m)) + O(n log n) + O(m log m)
    //SC - O(1)
    public static void mergeArray_Optimal(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int i = arr1.length - 1;
        int j = 0;

        while (i >= 0 && j < m) {
            //swap to right array
            if (arr1[i] >= arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }

        //sort individual arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}
