package dsa.recursion.test;

import dsa.recursion.main.AllSubSeqNoDuplicate;

import java.util.List;

public class AllSubSeqNoDuplicateTest {
    public static void main(String[] arg) {
        int[] input = {1, 2, 1, 1, 1};

        List<List<Integer>> actual = AllSubSeqNoDuplicate.getAllSubSeqNoDuplicates(input);

        System.out.println(actual);
    }
}
