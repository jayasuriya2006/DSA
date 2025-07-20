package dsa.recursion.test;

public class MergeSortTest {

    public static void main(String[] args) {
        int[] input = {38, 27, 43, 3, 9, 82, 10};
        int[] expectedOutput = {3, 9, 10, 27, 38, 43, 82};

        dsa.recursion.main.MergeSort.sort(input);

        boolean isSorted = dsa.array.main.IsArraySorted.isArraySortedCheck(input);

        if (isSorted) {
            System.out.println("..........TEST PASSED.............");
        } else {
            System.out.println("..........TEST FAILED.............");
            System.out.print("Expected: ");
            for (int num : expectedOutput) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.print("Actual: ");
            for (int num : input) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
