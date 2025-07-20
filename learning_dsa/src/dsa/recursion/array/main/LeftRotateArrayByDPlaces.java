package dsa.array.main;

public class LeftRotateArrayByDPlaces {
    public static void leftRotateArrayByDBetter(int[] arr, int d) {
        leftRotateArrayByDBetter(arr, arr.length, d);
    }

    public static void leftRotateArrayByDBrut(int[] arr, int d) {
        leftRotateArrayByDBrut(arr, arr.length, d);
    }

    public static void leftRotateArrayByDOptimal(int[] arr, int d) {
        leftRotateArrayByDOptimal(arr, arr.length, d);
    }

    //brut - call d times leftRotateArrayByOne
    //TC - O(d * n)
    private static void leftRotateArrayByDBrut(int[] arr, int n, int d) {

        //rotating n times will give the original array
        d = d % n;

        //O(d)
        for (int i = 1; i <= d; i++) {
            dsa.array.main.LeftRotateArrayByOnePlace.leftRotateArrayByOne(arr);
        }
    }

    //better
    private static void leftRotateArrayByDBetter(int[] arr, int n, int d) {
        //rotating n times will give the original array
        d = d % n;

        int[] temp = new int[d];
        //O(d)
        //copy d elements to temp
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];

        }

        //move n-d elements to left
        int ind = 0;
        for (int i = d; i < n; i++) {
            arr[ind] = arr[i];
            ind++;
        }

        //move d elements from temp to right part of array
        for (int i = 0; i < d; i++) {
            arr[ind] = temp[i];
            ind++;
        }
    }

    //optimal - reverse the array
    //TC - O(2n)
    private static void leftRotateArrayByDOptimal(int[] arr, int n, int d) {
        //rotating n times will give the original array
        d = d % n;

        dsa.array.main.ReverseArray.reverseTheArray(arr, 0, d - 1);
        dsa.array.main.ReverseArray.reverseTheArray(arr, d, n - 1);
        dsa.array.main.ReverseArray.reverseTheArray(arr);

        //for right rotate
        // dsa.array.main.ReverseArray.reverseTheArray(arr);
        // dsa.array.main.ReverseArray.reverseTheArray(arr, 0, d - 1);
        // dsa.array.main.ReverseArray.reverseTheArray(arr, d, n - 1);

    }


}
