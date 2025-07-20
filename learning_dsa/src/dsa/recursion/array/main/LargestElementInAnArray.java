package dsa.array.main;


import java.util.Arrays;

public class LargestElementInAnArray {

    public static int findLargestElementInAnArrayBrut(int[] arr) {
        return findLargestElementInAnArrayBrut(arr, arr.length);
    }

    public static int findLargestElementInAnArrayOptimal(int[] arr) {
        return findLargestElementInAnArrayOptimal(arr, arr.length);
    }


    //Brut-force
    //TC - O(N logN) for sorting
    private static int findLargestElementInAnArrayBrut(int[] arr, int n) {

        //step 1: sort the given array
        Arrays.sort(arr);        // O(N logN)

        //return the last element
        return arr[n - 1];
    }

    //Optimal
    //TC - O(N) -> N is the number of element        Since we are iterating the array one time
    //SC - O(1)      We are not using any extra space
    private static int findLargestElementInAnArrayOptimal(int[] arr, int n) {

        //step 1: assign the first value as largest value
        int largest = arr[0];

        //step 2: Iterate the array and check for largest,
        for (int i = 1; i < n; i++) {
            //if it's greater than largest replace the largest value
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        return largest;
    }
}

