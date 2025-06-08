package dsa.greedy.test;

import dsa.greedy.main.FractionalKnapsackAlgorithm;

public class FractionalKnapsackAlgorithmTest {
    /*
    You are given n items, each with a weight and a value.
    Your goal is to put a subset of these items into a knapsack of capacity W such that the total value is maximized.
    Unlike the classic knapsack problem, you are allowed to take fractions of items.

    n = 6
    capacity = 50
    values = [60, 100, 120, 240, 150, 75]
    weights = [10, 20, 30, 40, 50, 25]
    output: 300.0

    Weights = [5, 10, 15, 20, 25, 30]
    Values = [10, 20, 30, 40, 50, 60]
    Capacity = 60
    output = 120.0

   capacity = 50
   values  = [60, 100, 120, 240]
   weights = [10, 20, 30, 60]
   output = 240.0

   capacity = 100
   values  = [60, 100, 120, 240, 150, 75, 300, 200, 180, 90]
   weights = [10, 20, 30, 40, 50, 25, 60, 30, 20, 10]
   output = 710.0
     */

    public static void main(String[] srg) {
        int[] values = {60, 100, 120, 240};
        int[] weights = {10, 20, 30, 60};
        int capacity = 50;
        float expectedAns = 240.0F;

        float actualAns = FractionalKnapsackAlgorithm.getMaxProfit(values, weights, capacity);
        if (expectedAns == actualAns) {
            System.out.println("..............TEST PASSED................");
        } else {
            System.out.println("..............TEST FAILED................");
        }
    }
}
