package dsa.binarysearch.test;

import static dsa.binarysearch.main.KoKoEatingBananas.minEatingSpeedPerHour;

public class KoKoEatingBananasTest {
    public static void main(String[] args) {
        int[][] testPiles = {
                {3, 6, 7, 11},         // Example 1
                {30, 11, 23, 4, 20},   // Example 2
                {30, 11, 23, 4, 20},   // Tight h
                {1, 1, 1, 1},          // Minimal piles
                {1000000000},          // Large number
                {1, 2, 3, 4, 5, 6, 7, 8, 9}, // Linear
                {312884470},           // Single large pile
        };

        int[] testHours = {
                8,   // should return 4
                5,   // should return 30
                6,   // should return 23
                4,   // should return 1
                2,   // should return 500000000
                9,   // should return 5
                968709470 // should return 1
        };

        int[] expected = {
                4, 30, 23, 1, 500000000, 9, 1
        };

        for (int i = 0; i < testPiles.length; i++) {
            int result = minEatingSpeedPerHour(testPiles[i], testHours[i]);
            boolean passed = result == expected[i];
            System.out.println("Test " + (i + 1) +
                    ": Expected = " + expected[i] +
                    ", Got = " + result +
                    (passed ? " ✅" : " ❌"));
        }
    }
}
