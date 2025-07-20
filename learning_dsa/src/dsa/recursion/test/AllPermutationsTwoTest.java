package dsa.recursion.test;

import dsa.recursion.main.AllPermutationsTwo;

import java.util.List;

public class AllPermutationsTwoTest {
    public static void main(String[] args) {

        int[] input = {1, 2, 3, 4};

        List<List<Integer>> answer = AllPermutationsTwo.getAllPermutations(input);

        System.out.println(answer.size());
        System.out.println(answer);
    }
}
