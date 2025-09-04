package dsa.graphs.test;

import dsa.graphs.main.NoOfWaysToDestination;

public class NoOfWaysToDestinationTest {
    public static void main(String[] args) {
        NoOfWaysToDestination solver = new NoOfWaysToDestination();
        int passed = 0;
        int total = 8;

        passed += test(solver.countPaths(2, new int[][]{{0, 1, 3}}), 1, 1);
        passed += test(solver.countPaths(3, new int[][]{{0, 1, 1}, {1, 2, 1}, {0, 2, 2}}), 2, 2);
        passed += test(solver.countPaths(4, new int[][]{
                {0, 1, 1}, {0, 2, 1}, {1, 3, 1}, {2, 3, 1}
        }), 2, 3);
        //passed += test(solver.countPaths(5, new int[][]{
        //        {0,1,2},{0,2,2},{1,2,2},{1,3,1},{2,3,1},{3,4,1}
        //}), 4, 4);
        passed += test(solver.countPaths(3, new int[][]{{0, 1, 5}, {1, 2, 5}, {0, 2, 10}}), 2, 5);
        passed += test(solver.countPaths(1, new int[][]{}), 1, 6);
        passed += test(solver.countPaths(2, new int[][]{}), 0, 7);
        passed += test(solver.countPaths(4, new int[][]{
                {0,1,1},{1,2,1},{2,3,1}
        }), 1, 8);
        passed += test(solver.countPaths(6, new int[][]{
                {0,1,1000000000},{0,3,1000000000},{1,3,1000000000},{1,2,1000000000},
                {1,5,1000000000},{3,4,1000000000},{4,5,1000000000},{2,5,1000000000}
        }), 1, 9);
//        passed += test(solver.countPaths(3, new int[][]{
//                {0,1,1},{0,2,1},{1,2,1}
//        }), 2, 10); // 0→1→2 and 0→2 are both shortest paths

        System.out.printf("%nPassed %d out of %d tests.%n", passed, total);
    }

    private static int test(int result, int expected, int testCase) {
        if (result == expected) {
            System.out.printf("Test %d ✅ (Expected: %d, Got: %d)%n", testCase, expected, result);
            return 1;
        } else {
            System.out.printf("Test %d ❌ (Expected: %d, Got: %d)%n", testCase, expected, result);
            return 0;
        }
    }
}
