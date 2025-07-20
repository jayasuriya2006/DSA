package dsa.array.main;

import java.util.Arrays;

public class FirstMissingNumber {

    //TC- O(n * n)
    //SC - O(1)
    public static int findFirstMissingNumberBrut(int[] arr, int n) {
        //search 1 to n in the array using linear search
        for (int i = 1; i <= n; i++) {
            int index = LinearSearchInArray.getTheIndex(arr, i);
            if (index == -1) {
                return i;
            }
        }
        return 0;
    }

    //TC - O (2n)
    //SC - O(n)
    public static int findFirstMissingNumberBetter(int[] arr, int n) {
        //use hash array
        boolean[] track = new boolean[n + 1];
        //iterate the array and mark the index as true
        for (int item : arr) {
            track[item] = true;
        }

        //find the first false index
        for (int i = 1; i < n; i++) {
            if (track[i] == false) {
                return i;
            }
        }
        return 0;
    }

    //TC - O(n)
    //SC - O(1)
    public static int findFirstMissingNumberOptimal(int[] arr, int n) {
        // first n number sum( 1 to n) - sum{array elements = missing number
        int sumOneToN = n * (n + 1) / 2;
        int sumArray = 0;
        for (int i = 0; i < arr.length; i++) {
            sumArray += arr[i];
        }
        // sumArray = Arrays.stream(arr).sum();
        return sumOneToN - sumArray;
    }

    //TC - O(n)
    //SC - O(1)
    public static int findFirstMissingNumberOptimal_XOR(int[] arr, int n) {
        // XOR of same number will be 0
        // XOR of 0 with number will be number

        // 1 XOR 2 XOR 3 XOR 4 XOR 1 XOR 3 XOR 4 = 2
        int xorArray = 0;
        int xorN = 0;
        for (int i = 0; i < arr.length; i++) {
            xorArray = xorArray ^ arr[i];
            xorN = xorN ^ (i + 1);
        }
        xorN = xorN ^ n;
        return xorN ^ xorArray;
    }
}
