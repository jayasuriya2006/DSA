package dsa.array.test;


import dsa.array.main.MajorityElement_One;

//Find the element which occurs more than n/2 time    n - size of the array
public class MajorityElement_OneTest {
    public static void main(String[] args) {
        int[] array = {9, 10, 1, 1, 2, 1, 1, 5, 2, 1, 1, 1, 6, 3, 0, 1, 1, 1};
        int expected = 1;

        int res_brut = MajorityElement_One.findMajority_Brut(array);
        int res_better = MajorityElement_One.findMajority_Better(array);
        int res_optimal = MajorityElement_One.findMajority_Optimal(array);

        if (expected == res_brut) {
            System.out.println("..........BRUT - TEST PASSED.........");
        } else {
            System.out.println("..........BRUT - TEST FAILED.........");
        }
        if (expected == res_better) {
            System.out.println("..........BETTER - TEST PASSED.........");
        } else {
            System.out.println("..........BETTER - TEST FAILED.........");
        }
        if (expected == res_optimal) {
            System.out.println("..........OPTIMAL - TEST PASSED.........");
        } else {
            System.out.println("..........OPTIMAL - TEST FAILED.........");
        }

    }
}
