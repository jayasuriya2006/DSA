package dsa.graphs.test;

import dsa.graphs.main.NumberOfProvinces;

public class NumberOfProvincesTest {
    public static void main(String[] args) {
        int totalTests = 10;
        int passed = 0;

        // Test 1: Single province
        int[][] graph1 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        passed += test("Test 1", graph1, 2);

        // Test 2: All connected
        int[][] graph2 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        passed += test("Test 2", graph2, 1);

        // Test 3: All disconnected
        int[][] graph3 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        passed += test("Test 3", graph3, 3);

        // Test 4: Two provinces
        int[][] graph4 = {
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 1}
        };
        passed += test("Test 4", graph4, 2);

        // Test 5: Single node
        int[][] graph5 = {
                {1}
        };
        passed += test("Test 5", graph5, 1);

        // Test 6: Empty graph
        int[][] graph6 = {};
        passed += test("Test 6", graph6, 0);

        // Test 7: Asymmetric input (invalid, but let's handle gracefully)
        int[][] graph7 = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };
        passed += test("Test 7", graph7, 2); // Actually 2 disconnected components here (node 0 and node 2 are same province)

        // Test 8: Chain structure
        int[][] graph8 = {
                {1, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 1, 1},
                {0, 0, 1, 1}
        };
        passed += test("Test 8", graph8, 1);

        // Test 9: Two disconnected pairs
        int[][] graph9 = {
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 1}
        };
        passed += test("Test 9", graph9, 2);

        // Test 10: Five nodes, all disconnected
        int[][] graph10 = {
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1}
        };
        passed += test("Test 10", graph10, 5);

        System.out.println("\nSummary: Passed " + passed + "/" + totalTests);
    }

    private static int test(String testName, int[][] input, int expected) {
        int actual = NumberOfProvinces.findCircleNum(input);
        if (actual == expected) {
            System.out.println("✅ " + testName + " passed");
            return 1;
        } else {
            System.out.println("❌ " + testName + " failed");
            System.out.println("   Expected: " + expected);
            System.out.println("   Actual:   " + actual);
            return 0;
        }
    }
}
