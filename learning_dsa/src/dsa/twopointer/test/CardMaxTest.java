package dsa.twopointer.test;

// Import the CardMax class from the main package

import dsa.twopointer.main.CardMax;

public class CardMaxTest {
    //    **In one step, you can take one card from the beginning or from the end of the row.
//      You have to take exactly k cards.
//
//    **Your score is the sum of the points of the cards you have taken.
    public static void main(String[] args) {
        int[] card = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        int k = 4;
//      Expected output:25


//       int[] card = {10, 20, 30, 40, 50}
//       int k = 3;
//       Expected output: 60


//       int[] card = {10, 20, 30, 40, 50};
//       int k = 2;
//       Expected output: 90


        // Call the static method from CardMax class and print the result
        System.out.println(CardMax.approach(card, k));
    }
}
