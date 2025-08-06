package dsa.dp.test;

import dsa.dp.main.CherryPickupII;

public class CherryPickupIITest {
    public static void main(String[] args) {
        CherryPickupII solver = new CherryPickupII();

        // Test Case 1
        int[][] grid1 = {
                {3, 1, 1},
                {2, 5, 1},
                {1, 5, 5},
                {2, 1, 1}
        };

        int resultMemo1 = solver.cherryPickupMemo(grid1);
        int resultTab1 = solver.cherryPickupTabulation(grid1);
        System.out.println("Test Case 1:");
        System.out.println("Memoization Result: " + resultMemo1);    // Expected: 24
        System.out.println("Tabulation Result:   " + resultTab1);    // Expected: 24

        // Test Case 2
        int[][] grid2 = {
                {1, 0, 0, 0, 0, 0, 1},
                {2, 0, 0, 0, 0, 3, 0},
                {2, 0, 9, 0, 0, 0, 0},
                {0, 3, 0, 5, 4, 0, 0},
                {1, 0, 2, 3, 0, 0, 6}
        };

        int resultMemo2 = solver.cherryPickupMemo(grid2);
        int resultTab2 = solver.cherryPickupTabulation(grid2);
        System.out.println("\nTest Case 2:");
        System.out.println("Memoization Result: " + resultMemo2);    // Expected: 28
        System.out.println("Tabulation Result:   " + resultTab2);    // Expected: 28

        // Test Case 3 - Edge case: single row
        int[][] grid3 = {
                {1, 2, 3}
        };

        int resultMemo3 = solver.cherryPickupMemo(grid3);
        int resultTab3 = solver.cherryPickupTabulation(grid3);
        System.out.println("\nTest Case 3:");
        System.out.println("Memoization Result: " + resultMemo3);    // Expected: 4
        System.out.println("Tabulation Result:   " + resultTab3);    // Expected: 4
    }
}


