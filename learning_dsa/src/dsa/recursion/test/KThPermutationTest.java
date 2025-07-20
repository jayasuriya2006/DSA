package dsa.recursion.test;

import dsa.recursion.main.KThPermutation;

public class KThPermutationTest {
    public static void main(String[] args) {
        int n = 4;
        int k = 17;

        String kThPermutation = KThPermutation.getKThPermutation(n, k);
        System.out.println(kThPermutation);
    }
}
