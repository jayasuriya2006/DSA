package dsa.greedy.test;

import dsa.greedy.main.Candy;

public class CandyTest {
        /*
    A line of N kids is standing there. The rating values listed in the integer array ratings are assigned to each kid.
    These kids are receiving candy, according to the following criteria:
    1) There must be at least one candy for every child.
    2) Kids whose scores are higher than their neighbours receive more candies than their neighbours.
     Return the minimum number of candies needed to distribute among children.

     Examples:
       Input : ratings = [1, 0, 5]
       Output : 5
       Explanation : The distribution of candies will be 2 , 1 , 2 to first , second , third child respectively.

       Input : ratings = [1, 2, 2]
       Output : 4
       Explanation : The distribution of candies will be 1 , 2 , 1 to first , second , third child respectively.
       The third gets only 1 candy because it satisfy above two criteria.

        Input : ratings = [0 , 2, 4, 3, 2, 1, 1, 3, 5, 6, 4, 0, 0]
        Output : 27
     */

    public static void main(String args[]) {
        int[] ratings = {0, 2, 4, 3, 2, 1, 1, 3, 5, 6, 4, 0, 0};
        int reqCandies = 27;

        int actualAnsBrut = Candy.getReqMinCandies_Brut(ratings);
        int actualAnsBetter = Candy.getReqMinCandies_Better(ratings);
        int actualAnsOptimal = Candy.getReqMinCandies_Optimal(ratings);

        if (actualAnsBrut == reqCandies) {
            System.out.println("...........BRUT - TEST PASSED................");
        } else {
            System.out.println("...........BRUT - TEST FAILED........");
        }
        if (actualAnsBetter == reqCandies) {
            System.out.println("...........BETTER - TEST PASSED................");
        } else {
            System.out.println("...........BETTER - TEST FAILED........");
        }
        if (actualAnsOptimal == reqCandies) {
            System.out.println("...........OPTIMAL - TEST PASSED................");
        } else {
            System.out.println("...........OPTIMAL - TEST FAILED........");
        }

    }
}
