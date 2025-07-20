package dsa.array.main;

import java.util.Arrays;

public class SortArrayZeroOneTwo {
    //TC - O( N log N)
    public static void sortArray_0_1_2_Brut(int[] arr) {
        Arrays.sort(arr);
    }

    //count 0s, 1s, 2s then manually update      count of 0 and 1 is enough.. remaining will be two
    //TC - O(2N)
    public static void sortArray_0_1_2_Better(int[] arr) {
        int zeroC = 0;
        int oneC = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroC++;
            } else if (arr[i] == 1) {
                oneC++;
            }
        }

        for (int i = 0; i < zeroC; i++) {
            arr[i] = 0;
        }

        for (int i = zeroC; i < oneC + zeroC; i++) {
            arr[i] = 1;
        }

        for (int i = oneC + zeroC; i < arr.length; i++) {
            arr[i] = 2;
        }
    }

    //3 pointer approach  low to mid - sorted   mid to high - unsorted   high to n - sorted
    //TC - O(N)
    //SC - O(1)
    public static void sortArray_0_1_2_Optimal(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int item1, int item2) {
        int temp = arr[item1];
        arr[item1] = arr[item2];
        arr[item2] = temp;
    }
}
