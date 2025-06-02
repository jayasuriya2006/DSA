package dsa.array.main;

public class MoveZerosToLast {
    public static void moveZerosToLastBrut(int[] arr) {
        moveZerosToLastBrut(arr, arr.length);
    }

    //TC - O(n + d + n )
    private static void moveZerosToLastBrut(int[] arr, int n) {
        int[] temp = new int[n];
        int ind = 0;

        for (int item : arr) {
            if (item != 0) {
                temp[ind] = item;
                ind++;
            }
        }

        //O(d)
        for (int i = ind; i < n; i++) {
            temp[i] = 0;
        }
        //O(n)
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }


    public static void moveZerosToLastOptimal(int[] arr) {
        moveZerosToLastOptimal(arr, arr.length);
    }


    //two pointer approach
    //TC - O(N)
    private static void moveZerosToLastOptimal(int[] arr, int n) {
        //this will point to non zero index
        int nonZeroIndex = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                nonZeroIndex++;
                int temp = arr[nonZeroIndex];
                arr[nonZeroIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

}
