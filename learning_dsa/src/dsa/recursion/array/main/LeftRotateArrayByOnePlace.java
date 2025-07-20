package dsa.array.main;

public class LeftRotateArrayByOnePlace {
    public static void leftRotateArrayByOne(int[] arr) {
        leftRotateArrayByOne(arr, arr.length);
    }

    //O(N)
    private static void leftRotateArrayByOne(int[] arr, int n) {
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = temp;
    }
}
