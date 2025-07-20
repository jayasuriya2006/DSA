package dsa.bitmanupulations.test;

import dsa.bitmanupulations.main.PowerSet;

import java.util.ArrayList;
import java.util.List;

public class PowerSetTest {

    /*
    generate all the subsequences using power set (already done using recursion)
     */
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        List<List<Integer>> expectedAns = new ArrayList<>();
        expectedAns.add(new ArrayList<>()); // empty subsequence
        expectedAns.add(List.of(1));
        expectedAns.add(List.of(2));
        expectedAns.add(List.of(3));
        expectedAns.add(List.of(4));
        expectedAns.add(List.of(1, 2));
        expectedAns.add(List.of(1, 3));
        expectedAns.add(List.of(1, 4));
        expectedAns.add(List.of(2, 3));
        expectedAns.add(List.of(2, 4));
        expectedAns.add(List.of(3, 4));
        expectedAns.add(List.of(1, 2, 3));
        expectedAns.add(List.of(2, 3, 4));
        expectedAns.add(List.of(1, 2, 3, 4));
        expectedAns.add(List.of(1, 2, 4));
        expectedAns.add(List.of(1, 3, 4));


        List<List<Integer>> actualAns = PowerSet.getAllSubSequences(input);

        if (actualAns.size() == expectedAns.size() && actualAns.containsAll(expectedAns)) {
            System.out.println("..........TEST PASSED.............");
        } else {
            System.out.println("..........TEST FAILED.............");
            System.out.println("Expected: " + expectedAns);
            System.out.println("Actual: " + actualAns);
        }


    }
}
