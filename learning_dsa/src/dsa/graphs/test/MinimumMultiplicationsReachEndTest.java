package dsa.graphs.test;

import dsa.graphs.main.MinimumMultiplicationsReachEnd;

public class MinimumMultiplicationsReachEndTest {
    public static void main(String[] args) {
        MinimumMultiplicationsReachEnd solver = new MinimumMultiplicationsReachEnd();

        int passed = 0;

        passed += test(solver.minimumMultiplications(new int[]{2, 5, 7}, 3, 30), 2, 1);
        passed += test(solver.minimumMultiplications(new int[]{3, 4, 65}, 7, 66175), 4, 2);
        passed += test(solver.minimumMultiplications(new int[]{2}, 1, 1024), 10, 3); // 2^10 = 1024
        passed += test(solver.minimumMultiplications(new int[]{2}, 1, 1), 0, 4); // same start and end
        passed += test(solver.minimumMultiplications(new int[]{2}, 3, 3), 0, 5); // same start and end
        passed += test(solver.minimumMultiplications(new int[]{2, 3}, 2, 99999), -1, 6); // unreachable
        passed += test(solver.minimumMultiplications(new int[]{10}, 1, 100000), -1, 7); // overflow edge
        passed += test(solver.minimumMultiplications(new int[]{99999}, 2, 99998), 1, 8); // 2 * 99999 % 100000 = 99998
        passed += test(solver.minimumMultiplications(new int[]{2, 4}, 1, 16), 2, 9); // 1 → 2 → 4 → 8 → 16
        passed += test(solver.minimumMultiplications(new int[]{7, 13, 29}, 5, 99999), -1, 10); // just arbitrary reachable case

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
