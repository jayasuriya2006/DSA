package dsa.dp.test;

import dsa.dp.main.MinCoinsInfiniteSupply;

public class MinCoinsInfiniteSupplyTest {
    public static void main(String[] args) {
        int[] coins1 = {1, 2, 5};
        int target1 = 11;
        System.out.println("=== Test 1: Standard Case ===");
        System.out.println("Expected: 3 (5+5+1)");
        System.out.println("Recursion: " + MinCoinsInfiniteSupply.minCoinsRequired_recursion(coins1, target1));
        System.out.println("Memoization: " + MinCoinsInfiniteSupply.minCoinsRequired_memo(coins1, target1));
        System.out.println("Tabulation: " + MinCoinsInfiniteSupply.minCoinsRequired_tabulation(coins1, target1));
        System.out.println("Space Optimized: " + MinCoinsInfiniteSupply.minCoinsRequired_spaceOptimized(coins1, target1));

        int[] coins2 = {2};
        int target2 = 3;
        System.out.println("\n=== Test 2: No Solution ===");
        System.out.println("Expected: -1");
        System.out.println("Recursion: " + MinCoinsInfiniteSupply.minCoinsRequired_recursion(coins2, target2));
        System.out.println("Memoization: " + MinCoinsInfiniteSupply.minCoinsRequired_memo(coins2, target2));
        System.out.println("Tabulation: " + MinCoinsInfiniteSupply.minCoinsRequired_tabulation(coins2, target2));
        System.out.println("Space Optimized: " + MinCoinsInfiniteSupply.minCoinsRequired_spaceOptimized(coins2, target2));

        int[] coins3 = {1};
        int target3 = 0;
        System.out.println("\n=== Test 3: Target 0 ===");
        System.out.println("Expected: 0");
        System.out.println("Recursion: " + MinCoinsInfiniteSupply.minCoinsRequired_recursion(coins3, target3));
        System.out.println("Memoization: " + MinCoinsInfiniteSupply.minCoinsRequired_memo(coins3, target3));
        System.out.println("Tabulation: " + MinCoinsInfiniteSupply.minCoinsRequired_tabulation(coins3, target3));
        System.out.println("Space Optimized: " + MinCoinsInfiniteSupply.minCoinsRequired_spaceOptimized(coins3, target3));

        int[] coins4 = {2, 5, 10, 1};
        int target4 = 27;
        System.out.println("\n=== Test 4: Random Target ===");
        System.out.println("Expected: 4 (10+10+5+2)");
        System.out.println("Recursion: " + MinCoinsInfiniteSupply.minCoinsRequired_recursion(coins4, target4));
        System.out.println("Memoization: " + MinCoinsInfiniteSupply.minCoinsRequired_memo(coins4, target4));
        System.out.println("Tabulation: " + MinCoinsInfiniteSupply.minCoinsRequired_tabulation(coins4, target4));
        System.out.println("Space Optimized: " + MinCoinsInfiniteSupply.minCoinsRequired_spaceOptimized(coins4, target4));
    }
}
