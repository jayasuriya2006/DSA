package dsa.recursion.test;

import dsa.recursion.main.AllPermutationsOne;

import java.util.List;

public class AllPermutationsOneTest {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};

        List<List<Integer>> answer = AllPermutationsOne.getAllPermutations(input);

        //size should be n!
        System.out.println(answer.size());
        System.out.println(answer);
    }
}
