package dsa.graphs.test;

import dsa.graphs.main.CheapestFlightsWithKStops;

public class CheapestFlightsWithKStopsTest {
    public static void main(String[] args) {
        CheapestFlightsWithKStops solver = new CheapestFlightsWithKStops();

        int passed = 0;

        // Test Case 1
        passed += test(
                solver.findCheapestPrice(4, new int[][]{{0,1,100},{1,2,100},{2,3,100},{0,3,500}}, 0, 3, 1),
                500, 1);

        // Test Case 2
        passed += test(
                solver.findCheapestPrice(4, new int[][]{{0,1,100},{1,2,100},{2,3,100},{0,3,500}}, 0, 3, 2),
                300, 2);

        // Test Case 3
        passed += test(
                solver.findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1),
                200, 3);

        // Test Case 4 - No path with allowed stops
        passed += test(
                solver.findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100}}, 0, 2, 0),
                -1, 4);

        // Test Case 5 - Direct flight is cheapest
        passed += test(
                solver.findCheapestPrice(3, new int[][]{{0,1,100},{0,2,300},{1,2,100}}, 0, 2, 1),
                200, 5);

        // Test Case 6 - Single node graph
        passed += test(
                solver.findCheapestPrice(1, new int[][]{}, 0, 0, 0),
                0, 6);

        // Test Case 7 - No path at all
        passed += test(
                solver.findCheapestPrice(3, new int[][]{{0,1,100}}, 0, 2, 1),
                -1, 7);

        // Test Case 8 - Multiple same-cost paths
        passed += test(
                solver.findCheapestPrice(5, new int[][]{{0,1,100},{1,2,100},{0,2,500},{2,3,100},{3,4,100}}, 0, 4, 3),
                400, 8);

        // Test Case 9 - Cheaper path exceeds stop limit
        passed += test(
                solver.findCheapestPrice(4, new int[][]{{0,1,100},{1,2,100},{2,3,100}}, 0, 3, 1),
                -1, 9);

        // Test Case 10 - k is large enough to allow cheapest path
        passed += test(
                solver.findCheapestPrice(4, new int[][]{{0,1,100},{1,2,100},{2,3,100}}, 0, 3, 3),
                300, 10);

        System.out.println("\nPassed " + passed + "/10 test cases.");
    }

    static int test(int actual, int expected, int testCaseNum) {
        if (actual == expected) {
            System.out.println("Test " + testCaseNum + " ✅");
            return 1;
        } else {
            System.out.println("Test " + testCaseNum + " ❌ (Expected: " + expected + ", Got: " + actual + ")");
            return 0;
        }
    }
}
