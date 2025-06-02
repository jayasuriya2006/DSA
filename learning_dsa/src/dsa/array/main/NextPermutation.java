package dsa.array.main;

import java.util.Arrays;

public class NextPermutation {

    public static void getNextPermutation(int[] arr) {
        int n = arr.length;

        //find the breakpoint, which arr[i] < arr[i + 1]   -> this is for keeping longest prefix
        int breakIndex = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                breakIndex = i;
                break;
            }
        }

        //if given input is last permutation then we need to return first permutation -> just reverse and return
        if (breakIndex == -1) {
            ReverseArray.reverseTheArray(arr);
            return;
        }

        //find small number n - 1 to bi + 1, but it should greater than arr[bi]  -> so that we can stay close
        //since we know from back it's increasing curve, we can find the first number which is greater than arr[bi]
        for (int i = n - 1; i > breakIndex; i--) {
            if (arr[i] > arr[breakIndex]) {
                //still we can maintain increasing curve so swap
                int temp = arr[breakIndex];
                arr[breakIndex] = arr[i];
                arr[i] = temp;
                break;
            }
        }

        //we have to reverse bi + 1 to n-1, since we need next minimum
        // we know n - 1 to bi + 1 increasing curve, we can just reverse it. So that it will come as next small number
        ReverseArray.reverseTheArray(arr, breakIndex + 1, n - 1);
    }
}
