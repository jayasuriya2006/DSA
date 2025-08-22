package dsa.graphs.test;

import dsa.graphs.main.CountUniqueIslands;

public class CountUniqueIslandsTest {
    public static void main(String[] args) {
        int[][][] testCases = {
                // 1. One island + isolated land
                {
                        {1, 1, 0},
                        {1, 0, 0},
                        {0, 0, 1}
                },
                // 2. Two identical islands
                {
                        {1, 1, 0, 0},
                        {1, 0, 0, 0},
                        {0, 0, 1, 1},
                        {0, 0, 1, 0}
                },
                // 3. No islands
                {
                        {0, 0},
                        {0, 0}
                },
                // 4. All land (1 big island)
                {
                        {1, 1},
                        {1, 1}
                },
                // 5. All water
                {
                        {0, 0, 0},
                        {0, 0, 0}
                },
                // 6. Multiple unique islands
                {
                        {1, 0, 0, 1},
                        {0, 1, 1, 0},
                        {1, 0, 0, 1}
                },
                // 7. Diagonal land (should not connect)
                {
                        {1, 0},
                        {0, 1}
                },
                // 8. Complex shapes, same form
                {
                        {1, 1, 0, 0, 1, 1},
                        {1, 0, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0},
                        {1, 1, 0, 0, 1, 1},
                        {1, 0, 0, 0, 1, 0}
                },
                // 9. Line islands
                {
                        {1, 0, 1, 0, 1}
                },
                // 10. L-shaped islands
                {
                        {1, 1, 0, 0},
                        {1, 0, 1, 1},
                        {0, 0, 1, 0}
                }
        };

        int[] expected = {
                2, // Case 1
                1, // Case 2
                0, // Case 3
                1, // Case 4
                0, // Case 5
                2, // Case 6
                1, // Case 7
                1, // Case 8
                1, // Case 9
                1  // Case 10
        };

        for (int i = 0; i < testCases.length; i++) {
            int result = CountUniqueIslands.countNoOfUniqueIslands(testCases[i]);
            String status = result == expected[i] ? "✅" : "❌";
            System.out.println("Test Case " + (i + 1) + ": " + status +
                    " | Result: " + result + " | Expected: " + expected[i]);
        }
    }
}
