package dsa.recursion.test;

import dsa.array.main.ReverseArray;

public class ReverseArrayTest {

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 9, 10};
        int[] reversedArray = {10, 9, 6, 5, 4, 2};

        ReverseArray.reverseTheArray(arr);

        boolean testPassed = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != reversedArray[i]) {
                testPassed = false;
                break;
            }
        }
        if (testPassed) {
            System.out.println("........TEST PASSED........");
        } else {
            System.out.println("........TEST FAILED........");
        }
    }
}
