package dsa.binarysearch.test;

import static dsa.binarysearch.main.AllocateBooks.allocateBooks;

public class AllocateBooksTest {
    public static void main(String[] args) {
        runTest(new int[]{12, 34, 67, 90}, 2, 113, "Test 1");
        runTest(new int[]{10, 20, 30, 40}, 2, 60, "Test 2");
        runTest(new int[]{5, 5, 5, 5}, 2, 10, "Test 3");
        runTest(new int[]{100, 200, 300, 400}, 4, 400, "Test 4");
        runTest(new int[]{100, 200, 300, 400}, 5, -1, "Test 5 (more students than books)");
        runTest(new int[]{15, 17, 20}, 2, 32, "Test 6");
        runTest(new int[]{1, 2, 3, 4, 5}, 2, 9, "Test 7");
    }

    private static void runTest(int[] pages, int students, int expected, String testName) {
        int result = allocateBooks(pages, students);
        if (result == expected) {
            System.out.println(testName + " passed.");
        } else {
            System.out.printf("%s failed: expected %d, got %d\n", testName, expected, result);
        }
    }
}
