package dsa.recursion.test;

public class CountSubSequencesWithKSumTest {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int target = 5;
        int expectedAns = 3;

        int actualAns = dsa.recursion.main.CountSubSequencesWithKSum.countSubSequencesWithSumK(input, target);
        if (actualAns == expectedAns) {
            System.out.println("..........TEST PASSED.............");
        } else {
            System.out.println("..........TEST FAILED.............");
            System.out.println("Expected: " + expectedAns);
            System.out.println("Actual: " + actualAns);
        }
    }
}
