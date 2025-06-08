package dsa.greedy.main;

public class Candy {

    //TC - O(3N)
    //TC - O(2N)
    public static int getReqMinCandies_Brut(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];

        //min candies
        left[0] = 1;
        right[n - 1] = 1;

        //compute for left
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        //compute for right
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        //take max from left and right , add a sum
        int reqMinCandies = 0;
        for (int i = 0; i < n; i++) {
            reqMinCandies = reqMinCandies + Math.max(left[i], right[i]);
        }

        return reqMinCandies;
    }

    //TC - O(2N)
    //TC - O(N)
    public static int getReqMinCandies_Better(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];

        //min candies
        left[0] = 1;

        //compute for left
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int reqMinCandies = Math.max(1, left[n - 1]);
        int current = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                current = current + 1;
            } else {
                current = 1;
            }
            reqMinCandies = reqMinCandies + Math.max(current, left[i]);
        }
        return reqMinCandies;
    }

    //TC - O(N)
    //TC - O(1)
    //Slope approach
    public static int getReqMinCandies_Optimal(int[] ratings) {
        int reqCandies = 0;
        int n = ratings.length;
        if (n == 0) {
            return reqCandies;
        }
        int i = 1;
        reqCandies = 1;
        while (i < n) {
            //flat
            while (i < n && ratings[i] == ratings[i - 1]) {
                reqCandies++;
                i++;
            }
            //increasing
            int peek = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peek++;
                reqCandies = peek + reqCandies;
                i++;
            }

            //decreasing
            int down = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                reqCandies = down + reqCandies;
                down++;
                i++;
            }

            //right has high
            if (down > peek) {
                reqCandies = reqCandies + (down - peek);
            }
        }
        return reqCandies;
    }

}
