package dsa.binarysearch.test;

import static dsa.binarysearch.main.FloorAndCeil.getCeil;
import static dsa.binarysearch.main.FloorAndCeil.getFloor;

public class FloorAndCeilTest {
    public static void printTest(String testName, int expected, int actual) {
        if (expected == actual) {
            System.out.println(testName + " PASSED ✅");
        } else {
            System.out.println(testName + " FAILED ❌ (Expected: " + expected + ", Got: " + actual + ")");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};

        // Floor tests
        printTest("Floor 1", 0, getFloor(arr, 1));     // 1 at index 0
        printTest("Floor 4", 1, getFloor(arr, 4));     // 3 at index 1
        printTest("Floor 0", -1, getFloor(arr, 0));    // no floor
        printTest("Floor 10", 4, getFloor(arr, 10));   // 9 at index 4
        printTest("Floor 5", 2, getFloor(arr, 5));     // 5 at index 2

        // Ceil tests
        printTest("Ceil 1", 0, getCeil(arr, 1));       // 1 at index 0
        printTest("Ceil 4", 2, getCeil(arr, 4));       // 5 at index 2
        printTest("Ceil 0", 0, getCeil(arr, 0));       // 1 at index 0
        printTest("Ceil 10", -1, getCeil(arr, 10));    // no ceil
        printTest("Ceil 5", 2, getCeil(arr, 5));       // 5 at index 2

        int[] empty = {};
        printTest("Floor Empty Array", -1, getFloor(empty, 5));
        printTest("Ceil Empty Array", -1, getCeil(empty, 5));

        int[] single = {5};
        printTest("Floor Single Match", 0, getFloor(single, 5));
        printTest("Ceil Single Match", 0, getCeil(single, 5));
        printTest("Floor Single Too Low", -1, getFloor(single, 2));
        printTest("Ceil Single Too High", -1, getCeil(single, 10));

        int[] duplicates = {1, 2, 2, 2, 3};
        printTest("Floor Duplicate 2", 3, getFloor(duplicates, 2)); // last 2 at index 3
        printTest("Ceil Duplicate 2", 1, getCeil(duplicates, 2));   // first 2 at index 1
    }
}
